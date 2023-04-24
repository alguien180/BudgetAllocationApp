import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {
    public static Scanner sc1 = new Scanner(System.in);
    private String name;
    private double cost;
    private Map<String, Double> ExpenseListMixed = new HashMap<>();
    private Map<String, Double> ExpenseListpercentages = new HashMap<>();

    private double totalBudget = 0;
    private double availableMoney = totalBudget;

    public Budget(double initialBudget) {
        //data validation for initial budget
        while (initialBudget < 1) {
            System.out.println("Please enter a valid amount");
            initialBudget = sc1.nextDouble();
        }
        totalBudget = initialBudget;
        System.out.println("Your total budget is set to: " + totalBudget);
    }

    /*double moneyAllocated = 0;
        for (Double val : ExpenseListMixed.values()) {
        moneyAllocated += val;
    }*/
    public void inputExpense(String name, double cost) {
        this.name = name;
        this.cost = cost;
        ExpenseListMixed.put(name, cost);
        ExpenseListpercentages.put(name, 0.0);
        availableMoney = availableMoney - cost;
        System.out.println("Entered" + cost + "," + (availableMoney) + " remaining from your total budget");
    }

    public void validateBudget() {

    }

    public void changeExpense(String name, double newBudget) {
        while (newBudget < 0) {
            System.out.println("Budget is too low, please enter a new budget");
            newBudget = sc1.nextDouble();
        }

        if (ExpenseListMixed.containsKey(name)) {
            Double ExpenseChanged;
            availableMoney = availableMoney + ExpenseListMixed.get(name);
            ExpenseChanged = ExpenseListMixed.get(name);
            ExpenseListMixed.put(name, newBudget);
            availableMoney = availableMoney - ExpenseListMixed.get(name);
            if (availableMoney < 0) {
                System.out.println("New expense exceeds your total budget " + availableMoney);
                ExpenseListMixed.put(name, ExpenseChanged);
            }
        } else {
            System.out.println("the requested expense has not yet been created.");
            //HashMaps are the storage method
        }
    }
}
