import java.util.Scanner;

public class Main {
    
    public static boolean checkTimeFormat(int num) {
        if (num < 100) {
            return false;
        }
        int hours = num / 100;
        int minutes = num % 100;
        
        if (hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = scanner.nextInt();
        
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            if (num == -1) {
                break;
            }
            if (checkTimeFormat(num)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}
