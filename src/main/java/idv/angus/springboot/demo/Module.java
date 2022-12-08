package idv.angus.springboot.demo;

import com.google.common.collect.ImmutableMap;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Module {
    private final ScheduledExecutorService executor =
            new ScheduledThreadPoolExecutor(2, new NamedThreadFactory("poker-racing"));

    private final Map<String, Task> stages = ImmutableMap.of(
            TaskA.class.getSimpleName(), new TaskA(this),
            TaskB.class.getSimpleName(), new TaskB(this)
    );
    private Task currentStage = stages.get(TaskA.class.getSimpleName());
    private String moduleName;

    public Module(String moduleName) {
        this.moduleName = moduleName;
    }

    public void next(int delay) {
        executor.schedule(() -> {
            System.out.println(String.format("%s, currentTs: %s, %s start, threadName: %s",
                    moduleName, Instant.now().toString(), currentStage.getClass().getSimpleName(), Thread.currentThread().getName()));

            try {
                Task oldStage = currentStage;
                Task newStage = stages.get(currentStage.getNext());

                oldStage.execute();

                this.currentStage = newStage;
                newStage.changed();
            } catch (Throwable e) {

            }
        }, delay, TimeUnit.MILLISECONDS);
    }

    public String getModuleName() {
        return moduleName;
    }
}
