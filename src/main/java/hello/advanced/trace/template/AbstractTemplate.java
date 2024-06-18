package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T>{

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) throws InterruptedException, IllegalAccessException {
        TraceStatus status = null;
        try{
            status = trace.begin(message);

            // 로직 호출
            T result = call();

            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, new IllegalStateException());
            throw e;
        }
    }

    protected abstract T call() throws InterruptedException, IllegalAccessException;
}

