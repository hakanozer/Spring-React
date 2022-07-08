package com.example.utils;

public class Util {

    public static String md5( String plainText ) {
        String cipherText = convertMD5(plainText);
        for (int i = 0; i < 2; i++) {
            cipherText = convertMD5(cipherText);
        }
        return cipherText;
    }

    private static String convertMD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
