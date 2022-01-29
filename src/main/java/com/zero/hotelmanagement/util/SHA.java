package com.zero.hotelmanagement.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * SHA加密工具类
 */
public class SHA {
    /* 加密算法 */
    private static final String KEY_SHA = "SHA";
    /* 随便手敲的盐 */
    public static final String THE_SALT = "ihb142798h9ufaiuhjdaqs09812";

    /**
     * 将字符串加盐加密（取摘要）
     *
     * @param inputStr 待加密字符串
     * @return 加密后字符串
     */
    public static String getResult(String inputStr) {
        BigInteger sha;
        String outputData = null;
        String inputAndSalt = inputStr.concat(THE_SALT);
        byte[] inputData = inputAndSalt.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            sha = new BigInteger(messageDigest.digest());
            outputData = sha.toString(32);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputData;
    }

    /**
     * 比较明文加密后与摘要是否相同
     *
     * @param text   明文
     * @param digest 摘要
     * @return 是否相等
     */
    public static boolean equals(String text, String digest) {
        return getResult(text).equals(digest);
    }
}
