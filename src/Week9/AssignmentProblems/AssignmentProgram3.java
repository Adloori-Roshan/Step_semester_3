import java.util.*;

interface TransportUser {
    double TRANSPORT_FEE = 12000.0;

    boolean usesBus();
}

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuitionFee();

    double getFee() {
        double fee = getTuitionFee();

        if (usesBus()) {
            fee += TransportUser.TRANSPORT_FEE;
        }

        return fee;
    }

    abstract boolean usesBus();
}

class DayScholar extends Student implements TransportUser {

    DayScholar(String name) {
        super(name);
    }

    double getTuitionFee() {
        return 40000.0;
    }

    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double getTuitionFee() {
        return 40000.0 + 60000.0;
    }

    boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student implements TransportUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    double getTuitionFee() {
        return 20000.0;
    }

    public boolean usesBus() {
        return true;
    }
}

public class AssignmentProblem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.getFee();

            System.out.printf("%s: %.2f%n", name, fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}