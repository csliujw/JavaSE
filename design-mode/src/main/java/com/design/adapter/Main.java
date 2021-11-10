package com.design.adapter;

/**
 * 适配器模式。
 * 将两个原本功能不相关的类，通过中间类（适配器）进行相应转换。
 * UserInfo 与
 */
public class Main {
    public static void main(String[] args) {
        IUserInfo userInfo = new UserInfo();
        userInfo.getHomeAddress();

        IUserInfo adapterInfo = new AdapterInfo();
        System.out.println(adapterInfo.getHomeAddress());
    }
}
