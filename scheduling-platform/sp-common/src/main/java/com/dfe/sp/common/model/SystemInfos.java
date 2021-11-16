package com.dfe.sp.common.model;

import java.io.UnsupportedEncodingException;

/**
 * @author     ：任登凯
 * @date       ：Created in 2021-08-12 11:05:00
 * @description：系统信息类
 */
public class SystemInfos {
    // 系统名称
    private String osName;
    // 系统序列号
    private String serialnumber;
    // 磁盘序列号
    private String diskSerial;
    // 网卡mac
    private String mac;
    // Ip地址
    private String ip;
    // 服务端口号
    private String port;
    // 服务名
    private String serverName;

    public SystemInfos() {
    }

    public SystemInfos(String osName, String serialnumber, String diskSerial, String mac, String ip, String port, String serverName) {
        this.osName = osName;
        this.serialnumber = serialnumber;
        this.diskSerial = diskSerial;
        this.mac = mac;
        this.ip = ip;
        this.port = port;
        this.serverName = serverName;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getDiskSerial() {
        return diskSerial;
    }

    public void setDiskSerial(String diskSerial) {
        this.diskSerial = diskSerial;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String toString() {
        return "SystemInfos{" +
                "osName='" + osName + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", diskSerial='" + diskSerial + '\'' +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
    public byte[] getBytes() throws UnsupportedEncodingException {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.osName).append(this.serialnumber).append(this.diskSerial)
                .append(this.mac).append(this.ip).append(this.port).append(this.serverName);
        return buffer.toString().getBytes("UTF-8");
    }
}
