package ch4.s2;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.Map;

/**
 *  BouncyCastle 环境测试
 *
 *  BouncyCastle环境配置2种方式：
 *  一. 静态配置
 *  1). 去BouncyCastle官网下载provider的包，然后放入$JAVA_HOME\jre\lib\ext目录下；
 *  2). 修改配置文件$JAVA_HOME\jre\lib\security\java.security，加入一行配置：security.provider.按顺序填数字=org.bouncycastle.jce.provider.BouncyCastleProvider
 *  二. 动态配置
 *  1). Maven pom.xml引入BouncyCastle依赖
 *  2). Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
 *
 * @author yangjun
 * @date 2019.1.15
 */
public class BouncyCastleTest {

    /**
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encodeMD4(byte[] data) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD4", "BC");
        md.update(data);
        return md.digest();
    }

    public static void bouncyCastleDetails(){
        Provider provider = Security.getProvider("BC");
        System.err.println(provider);
        for(Map.Entry<Object, Object> entry : provider.entrySet()){
            System.err.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception{
        //动态注册BouncyCastle
        Security.addProvider(new BouncyCastleProvider());
        System.out.println(encodeMD4("a;sdjfasdfj;".getBytes()));

        //bouncyCastleDetails();
    }

}
