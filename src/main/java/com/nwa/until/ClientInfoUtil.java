package com.nwa.until;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class ClientInfoUtil {

    public static String getBrowserInfo(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent.contains("MSIE")) {
            return "Internet Explorer";
        } else if (userAgent.contains("Firefox")) {
            return "Mozilla Firefox";
        } else if (userAgent.contains("Chrome")) {
            return "Google Chrome";
        } else if (userAgent.contains("Safari")) {
            return "Apple Safari";
        } else if (userAgent.contains("Opera")) {
            return "Opera";
        } else {
            return "Unknown";
        }
    }

    public static String getOperatingSystem(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent.contains("Windows")) {
            return "Windows";
        } else if (userAgent.contains("Mac")) {
            return "Macintosh";
        } else if (userAgent.contains("Linux")) {
            return "Linux";
        } else if (userAgent.contains("Android")) {
            return "Android";
        } else if (userAgent.contains("iOS")) {
            return "iOS";
        } else {
            return "Unknown";
        }
    }

    /***
     * 获取客户端ip地址
     * @param request
     */
    public static String getIP(final HttpServletRequest request) throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipStr = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipStr) || "unknown".equalsIgnoreCase(ipStr)) {
            ipStr = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipStr.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipStr = str;
                break;
            }
        }
        //目的是将localhost访问对应的ip 0:0:0:0:0:0:0:1 转成 127.0.0.1。
        return ipStr.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ipStr;
    }
}
