package noRepeatebly;
/**
 * @author S.Dergunov sdergynov@gmail.com
 *
 * <br> Вывести все числа с неповторяющимися цифрами.
 */

public class Main {
    static int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private static long count = 0;

    public static void main(String[] args) {
        for (int length = 1; length <= 10; length++) {
            shiftLeft(length - 1, -1);
        }
        System.out.println("Итого:" + count);
    }
    static void shiftLeft(int limit, int level) {
        int i;
        if (level >= limit - 1) {
            lastNumber(limit);
            return;
        }
        for (i = 0; i < 9 - level; i++) {
            level ++;
            shiftLeft(limit, level);
            shift(level);
            level--;
        }
    }

    static void shift(int from) {
        int temp = digits[from];
        if (9 - from >= 0) System.arraycopy(digits, from + 1, digits, from, 9 - from);
        digits[9] = temp;
    }

    static void lastNumber(int limit) {
        int temp = digits[limit];
        int ii = limit - 1;
        if (digits[0] == 0) {
            return;
        }
        while (ii < 9) {
            digits[limit] = digits[ii + 1];
            out(limit);
            count++;
            ii++;
        }
        digits[limit] = temp;
    }

    static void out(int length) {
        for (int i = 0; i <= length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
