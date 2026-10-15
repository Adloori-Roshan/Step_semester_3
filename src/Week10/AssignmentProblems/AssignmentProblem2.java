class AssignmentProblems2 {
    static void attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                current++;

                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longest);
    }

    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};

        attendanceSummary(days);
    }
}