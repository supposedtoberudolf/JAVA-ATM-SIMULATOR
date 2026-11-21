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

        boolean Logout = false;

        while (!Logout) {

            boolean isRunning = true;
            boolean VerificationComplete = false;
            Logout = false;
            int index = 0;
            int choice = 0;

            System.out.println("==========================================");
            System.out.println("              --- LOG IN ---              ");
            System.out.println("==========================================\n");

            do {

                int attempts = 4;
                boolean isFound = false;
                VerificationComplete = false;
                isRunning = true;

                System.out.print("ENTER ACCOUNT NUMBER (0 TO EXIT): ");
                String ID = scanner.nextLine().trim();

                if (ID.isEmpty()) System.out.println("\nPLEASE PROVIDE YOUR ACCOUNT NUMBER\n");
                else if (ID.equals("0")) break;
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
                                isRunning = false;
                                break;
                            }
                            else if (!(PIN.matches("[0-9]{4}"))) {
                                
                                attempts--;

                                if (attempts == 0) {
                                    System.out.println("\nLOG IN FAILED\nPLEASE TRY AGAIN LATER\n\n");
                                    isRunning = false;
                                    break;
                                }

                                System.out.printf("\nPIN ONLY CONTAINS 4-DIGIT NUMBERS\nYOU HAVE %d ATTEMPTS LEFT\nPLEASE TRY AGAIN\n\n", attempts);
                            }
                            else {
                                if (PIN.equals(account[index].PIN)) {
                                    isRunning = false;
                                    VerificationComplete = true;
                                    break;
                                }
                                else {

                                    attempts--;

                                    if (attempts == 0) {
                                        System.out.println("\nLOG IN FAILED\nPLEASE TRY AGAIN LATER\n");
                                        isRunning = false;
                                        break;
                                    }

                                    System.out.printf("\nINCORRECT PIN\nYOU HAVE %d ATTEMPTS LEFT\nPLEASE TRY AGAIN\n\n", attempts);
                                }
                            }
                        } while (true);
                        
                    }
                    else {
                        System.out.println("\nACCOUNT NOT FOUND\nPLEASE TRY AGAIN\n");
                    }
                }

            } while (isRunning);

            if (VerificationComplete) {

                while (true) {

                    choice = MainMenu(scanner);

                    if (choice == 1) account[index].CheckBalance(scanner);
                    else if (choice == 2) account[index].Withdraw(scanner);
                    else if (choice == 3);
                    else {
                        System.out.println("\n[PROGRAM TERMINATED]\n");
                        Logout = true;
                        break;
                    }
                }

                
            }
            else {
                System.out.println("\nPROGRAM TERMINATED\n");
                break;
            }
        }

        
    }
    static int MainMenu(Scanner scanner) {

        int choice = 0;

        System.out.println("\n==========================================");
        System.out.println("                --- ATM ---                ");
        System.out.println("==========================================\n");

        System.out.println("   [1] CHECK BALANCE      [3] DEPOSIT\n");
        System.out.println("   [2] WITHDRAW           [4] LOG OUT\n\n");

        do {
            try {
                System.out.print("ENTER CHOICE (1-4): ");
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nINVALID INPUT\nPLEASE TRY AGAIN\n\n");
                continue;
            }
            if (choice > 4 || choice < 1) System.out.print("\nINVALID OPTION\nPLEASE TRY AGAIN\n");
            else break;  
            
        } while (true);
        
        return choice;
    }


}
