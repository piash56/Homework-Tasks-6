
public class Task3 {

    public static int sumDigits(int x) {

        if (x < 10) {
            return x;
        }

        return (x % 10) + sumDigits(x / 10);
    }

    public static void main(String[] args) {

        int number = 1342;

        System.out.println("Sum of digits: " + sumDigits(number));
    }
}
