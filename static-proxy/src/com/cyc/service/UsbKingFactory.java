package com.cyc.service;
//目标类：金士顿厂家，厂家不接受用户的单独购买。
public class UsbKingFactory implements  UsbSell{
    @Override
    public float sell(int amount) {
        //一个128G的u盘是85元

        return amount;
    }
}
