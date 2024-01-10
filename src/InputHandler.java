import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
    }

    public double getNextDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
