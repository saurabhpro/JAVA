package saurabh;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Defog Tech
 * <p>
 * If SDF only had global state variable, set only once during Constructor,
 * we would not have thread-safety problem.
 * <p>
 * Unfortunately, multiple global variables (eg: calendar) are modified even when format() method is called.
 * Thus if 2 threads use same SDF object, and both call format() at the same time,
 * one thread's format() will call calendar.setTime(date) and
 * then other thread will do the same overriding first thread's date.
 * <p>
 * Thus we need external sync over whole object, or have to use ThreadLocal.
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        UserService.getFormattedBirthDate();
    }

    // Use ThreadLocal for thread-safety, memory efficiency and for per-thread context storage.
    // or AtomicReference
    private static class ThreadSafeDateFormatter {
        public static final ThreadLocal<SimpleDateFormat> threadSafeFormatter =
                ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MM-yyyy"));

        private ThreadSafeDateFormatter() {
        }
    }

    private static class UserService {
        public static void getFormattedBirthDate() {
            Instant date = Instant.now();
            System.out.println(date);

            // evey thread will get its own copy of thread local - no object sharing - no synchronization required
            SimpleDateFormat formatter = ThreadSafeDateFormatter.threadSafeFormatter.get();
            System.out.println(formatter.format(Date.from(date)));
        }
    }
}
