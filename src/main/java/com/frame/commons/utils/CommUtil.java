package com.frame.commons.utils;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * <p>
 * Title: CommUtil.java
 * </p>
 * 
 * <p>
 * Description:系统工具类，用来快速处理,系统默认将该工具类添加到ModelAndView中，前台可以使用$!CommUtil.xxx调用该工具类
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2012-2014
 * </p>
 * 
 * <p>
 * Company: 江苏太湖云计算信息技术股份有限公司 www.chinacloud.net
 * </p>
 * 
 * @author erikzhang
 * 
 * @date 2014-4-27
 * 
 * @version LakeCloud_C2C 1.3
 */
public class CommUtil {
	private static final SimpleDateFormat dateFormat = new

	SimpleDateFormat("yyyy-MM-dd");

	public static String first2low(String str) {
		String s = "";
		s = str.substring(0, 1).toLowerCase() + str.substring(1);
		return s;
	}

	public static String first2upper(String str) {
		String s = "";
		s = str.substring(0, 1).toUpperCase() + str.substring(1);
		return s;
	}

	/**
	 * 用来处理一行一条数据
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static List<String> str2list(String s) throws IOException {
		List<String> list = new ArrayList<String>();
		if (s != null && !s.equals("")) {
			StringReader fr = new StringReader(s);
			BufferedReader br = new BufferedReader(fr);
			String aline = "";
			while ((aline = br.readLine()) != null) {
				list.add(aline);
			}
		}
		return list;
	}

	public static Date formatDate(String s) {
		Date d = null;
		try {
			d = dateFormat.parse(s);
		} catch (Exception e) {
		}
		return d;
	}

	public static Date formatDate(String s, String format) {
		Date d = null;
		try {
			SimpleDateFormat dFormat = new SimpleDateFormat(format);
			d = dFormat.parse(s);
		} catch (Exception e) {
		}
		return d;
	}

	public static String formatTime(String format, Object v) {
		if (v == null)
			return null;
		if (v.equals(""))
			return "";
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(v);
	}

	public static String formatLongDate(Object v) {
		if (v == null || v.equals(""))
			return "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(v);
	}

	public static String formatShortDate(Object v) {
		if (v == null)
			return null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(v);
	}

	public static String decode(String s) {
		String ret = s;
		try {
			ret = URLDecoder.decode(s.trim(), "UTF-8");
		} catch (Exception e) {
		}
		return ret;
	}

	public static String encode(String s) {
		String ret = s;
		try {
			ret = URLEncoder.encode(s.trim(), "UTF-8");
		} catch (Exception e) {
		}
		return ret;
	}

	public static String convert(String str, String coding) {
		String newStr = "";
		if (str != null)
			try {
				newStr = new String(str.getBytes("ISO-8859-1"), coding);
			} catch (Exception e) {
				return newStr;
			}
		return newStr;
	}


	public static boolean isImg(String extend) {
		boolean ret = false;
		List<String> list = new ArrayList<String>();
		list.add("jpg");
		list.add("jpeg");
		list.add("bmp");
		list.add("gif");
		list.add("png");
		list.add("tif");
		for (String s : list) {
			if (s.equals(extend))
				ret = true;
		}
		return ret;
	}




	public static boolean isNotNull(Object obj) {
		if (obj != null && !obj.toString().equals("")) {
			return true;
		} else
			return false;
	}




	public static char randomChar() {
		char[] chars = new char[] { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D',
				'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J',
				'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P',
				'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V',
				'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z' };
		int index = (int) (Math.random() * 52) - 1;
		if (index < 0) {
			index = 0;
		}
		return chars[index];
	}

	public static String[] splitByChar(String s, String c) {
		String[] list = s.split(c);
		return list;
	}

	public static Object requestByParam(HttpServletRequest request, String param) {
		if (!request.getParameter(param).equals("")) {
			return request.getParameter(param);
		} else
			return null;

	}




	public static int null2Int(Object s) {
		int v = 0;
		if (s != null)
			try {
				v = Integer.parseInt(s.toString());
			} catch (Exception e) {
			}
		return v;
	}

	public static float null2Float(Object s) {
		float v = 0.0f;
		if (s != null)
			try {
				v = Float.parseFloat(s.toString());
			} catch (Exception e) {
			}
		return v;
	}

	public static double null2Double(Object s) {
		double v = 0.0;
		if (s != null)
			try {
				v = Double.parseDouble(null2String(s));
			} catch (Exception e) {
			}
		return v;
	}

	public static boolean null2Boolean(Object s) {
		boolean v = false;
		if (s != null)
			try {
				v = Boolean.parseBoolean(s.toString());
			} catch (Exception e) {
			}
		return v;
	}

	public static String null2String(Object s) {
		return s == null ? "" : s.toString().trim();
	}

	public static Long null2Long(Object s) {
		Long v = -1l;
		if (s != null)
			try {
				v = Long.parseLong(s.toString());
			} catch (Exception e) {
			}
		return v;
	}

	public static String getTimeInfo(long time) {
		int hour = (int) time / (1000 * 60 * 60);
		long balance = time - hour * 1000 * 60 * 60;
		int minute = (int) balance / (1000 * 60);
		balance = balance - minute * 1000 * 60;
		int seconds = (int) balance / 1000;
		String ret = "";
		if (hour > 0)
			ret += hour + "小时";
		if (minute > 0)
			ret += minute + "分";
		else if (minute <= 0 && seconds > 0)
			ret += "零";
		if (seconds > 0)
			ret += seconds + "秒";
		return ret;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			java.net.InetAddress addr = null;
			try {
				addr = java.net.InetAddress.getLocalHost();
			} catch (java.net.UnknownHostException e) {
				e.printStackTrace();
			}
			ip = CommUtil.null2String(addr.getHostAddress());// 获得本机IP
		}
		return ip;
	}

	public static int indexOf(String s, String sub) {
		return s.trim().indexOf(sub.trim());
	}

	public static Map cal_time_space(Date begin, Date end) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long l = end.getTime() - begin.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long second = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		Map map = new HashMap();
		map.put("day", day);
		map.put("hour", hour);
		map.put("min", min);
		map.put("second", second);
		return map;
	}

	public static final String randomString(int length) {
		char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
				+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		if (length < 1) {
			return "";
		}
		Random randGen = new Random();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}

	public static final String randomInt(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = ("0123456789").toCharArray();

		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
		}
		return new String(randBuffer);
	}

	/**
	 * 计算两个时间间隔
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long getDateDistance(String time1, String time2) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}

	/**
	 * 浮点数除法运算，保证数据的精确度
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double div(Object a, Object b) {
		double ret = 0.0;
		if (!null2String(a).equals("") && !null2String(b).equals("")) {
			BigDecimal e = new BigDecimal(null2String(a));
			BigDecimal f = new BigDecimal(null2String(b));
			if (null2Double(f) > 0)
				ret = e.divide(f, 3, BigDecimal.ROUND_DOWN).doubleValue();
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret));
	}

	/**
	 * 浮点数据减法运算，保证数据的精确度
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double subtract(Object a, Object b) {
		double ret = 0.0;
		BigDecimal e = new BigDecimal(CommUtil.null2Double(a));
		BigDecimal f = new BigDecimal(CommUtil.null2Double(b));
		ret = e.subtract(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret));
	}

	/**
	 * 浮点数据加法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double add(Object a, Object b) {
		double ret = 0.0;
		BigDecimal e = new BigDecimal(CommUtil.null2Double(a));
		BigDecimal f = new BigDecimal(CommUtil.null2Double(b));
		ret = e.add(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret));
	}

	/**
	 * 浮点数乘法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double mul(Object a, Object b) {// 乘法
		BigDecimal e = new BigDecimal(CommUtil.null2Double(a));
		BigDecimal f = new BigDecimal(CommUtil.null2Double(b));
		double ret = e.multiply(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret));
	}

	public static double formatMoney(Object money) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(money));
	}

	public static int M2byte(float m) {
		float a = m * 1024 * 1024;
		return (int) a;
	}

	public static boolean convertIntToBoolean(int intValue) {
		return (intValue != 0);
	}

	public static String getURL(HttpServletRequest request) {
		String contextPath = request.getContextPath().equals("/") ? ""
				: request.getContextPath();
		String url = "http://" + request.getServerName();
		if (null2Int(request.getServerPort()) != 80) {
			url = url + ":" + null2Int(request.getServerPort()) + contextPath;
		} else {
			url = url + contextPath;
		}
		return url;
	}



	public static int parseDate(String type, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (type.equals("y")) {
			return cal.get(Calendar.YEAR);
		}
		if (type.equals("M")) {
			return cal.get(Calendar.MONTH) + 1;
		}
		if (type.equals("d")) {
			return cal.get(Calendar.DAY_OF_MONTH);
		}
		if (type.equals("H")) {
			return cal.get(Calendar.HOUR_OF_DAY);
		}
		if (type.equals("m")) {
			return cal.get(Calendar.MINUTE);
		}
		if (type.equals("s")) {
			return cal.get(Calendar.SECOND);
		}
		return 0;
	}

	// 读取远程url图片,得到宽高
	public static int[] readImgWH(String imgurl) {
		boolean b = false;
		try {
			// 实例化url
			URL url = new URL(imgurl);
			// 载入图片到输入流
			BufferedInputStream bis = new BufferedInputStream(
					url.openStream());
			// 实例化存储字节数组
			byte[] bytes = new byte[100];
			// 设置写入路径以及图片名称
			OutputStream bos = new FileOutputStream(new File(
					"C:\\thetempimg.gif"));
			int len;
			while ((len = bis.read(bytes)) > 0) {
				bos.write(bytes, 0, len);
			}
			bis.close();
			bos.flush();
			bos.close();
			// 关闭输出流
			b = true;
		} catch (Exception e) {
			// 如果图片未找到
			b = false;
		}
		int[] a = new int[2];
		if (b) {// 图片存在
			// 得到文件
			File file = new File("C:\\thetempimg.gif");
			BufferedImage bi = null;
			boolean imgwrong = false;
			try {
				// 读取图片
				bi = ImageIO.read(file);
				try {
					// 判断文件图片是否能正常显示,有些图片编码不正确
					int i = bi.getType();
					imgwrong = true;
				} catch (Exception e) {
					imgwrong = false;
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			if (imgwrong) {
				a[0] = bi.getWidth(); // 获得 宽度
				a[1] = bi.getHeight(); // 获得 高度
			} else {
				a = null;
			}
			// 删除文件
			file.delete();
		} else {// 图片不存在
			a = null;
		}
		return a;
	}


	/**
	 * 前台判定是否存在文件
	 * 
	 * @param path
	 * @return
	 */
	public static boolean fileExist(String path) {
		File file = new File(path);
		return file.exists();
	}

