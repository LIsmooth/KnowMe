package com.leif.knowme.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author HelloLeif
 * @date 2020/8/24
 */
public class CryptUtil {

    public static String cryptByMD5(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encrypted cannot be null or zero length");
        }
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (byte b : hash) {
                if ((0xff & b) < 0x10) {
                    hexString.append("0").append(Integer.toHexString((0xFF & b)));
                } else {
                    hexString.append(Integer.toHexString(0xFF & b));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }

}
