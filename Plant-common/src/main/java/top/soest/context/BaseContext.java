package top.soest.context;

public class BaseContext {

    public static ThreadLocal<Long> THREAD_LOCAL = new ThreadLocal<>();

    public static void setThreadLocal(long id) {
        THREAD_LOCAL.set(id);
    }

    public static Long getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    public static void removeThreadLocal() {
        THREAD_LOCAL.remove();
    }
}
