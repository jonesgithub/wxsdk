package com.lemon.weixin.sdk.base.constants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by lemon_bar on 2014/12/4.
 */
public class WXApiUrl {
    private static String BASE_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    private static String AUTH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    private static String AUTH_TOKEN_REFRESH = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";
    private static String AUTH_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";
    private static String AUTH_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";//support chinese.

    private static String MESSAGE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";
    private static String MESSAGE_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    private static String USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";
    private static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

    private static String MEDIA_UPLOAD_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";

    private static String QRCODE_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";
    private static String QRCODE_SHOW_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";

    private static String TRANSFER_SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=%s";

    public static String getShortUrl(String accessToken) {
        return String.format(TRANSFER_SHORT_URL, accessToken);
    }

    public static String getQrcodeCreateUrl(String accessToken) {
        return String.format(QRCODE_CREATE_URL, accessToken);
    }

    public static String getQrcodeShowUrl(String ticket) {
        return String.format(QRCODE_SHOW_URL, ticket);
    }

    public static String getMediaUploadUrl(String accessToken, String type) {
        return String.format(MEDIA_UPLOAD_URL, accessToken, type);
    }

    public static String getUserListUrl(String accessToken, String firstOpenId) {
        return String.format(USER_LIST_URL, accessToken, firstOpenId);
    }

    public static String getUserInfoUrl(String accessToken, String openId) {
        return String.format(USER_INFO_URL, accessToken, openId);
    }

    public static String getBaseTokenUrl() {
        return String.format(BASE_TOKEN, WXAppInfo.APP_KEY, WXAppInfo.APP_SECRET);
    }

    public static String getAuthTokenUrl(String code) {
        return String.format(AUTH_TOKEN, WXAppInfo.APP_KEY, WXAppInfo.APP_SECRET, code);
    }

    public static String getAuthTokenRefreshUrl(String refreshToken) {
        return String.format(AUTH_TOKEN_REFRESH, WXAppInfo.APP_KEY, refreshToken);
    }

    public static String getAuthCodeUrl(String redirectUrl, String scope, String state) {
        try {
            return String.format(AUTH_CODE, WXAppInfo.APP_KEY, URLEncoder.encode(redirectUrl, "utf-8"), scope, state);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static String getAuthUserInfoUrl(String authToken, String openId) {
        return String.format(AUTH_USER_INFO, authToken, openId);
    }

    public static String getMessageSendUrl(String accessToken) {
        return String.format(MESSAGE_SEND_URL, accessToken);
    }

    public static String getMessageTemplateSendUrl(String accessToken) {
        return String.format(MESSAGE_TEMPLATE_URL, accessToken);
    }
}
