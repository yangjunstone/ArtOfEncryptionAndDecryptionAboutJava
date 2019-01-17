package ch7.s4;

import static org.junit.Assert.*;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

/**
 * AES安全编码组件校验
 * @author yangjun
 */
public class AESCoderTest {

    /**
     * 测试AES算法
     * @throws Exception
     */
    @Test
    public final void test() throws Exception {
        String inputStr = "AES";
        byte[] inputData = inputStr.getBytes();
        System.err.println("原文： \t" + inputStr);
        // 初始化秘钥
        byte[] key = AESCoder.initKey();
        System.err.println("秘钥: \t" + Base64.encodeBase64String(key));
        //加密
        inputData = AESCoder.encrypt(inputData, key);
        System.err.println("加密后: \t" +Base64.encodeBase64String(inputData));
        //解密
        byte[] outputData = AESCoder.decrypt(inputData,key);
        String outputStr = new String(outputData);
        System.err.println("解密后: \t" + outputStr);
        // 校验
        assertEquals(inputStr, outputStr);
    }
}
