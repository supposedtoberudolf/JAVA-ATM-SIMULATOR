import java.util.Scanner;

public class Accounts {
    String ID;
    String Name;
    String PIN;
    double Balance;

    Accounts(String ID, String Name, String PIN, double Balance) {
        this.ID = ID;
        this.Name = Name;
        this.PIN = PIN;
        this.Balance = Balance;
    }

    // TRANSACTION PROCESS

    public void CheckBalance(Scanner scanner) {
        
        System.out.println("\n╬═════════════════════════════════════════╬");
        System.out.println("║                                         ║");
        System.out.printf("║        ACCOUNT BALANCE: %-15.2f ║\n", Balance);
        System.out.println("║                                         ║");
        System.out.println("╬═════════════════════════════════════════╬");
        System.out.print("\n\n         PRESS [ENTER] TO CONTINUE");
        scanner.nextLine();
    }

    public void Withdraw(Scanner scanner) {

        double Withdraw = 0;

        System.out.println("\n╬═════════════════════════════════════════╬");
        System.out.println("║                WITHDRAW                 ║");
        System.out.println("╬═════════════════════════════════════════╬\n");

        do {

            try {
                System.out.print("ENTER WITHDRAWAL AMOUNT [0 TO EXIT]:\n>> ");
                String input = scanner.nextLine();
                Withdraw = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("\nINVALID INPUT!\nPLEASE TRY AGAIN\n");
                continue;
            }
            if (Withdraw == 0) break;
            else if (Withdraw < 0) System.out.println("\nWITHDRAWAL AMOUNT CANNOT BE NEGATIVE\n");
            else if (Withdraw > Balance) System.out.println("\nINSUFFICIENT BALANCE\n");
            else if (Withdraw % 100 != 0) System.out.println("\nWITHDRAWAL AMOUNT SHOULD BE A MULTIPLE OF 100\n");
            else {
                Balance -= Withdraw;
                Loading();
                System.out.println("\n╬═════════════════════════════════════════╬");
                System.out.println("║            WITHDRAW SUCCESSFUL          ║");
                System.out.println("╬═════════════════════════════════════════╬\n");

                System.out.println("\n╬═════════════════════════════════════════╬");
                System.out.println("║                 RECEIPT                 ║");
                System.out.println("╬═════════════════════════════════════════╬");
                System.out.println("║                                         ║");
                System.out.printf("║       WITHDRAW    : %-20.2f║\n", Withdraw);
                System.out.println("║                                         ║");
                System.out.printf("║       NEW BALANCE : %-20.2f║\n", Balance);
                System.out.println("║                                         ║");
                System.out.println("╬═════════════════════════════════════════╬");
                System.out.print("\n\n        PRESS [ENTER] TO CONTINUE");
                scanner.nextLine();
                break;
            }
            
        } while (true);

    }

    public void Deposit(Scanner scanner) {

        double Deposit = 0;

        System.out.println("\n╬═════════════════════════════════════════╬");
        System.out.println("║                 DEPOSIT                 ║");
        System.out.println("╬═════════════════════════════════════════╬\n");

        do {

            try {
                System.out.print("ENTER DEPOSIT AMOUNT [0 TO EXIT]:\n>> ");
                String input = scanner.nextLine();
                Deposit = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("\nINVALID INPUT!\nPLEASE TRY AGAIN\n");
                continue;
            }
            if (Deposit == 0) break;
            else if (Deposit < 0) System.out.println("\nDEPOSIT AMOUNT CANNOT BE NEGATIVE\n");
            else if (Deposit > 500000) System.out.println("\nMAX DEPOSIT IS ONLY PHP 500,000\nPLEASE TRY AGAIN\n");
            else if (Deposit % 100 != 0) System.out.println("\nDEPOSIT AMOUNT SHOULD BE A MULTIPLE OF 100\n");
            else {
                Balance += Deposit;
                Loading();
                System.out.println("\n╬═════════════════════════════════════════╬");
                System.out.println("║            DEPOSIT SUCCESSFUL           ║");
                System.out.println("╬═════════════════════════════════════════╬\n");

                System.out.println("\n╬═════════════════════════════════════════╬");
                System.out.println("║                 RECEIPT                 ║");
                System.out.println("╬═════════════════════════════════════════╬");
                System.out.println("║                                         ║");
                System.out.printf("║       DEPOSIT     : %-20.2f║\n", Deposit);
                System.out.println("║                                         ║");
                System.out.printf("║       NEW BALANCE : %-20.2f║\n", Balance);
                System.out.println("║                                         ║");
                System.out.println("╬═════════════════════════════════════════╬");
                System.out.print("\n\n        PRESS [ENTER] TO CONTINUE");
                scanner.nextLine();
                break;
            }
            
        } while (true);
        
    }

    public static void Loading() {

        int totalBars = 20; 
    
        System.out.println();
        for (int i = 0; i <= totalBars; i++) {
            int percent = (i * 100) / totalBars;
            
            
            String filled = "█".repeat(i);
            String empty = "░".repeat(totalBars - i);
            
            System.out.print("\r" + "LOADING" + " [" + filled + empty + "] " + percent + "%");
            
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }       
        }
        System.out.println();
    
    }
}
