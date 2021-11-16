package com.dfe.appcode;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;

import java.util.Arrays;
import java.util.List;
/**
 * @author     ：任登凯
 * @date       ：Created in 2021-08-12 11:05:00
 * @description：获取系统相关信息
 */
public class OshiUtil {
    private static SystemInfo si;
    private static SystemInfos infos;
    private static HardwareAbstractionLayer hal;
    private static OperatingSystem os;
    static {
        SystemInfo si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();
    }

    public static synchronized SystemInfos getSystemInfo(String port,String serverName) {
        if(infos==null) {
            infos = new SystemInfos();
            infos.setOsName(System.getProperty("os.name"));
            infos.setSerialnumber(hal.getComputerSystem().getSerialNumber());
            List<HWDiskStore> diskStores = hal.getDiskStores();
            for (HWDiskStore diskStore : diskStores) {
                infos.setDiskSerial(diskStore.getSerial());
                break;
            }
            List<NetworkIF> networkIFs = hal.getNetworkIFs();
            for (NetworkIF networkIF : networkIFs) {
                infos.setMac(networkIF.getMacaddr());
                infos.setIp(Arrays.toString(networkIF.getIPv4addr()));
                break;
            }
            infos.setPort(port);
            infos.setServerName(serverName);
        }
        return infos;
    }
}
