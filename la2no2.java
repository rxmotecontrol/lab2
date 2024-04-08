import java.util.Scanner;

public class Main {
    
    public static void illustration(int banki, int ostatok, int countSteps) {
        if (countSteps == 0) {
            System.out.println("Jars");
            for (int i = 0; i < banki; i++) {
                System.out.print("F");
            }
            System.out.println();
        } else if (countSteps % 2 != 0) {
            System.out.printf("%d step\n", countSteps);
            for (int i = 0; i < banki; i++) {
                System.out.print("E");
            }
            System.out.println();
        } else {
            System.out.printf("%d step\n", countSteps);
            for (int i = 0; i < (banki - ostatok); i++) {
                System.out.print("F");
            }
            System.out.println();
            for (int i = 0; i < ostatok; i++) {
                System.out.print("E");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input jar quantity: ");
        int banki = scanner.nextInt();
        
        System.out.println("Input exchange: ");
        int obmen = scanner.nextInt();
        
        if (banki <= 0 || obmen <= 0) {
            System.out.println("Error");
        } else {
            int countEmpty = 0;
            int countSteps = 0;
            int ostatok = 0;
            int newBanki = banki;
            
            while (newBanki >= obmen) {
                if (countSteps == 0) {
                    illustration(newBanki, ostatok, countSteps);
                }
                countSteps++;
                illustration(newBanki, ostatok, countSteps);
                countEmpty += newBanki - ostatok;
                ostatok = newBanki % obmen;
                newBanki = (newBanki / obmen) + ostatok;
                countSteps++;
                illustration(newBanki, ostatok, countSteps);
            }
            
            if (newBanki < obmen) {
                countEmpty += newBanki - ostatok;
                countSteps++;
                illustration(newBanki, ostatok, countSteps);
                System.out.printf("Jars drunk: %d\n", countEmpty);
                System.out.printf("Step count: %d\n", countSteps);
            }
        }
        
        scanner.close();
    }
}
