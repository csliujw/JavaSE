package com.design.factor.geek.ioc.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean定义信息
 */
@SuppressWarnings("all")
public class BeanDefinition {
    // bean id
    private String id;
    // bean 类全名
    private String className;
    // 构造参数列表
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    // 单例 非单例
    private Scope scope = Scope.SINGLETON;
    // 是否懒加载
    private boolean lazyInit = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }
}
