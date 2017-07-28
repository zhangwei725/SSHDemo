package com.werner.webapp.utils;

/**
 * 项目名称：
 */
public class Constants {

    public static final String ADMIN_USER = "adminuser";//用户session保存对应的key

    public static final String SUPER_USER_ROLE_ID = "1";//超级管理员对应的角色CODE

    public static final String MANAGER_USER_ROLE_ID = "2";//管理员对应的角色CODE


    public static final Long PAGE_SIZE = 10L;

    public static final String TONKEN_ID = "tokenId";

    public static final String LOGIN = "/system/login/login_toLogin.do";

    public static final String ENTITY_DELETE = "1";//标识删除状态的实体
    public static final String ENTITY_NORMAL = "0";//标识正常状态的实体

    public static final String ENTITY_ENABLED = "1";//标识启用状态的实体
    public static final String ENTITY_UNABLED = "0";//标识禁用状态的实体

    public static final String WORD_FOLDER = "wordfile";

    public static final String SESSION_SECURITY_CODE = "sessionSecCode";//验证码

    /// 上传文件存储基文件夹
    public static final String UPLOAD_FOLDER = "uploadfile";
    public static final String UPLOAD_FOLDER_WEB = "web";
    public static final String UPLOAD_FOLDER_ANDRIOD = "andriod";
    public static final String UPLOAD_FOLDER_WEIXIN = "weixin";
    public static final String UPLOAD_FOLDER_IOS = "ios";
    public static final String PHONE_UPLOAD_FOLDER = "app";

}
