package idv.angus.springboot.demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class ModuleTest {

    @Test
    void name() throws InterruptedException {
        new Module("123").next(0);
        new Module("456").next(0);
        new Module("789").next(0);
        TimeUnit.SECONDS.sleep(180);
    }
}