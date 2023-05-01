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
    public double getTotalExpenses(Map<String, Double> expenses) {
        double total = 0;
        for (Double val : expenses.values()) {
            total += val;
        }
    return total;
    }
public void changeTotalBudget(){
        double oldTotalBudget = this.totalBudget;
    System.out.println("please write the new amount");
        Scanner scIn= new Scanner(System.in);
        this.totalBudget = scIn.nextDouble();
        while (this.totalBudget<getTotalExpenses(this.ExpenseListMixed)){
            System.out.println("New budget is lower than current expenses, please input a higher amount");
            this.totalBudget = scIn.nextDouble();
        }
    System.out.println("Updated, the new budget is of "+ this.totalBudget+" euros");
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
    public void reallocateBudget(Budget budget){
        Scanner sc3 = new Scanner(System.in);
        System.out.println(budget.ExpenseListMixed + "\n Which expense which will have its budget modified ");
        String nameOfExpense = sc3.nextLine();
                    if (budget.ExpenseListMixed.get(nameOfExpense).equals(null)) {
                        System.out.println(budget.ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget REDUCED ");
                        nameOfExpense =sc1.nextLine().toLowerCase();
                    }
        System.out.println(budget.ExpenseListMixed + "\n please write the amount of money that will be substracted from the account ");
                    double budgetChange=0;
        boolean notDouble=true;
        //TODO find how to change in reallocateBudget the while, to have an input validator for the doubles
        while (notDouble)
            try {
                budgetChange = Double.parseDouble(sc3.nextLine());
                notDouble=false;
            } catch (NumberFormatException nfe) {
                System.out.print("Try again: ");
            }

        System.out.println(budget.ExpenseListMixed + "\n \n please write the name of the expense which will have its budget INCREASED ");
        String nameOfIncreasedBudget = sc3.skip("\n").nextLine();
                    if (budget.ExpenseListMixed.get(nameOfIncreasedBudget).equals(null)) {
                        System.out.println(budget.ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget modified ");
                        nameOfIncreasedBudget =sc1.nextLine().toLowerCase();}


        if (budget.ExpenseListMixed.get(nameOfExpense) + budgetChange < 0) {
            System.out.println("amount is greater than the amount currently allocated to that expense, please re-check your input");
            budgetChange = sc3.skip("\n").nextDouble();
        }
        budget.ExpenseListMixed.put(nameOfExpense,budget.ExpenseListMixed.get(nameOfExpense)-budgetChange);
        budget.ExpenseListMixed.put(nameOfIncreasedBudget,budget.ExpenseListMixed.get(nameOfIncreasedBudget)+budgetChange);
        System.out.println(budget.ExpenseListMixed + "\n is the updated budget ");
    }
}
