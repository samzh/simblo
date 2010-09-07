/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

	// config.toolbar = [ [ 'Source', '-', 'Bold', 'Italic', 'syntaxhighlight' ]
	// ];
	//	
	// config.extraPlugins='syntaxhighlight';
	config.filebrowserUploadUrl = '../upload/File';
	config.filebrowserImageUploadUrl = '../upload/Image';
	config.filebrowserFlashUploadUrl = '../upload/Flash';
	// 图片浏览配置
	config.filebrowserImageBrowseUrl = '../browse/image';

};
