import java.util.*;

public class BudgetAllocatorApp {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please enter your total budget");
        Budget budget = new Budget(sc1.nextDouble());

        int entry = 0;

        //initial input of the total budget
        //double totalMoney = sc1.nextDouble();
        //try {

            //menu

          //  entry = sc1.nextInt();

/*
    public static void changeBudget(Map<String,Double> budgets){
        Scanner sc3 = new Scanner(System.in);
        System.out.println(budgets + "\n Which expense which will have its budget modified ");
        String nameOfExpense = sc3.nextLine();
                    /*if (ExpenseListMixed.get(nameOfReducedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget REDUCED ");
                        nameOfReducedBudget =sc1.nextLine().toLowerCase();
                    }*/
            //System.out.println(budgets + "\n please write the amount of money that will be increased or substracted (use negative numbers for the latter) ");
            //double budgetChange = sc3.nextDouble();


       /* if (budgets.get(nameOfExpense) + budgetChange < 0) {
            System.out.println("amount is greater than the amount currently allocated to that expense, please re-check your input");
            budgetChange = sc3.skip("\n").nextDouble();
        }
        budgets.put(nameOfExpense,budgets.get(nameOfExpense)+budgetChange);
        System.out.println(budgets + "\n is the updated budget ");
    }

    public static void reallocateBudget(Map<String,Double> budgets){
        Scanner sc3 = new Scanner(System.in);
        System.out.println(budgets + "\n Which expense which will have its budget modified ");
        String nameOfExpense = sc3.nextLine();
                    /*if (ExpenseListMixed.get(nameOfReducedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget REDUCED ");
                        nameOfReducedBudget =sc1.nextLine().toLowerCase();
                    }
        System.out.println(budgets + "\n please write the amount of money that will be substracted from the account ");
        double budgetChange = sc3.nextDouble();

        System.out.println(budgets + "\n \n please write the name of the expense which will have its budget INCREASED ");
        String nameOfIncreasedBudget = sc3.skip("\n").nextLine();
                    /*if (ExpenseListMixed.get(nameOfIncreasedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget modified ");
                        nameOfIncreasedBudget =sc1.nextLine().toLowerCase();}

        */
        /*if (budgets.get(nameOfExpense) + budgetChange < 0) {
            System.out.println("amount is greater than the amount currently allocated to that expense, please re-check your input");
            budgetChange = sc3.skip("\n").nextDouble();
        }
        budgets.put(nameOfExpense,budgets.get(nameOfExpense)-budgetChange);
        budgets.put(nameOfIncreasedBudget,budgets.get(nameOfIncreasedBudget)+budgetChange);
        System.out.println(budgets + "\n is the updated budget ");
    }
public static double totalBudgetChange(Map<String, Double> budgets){
    System.out.println("Please enter the new expense budget");
    double totalMoney=0;
    Scanner sc2 = new Scanner(System.in);
    double moneyAllocated = 0;
    for (Double val : budgets.values()) {
        moneyAllocated += val;
    }
    totalMoney = sc2.nextDouble();
    if (totalMoney<0){
        System.out.println("Invalid amount, please enter a positive number");
        totalMoney = sc2.nextDouble();
    }
    if (totalMoney < moneyAllocated) {
        System.out.println("\n WARNING: New budget is less than the currently allocated budget. Cut expenses or input a new value\n");
    }
    System.out.println("Changed" + budgets + "," + (totalMoney - moneyAllocated) + " remaining from your total budget");
    return totalMoney;
}

    public static void percentageCalculator(Map<String, Double> expenses) {
        double total = 0;
        for (Double val : expenses.values()) {
            total += val;
        }
        Map<String, ArrayList<Double>> percentageMap = new HashMap<>();
        //Uses the interface entry which allows you to iterate through a hasmap and use both the key and the values
         a for loop to sum the total value
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
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

    public static void seeCurrentBurgetAllocation(Map<String, Double> expenseMap) {
        for (Map.Entry<String, Double> input : expenseMap.entrySet())
            System.out.println("Object = " + input.getKey() +
                    ", Expense = " + input.getValue());while(newBudget<0)
    }

     * 2 create a currency input property (hasmap won't cut it I think)
     * 2.1 create a connection to a curencty converter
     * + en funciones y comentar el codigo
     * meterlo en clases
    // add big decimal*/
            //agregar un modulo que te pida boundaries para metas de ahorro e inversion.
            //budget inmediato de projectos
            //correos de email automatizar envois de email*/
        }
    }
