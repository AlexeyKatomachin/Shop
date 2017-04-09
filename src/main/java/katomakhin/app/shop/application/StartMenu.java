package katomakhin.app.shop.application;

import java.util.Scanner;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public class StartMenu {
    public static final String COMMAND = (char) 27 + "[92m";
    public static final String END = (char) 27 + "[0m";

    public void start() {
        history = new MessageHistory();
        System.out.println("Console App for working with messages in JSON format.");
        System.out.println("Type " + COMMAND + "help" + END + " for list of commands; " +
                COMMAND + "quit" + END + " to quit.");
        inputWaiter();
    }

    private void inputWaiter() {
        try (Scanner in = new Scanner(System.in)) {
            do {
                System.out.print("shop> ");
            } while (handleCommand(in.nextLine()));
        } catch (Exception e) {
            System.out.println("Something went wrong:(");
        } finally {
            history.close();
            System.out.println("Thanks for using my app!");
        }
    }

    private boolean handleCommand(String category) {
        String[] command = category.split(" ");
        int inputSize = command.length - 1;
        switch (command[0]) {

            case "load":
                history.loadMessagesFromJsonFile( inputSize == 0 ? null : command[1] );
                return true;

            case "add":
                if (inputSize < 2) {
                    System.out.println(RED + "WARNING: not enough arguments, some data will be replaced with ?" + END);
                }
                if (inputSize == 0 ) {
                    history.addMessage("?", "?");
                } else if (inputSize == 1) {
                    history.addMessage(command[1], "?");
                } else if (inputSize >= 2) {
                    StringBuilder message = new StringBuilder();
                    for (int i = 2; i < command.length; i++) {
                        message.append(command[i]).append(" ");
                    }
                    message.deleteCharAt(message.length() - 1);
                    history.addMessage(command[1], message.toString());
                }
                return true;

            case "show":
                if (inputSize == 0) {
                    history.showMessages(false);
                } else if (inputSize == 1) {
                    if (command[1].equals("-f")) {
                        history.showMessages(true);
                    } else {
                        history.showMessagesByTime(false, command[1], null);
                    }
                } else if (inputSize == 2) {
                    if (command[1].equals("-f")) {
                        history.showMessagesByTime(true, command[2], null);
                    } else {
                        history.showMessagesByTime(false, command[1], command[2]);
                    }
                } else if (inputSize == 3 && command[1].equals("-f")) {
                    history.showMessagesByTime(true, command[2], command[3]);
                } else {
                    System.out.println(RED + "WRONG QUERY: bad set of arguments" + END);
                }
                return true;

            case "remove":
                history.deleteMessagePermanently( inputSize == 0 ? null : command[1] );
                return true;

            case "save":
                history.saveMessagesToJsonFile( inputSize == 0 ? null : command[1] );
                return true;

            case "search":
                if (inputSize < 2) {
                    System.out.println(RED + "ERROR: not enough arguments. Parameters are required" + END);
                    return true;
                }
                history.searchMessages(command[1], command[2]);
                return true;

            case "clear":
                history.clearMessages();
                return true;

            case "quit":
            case "exit":
                return false;

            default:
                System.out.println("Unknown command. Try again.");
                return true;
        }
    }
}
