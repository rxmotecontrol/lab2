import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m, n, mStart = 0, nStart = 0;
        String line;

        System.out.println("Enter m:");
        m = scanner.nextInt();
        
        System.out.println("Enter n:");
        n = scanner.nextInt();
        
        scanner.nextLine(); // consume the newline character
        
        System.out.println("Enter line:");
        line = scanner.nextLine();

        int mCurr = 1, nCurr = 1;

        if (m < 1 || n < 1) {
            System.out.println("Error");
        } else {
            for (char i : line.toCharArray()) {
                if (i == 'L') {
                    mCurr -= 1;
                } else if (i == 'R') {
                    mCurr += 1;
                } else if (i == 'D') {
                    nCurr += 1;
                } else if (i == 'U') {
                    nCurr -= 1;
                }
            }

            if (mCurr > m || nCurr > n) {
                System.out.println("Error");
            } else if (mCurr < 1 || nCurr < 1) {
                if (mCurr < 1) {
                    mStart = 2 + Math.abs(mCurr);
                }
                if (nCurr < 1) {
                    nStart = 2 + Math.abs(nCurr);
                }
                System.out.printf("%d %d\n", mStart, nStart);
            } else {
                System.out.println("1 1");
            }
        }
    }
}