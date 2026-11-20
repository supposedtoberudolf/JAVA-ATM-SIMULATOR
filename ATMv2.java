import java.util.Scanner;

public class ATMv2 {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        Accounts[] account = {
            new Accounts("1001", "RUDOLF VICTORIA", "1234", 5000),
            new Accounts("1002", "JOHN LLYOD CRUZ", "1444", 6000),
            new Accounts("1003", "CRIS ANDREW", "1543", 7000),
            new Accounts("1004", "OWEN DAVID", "1236", 8000),
            new Accounts("1005", "ANDREW SAM", "2468", 9000)
        };

        LoginPage(account);


    }
    static void LoginPage(Accounts[] account) {

        boolean isDone = true;

        System.out.println("==========================================");
        System.out.println("               --- ATM ---                ");
        System.out.println("==========================================\n");

        do {

            int index = 0;
            int attempts = 0;
            boolean isFound = false;
            
            isDone = true;

            System.out.print("ENTER ACCOUNT NUMBER (0 TO EXIT): ");
            String ID = scanner.nextLine().trim();

            if (ID.isEmpty()) System.out.println("\nPLEASE PROVIDE YOUR ACCOUNT NUMBER\n");
            else if (ID.equals("0")) {
                System.out.println("\nPROGRAM TERMINATED\n");
                break;
            }
            else if (!(ID.matches("[0-9]{4}"))) System.out.println("\nACCOUNT NUMBER ONLY CONTAINS 4-DIGIT NUMBERS\n");
            else {
                for (int i = 0; i < account.length; i++) {
                    if (ID.equals(account[i].ID)) {
                        isFound = true;
                        index = i;
                        break;
                    }
                }

                if (isFound) {

                    System.out.println("\n==========================================");
                    System.out.printf("   --- WELCOME BACK, %s --- \n", account[index].Name);
                    System.out.println("==========================================\n");

                    do {
                        System.out.print("ENTER PIN (0 TO EXIT): ");
                        String PIN = scanner.nextLine().trim();

                        if (PIN.isEmpty()) System.out.println("\nPLEASE PROVIDE YOUR ACCOUNT PIN\n");
                        else if (PIN.equals("0")) {
                            System.out.println("\nPROGRAM TERMINATED\n");
                            isDone = false;
                            break;
                        }
                        else if (!(PIN.matches("[0-9]{4}"))) System.out.println("\nPIN ONLY CONTAINS 4-DIGIT NUMBERS\n");
                        else {
                            if (PIN.equals(account[index].PIN)) {
                                isDone = false;
                                break;
                            }
                            else {
                                attempts++;
                                System.out.println("\nINCORRECT PIN\nPLEASE TRY AGAIN\n");
                            }
                        }
                    } while (true);
                      
                }
                else {
                    System.out.println("\nACCOUNT NOT FOUND\nPLEASE TRY AGAIN\n");
                }
            }

        } while (isDone);
        

    }
}
