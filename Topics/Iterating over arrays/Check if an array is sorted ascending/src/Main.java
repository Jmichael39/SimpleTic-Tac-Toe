import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        boolean ordered = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                ordered = false;
                break;
            }
        }
        System.out.println(ordered);
    }
}