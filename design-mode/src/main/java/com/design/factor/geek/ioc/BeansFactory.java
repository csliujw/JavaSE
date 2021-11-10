package com.design.factor.geek.ioc;

import com.design.factor.geek.ioc.bean.BeanDefinition;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("all")
public class BeansFactory {
    // 存储属性为单例的对象。ConcurrentHashMap：线程安全
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        // to do something
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            // 不是懒加载
            if (beanDefinition.isLazyInit() == false && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    public Object getBean(String beanId) {
        // to do something
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        try {
            if (beanDefinition == null) {
                throw new NoSuchObjectException("bean is not define: " + beanId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createBean(beanDefinition);
    }

    protected Object createBean(BeanDefinition beanDefinition) {
        // 如果是单例，且已经实例化
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId()))
            return singletonObjects.get(beanDefinition.getId());
        // to do something
        return null;
    }
}
