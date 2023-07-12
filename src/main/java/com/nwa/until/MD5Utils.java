package com.nwa.until;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Lucky友人a
 * @Date 2023/1/25 -16:09
 */


public class MD5Utils {
    public static String md5(String pwd) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            md5.update(pwd.getBytes());
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
