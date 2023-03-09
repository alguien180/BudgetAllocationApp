import java.util.*;

public class BudgetAllocatorApp {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        //HashMaps are the storage method
        Map<String, Double> ExpenseListMixed = new HashMap<>();
        Map<String, Double> ExpenseListpercentages = new HashMap<>();
        int entry = 0;
        System.out.println("Please enter your total budget");
        //initial input of the total budget
        double totalMoney = sc1.nextDouble();
        try {
            //data validation for initial budget
            if (totalMoney < 1) {
                System.out.println("Please enter a valid amount");
                totalMoney = sc1.nextDouble();
            }
            //menu
            System.out.println("Welcome, what would you like to do?\n 1. Input a new expense \n 2. increase or reduce amount of an expense \n 3. Re-allocate budget to another section \n 4. See the current budget allocation \n 5. re-set total budget \n 6. exit programm");

            entry = sc1.nextInt();
            while (entry != 6) {
                while (entry < 1 || entry > 6) {
                    System.out.println("invalid input, re-enter the option");
                    entry = sc1.nextInt();
                }
                if (entry == 1) {
                    //allows the declaration and input of new expenses
                    System.out.println("enter object name");
                    String name = sc1.next().toLowerCase();

                    System.out.println("enter object cost");
                    double cost = sc1.nextDouble();
                    ExpenseListMixed.put(name, cost);
                    ExpenseListpercentages.put(name, 0.0);
                    double moneyAllocated = 0;
                    for (Double val : ExpenseListMixed.values()) {
                        moneyAllocated += val;
                    }

                    System.out.println("Entered" + ExpenseListMixed + "," + (totalMoney - moneyAllocated) + " remaining from your total budget");
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. increase or reduce amount of an expense \n 3. Re-allocate budget to another section \n 4. See the current budget allocation \n 5. re-set total budget \n 6. exit programm");
                    entry = sc1.nextInt();
                } else if (entry == 2) {

                    changeBudget(ExpenseListMixed);
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. increase or reduce amount of an expense \n 3. Re-allocate budget to another section \n 4. See the current budget allocation \n 5. re-set total budget \n 6. exit programm");
                    entry = sc1.nextInt();


                } else if (entry == 3) {

                    reallocateBudget(ExpenseListMixed);
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. increase or reduce amount of an expense \n 3. Re-allocate budget to another section \n 4. See the current budget allocation \n 5. re-set total budget \n 6. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 4) {
                    //shows current hashmap list
                    seeCurrentBurgetAllocation(ExpenseListMixed);
                    percentageCalculator(ExpenseListMixed);
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. increase or reduce amount of an expense \n 3. Re-allocate budget to another section \n 4. See the current budget allocation \n 5. re-set total budget \n 6. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 5) {
                    //Allows to change the total budget
                    totalBudgetChange(ExpenseListMixed);
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. increase or reduce amount of an expense \n 3. Re-allocate budget to another section \n 4. See the current budget allocation \n 5. re-set total budget \n 6. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 6) {
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number");
        } finally {
            sc1.close();
        }
    }

    public static void changeBudget(Map<String,Double> budgets){
        Scanner sc3 = new Scanner(System.in);
        System.out.println(budgets + "\n Which expense which will have its budget modified ");
        String nameOfExpense = sc3.nextLine();
                    /*if (ExpenseListMixed.get(nameOfReducedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget REDUCED ");
                        nameOfReducedBudget =sc1.nextLine().toLowerCase();
                    }*/
        System.out.println(budgets + "\n please write the amount of money that will be increased or substracted (use negative numbers for the latter) ");
        double budgetChange = sc3.nextDouble();


       /* if (budgets.get(nameOfExpense) + budgetChange < 0) {
            System.out.println("amount is greater than the amount currently allocated to that expense, please re-check your input");
            budgetChange = sc3.skip("\n").nextDouble();
        }*/
        budgets.put(nameOfExpense,budgets.get(nameOfExpense)+budgetChange);
        System.out.println(budgets + "\n is the updated budget ");
    }

    public static void reallocateBudget(Map<String,Double> budgets){
        Scanner sc3 = new Scanner(System.in);
        System.out.println(budgets + "\n Which expense which will have its budget modified ");
        String nameOfExpense = sc3.nextLine().toLowerCase();
                    /*if (ExpenseListMixed.get(nameOfReducedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget REDUCED ");
                        nameOfReducedBudget =sc1.nextLine().toLowerCase();
                    }*/
        System.out.println(budgets + "\n please write the amount of money that will be increased or substracted (use negative numbers for the latter) ");
        double budgetChange = sc3.nextDouble();

        System.out.println(budgets + "\n \n please write the name of the expense which will have its budget INCREASED ");
        String nameOfIncreasedBudget = sc3.skip("\n").nextLine().toLowerCase();
                    /*if (ExpenseListMixed.get(nameOfIncreasedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget modified ");
                        nameOfIncreasedBudget =sc1.nextLine().toLowerCase();}*/

        if (budgets.get(nameOfExpense) + budgetChange < 0) {
            System.out.println("amount is greater than the amount currently allocated to that expense, please re-check your input");
            budgetChange = sc3.skip("\n").nextDouble();
        }
        budgets.get(nameOfExpense).equals(budgets.get(nameOfExpense)-budgetChange);
        budgets.get(nameOfIncreasedBudget).equals(budgets.get(nameOfIncreasedBudget)+budgetChange);
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
        // a for loop to sum the total value
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
                    ", Expense = " + input.getValue());
    }
/*
     * 2 create a currency input property (hasmap won't cut it I think)
     * 2.1 create a connection to a curencty converter
     * + en funciones y comentar el codigo
    // add big decimal*/
}