	/**
	 * 计算分割后的数组长度
	 * 
	 * @param s
	 * @param c
	 * @return
	 */
	public static int splitLength(String s, String c) {
		int v = 0;
		if (!s.trim().equals("")) {
			v = s.split(c).length;
		}
		return v;
	}

	/**
	 * 计算file文件大小，可以是单个文件也可以是文件夹
	 * 
	 * @param file
	 * @return
	 */
	static int totalFolder = 0;
	static int totalFile = 0;

	public static double fileSize(File folder) {
		if (folder.exists()) {
			totalFolder++;
			// System.out.println("Folder: " + folder.getName());
			long foldersize = 0;
			File[] filelist = folder.listFiles();
			for (int i = 0; i < filelist.length; i++) {
				if (filelist[i].isDirectory()) {
					foldersize += fileSize(filelist[i]);
				} else {
					totalFile++;
					foldersize += filelist[i].length();
				}
			}
			return div(foldersize, 1024);
		} else
			return 0;
	}

	/**
	 * 计算文件夹下文件数量
	 * 
	 * @param file
	 * @return
	 */
	public static int fileCount(File file) {
		if (file == null) {
			return 0;
		}
		if (!file.isDirectory()) {
			return 1;
		}
		int fileCount = 0;
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				fileCount++;
			} else if (f.isDirectory()) {
				fileCount++;
				fileCount += fileCount(file); // 如果遇到目录则通过递归调用继续统计
			}
		}
		return fileCount;
	}

	/**
	 * 获取当前请求完整的URL
	 * 
	 * @param request
	 */
	public static String get_all_url(HttpServletRequest request) {
		String query_url = request.getRequestURI();
		if (request.getQueryString() != null
				&& !request.getQueryString().equals("")) {
			query_url = query_url + "?" + request.getQueryString();
		}
		return query_url;
	}

	/**
	 * 根据html颜色代码返回java Color
	 * 
	 * @param color
	 * @return
	 */
	public static Color getColor(String color) {
		if (color.charAt(0) == '#') {
			color = color.substring(1);
		}
		if (color.length() != 6) {
			return null;
		}
		try {
			int r = Integer.parseInt(color.substring(0, 2), 16);
			int g = Integer.parseInt(color.substring(2, 4), 16);
			int b = Integer.parseInt(color.substring(4), 16);
			return new Color(r, g, b);
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	/**
	 * 根据种子a随机出一组长度为length不重复的整型数组
	 * 
	 * @param a
	 * @param length
	 * @return
	 */
	public static Set<Integer> randomInt(int a, int length) {
		Set<Integer> list = new TreeSet<Integer>();
		int size = length;
		if (length > a) {
			size = a;
		}
		while (list.size() < size) {
			Random random = new Random();
			int b = random.nextInt(a);
			list.add(b);
		}
		return list;
	}

	/**
	 * 格式化数字，保留对应的小数位
	 * 
	 * @param obj
	 * @param len
	 * @return
	 */
	public static Double formatDouble(Object obj, int len) {
		Double ret = 0.0;
		String format = "0.0";
		for (int i = 1; i < len; i++) {
			format = format + "0";
		}
		DecimalFormat df = new DecimalFormat(format);
		return Double.valueOf(df.format(obj));
	}

	/**
	 * 判断字符是否为中文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否为乱码
	 * 
	 * @param strName
	 * @return
	 */
	public static boolean isMessyCode(String strName) {
		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");
		char[] ch = temp.trim().toCharArray();
		float chLength = ch.length;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) {

				if (!isChinese(c)) {
					count = count + 1;
					System.out.print(c);
				}
			}
		}
		float result = count / chLength;
		if (result > 0.4) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 去掉IP字符串前后所有的空格
	 * 
	 * @param IP
	 * @return
	 */
	public static String trimSpaces(String IP) {//
		while (IP.startsWith(" ")) {
			IP = IP.substring(1, IP.length()).trim();
		}
		while (IP.endsWith(" ")) {
			IP = IP.substring(0, IP.length() - 1).trim();
		}
		return IP;
	}

	/**
	 * 判断是否是一个IP
	 * 
	 * @param IP
	 * @return
	 */
	public static boolean isIp(String IP) {//
		boolean b = false;
		IP = trimSpaces(IP);
		if (IP.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
			String s[] = IP.split("\\.");
			if (Integer.parseInt(s[0]) < 255)
				if (Integer.parseInt(s[1]) < 255)
					if (Integer.parseInt(s[2]) < 255)
						if (Integer.parseInt(s[3]) < 255)
							b = true;
		}
		return b;
	}

	/**
	 * 邮箱验证
	 * 
	 * @param s
	 * @return
	 */
	public static boolean checkEmail(String s) {
		String regex = "[a-zA-Z][\\w_]+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}

	public static String generic_domain(HttpServletRequest request) {
		// System.out.println(request.getServerName());
		String system_domain = "localhost";
		String serverName = request.getServerName();
		if (isIp(serverName)) {
			system_domain = serverName;
		} else {
			system_domain = serverName.substring(serverName.indexOf(".") + 1);
		}
		// System.out.println(system_domain);
		return system_domain;
	}

//	public static JSONObject jsonResult(boolean flag) {
//
//		JSONObject ret = new JSONObject();
//		if(flag) {
//			ret.put("status",0);
//			ret.put("msg","成功");
//		}else {
//			ret.put("status",1);
//			ret.put("msg","失败");
//		}
//		ret.put("contents","");
//		return ret;
//	}
}
