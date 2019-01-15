package ch5.s7.bouncycastle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Base64编码与解码（BouncyCastle实现）测试类
 * @author yangjun
 */
public class UrlBase64CoderTest {
    /**
     * 测试Base64编码与解码
     * @throws Exception
     */
    @Test
    public final void test() throws Exception {
        String inputStr = "Java加密与解密的艺术";
        System.err.println("原文:\t" + inputStr);
        //进行Base64编码
        String code = UrlBase64Coder.encode(inputStr);
        System.err.println("编码后：\t" + code);
        //进行Base64解码
        String outputStr = UrlBase64Coder.decode(code);
        System.err.println("解码后: \t" + outputStr);
        //验证Base64编码解码一致性
        assertEquals(inputStr, outputStr);
    }
}
