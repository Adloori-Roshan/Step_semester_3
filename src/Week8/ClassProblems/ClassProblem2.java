import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowDays();
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowDays() {
        return 3;
    }
}

public class ClassProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int space = line.indexOf(" ");

            String type = line.substring(0, space);

            String title = line.substring(space + 1)
                    .replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK"))
                item = new Book(title);
            else if (type.equals("DVD"))
                item = new DVD(title);
            else
                item = new Magazine(title);

            LocalDate dueDate =
                    currentDate.plusDays(item.getBorrowDays());

            System.out.println(
                    title + ": " + dueDate.format(format)
            );
        }
    }
}