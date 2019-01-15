package ch6.s2.sun;

import java.security.MessageDigest;

/**
 *  MD消息摘要组件
 * @author yangjun
 */
public abstract class MDCoder {
    /**
     * MD2 消息摘要
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static byte[] encodeMD2(byte[] data) throws Exception {
        //初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD2");
        // 执行消息摘要
        return md.digest(data);
    }

    /**
     * MD5 消息摘要
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static byte[] encodeMD5(byte[] data) throws Exception {
        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 执行消息摘要
        return md.digest(data);
    }
}
