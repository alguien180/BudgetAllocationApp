import java.util.*;

import static java.lang.Double.isNaN;

public class BudgetAllocatorApp {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);

        Map<String, Double> ExpenseListMixed = new HashMap<>();
        Map<String, Double> ExpenseListpercentages = new HashMap<>();
        int entry = 0;
        System.out.println("Please enter your total budget");

        double totalMoney = sc1.nextDouble();
        try {
            if (totalMoney < 1) {
                System.out.println("Please enter a valid amount");
                totalMoney = sc1.nextDouble();
            }
            System.out.println("Welcome, what would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");

            entry = sc1.nextInt();
            while (entry != 5) {
                while (entry < 1 || entry > 5) {
                    System.out.println("invalid input, re-enter the option");
                    entry = sc1.nextInt();
                }
                if (entry == 1) {
                    System.out.println("enter object name");
                    String name = sc1.next().toLowerCase();

                    System.out.println("enter object cost");
                    double cost = sc1.nextDouble();
                    ExpenseListMixed.put(name, cost);
                    ExpenseListpercentages.put(name,0.0);
                    double moneyAllocated = 0;


                    System.out.println("Entered" + ExpenseListMixed + "," + (totalMoney - moneyAllocated) + " remaining from your total budget");
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 2) {
                    System.out.println(ExpenseListMixed + "\n please write the name of the expense which will have its budget REDUCED ");
                    String nameOfReducedBudget =sc1.nextLine().toLowerCase();
                    if (ExpenseListMixed.get(nameOfReducedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget REDUCED ");
                        nameOfReducedBudget =sc1.nextLine().toLowerCase();
                    }
                    System.out.println(ExpenseListMixed + "\n please write the name of the expense which will have its budget INCREASED ");
                    String nameOfIncreasedBudget =sc1.nextLine().toLowerCase();
                    if (ExpenseListMixed.get(nameOfIncreasedBudget).equals(null)) {
                        System.out.println(ExpenseListMixed + "\n Invalid input, please write the name of the expense which will have its budget INCREASED ");
                        nameOfIncreasedBudget =sc1.nextLine().toLowerCase();
                    }
                    System.out.println(ExpenseListMixed + "\n please write the amount of the expense which will have its budget INCREASED ");
                    double budgetRelocated = sc1.nextDouble();
                    if(ExpenseListMixed.get(nameOfReducedBudget)-budgetRelocated<0){
                        System.out.println("amount is greater than the amount currently allocated to that expense, please re-check your input");
                        budgetRelocated = sc1.nextDouble();
                    }
                    ExpenseListMixed.replace(nameOfReducedBudget,ExpenseListMixed.get(nameOfReducedBudget)-budgetRelocated);
                    ExpenseListMixed.replace(nameOfIncreasedBudget,ExpenseListMixed.get(nameOfIncreasedBudget)+budgetRelocated);
                    System.out.println(ExpenseListMixed + "\n is the updated budget ");
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 3) {
                    percentageCalculator(ExpenseListMixed, ExpenseListpercentages);
                    System.out.println(ExpenseListMixed+" "+ExpenseListpercentages);
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 4) {
                    System.out.println("Please enter the new expense budget");
                    double moneyAllocated = 0;
                    for (Double val : ExpenseListMixed.values()) {
                        moneyAllocated += val;
                    }
                    totalMoney = sc1.nextDouble();
                    if (totalMoney < moneyAllocated) {System.out.println("\n WARNING: Amount is under the current budget, cut expenses or input a new value");}
                        System.out.println("Changed" + ExpenseListMixed + "," + (totalMoney - moneyAllocated) + " remaining from your total budget");
                        System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                        entry = sc1.nextInt();
                    }
                }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number");
        }
        finally{sc1.close();}
    }
    public static void percentageCalculator(Map Expenses, Map percentagesToBeCalculated){
        double total=0;
        double percentage=0;
        /*for (Object val : Expenses.entrySet()) {
            total += (double) val;
            if(percentagesToBeCalculated.containsKey(Expenses.keySet()))
            percentagesToBeCalculated.put(Expenses)
        }*/
        for(Object entry: Expenses.entrySet()){
            double moneyAllocated = 0;
            for (Object val : Expenses.values()) {
                moneyAllocated += (double) val;
            }
            if(percentagesToBeCalculated.containsKey(entry)){
                percentagesToBeCalculated.put(entry,((double)percentagesToBeCalculated.get(entry)/moneyAllocated));
            }
        }
    }

    /* 1. create the % representation
    * 2 create a currency input property (hasmap won't cut it I think)
    * 2.1 create a connection to a curencty converter
    * + en funciones y comentar el codigo
    * mete varias verisones a github*/
}