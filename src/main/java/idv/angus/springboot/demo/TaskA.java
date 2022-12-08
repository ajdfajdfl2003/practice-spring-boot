package idv.angus.springboot.demo;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class TaskA implements Task {
    private final Module module;

    public TaskA(Module module) {
        this.module = module;
    }

    public void execute() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        System.out.println(String.format("%s, currentTs: %s, TaskA done, threadName: %s",
                module.getModuleName(), Instant.now().toString(), Thread.currentThread().getName()));
    }

    @Override
    public String getNext() {
        return TaskB.class.getSimpleName();
    }

    @Override
    public void changed() {
        this.module.next(2000);
    }
}
