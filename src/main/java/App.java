import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ConnectFour connectFour = new ConnectFour(System.out);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Column For Move: ");

            connectFour.makeMove(scanner.nextInt());
        }
    }
}
