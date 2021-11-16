package com.dfe.appcode;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author     ：任登凯
 * @date       ：Created in 2021-08-12 11:05:00
 * @description：根据服务器信息生成申请码
 */
public class AppCode {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String port = System.getProperty("port");
        String serverName = System.getProperty("serverName");
        if(port==null||"".equals(port.trim())) {
            System.out.println("port 参数为空 请添加 -Dprot=value 启动参数");
            System.exit(0);
        }
        if(serverName==null||"".equals(serverName.trim())) {
            System.out.println("serverName 参数为空 请添加 -DserverName=value 启动参数");
            System.exit(0);
        }
        SystemInfos systemInfo = OshiUtil.getSystemInfo(port, serverName);
        System.out.println(systemInfo.toString());
        // 通过sha1生成申请码
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        BigInteger bigInteger = new BigInteger(sha1.digest(systemInfo.getBytes()));
        System.out.println(bigInteger.toString(16));
    }
}
