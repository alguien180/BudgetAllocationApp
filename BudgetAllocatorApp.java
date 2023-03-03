import java.util.Scanner;
public class BudgetAllocatorApp {
    public static void main(String[] args) {
        Database actualDatabase = new Database();


        System.out.println("Welcome, what would you like to do?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation\n 4. exit programm");
        Scanner sc1 = new Scanner(System.in);
        int entry = 0;
        entry = sc1.nextInt();
        while (entry !=4){
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
        }
        while(entry <0 || entry >4 ){
            System.out.println("invalid input, re-enter the option");
            entry = sc1.nextInt();
        }*/
        if (entry == 1) {
            actualDatabase.addExpense();
            System.out.println("\n \n What would you like to do now?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation\n 4. exit programm");
            entry = sc1.nextInt();
        }else if (entry ==2){
            System.out.println("pate");
            System.out.println("\n \n What would you like to do now?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation\n 4. exit programm");
            entry = sc1.nextInt();
        }else if (entry ==3 ){
            System.out.println(actualDatabase.toString());
            System.out.println("\n \n What would you like to do now?\n 1. Input a new expense \n 2. Re-allocate budget to another section \n 3. See the current budget allocation\n 4. exit programm");
            entry = sc1.nextInt();

        }
    }
    }
}