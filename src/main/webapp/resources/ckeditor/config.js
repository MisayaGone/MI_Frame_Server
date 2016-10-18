/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see LICENSE.html or
 *          http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.enterMode = CKEDITOR.ENTER_BR; 
	config.shiftEnterMode = CKEDITOR.ENTER_P;
	config.toolbarCanCollapse = true;
	config.toolbar = 'Full'; 
	config.toolbar_Full = 
	[ 
	  { name: 'document', items : [ 'Source','-','NewPage','DocProps','Preview','-','Templates' ] },
	  { name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] }, 
	  { name: 'editing', items : [ 'Find','Replace','-','SelectAll'] },
	  { name: 'forms', items : [ 'Form', 'Table', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'Image', 'HiddenField' ] }, '/',
	  { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
	  { name: 'paragraph', items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv', '-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock' ] },
	  { name: 'links', items : [ 'Link','Unlink','Anchor' ] },
	  { name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] }, 
	  { name: 'colors', items : [ 'TextColor','BGColor' ] }, 
	  { name: 'tools', items : [ 'Maximize' ] }
	];
	
	config.font_names='正文/正文;宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+config.font_names; 
	
	config.toolbar_Basic = [ ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About'] ];
//	config.filebrowserUploadUrl="/admincms/servlet/browerServer.do?type=image";
//	config.filebrowserImageBrowseUrl = "/admincms/servlet/browerServer.do?type=image";
//	config.image_previewText="";     //预览区域显示内容
	config.filebrowserImageUploadUrl = "/web/admin/upload/editorUpload.json";
	//config.fullPage = true;	// 使用完整的HTML格式
	config.protectedSource.push( /<\s*#list[\s\S]*?>/gi  );
	config.protectedSource.push( /<\/#list>/gi  );
	config.protectedSource.push( /<\s*#if[\s\S]*?>/gi  );
	config.protectedSource.push( /<\/#if>/gi  );
	config.protectedSource.push( /<\s*#assign[\s\S]*?>/gi  );
	
	// 整页面
	config.protectedSource.push( /<\s*html[\s\S]*?>/gi  );
	config.protectedSource.push( /<\/html>/gi  );
	config.protectedSource.push( /<\s*head[\s\S]*?\/head\s*>/gi  );
	config.protectedSource.push( /<\s*body[\s\S]*?>/gi  );
	config.protectedSource.push( /<\/body>/gi  );
	config.protectedSource.push( /<\s*!DOCTYPE[\s\S]*?>/gi  );
	

//	config.protectedSource.push( /<\s*#if[\s\S]*?\/#if\s*>/gi  );
//	config.protectedSource.push( /<\s*html[\s\S]*?\/html\s*>/gi );
	config.protectedSource.push( /<\s*i[\s\S]*?\/i\s*>/gi );
//	config.protectedSource.push( /<\s*span[\s\S]*?\/span\s*>/gi );
	
	config.allowedContent=true;

	// 去掉图片属性框'高级'按钮
	config.removeDialogTabs = 'image:advanced';

};
