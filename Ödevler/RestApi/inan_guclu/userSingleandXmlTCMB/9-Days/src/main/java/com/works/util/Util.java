package com.works.util;

import java.util.Map;

public class Util {

    static String baseUrl = "";
    public static String paramsUrl(String url, Map<String, String > map) {
        baseUrl = url + "?";
        map.forEach( (key, val) -> {
            baseUrl += key + "=" + val + "&";
        });

        if ( baseUrl.endsWith("&") ) {
            baseUrl = baseUrl.substring(0, baseUrl.length() -1);
        }
        return baseUrl;
    }

}
