package controller;

import enums.Options;
import service.TimerService;
import view.UserInterface;

public class TimerController {
    private UserInterface userInterface;
    private TimerService timerService;

    public TimerController(UserInterface userInterface, TimerService timerService) {
        this.userInterface = userInterface;
        this.timerService = timerService;
    }

    public void start() {
        Options option = null;

        do {
            String userChoice = this.userInterface.getUserChoice();
            String[] arguments = userChoice.split("\\s+");

            if (arguments.length < 1 || arguments.length > 2) {
                this.userInterface.printError("Wrong number of arguments!");
            } else if (!Options.contains(arguments[0])) {
                this.userInterface.printError("Unknown command!");
            } else if (arguments.length == 2) {
                option = Options.getOption(arguments[0]);
                this.timerService.executeCommand(option, arguments[1]);
            } else {
                option = Options.getOption(arguments[0]);
                this.timerService.executeCommand(option);
            }

        } while (option != Options.EXIT);
    }
}
