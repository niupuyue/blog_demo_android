package com.paulniu.loginsecret;

import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * Coder: niupuyue
 * Date: 2019/9/23
 * Time: 16:54
 * Desc:
 * Version:
 */
public class BaseUtility {

    public static final String PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0IOPDMANIDE<DISNCEWSOCAQEAmQEjEdEXNZewgCZt40SAtYx2p/+91Cesx6Ns3sSg22NQxOHW1Mnt/OBaAEyvZu733PlMQQGkm6AkJtswRr61" +
                    "Z5pRk4ZKMIxj8sx7m1+DpnJr5ZJDZ3fd98e6d3+1d4e+8e5=d74MY0NjRGvPVKWiVOHwXaY823RJAAfG1Ks3a4KL1E6RBXLjNaN85uthK05QLuCGSoXuyc2pQRuuOykt" +
                    "EjYiqRofwJBTkYTQ5nGPuDVzIzPmlmu10WMmY39dMXr1l00EVPobdnuuQu+dHsOqMrg0cRkMY/344SK7KKCI74YMKARDaXcRF2Kdulg8l4l46GG/29HBaUo/rvVlfFE2fwIDAQAB";



    public static EncryptionInfoMode getEncryptionInfoMode(PhoneLoginModel model){
        EncryptionInfoMode encryptionInfoMode = new EncryptionInfoMode();

        String text = new Gson().toJson(model,PhoneLoginModel.class);
        encryptionInfoMode = getEncryptionModel(text);
        return encryptionInfoMode;
    }

    public static EncryptionInfoMode getEncryptionModel(String text){
        EncryptionInfoMode mode = new EncryptionInfoMode();
        if (TextUtils.isEmpty(text)){
            return mode;
        }
        try {
            // 生成会话密钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");// 使用AES加密算法
            keyGenerator.init(128);  // 使用128位长度的密钥
            mode.secretKey = keyGenerator.generateKey();  // 生成密钥

            // 通信报文，用户登录信息等
            byte[] plaintext = text.getBytes();
            byte[] pubk = Base64.decode(PUBLIC_KEY.getBytes(),Base64.DEFAULT);  // 公钥，预先设置在App中

            // 加密报文
            Cipher secretKeyCiper = Cipher.getInstance("AES");// 使用AES加密算法
            secretKeyCiper.init(Cipher.ENCRYPT_MODE,mode.secretKey);  // 设置加密模式
            byte[] ciphertext = secretKeyCiper.doFinal(plaintext);

            // 读取公钥
            KeyFactory kf = KeyFactory.getInstance("RSA"); // 使用RSA算法
            X509EncodedKeySpec x509ks = new X509EncodedKeySpec(pubk);
            PublicKey publicKey = kf.generatePublic(x509ks);

            // 用公钥对密钥进行加密
            Cipher publicKeyCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");  // 使用RSA算法
            publicKeyCipher.init(Cipher.ENCRYPT_MODE,publicKey); // 加密模式
            byte[] plainkey = mode.secretKey.getEncoded();  // 密钥铭文
            byte[] cipherkey = publicKeyCipher.doFinal(plainkey);// 密钥密文

            // 最后把加密的密钥cipherkey和密文ciphertext发送给服务器
            mode.cipherText = new String(Base64.encode(ciphertext,Base64.NO_WRAP));
            mode.cipherKey = new String(Base64.encode(cipherkey,Base64.NO_WRAP));
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return mode;
    }

}
