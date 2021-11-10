package com.design.adapter;

public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("公司员工姓名");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("公司员住址");
        return null;
    }

    @Override
    public String getMobilePhone() {
        System.out.println("公司员工电话");
        return null;
    }
}
