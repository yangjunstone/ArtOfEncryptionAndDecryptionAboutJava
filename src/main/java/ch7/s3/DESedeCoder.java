package ch7.s3;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

public abstract class DESedeCoder {
    /**
     * 秘钥算法
     * Java7支持秘钥长度为112位和168位
     * Bouncy Castle支持秘钥长度为128位和192位
     */
    public static final String KEY_ALGORITHM = "DESede";
    /**
     * 加密/解密算法/工作模式/填充方式
     * Java7支持PKCS5Padding填充方式
     * Bouncy Castle支持PKCS7Padding填充方式
     */
    public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 转换秘钥
     * @param key 二进制秘钥
     * @return key 秘钥
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        // 实例化DES秘钥材料
        DESedeKeySpec dks = new DESedeKeySpec(key);
        // 实例化私密秘钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        // 生成秘密秘钥
        return keyFactory.generateSecret(dks);
    }

    /**
     * 解密
     * @param data 待解密数据
     * @param key 秘钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        //还原秘钥
        Key k = toKey(key);
        /**
         * 实例化
         * 使用PKCS7Padding填充方式， 按如下代码实现
         * Cipher.getInstance(CIPHER_ALGORITHM, "BC");
         */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 初始化， 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * 加密
     * @param data 待加密数据
     * @param key 秘钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        //还原秘钥
        Key k = toKey(key);
        /**
         * 实例化
         * 使用PKCS7Padding填充方式，按如下代码实现
         * Cipher.getInstance(CIPHER_ALGORITHM, "BC");
         */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }

    public static byte[] initKey() throws Exception {
        /**
         * 实例化
         * 使用128位或192位长度秘钥， 按如下代码实现
         * KeyGenerator.getInstance(KEY_ALGORITHM, "BC");
         */
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        /**
         * 初始化
         * Java7支持秘钥长度为112位和168位
         * 若使用128位或192位长度秘钥，按如下代码实现
         * kg.init(128);
         * 或
         * kg.init(192);
         */
        kg.init(168);
        //生成秘密秘钥
        SecretKey secretKey = kg.generateKey();
        //获得秘钥的二进制编码形式
        return secretKey.getEncoded();
    }
}
