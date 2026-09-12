public class MatchDayGridAnalyzer {

    // Helper method to calculate average of one row
    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {

        String result = "";

        // Go through each match
        for (int i = 0; i < runsPerOver.length; i++) {

            double average = rowAverage(runsPerOver[i]);

            if (average >= threshold) {
                result = result + "Match " + i + ": Power Surge";
            } else {
                result = result + "Match " + i + ": Normal";
            }

            // Add separator except after last match
            if (i < runsPerOver.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        int threshold = 8;

        String result =
                classifyMatches(runsPerOver, threshold);

        System.out.println(result);
    }
}
