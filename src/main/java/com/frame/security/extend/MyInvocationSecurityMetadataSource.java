package com.frame.security.extend;

import com.frame.security.entity.SystemAuthority;
import com.frame.security.entity.SystemResource;
import com.frame.security.service.ISystemAuthorityService;
import com.frame.security.service.ISystemResourceService;
import com.frame.security.util.AntUrlPathMatcher;
import com.frame.security.util.UrlMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * 系统启动加载系统权限  用户登入验证权限
 * <p/>
 * 加载资源与权限的对应关系
 * <p/>
 * 该过滤器的主要作用就是通过spring著名的IoC生成securityMetadataSource。
 * securityMetadataSource相当于本包中自定义的MyInvocationSecurityMetadataSourceService。
 * 该MyInvocationSecurityMetadataSourceService的作用提从数据库提取权限和资源，装配到HashMap中，
 * 供Spring Security使用，用于权限校验。
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private final static Logger logger = LoggerFactory.getLogger(MyInvocationSecurityMetadataSource.class);

	private ISystemAuthorityService systemAuthorityService;

	private ISystemResourceService systemResourceService;

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();

	/**
	 * 由spring调用
	 */
	public MyInvocationSecurityMetadataSource(ISystemAuthorityService systemAuthorityService, ISystemResourceService systemResourceService) {
		this.systemAuthorityService = systemAuthorityService;
		this.systemResourceService = systemResourceService;
		loadResourceDefine();
	}

	/**
	 * 加载所有资源与权限的关系
	 */
	private void loadResourceDefine() {

		//初始化resourceMap
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		//获取所有权限
		List<SystemAuthority> systemAuthorityList = systemAuthorityService.findList();
		logger.info("Find all SystemAuthority size is [{}]", systemAuthorityList.size());

		for (SystemAuthority systemAuthority : systemAuthorityList) {

			//获取该权限下所有资源
			List<SystemResource> systemResourceList = systemResourceService.getResourceByAuthId(systemAuthority.getId());
			logger.info("Find all SystemResource size is [{}]", systemResourceList.size());

			//根据名称创建新的配置标签
			ConfigAttribute configAttribute = new SecurityConfig(systemAuthority.getAuthorityName());

			for (SystemResource systemResource : systemResourceList) {

				//获取资源url
				String resourceUrl = systemResource.getResourceString();

				//创建配置标签集合
				Collection<ConfigAttribute> configAttributeCollection;
				if (resourceMap.containsKey(resourceUrl)) {
					configAttributeCollection = resourceMap.get(resourceUrl);
				} else {
					configAttributeCollection = new ArrayList<ConfigAttribute>();
					resourceMap.put(resourceUrl, configAttributeCollection);
				}

				configAttributeCollection.add(configAttribute);
			}
		}
	}

	/**
	 * 返回所请求资源所需要的权限
	 */
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

		//假设获得的是一个URL参数
		String url = ((FilterInvocation) object).getRequestUrl();

		Integer firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		for (Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {

			String resURL = entry.getKey();
			if (urlMatcher.pathMatchesUrl(resURL, url)) {
				for (ConfigAttribute c : resourceMap.get(resURL)) {
					logger.debug("{}:{}", url, c.getAttribute());
				}
				return resourceMap.get(resURL);
			}
		}

		return null;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
}
