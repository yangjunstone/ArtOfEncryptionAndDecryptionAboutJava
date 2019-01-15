package ch6.s2.bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.security.MessageDigest;
import java.security.Security;

public abstract class MD4Coder {
    /**
     *  MD4消息摘要
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static byte[] encodeMD4(byte[] data) throws Exception{
        // 加入BouncyCastleProvider支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD4");
        // 执行消息摘要
        return md.digest(data);
    }

    /**
     * MD4消息摘要16进制
     * @param data 待做摘要处理的数据
     * @return String 消息摘要
     * @throws Exception
     */
    public static String encodeMD4Hex(byte[] data) throws Exception {
        // 执行消息摘要
        byte[] b = encodeMD4(data);
        // 做十六进制编码处理
        return new String(Hex.encode(b));
    }
}
