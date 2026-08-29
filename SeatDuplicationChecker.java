public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Skip elements that were already identified and printed as duplicates
            boolean alreadyChecked = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyChecked = true;
                    break;
                }
            }
            if (alreadyChecked) {
                continue;
            }

            // Compare seatNumbers[i] with every subsequent seat number
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    hasDuplicate = true;
                    break; // Move to the next unique seat once a duplicate is confirmed
                }
            }
        }

        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] input1 = {101, 102, 103, 102, 105};
        int[] input2 = {101, 102, 103, 104, 105};

        System.out.print("Input 1 Output: ");
        checkDuplicateSeats(input1);

        System.out.print("Input 2 Output: ");
        checkDuplicateSeats(input2);
    }
}