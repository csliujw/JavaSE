package com.design.factor.geek.ioc.parser;

import com.design.factor.geek.ioc.bean.BeanDefinition;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class XmlBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        // something to do
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        // something to do
        return beanDefinitions;
    }
}
