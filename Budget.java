import java.util.*;

public class Budget {
    public static Scanner sc1 = new Scanner(System.in);
    private String name;
    private double cost;
    private Map<String, Double> ExpenseListMixed = new HashMap<>();
    private Map<String, Double> ExpenseListpercentages = new HashMap<>();

    private double totalBudget = 0;
    private double availableMoney;

    public Budget(double initialBudget) {
        //data validation for initial budget
        while (initialBudget < 1) {
            System.out.println("Please enter a valid amount");
            initialBudget = sc1.nextDouble();
        }
        totalBudget = initialBudget;
        availableMoney=totalBudget;
        System.out.println("Your total budget is set to: " + totalBudget);
    }

    /*double moneyAllocated = 0;
        for (Double val : ExpenseListMixed.values()) {
        moneyAllocated += val;
    }*/
    public void inputExpense(String name, double cost) {
        this.name = name;
        this.cost = cost;
        validateBudget(availableMoney);
        ExpenseListMixed.put(name, cost);
        ExpenseListpercentages.put(name, 0.0);
        availableMoney = availableMoney - cost;
        System.out.println("Entered" + cost + "," + (availableMoney) + " remaining from your total budget");

    }



    public void validateBudget(double newBudget){
        if (ExpenseListMixed.containsKey(name)) {
            Double ExpenseChanged;
            availableMoney = availableMoney + ExpenseListMixed.get(name);
            ExpenseChanged = ExpenseListMixed.get(name);
            ExpenseListMixed.put(name, newBudget);
            availableMoney = availableMoney - ExpenseListMixed.get(name);
            if (availableMoney < 0) {
                System.out.println("New expense exceeds your total budget, leaving you with " + availableMoney);
                ExpenseListMixed.put(name, ExpenseChanged);
            }
        } /*else {
            System.out.println("the requested expense was not previously created.");
            //HashMaps are the storage method
        }*/
    }
    public void changeExpense(String name, double newBudget) {
        while (newBudget < 0) {
            System.out.println("Budget is too low, please enter a new budget");
            newBudget = sc1.nextDouble();
        }
        validateBudget(newBudget);


    }
    public void seeCurrentBurgetAllocation() {
        for (Map.Entry<String, Double> input : this.ExpenseListMixed.entrySet())
            System.out.println("Object = " + input.getKey() +
                    ", Expense = " + input.getValue());
    }
    public void percentageCalculator() {
        double total = 0;
        for (Double val : this.ExpenseListMixed.values()) {
            total += val;
        }
        Map<String, ArrayList<Double>> percentageMap = new HashMap<>();
        //Uses the interface entry which allows you to iterate through a hashmap and use both the key and the values
       // a for loop to sum the total value
        for (Map.Entry<String, Double> entry : this.ExpenseListMixed.entrySet()) {
            List<Double> temporaryArray = List.of((entry.getValue() / total), entry.getValue());
            ArrayList<Double> temporaryArrayList = new ArrayList<>(temporaryArray);
            percentageMap.put(entry.getKey(), temporaryArrayList);
        }
        for (Map.Entry<String, ArrayList<Double>> printing : percentageMap.entrySet()) {
            System.out.println("Expense name = " + printing.getKey() +
                    ", Value = " + String.format("%.2f",printing.getValue().get(0))+" % "+
                    printing.getValue().get(1)+" euros");
        }
    }
    public static void populateDatabase(Budget budget){
        budget.inputExpense("Dog", 100);
        budget.inputExpense("Potatoes", 50);
        budget.inputExpense("Cat", 150);

    }
}
