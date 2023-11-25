import java.util.Scanner;

public class Main {

    public static int sign(int n) {
        // write your code here
        return (n < 0) ? -1 : (n == 0) ? 0 : 1;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}