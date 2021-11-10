package com.design.builder;

/**
 * 校验逻辑放置到 Builder 类中，先创建建造者，并且通过 set() 方法设置建造者的变量值，然后在使用 build() 方法真正创建对象之前，做集中的校验，校验通过之后才会创建对象。
 */
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    public static void main(String[] args) throws Exception {
        ResourcePoolConfig test_db = new Builder()
                .setName("test_db")
                .setMinIdle(1)
                .setMaxIdle(5)
                .setMaxTotal(50)
                .builder();
        System.out.println(test_db);
    }

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.maxTotal = builder.maxTotal;
        this.minIdle = builder.minIdle;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        // 设置好属性后，对属性进行检查，然后再创建对象
        private ResourcePoolConfig builder() throws Exception {
            if ("".equals(this.name) || null == this.name) {
                throw new Exception("name should not be null");
            }
            if (this.maxTotal <= 0) {
                throw new Exception("maxTotal should > zero");
            }
            if (this.minIdle < 0) {
                throw new Exception("minIdle should >= 0");
            }
            if (this.maxTotal < this.minIdle) {
                throw new Exception("maxTotal should >= minIdle");
            }
            // 创建出我们需要的对象。
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }
}
