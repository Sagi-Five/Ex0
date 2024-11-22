import java.util.Scanner;

public class Ex0 {
    public static void main(String[] args) {
        String id = "207372095";
        // Input: Get input from the user
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.print("Please insert a number that is greater than 4: ");
        number = scanner.nextInt();

        // Start Timer: Record the start time
        long startTime = System.currentTimeMillis();

        // Check conditions based on the task requirements
        if (number > 4 && number % 2 == 0) {
            // Task a
            toFindPrime(number);

            // Task b
            primeSubstraction(number);

            // Task d
            decompositionPrime(number);

            // Task c
            count(number);
        } else if (number > 4 && number % 2 != 0) {
            // If the number is odd
            System.out.println("Please insert an even number");
        } else if (number < 4) {
            // If the number is less than 4
            System.out.println("You entered a number less or equal than 4. Please try again.");
        }

        // Print ID
        System.out.println("ID: " + id);

        // End Timer: Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate and print runtime in seconds
        double duration = (endTime - startTime) / 1000.0;
        System.out.println("Runtime " + duration + " seconds");
    }

    public static boolean isPrime(int number) {
        // Check if the number is prime number
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void toFindPrime(int number) {
        // Task a: Find two primes that add up to the number
        int p1;
        boolean foundPair = false;
        for (p1 = 3; p1 < number / 2 && !foundPair; p1 += 2) {
            int p2 = number - p1;
            if (isPrime(p1) && isPrime(p2)) {
                System.out.println(number + " = " + p1 + " + " + p2);
                foundPair = true;
            }
        }
    }

    public static void primeSubstraction(int number) {
        // Task b: Find two primes where the difference equals the number
        boolean foundPair = false;
        for (int p3 = 2; p3 < number && !foundPair; p3++) {
            int p4 = number + p3;
            if (isPrime(p3) && isPrime(p4)) {
                System.out.println(number + " = " + p4 + " - " + p3);
                foundPair = true;
            }
        }
    }

    public static void count(int number) {
        // Task c: Count how many primes are between 2 - number
        int primeCount = 0;
        for (int i = 2; i < number; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        System.out.println(primeCount + " prime numbers between: [2," + number + "]");
    }

    public static void decompositionPrime(int number) {
        // Task d: Find the prime decomposition of the number
        int i = 2;
        System.out.print(number + " = ");
        while (number > 1) {
            while (number % i == 0) {
                if (i == number) {
                    System.out.println(i);
                }
                else {
                    System.out.print(i + " * ");
                }
                number = number / i;
            }
            i++;
        }
    }
}

