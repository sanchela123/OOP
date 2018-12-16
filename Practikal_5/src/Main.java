import java.util.Scanner;

public class Main {
    public static String recursion(int n) {
        if (n == 1) {
            return "1";
        }
        return recursion(n - 1) + " " + n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = sc.nextInt();
        System.out.println(recursion(n)); // вызов рекурсивной функции
    }
}
