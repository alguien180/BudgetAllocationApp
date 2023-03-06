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
                    String name = sc1.next();

                    System.out.println("enter object cost");
                    double cost = sc1.nextDouble();
                    ExpenseListMixed.put(name, cost);
                    ExpenseListpercentages.put(name,0.0);
                    double moneyAllocated = 0;


                    System.out.println("Entered" + ExpenseListMixed + "," + (totalMoney - moneyAllocated) + " remaining from your total budget");
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 2) {
                    System.out.println(ExpenseListMixed + "\n please write the name and amount of the balance the value will be subtracted (separated by a space ");

                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 3) {
                    System.out.println(ExpenseListMixed+percentageCalculator(ExpenseListMixed, ));
                    System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
                    entry = sc1.nextInt();

                } else if (entry == 4) {
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
    public double percentageCalculator(Map Expenses, Map percentagesToBeCalculated){
        double total=0;
        double percantage=0;
        /*for (Object val : Expenses.entrySet()) {
            total += (double) val;
            if(percentagesToBeCalculated.containsKey(Expenses.keySet()))
            percentagesToBeCalculated.put(Expenses)
        }*/
        for(Map.Entry<String,Double> entry: Expenses.entrySet()){

        }
        percantage=(double)x.get(elemnentName)/total;
        return percantage;
    }

    /* 1. create the % representation
    * 2 create a currency input property (hasmap won't cut it I think)
    * 2.1 create a connection to a curencty converter
    * + en funciones y comentar el codigo
    * mete varias verisones a github*/
}