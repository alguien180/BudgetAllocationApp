import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private String name;
    private double moneyAllocated;
    private double percentageOfTotal;
    public Database(){};
public Database(String name, double price){
    this.name = name;
    this.moneyAllocated = price;
}
    public void setName(String name) {
        this.name = name;
    }

    public void setMoneyAllocated(double moneyAllocated) {
        this.moneyAllocated = moneyAllocated;
    }

    public void setPercentageOfTotal(double percentageOfTotal) {
        this.percentageOfTotal = percentageOfTotal;
    }


    ArrayList<Database> database = new ArrayList<>();

    public double proportionOfExpenses(Database data){
        double totalMoney=0;
        for (int i =0; i<database.size();i++){
            totalMoney += data.moneyAllocated;
        }
        for(int j=0;j<database.size();j++){
            return data.percentageOfTotal= data.moneyAllocated/totalMoney;
        }
        return data.percentageOfTotal= data.moneyAllocated/totalMoney;
    }
    /*
    public void addExpense(){

        Scanner sc2 = new Scanner(System.in);
        System.out.println("enter object name");
        this.name = sc2.next();

        System.out.println("enter object cost");
        this.moneyAllocated = sc2.nextDouble();
    }*/

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", moneyAllocated=" + moneyAllocated +
                ", percentageOfTotal=" + percentageOfTotal +
                '}';
    }
}
