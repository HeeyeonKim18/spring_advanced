package hello.advanced.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) throws IllegalAccessException, InterruptedException {

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderRepository.save()");
            if (itemId.equals("ex")) {
                throw new IllegalAccessException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 한다.
        }

        // 저장 로직

    }

    private void sleep(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
