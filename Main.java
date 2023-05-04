import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("enter initial budget");
        menu();

    }

    public static void menu() {

        Budget budget = new Budget(sc.nextDouble());

        int menuOption = 0;
        menuString();
        while (menuOption != 6) {
            while (menuOption < 1 || menuOption > 7) {
                System.out.println("invalid input, re-enter the option");
                menuOption = sc.nextInt();
            }
            if (menuOption == 1) {
                //allows the declaration and input of new expenses
                System.out.println("enter object name");
                String name = sc.next().toLowerCase();
                System.out.println("enter object cost");
                double cost = sc.nextDouble();
                budget.inputExpense(name, cost);

                menuString();
                menuOption = sc.nextInt();
            } else if (menuOption == 2) {
                System.out.println("Enter the name of the budget to be changed and press INTRO ");
                budget.seeCurrentBurgetAllocation();
                String name = sc.next();

                System.out.println("\n then enter the new budget for this object and press INTRO");
                double newExpense = sc.nextDouble();
                budget.changeExpense(name, newExpense);

                menuString();
                menuOption = sc.nextInt();

            } else if (menuOption == 3) {

                budget.reallocateBudget(budget);
                menuString();
                menuOption = sc.nextInt();

            } else if (menuOption == 4) {
                //shows current hashmap list

                budget.percentageCalculator();
                menuString();
                menuOption = sc.nextInt();

            } else if (menuOption == 5) {
                //Allows to change the total budget
                budget.changeTotalBudget();
                menuString();
                menuOption = sc.nextInt();

            } else if (menuOption == 6) {
                break;
            } else if (menuOption == 7) {
                budget.populateDatabase(budget);
                menuString();
                menuOption = sc.nextInt();
            }
        }
    }

    public static void menuString() {
        System.out.println("\n\n Welcome, what would you like to do?" +
                "\n 1. Input a new expense " +
                "\n 2. increase or reduce amount of an expense " +
                "\n 3. Re-allocate budget to another section " +
                "\n 4. See the current budget allocation " +
                "\n 5. re-set total budget " +
                "\n 6. exit programm" +
                "\n 7. Auto-fill with 3 objects for testing");

    }
}


