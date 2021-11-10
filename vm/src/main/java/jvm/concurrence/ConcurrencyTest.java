package jvm.concurrence;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.I_Result;

@JCStressTest
// 检查感兴趣的结果。如果结果是 1 和 4 那么分类未 Expect.ACCEPTABLE
@Outcome(id = {"1"}, expect = Expect.ACCEPTABLE, desc = "ok")
@Outcome(id = {"0"}, expect = Expect.ACCEPTABLE_INTERESTING, desc = "!!!!")
@State
public class ConcurrencyTest {
    int num = 2;

    @Actor
    public void actor1(I_Result r) {
        if (DCL.getInstance() == DCL.getInstance()) {
            r.r1 = 1;
        } else {
            r.r1 = 0;
        }
    }

    @Actor
    public void actor2(I_Result r) {
        num = 2;
    }
}