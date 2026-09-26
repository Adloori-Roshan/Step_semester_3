class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("success");
        } else {
            System.out.println("rejected");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class Class_prg4 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}