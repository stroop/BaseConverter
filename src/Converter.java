import java.util.Scanner;

/**
 * Created by jacobstroop on 9/7/15.
 */
public class Converter {

    public static int getConversion(Scanner in) {
        System.out.println("Choose a conversion:\n\n1. Binary to decimal");
        int conversionType = in.nextInt();

        if (conversionType != 1) {
            System.out.println("Please make a valid selection.\n\n");
            getConversion(in);
        }

        return conversionType;
    }

    public static String getTarget(Scanner in) {

        System.out.println("Enter a binary number");
        String target = in.next();

        // todo add sanitation

        return target;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int conversionType = getConversion(in);
        String target = getTarget(in);

        BinaryConverter binCon = new BinaryConverter(target);

        int decResult = binCon.getDecimalEquivalent();
        String hexResult = binCon.getHexEquivalent();
        target = binCon.getTarget();

        System.out.println(target + " is " + decResult + " in base 10.\n" +
                target + " is " + hexResult + " in base 16.");

        System.exit(0);

    }
}
