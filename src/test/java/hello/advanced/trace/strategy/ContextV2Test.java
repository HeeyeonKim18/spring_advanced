package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excute(new StrategyLogic1());
        contextV2.excute(new StrategyLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excute(()-> log.info("비즈니스 로직 1 실행"));
        contextV2.excute(()-> log.info("비즈니스 로직 2 실행"));
    }

    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.excute(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });

        contextV2.excute(new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }
}
