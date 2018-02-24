package model;

public class MyTimer extends Thread {
    private int timeCounter;
    private boolean isActive;
    private boolean isClosed;

    public void close() {
        this.isClosed = true;
    }

    public MyTimer(String name) {
        super(name);
        this.timeCounter = 0;
        this.isActive = true;
        this.isClosed = false;
    }

    @Override
    public void run() {

        while (!this.isClosed) {

            try {
                Thread.sleep(1000);

                if (this.isActive) {
                    this.timeCounter++;
                }

            } catch (InterruptedException e) {
                this.isActive = false;
            }

        }

    }

    public void resetInterrupt() {
        this.isActive = true;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, ThreadId: %d, Seconds: %d", this.getName(), this.getId(), this.timeCounter);
    }

}
