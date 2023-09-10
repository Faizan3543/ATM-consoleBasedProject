package ATM_machine;

import java.util.Scanner;

class ATM{
    float balance;
    final int pin = 1234;
    int attempt = 3;
    public void checkPin(){
    System.out.println("Please enter your four digit pin");
    Scanner scan = new Scanner(System.in);
    int pin = scan.nextInt();
    if(this.pin==pin){
        menu();
    }
    else if(attempt>=1){
        System.out.println("invalid pin, please try again");
        attempt-=1;
        if(attempt>=1){
        System.out.println("you have "+attempt+" attempt left");
        }
        else{
        System.out.println("Your card is blocked for 24 hrs");
        }
        checkPin();
    }

}
    public void menu(){
    System.out.println("1.CHECK BALANCE");
    System.out.println("2.DEPOSIT MONEY");
    System.out.println("3.WITHDRAW MONEY");
    System.out.println("4.Exit");

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter your choice");
    int choice = scan.nextInt();
    switch (choice) {
        case 1:
            CheckBalance();
            break;
    
        case 2:
            DepositMoney();
            break;
        case 3:
            WithdrawMoney();
            break;
    
        case 4:
            break;
        default:
            break;
    }
    }

    public void CheckBalance(){
        System.out.println("Your account balance is " + balance);
        menu();
    }
    public void DepositMoney(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit");
        float DepositAmount = scan.nextFloat();
        balance += DepositAmount;
        System.out.println("amount successfully deposited");
        menu(); 
    }
    public void WithdrawMoney(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw");
        float WithdrawAmount = scan.nextFloat();
        if(balance<WithdrawAmount){
            System.out.println("Insufficient funds");
        }
        else{
        balance -= WithdrawAmount;
        System.out.println("Amount successfully Withdrawn");
        menu(); 
    }
}
}