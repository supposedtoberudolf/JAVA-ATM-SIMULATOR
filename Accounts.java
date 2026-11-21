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

    public void CheckBalance(Scanner scanner) {
        System.out.println("\n==========================================");
        System.out.printf("         ACCOUNT BALANCE: %.2f        \n", Balance);
        System.out.println("==========================================");

        System.out.print("\nPRESS [ENTER] TO CONTINUE ");
        scanner.nextLine();
    }

    public void Withdraw(Scanner scanner) {

        double Withdraw = 0;

        System.out.println("==========================================");
        System.out.println("                 WITHDRAW                 ");
        System.out.println("==========================================\n");

        do {

            try {
                System.out.print("ENTER WITHDRAWAL AMOUNT (0 TO EXIT): ");
                String input = scanner.nextLine();
                Withdraw = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("\nINVALID INPUT!\nPLEASE TRY AGAIN\n");
                continue;
            }
            if (Withdraw == 0) break;
            else if (Withdraw < 0) System.out.println("\nWITHDRAWAL AMOUNT SHOULD NOT BE 0 BELOW\n");
            else if (Withdraw > Balance) System.out.println("\nINSUFFICIENT BALANCE\n");
            else if (Withdraw % 100 != 0) System.out.println("\nWITHDRAWAL AMOUNT SHOULD BE A MULTIPLE OF 100\n");
            else {
                Balance -= Withdraw;
                System.out.println("WITHDRAWAL SUCCESSFUL\n");

                // RECEIPT
                break;
            }
            
        } while (true);

    }

    public void Deposit(Scanner scanner) {

        // DEPOSIT SECTION
    }
}
