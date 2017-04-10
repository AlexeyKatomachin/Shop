package katomakhin.app.shop.application;

import katomakhin.app.shop.entity.Shop;
import katomakhin.app.shop.entity.user.User;
import katomakhin.app.shop.facade.ShopManager;

import java.util.Scanner;

public class StartMenu {
    public static final String COMMAND = (char) 27 + "[92m";
    public static final String END = (char) 27 + "[0m";
    public Shop shop;

    public void start() {
        shop = new ShopManager().initShop();
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
            System.out.println("Thanks for using my app!");
        }
    }

    private boolean handleCommand(String category) {
        String[] command = category.split(" ");
        int inputSize = command.length - 1;
        switch (command[0]) {

            case "free":
                new ShopManager().printFreeEquipment();
                return true;

            case "reserve":
                System.out.println("Enter title ");
                Scanner in = new Scanner(System.in);
                String title = in.nextLine();
                System.out.println("Enter user ID ");
                String userID = in.nextLine();
                User user = new User();
                user.setUserID(userID);
                new ShopManager().rentEquipment(title,shop,user);
                return true;

            case "res":
                new ShopManager().printRentEquipment();
                return true;
            case "help":
                help();
                return true;
            case "quit":
            case "exit":
                return false;

            default:
                System.out.println("Unknown command. Try again.");
                return true;
        }
    }

    public void help(){
        System.out.println("Type " + COMMAND + "free" + END + " to show free equipment;");
        System.out.println("Type " + COMMAND + "reserve" + END + " to reserve free equipment;");
        System.out.println("Type " + COMMAND + "res" + END + " to show reserve equipment;");
        System.out.println("Type " + COMMAND + "exit" + END + " to exit;");
    }
}
