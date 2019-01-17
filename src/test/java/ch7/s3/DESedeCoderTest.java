package ch7.s3;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import static org.junit.Assert.*;

public class DESedeCoderTest {
    /**
     * 测试多重DES算法
     * @throws Exception
     */
    @Test
    public final void test() throws Exception {
        String inputStr = "DESede";
        byte[] inputData = inputStr.getBytes();
        System.err.println("原文：\t" + inputStr);

        //初始化秘钥
        byte[] key = DESedeCoder.initKey();
        System.err.println("秘钥：\t" + Base64.encodeBase64String(key));
        //加密
        inputData = DESedeCoder.encrypt(inputData, key);
        System.err.println("加密后： \t" + Base64.encodeBase64String(inputData));
        // 解密
        byte[] outputData = DESedeCoder.decrypt(inputData, key);
        String outputStr = new String(outputData);
        System.err.println("解密后： \t" + outputStr);
        //校验
        assertEquals(inputStr, outputStr);
    }
}
