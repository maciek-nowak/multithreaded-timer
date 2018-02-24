import controller.TimerController;
import service.TimerService;
import view.UserInterface;

public class Application {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        TimerService timerService = new TimerService(userInterface);
        new TimerController(userInterface, timerService).start();
    }

}
