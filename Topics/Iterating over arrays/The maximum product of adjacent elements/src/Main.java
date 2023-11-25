import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String elements = scanner.nextLine();

        String[] arrayElements = elements.split(" ");
        int[] array = new int[n];

        for (int i = 0; i < arrayElements.length; i++) {
            array[i] = Integer.parseInt(arrayElements[i]);
        }

        int maxAdjacent = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int cont = 0;
            cont = array[i] * array[i + 1];
            if (cont > maxAdjacent){maxAdjacent = cont;}
        }
        System.out.println(maxAdjacent);
    }
}