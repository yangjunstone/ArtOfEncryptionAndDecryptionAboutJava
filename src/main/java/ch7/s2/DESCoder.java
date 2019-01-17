package ch7.s2;

import org.bouncycastle.jcajce.provider.symmetric.AES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

public class DESCoder {
    /**
     * 秘钥算法 <br>
     *  Java7只支持56位秘钥 <br>
     *  Bouncy Castle支持64位秘钥
     */
    public static final String KEY_ALGORITHM = "DES";
    /**
     * 加密/解密算法/工作模式/填充方式
     */
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * 转换秘钥
     * @param key 二进制秘钥
     * @return Key 秘钥
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {
        // 实例化DES秘钥材料
        DESKeySpec dks = new DESKeySpec(key);
        //实例化私密秘钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        // 生成私密秘钥
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

    /**
     * 解密
     * @param data 待解密数据
     * @param key 秘钥
     * @return byte[] 秘钥数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        //还原秘钥
        Key k = toKey(key);
        // 实例化
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
        // 还原秘钥
        Key k = toKey(key);
        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化， 设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);
        // 执行操作
        return cipher.doFinal(data);
    }

    public static byte[] initKey() throws Exception {
        /**
         * 实例化秘钥生成器
         * 若要使用64位秘钥注意替换
         * 将下述代码中的
         * KeyGenerator.getInstance(CIPHER_ALGORITHM);
         * 替换为
         * KeyGenerator.getInstance(CIPHER_ALGORITHM, "BC");
         */
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        /**
         * 初始化秘钥生成器
         * 若要使用64位秘钥注意替换
         * 将下述代码kg.init(56);
         * 替换为kg.init(64);
         */
        kg.init(56);
        //生成秘钥秘钥
        SecretKey secretKey = kg.generateKey();
        // 获得秘钥的二进制编码形式
        return secretKey.getEncoded();
    }
}
