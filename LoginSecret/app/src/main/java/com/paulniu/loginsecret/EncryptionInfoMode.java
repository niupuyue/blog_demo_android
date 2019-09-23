package com.paulniu.loginsecret;

import javax.crypto.SecretKey;

/**
 * Coder: niupuyue
 * Date: 2019/9/23
 * Time: 17:00
 * Desc:
 * Version:
 */
public class EncryptionInfoMode {

    public SecretKey secretKey = null;

    /**
     * 私钥
     */
    public String cipherKey = "";

    /**
     * 加密内容
     */
    public String cipherText = "";

}
