import java.util.*;

interface SaverMode {
    boolean supportsSaver();
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return (getPower() * hours) / 1000.0;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    public boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    public boolean supportsSaver() {
        return true;
    }
}

public class AssignmentProblem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();

                if (next.equals("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AC(hours);
            } else if (type.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.getUnits();

            if (saver) {
                units *= 0.75;
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}