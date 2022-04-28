package com.ch.common.util;

import com.ch.common.exception.AppException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/**
 * 加密工具类
 * @Author : liupeng
 * @Date : 2019-01-05
 * @Modified By
 */
public class UtilDigest {
    /**
     * MD5 加密
     *
     * @param target 需要加密的明文
     * @return MD5加密的后密文
     */
    public static String encodeMD5(String target) {
        return DigestUtils.md5Hex(target);
    }


    /**
     * SHA1 加密
     *
     * @param target 需要加密的明文
     * @return 密文
     */
    public static String encodeSha1(String target) {
        return DigestUtils.sha1Hex(target);
    }


    /**
     * Sha256 加密
     *
     * @param target 需要加密的明文
     * @return 密文
     */
    public static String encodeSha256(String target) {
        return DigestUtils.sha256Hex(target);
    }

    /**
     * Sha384 加密
     *
     * @param target 需要加密的明文
     * @return 密文
     */
    public static String encodeSha384(String target) {
        return DigestUtils.sha384Hex(target);
    }

    /**
     * sha512 加密
     *
     * @param target 需要加密的明文
     * @return 密文
     */
    public static String encodeSha512(String target) {
        return DigestUtils.sha512Hex(target);
    }

    /**
     * Base64 加密
     *
     * @param target
     * @return
     */
    public static String encodeBase64(String target) {
        byte[] b = Base64.encodeBase64(target.getBytes(), false);
        return new String(b);
    }

    /**
     * Base64解密
     *
     * @param target
     * @return
     */
    public static String decodeBase64(String target) {
        byte[] b = Base64.decodeBase64(target);
        return new String(b);
    }

    /**
     * 加密身份证
     * @param identifyId
     * @return
     */
    public static String digestIdentifyId(String identifyId) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            byte[] result = digest.digest(identifyId.getBytes());

            return java.util.Base64.getEncoder().encodeToString(result);
        } catch (GeneralSecurityException e) {
            throw new AppException("加密身份证信息错误") ;
        }
    }


}
