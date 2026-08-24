public class Main {

    public static int findLargest(int[] numbers) {

        // Constraint: array must not be empty
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int largest = numbers[0];

        // Find largest without sorting
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {

        int[] numbers = {10, 25, 7, 40, 15};

        System.out.println("Largest number: " + findLargest(numbers));
    }
}