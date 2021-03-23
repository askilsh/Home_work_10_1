import java.util.Arrays;
import java.util.Scanner;

public class Lambda {
    private final int size = 10;

    public static void main(final String[] argc) {
        final int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите модификатор... Пожалуйста...");
        int mfr = scanner.nextInt();
        Lambda lambda = new Lambda();
        int[] fstMass;
        fstMass = lambda.getFilledArray(lambda.size, mfr, Integer::sum);
        int[] scdMass;
        scdMass = lambda.getFilledArray(lambda.size, mfr, (inx, mod) -> {
            return inx * mod;
        });
        int[] thdMass;
        thdMass = lambda.getFilledArray(lambda.size, mfr, (inx, mod) -> {
            if ((inx % 2) == 0) {
                return inx / 2 + mod;
            } else {
                return (inx * inx) - mod;
            }
        });
        int[] degreeMass;
        degreeMass = lambda.getFilledArray(lambda.size, mfr, (inx, mod) -> {
            int puff = inx;
            for (; mod > 1; mod--) {
                inx = inx * puff;
            }
            return inx;
        });
        int[] factMass;
        factMass = lambda.getFilledArray(lambda.size, mfr, (inx, mod) -> {
            if (inx == 0) {
                inx = 1;
            }
            int puff = inx;
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



