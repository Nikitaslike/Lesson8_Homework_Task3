package org.example;
import java.util.Scanner;
//3. *Управління банківським рахунком:*
//  Реалізуйте клас `BankAccount`, який має методи для внесення коштів,
//  зняття коштів та виведення залишку на рахунку.
//  Забезпечте перевірку наявності достатньої кількості коштів перед зняттям.

// Додав, що банкомат невічний)
public class Main {
    public static void main(String[] args) {
        double cashOfBank = 100000; // Приблизна максимальна місткість банкомата
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість грошей на вашій картці: ");
        double money = scanner.nextDouble();
        if(money>=0){
            System.out.println("На вашій картці "+money+"$. Для того щоб зняти гроші натисніть 1. Для того щоб внести кошти натисніть 2. Для того щоб зупинити програму натисніть 0");
            int option = scanner.nextInt();
            if(option>=0 && option<=2){
                System.out.println("Введіть сума коштів для дії "+option+":");
                double paying = scanner.nextInt();
                if (paying < 0) {
                    BankAccount bankAccount = new BankAccount(money, paying, option);
                    scanner.close();
                    bankAccount.processTransaction(cashOfBank);
                }
                else {
                    System.out.println("Помилка");
                }
            }
            else{
                System.out.println("Помилка");
            }
        }
        else {
            System.out.println("Помилка");
        }
    }
}
class BankAccount{
    private double money;
    private double paying;
    private int option;
    public void setMoney(double actionMoney){
        if(actionMoney>=0){
            money = actionMoney;
        }
    }
    public double getMoney(){
        return money;
    }
    public void setPaying(double actionPay){
        if(actionPay>=0){
            paying = actionPay;
        }
    }
    public double getPaying(){
        return paying;
    }
    public void setActionType(int actionOption){
        if(actionOption>=0 && actionOption<=2){
            option = actionOption;
        }
    }
    public int getActionType(){
        return option;
    }
    public BankAccount(double money, double paying, int actionType){
        this.setMoney(money);
        this.setPaying(paying);
        this.setActionType(actionType);
    }
    public void processTransaction(double cashOfBank){
        switch(getActionType()){
            case 0:
                System.out.println("Гарного дня Вам!");
                break;
            case 1:
                if(getMoney()<getPaying() || getPaying()<0){
                    System.out.println("Error");
                }
                else {
                    setMoney(getMoney() - getPaying());
                    cashOfBank += getPaying();
                    System.out.println("На вашому рахунку зараз: " + getMoney());
                }
                break;
            case 2:
                if(getPaying()<0){
                    System.out.println("Error");
                }
                else {
                    setMoney(getMoney() + getPaying());
                    cashOfBank -= getPaying();
                    System.out.println("На вашому рахунку зараз: " + getMoney() + "$");
                }
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}