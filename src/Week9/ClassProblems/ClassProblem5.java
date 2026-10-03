import java.util.*;

abstract class Travel {
    static final double BOOKING_FEE = 50.0;

    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double getFare();

    double getTotal() {
        return getFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {

    Bus(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 2.0;
    }
}

class Train extends Travel {

    Train(double distance) {
        super(distance);
    }

    double getFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {

    Flight(double distance) {
        super(distance);
    }

    double getFare() {
        return 2500 + distance * 4.0;
    }
}

public class ClassProblem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            if (mode.equals("BUS")) {
                travel = new Bus(distance);
            }
            else if (mode.equals("TRAIN")) {
                travel = new Train(distance);
            }
            else {
                travel = new Flight(distance);
            }

            double amount = travel.getTotal();

            System.out.printf(
                    "%s: %.2f%n",
                    mode, amount
            );

            total += amount;
        }

        // The problem has no separate total output.
    }
}