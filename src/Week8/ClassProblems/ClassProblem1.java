import java.util.*;

abstract class PaymentMethod {
    abstract double calculateAmount(double amount);
}

class Card extends PaymentMethod {
    double calculateAmount(double amount) {
        return amount * 1.02;
    }
}

class Wallet extends PaymentMethod {
    double calculateAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer extends PaymentMethod {
    double calculateAmount(double amount) {
        return amount;
    }
}

public class ClassProblem15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment;

            if (type.equals("CARD"))
                payment = new Card();
            else if (type.equals("WALLET"))
                payment = new Wallet();
            else
                payment = new BankTransfer();

            double result = payment.calculateAmount(amount);
            total += result;

            System.out.printf("%s: %.2f%n", type, result);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}