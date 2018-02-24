package view;

import java.util.Scanner;

public class UserInterface {
    private Scanner scan;

    public UserInterface() {
        this.scan = new Scanner(System.in);
    }

    public String getUserChoice() {
        System.out.println("Type your command: ");
        return scan.nextLine();
    }

    public void printError(String message) {
        System.out.println("ERROR: " + message);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
