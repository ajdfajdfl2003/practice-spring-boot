package idv.angus.springboot.demo;

public interface Task {
    void execute() throws InterruptedException;

    String getNext();

    void changed();
}
