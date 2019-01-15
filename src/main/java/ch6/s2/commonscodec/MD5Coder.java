package ch6.s2.commonscodec;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class MD5Coder {
    /**
     *  MD5 消息摘要
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static byte[] encodeMD5(String data) throws Exception {
        // 执行消息摘要
        return DigestUtils.md5(data);
    }

    /**
     * MD5消息摘要16进制
     * @param data 待做摘要处理的数据
     * @return byte[] 消息摘要
     * @throws Exception
     */
    public static String encodeMD5Hex(String data) throws Exception {
        // 执行消息摘要
        return DigestUtils.md5Hex(data);
    }
}
