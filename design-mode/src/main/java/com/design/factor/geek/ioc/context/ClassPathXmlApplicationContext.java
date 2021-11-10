package com.design.factor.geek.ioc.context;

import com.design.factor.geek.ioc.parser.BeanConfigParser;
import com.design.factor.geek.ioc.bean.BeanDefinition;
import com.design.factor.geek.ioc.BeansFactory;
import com.design.factor.geek.ioc.parser.XmlBeanConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SuppressWarnings("all")
public class ClassPathXmlApplicationContext implements ApplicationContext {
    // bean工厂
    private BeansFactory beansFactory;
    // 解析配置文件
    private BeanConfigParser beanConfigParser;

    // 初始化Contex，将一些设置为 随Context的加载而加载的Bean一起加载到容器中。
    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    // 加载bean信息
    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
