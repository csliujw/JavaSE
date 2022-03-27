package monitor;


import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;

class Dog {
}

@Slf4j(topic = "c.TestBiased")
public class TestBiased {
    // 测试hashCode -XX:+UseCompressedOops -XX:BiasedLockingStartupDelay=0
    public static void main(String[] args) throws IOException, InterruptedException {
        // 要解析的对象
        Object obj = new Object();
        obj.hashCode();
        log.debug(ClassLayout.parseInstance(obj).toPrintable());
    }
}

