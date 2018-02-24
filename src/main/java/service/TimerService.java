package service;

import enums.Options;
import model.MyTimer;
import view.UserInterface;

import java.util.HashMap;
import java.util.Map;


public class TimerService {
    private Map<String, MyTimer> timers;
    private UserInterface userInterface;

    public TimerService(UserInterface userInterface) {
        this.timers = new HashMap<>();
        this.userInterface = userInterface;
    }

    public void executeCommand(Options option, String name) {
        switch (option) {
            case START:
                this.startTimer(name);
                break;

            case CHECK:
                this.listTimer(name);
                break;

            case STOP:
                this.stopTimer(name);
                break;
        }
    }

    private void stopTimer(String name) {
        name = name.toUpperCase();
        if (this.timers.containsKey(name)) {
            MyTimer chosenTimer = this.timers.get(name);
            chosenTimer.interrupt();
        }
    }

    private void startTimer(String name) {
        name = name.toUpperCase();

        if (!this.timers.containsKey(name)) {
            this.timers.put(name, new MyTimer(name));
            this.timers.get(name).start();
        } else {
            this.timers.get(name).resetInterrupt();
        }
    }

    public void executeCommand(Options option) {
        switch (option) {
            case CHECK:
                this.listAllTimers();
                break;

            case EXIT:
                this.closeAllTimers();
                break;
        }

    }

    private void closeAllTimers() {
        for (MyTimer timer : timers.values()) {
            timer.close();
        }
    }

    private void listAllTimers() {
        for (MyTimer timer : timers.values()) {
            this.userInterface.print(timer.toString());
        }
    }

    private void listTimer(String name) {
        name = name.toUpperCase();
        if (this.timers.containsKey(name)) {
            MyTimer chosenTimer = this.timers.get(name);
            this.userInterface.print(chosenTimer.toString());
        }
    }
}
