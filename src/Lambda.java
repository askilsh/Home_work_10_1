import java.util.Arrays;
import java.util.Scanner;

public class Lambda {
    private static final int SIZE = 10;

    public static void main(final String[] argc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите модификатор... Пожалуйста...");
        int mfr = scanner.nextInt();
        Lambda lambda = new Lambda();
        int[] fstMass;
        fstMass = lambda.getFilledArray(SIZE, mfr, Integer::sum);
        int[] scdMass;
        scdMass = lambda.getFilledArray(SIZE, mfr, (inx, mod) -> inx * mod);
        int[] thdMass;
        thdMass = lambda.getFilledArray(SIZE, mfr, (inx, mod) -> {
            if ((inx % 2) == 0) {
                return inx / 2 + mod;
            } else {
                return (inx * inx) - mod;
            }
        });
        int[] degreeMass;  // Лямбда, которая возводит индекс массива в степень модификатора
        degreeMass = lambda.getFilledArray(SIZE, mfr, (inx, mod) -> { // буфер, чтобы помнить значение индекса
            int puff = inx; // Умножаем значение индекса на себя, пока степень больше 1
            for (; mod > 1; mod--) {
                inx = inx * puff;
            }
            return inx;
        });
        int[] factMass; // Лямбда, которая возводит значение индекса в факториал и умножает на модификатор
        factMass = lambda.getFilledArray(SIZE, mfr, (inx, mod) -> { // Факториал 0 равен 1
            if (inx == 0) {
                inx = 1;
            } // Буфер, чтобы помнить значение индекса
            int puff = inx; // Умножаем значение индекса на значение индекса - 1 в цикле, пока оно больше 1
            for (; inx > 1; inx--) {
                puff = puff * (inx - 1);
            }
            return puff * mod;
        });
        System.out.println(Arrays.toString(fstMass));
        System.out.println(Arrays.toString(scdMass));
        System.out.println(Arrays.toString(thdMass));
        System.out.println(Arrays.toString(degreeMass));
        System.out.println(Arrays.toString(factMass));
    }

    final int[] getFilledArray(final int sze, final int mfr, final Process process) {
        int[] mass = new int[sze];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = process.process(i, mfr);
        }
        return mass;
    }
}



