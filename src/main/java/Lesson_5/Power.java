package Lesson_5;

public class Power {
    public static void main(String[] args) {
        System.out.println(powerTheNumber(5,5));
    }

    private static int powerTheNumber(int number, int power) {
        if (power < 1) throw new NumberFormatException("Power must be > 0");
        if (power == 1) return number;
        return number * powerTheNumber(number, power - 1);
    }
}
