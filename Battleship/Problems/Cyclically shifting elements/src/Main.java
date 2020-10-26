import java.util.Scanner;

class Main {
    private static int size;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        arr = new int[size];

        for (var i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        for (var i = 0; i < size - 1; i++) {
            arr[0] ^= arr[etNext(i)];
            arr[etNext(i)] ^= arr[0];
            arr[0] ^= arr[etNext(i)];
        }
        for (var s : arr) {
            System.out.print(s);
            System.out.print(" ");
        }
    }

    private static int etNext(int i) {
        i++;
        if (i >= size)
            i -= size;
        return i;
    }
}