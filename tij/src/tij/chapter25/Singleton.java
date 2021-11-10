package tij.chapter25;

interface Resource {
    int getValue();

    void setValue(int x);
}

public class Singleton {
    private static class ResourceHolder {
        private static Resource resource = new ResourceImpl(47);
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }

    private static final class ResourceImpl implements Resource {
        private int i;

        private ResourceImpl(int i) {
            this.i = i;
        }

        public synchronized int getValue() {
            return i;
        }

        public synchronized void setValue(int x) {
            i = x;
        }
    }
}
