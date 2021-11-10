package com.design.adapter;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOuterUser {
    @Override
    public Map<String, String> getUserBaseInfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("userName", "payphone");
        map.put("phone", "150789515893");
        return map;
    }

    @Override
    public Map<String, String> getUserHomeInfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("home", "jiangxi ganzhou");
        return map;
    }
}
