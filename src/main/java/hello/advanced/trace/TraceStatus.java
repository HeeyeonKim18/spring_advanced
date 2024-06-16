package hello.advanced.trace;

// 로그의 상태 정보
public class TraceStatus {

    private TraceId traceId;
    private Long startMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startMs, String message) {
        this.traceId = traceId;
        this.startMs = startMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartMs() {
        return startMs;
    }

    public String getMessage() {
        return message;
    }
}
