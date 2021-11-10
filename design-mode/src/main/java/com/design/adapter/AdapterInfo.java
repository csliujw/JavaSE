package com.design.adapter;

import java.util.Map;

/**
 * 适配器，将原本无法适配的内容进行一定的转换。不用遵循死规则，可以写的灵活些。
 */
public class AdapterInfo extends OuterUser implements IUserInfo {

    // 初始化了父类的数据，用的父类的数据
    private Map<String, String> baseInfo = super.getUserBaseInfo();
    private Map<String, String> homeInfo = super.getUserHomeInfo();

    @Override
    public String getUserName() {
        return baseInfo.get("userName");
    }

    @Override
    public String getHomeAddress() {
        return homeInfo.get("home");
    }

    @Override
    public String getMobilePhone() {
        return baseInfo.get("phone");
    }
}
