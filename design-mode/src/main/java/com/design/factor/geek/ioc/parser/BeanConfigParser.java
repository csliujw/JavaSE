package com.design.factor.geek.ioc.parser;

import com.design.factor.geek.ioc.bean.BeanDefinition;

import java.io.InputStream;
import java.util.List;

/**
 * bean配置信息解析接口
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);
}
