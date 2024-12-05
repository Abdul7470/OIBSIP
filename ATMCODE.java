import java.util.Scanner;

class BankAccount {
    int BAL;
    int Prv_Trans;
    String Cst_Name;
    String Cst_Id;
    int flag = 0;

    BankAccount(String cName, String cId) {
        Cst_Name = cName;
        Cst_Id = cId;
    }

    public final void clrscr() {
        try {
            try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } catch (final Exception es) {
        // System.out.println("nothing here!");
    }

    }

    void checkId() {
        clrscr();
        System.out.println("Welcome to our bank " + Cst_Name);
        System.out.println();
        System.out.print("Please enter your Customer ID : ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(Cst_Id)) {
            clrscr();
            showMenu();
        } else {
            System.out.println("---------------------------------");
            System.out.println("Wrong Login!!");
            System.out.println("---------------------------------");

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amt) {
        if (amt != 0) {
            BAL = BAL + amt;
            Prv_Trans = amt;
        }
    }

    void withdraw(int amt) {
        if (this.BAL > amt) {
            BAL = BAL - amt;
            Prv_Trans = -amt;
        } else {
            clrscr();
            System.out.println("---------------------------------");
            System.out.println(" INSUFFICENT BALANCE !");
            System.out.println("---------------------------------");
        }
    }

    void getPrevTransaction() {
        if (Prv_Trans > 0) {
            System.out.println("Deposited: " + Prv_Trans);
        } else if (Prv_Trans < 0) {
            System.out.println("Withdraw: " + Math.abs(Prv_Trans));
        } else {
            System.out.println("No Transaction Occured ");
        }
    }

    public void transfer(double amt, BankAccount acc) {
        if (this.BAL < amt) {
            clrscr();
            System.out.println("---------------------------------");
            System.out.println("Transfer Fails due to insufficient balance!");
            System.out.println("---------------------------------");
        } else {
            this.BAL -= amt;
            acc.BAL += amt;
            System.out.println("Account of " + this.Cst_Name + " becomes $" + this.BAL);
            System.out.println("Account of " + acc.Cst_Name + " becomes $" + acc.BAL);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        int ch;
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome " + Cst_Name);
        System.out.println("Your ID is  " + Cst_Id);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("1. Check Bank Balance");
            System.out.println("2. Deposit ");
            System.out.println("3. Withdraw ");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");

            System.out.println("---------------------------------");
            System.out.println("SELECT THE SERVICE");
            System.out.println("---------------------------------");
            ch = inp.nextInt();
            ch = Character.toUpperCase(ch);
            System.out.println("\n");

            switch (ch) {
                case 1:
                    clrscr();
                    System.out.println("----------------");
                    System.out.println(" Bank Balance :" + BAL);
                    System.out.println("----------------");
                    System.out.println("\n");
                    break;

                case 2:
                    clrscr();
                    System.out.println("----------------");
                    System.out.println("Enter the amount you want to deposit");
                    System.out.println("----------------");
                    int amt = inp.nextInt();
                    deposit(amt);
                    System.out.println("\n");
                    break;
                
                case 3:
                    clrscr();
                    System.out.println("----------------");
                    System.out.println("Enter the amount you want to withdraw");
                    System.out.println("----------------");
                    int amt2 = inp.nextInt();
                    withdraw(amt2);
                    System.out.println("\n");
                    break;

                case 4:
                    clrscr();
                    System.out.println("----------------");
                    getPrevTransaction();
                    System.out.println("----------------");
                    System.out.println("\n");
                    break;

                case 5:
                    clrscr();
                    System.out.println("...............");
                    System.out.println(" TO WHOM");
                    BankAccount bb = new BankAccount("MURTAZA", "1012");
                    System.out.println(bb.Cst_Name);
                    System.out.println("...............");
                    System.out.println("Amount to Transfer");
                    double am = inp.nextDouble();
                    System.out.println("...............");
                    transfer(am, bb);
                    break;

                case 6:
                    clrscr();
                    System.out.println("...............");
                    break;
                
                default:
                    clrscr();
                    System.out.println(" Out of option !!! \n Please Enter Again");
            }

        } while (ch != 6);
        System.out.println("Thank You For using our services \n KEEP USING OUR SERVICE");

    }
}

public class ATMCODE{
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("ABDUL QADIR", "1022");
        ba.checkId();
    }

}