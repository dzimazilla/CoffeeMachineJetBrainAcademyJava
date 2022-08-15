import java.util.Scanner;

public class CoffeeMachine {

    static void printState(int[] stateCoffeeMachine) {
        System.out.println("The coffee machine has:\n" +
                stateCoffeeMachine[0] + " ml of water\n" +
                stateCoffeeMachine[1] + " ml of milk\n" +
                stateCoffeeMachine[2] + " g of coffee beans\n" +
                stateCoffeeMachine[3] + " disposable cups\n" +
                "$" + stateCoffeeMachine[4] + " of money\n");
    }

    static void cupCoffeeSold(int[] typeCoffee, int[] stateCoffeeMachine) {
        if (typeCoffee[0] > stateCoffeeMachine[0]) {
            System.out.println("Sorry, not enough water!");
        } else if (typeCoffee[1] > stateCoffeeMachine[1]) {
            System.out.println("Sorry, not enough milk!");
        } else if (typeCoffee[2] > stateCoffeeMachine[2]) {
            System.out.println("Sorry, not enough coffee!");
        } else if (typeCoffee[3] > stateCoffeeMachine[3]) {
            System.out.println("Sorry, not enough cups!");
        } else {
            stateCoffeeMachine[0] -= typeCoffee[0];
            stateCoffeeMachine[1] -= typeCoffee[1];
            stateCoffeeMachine[2] -= typeCoffee[2];
            stateCoffeeMachine[3] -= typeCoffee[3];
            stateCoffeeMachine[4] += typeCoffee[4];
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //0: water; 1: milk; 2: beans; 3: cups; 4: money
        int[] espresso = {250, 0, 16, 1, 4};
        int[] latte = {350, 75, 20, 1, 7};
        int[] cappuccino = {200, 100, 12, 1, 6};
        int[] stateCoffeeMachine = {400, 540, 120, 9, 550};
        String action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();

            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String typeCoffee = scanner.next();
                    switch (typeCoffee) {
                        case "1":
                            cupCoffeeSold(espresso, stateCoffeeMachine);
                            break;
                        case "2":
                            cupCoffeeSold(latte, stateCoffeeMachine);
                            break;
                        case "3":
                            cupCoffeeSold(cappuccino, stateCoffeeMachine);
                            break;
                        case "back": break;
                        default:
                            System.out.println("Mistaken input");
                            break;
                    }
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    stateCoffeeMachine[0] += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    stateCoffeeMachine[1] += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    stateCoffeeMachine[2] += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    stateCoffeeMachine[3] += scanner.nextInt();
                }
                case "take" -> {
                    System.out.println("I gave you $" + stateCoffeeMachine[4]);
                    stateCoffeeMachine[4] = 0;
                }
                case "remaining" -> printState(stateCoffeeMachine);
                case "exit" -> {
                }
                default -> System.out.println("Mistaken input");
            }
        } while (!action.equals("exit"));
    }
}