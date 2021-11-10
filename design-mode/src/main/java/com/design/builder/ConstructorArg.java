package com.design.builder;

/**
 * 在下面的 ConstructorArg 类中
 * 当 isRef 为 true 的时候，arg 表示 String 类型的refBeanId，type 不需要设置；
 * 当 isRef 为 false 的时候，arg、type 都需要设置。
 * 请根据这个需求，完善 ConstructorArg 类。
 */
@SuppressWarnings("all")
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    public static void main(String[] args) throws Exception {
        ConstructorArg builder = new Builder().setRef(false).setArg("Hell").setType(String.class).builder();
    }

    private ConstructorArg(Builder builder) {
        this.isRef = builder.isRef;
    }

    public static class Builder {
        private boolean isRef = true;
        private Class type;
        private Object arg;

        public ConstructorArg builder() throws Exception {
            // 逻辑检查
            this.checkLogic();
            return new ConstructorArg(this);
        }

        public void checkLogic() throws Exception {
            if (isRef) {
                if (arg.getClass() != String.class) {
                    throw new Exception("arg必须为String类型");
                }
                if (null != type) {
                    throw new Exception("type必须为null");
                }
            } else {
                if (null == arg) {
                    throw new Exception("arg必须设置");
                }
                if (null == type) {
                    throw new Exception("type必须设置");
                }
            }
        }

        public Builder setRef(boolean ref) {
            this.isRef = ref;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }
}
