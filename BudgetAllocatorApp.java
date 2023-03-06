import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class BudgetAllocatorApp {
    public static void main(String[] args) {


        Scanner sc1 = new Scanner(System.in);

        ArrayList<String> nameOfExpense = new ArrayList<>();
        ArrayList<Double> priceList = new ArrayList<>();

        Map<String, Double> ExpenseListMixed = new HashMap<>();
        System.out.println("Please enter your total budget");
        double totalMoney = sc1.nextDouble();

        System.out.println("Welcome, what would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
        int entry = 0;
        entry = sc1.nextInt();
     while (entry !=5){
        /*
        try{
            System.out.println("entered the try");
            entry = sc1.nextInt();
        }catch(Exception e){
            System.out.println("entered the catch");
            while (!sc1.hasNextInt()){
                System.out.println("entered the while in catch");
                System.out.println("invalid input, re-enter the option");
                entry = sc1.nextInt();
            }
        }*/
        while(entry <0 || entry >4 ){
            System.out.println("invalid input, re-enter the option");
            entry = sc1.nextInt();
        }
        if (entry == 1) {
            System.out.println("enter object name");
            String name=sc1.next();



            System.out.println("enter object cost");
            double  cost=sc1.nextDouble();
            ExpenseListMixed.put(name,cost);
            double moneyAllocated = 0;
            for(Double val : ExpenseListMixed.values()){
                moneyAllocated += val;}
            System.out.println("Entered"+ ExpenseListMixed+ ","+ (totalMoney-moneyAllocated) + " remaining from your total budget");
            System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
            entry = sc1.nextInt();
        }else if (entry ==2){
            System.out.println("pate");
            System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
            entry = sc1.nextInt();
        }else if (entry ==3 ){
            System.out.println(ExpenseListMixed);
            System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
            entry = sc1.nextInt();
        } else if(entry ==4){
            System.out.println("\n\nWhat would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation \n 4. re-set total budget \n 5. exit programm");
            totalMoney = sc1.nextDouble();
        }
    }
    }
}