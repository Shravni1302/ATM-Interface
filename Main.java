import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args){
        Atm obj = new Atm();
        obj.checkpin();
    }

}
class Atm{
    float Balance;
    int PIN = 1302;

    public void checkpin(){
        System.out.println("enter you pin : ");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if( enteredpin == PIN){
            menu();
        }
        else{
            System.out.println("Enter valid pin");
            return;
        }
    }
    public void menu(){
        System.out.println("1.check balance");
        System.out.println("2.withdraw money");
        System.out.println("3.deposit money");
        System.out.println("4.exit");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        if(choose==1){
            checkbalance();
        }
        if(choose==2){
            withdraw();
        }
        if(choose==3){
            deposit();
        }
        if(choose==4){
            return;
        }
    }
    public void checkbalance(){
        System.out.println("Balance = "+ Balance);
        menu();
    }
    public void withdraw(){
        System.out.println("Enter amount: ");
        Scanner sc = new Scanner(System.in);
        int amt= sc.nextInt();
        if(amt>Balance){
            System.out.println("Insufficient Balance");
        }
        else{
            Balance = Balance - amt;
        }
        menu();
    }
    public void deposit(){
        System.out.println("Enter amount: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        Balance = Balance + a ;
        menu();
    }

}