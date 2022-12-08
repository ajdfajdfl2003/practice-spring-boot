package idv.angus.springboot.demo;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TaskB implements Task {
    private final Module module;

    public TaskB(Module module) {
        this.module = module;
    }

    @Override
    public void execute() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);

        System.out.println(String.format("%s, currentTs: %s, TaskB done, threadName: %s",
                module.getModuleName(), Instant.now().toString(), Thread.currentThread().getName()));
    }

    @Override
    public String getNext() {
        return TaskA.class.getSimpleName();
    }

    @Override
    public void changed() {
        this.module.next(2000);
    }
}
