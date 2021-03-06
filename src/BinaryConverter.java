import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jacobstroop on 9/7/15.
 */
public class BinaryConverter {

    // constants
    private final String BIN_REGEX = "[0-1\\s]+";

    // properties
    private String target;
    private char[] binArray;
    private int decimalEquivalent;
    private String hexEquivalent;
    private boolean isValidTarget;

    // constructors
    public BinaryConverter() {
        super();
    }

    public BinaryConverter(String target) {

        setTarget(target);
        setValidTarget(false);
        validateTarget();

        if (isValidTarget) {
            setBinArray(this.target);
            setDecimalEquivalent();
            setHexEquivalent();
        }
    }

    // setters

    public void setValidTarget(boolean isValidTarget) {
        this.isValidTarget = isValidTarget;
    }
    public void setTarget(String target) {
        this.target = target;
    }
    private void setBinArray(String target) {

        StringBuilder sb = new StringBuilder(target);

        // if binary number is not equally divisble
        // by 4, prepend off bits until it is
        while (sb.length() % 4 != 0) {
            sb.insert(0, '0');
        }

        this.binArray = sb.toString().toCharArray();
    }
    private void setDecimalEquivalent() {

        this.decimalEquivalent = calcDecimal(binArray);
    }
    private void setHexEquivalent() {

        StringBuilder sb = new StringBuilder();

        // loop binArray by nibbles
        for (int i=0; i<binArray.length; i+=4) {

            // new empty char[] every nibble
            char[] bits = new char[4];

            // create next nibble array in bits
            for (int j=0; j<4; j++) {
                bits[j] = binArray[i+j];
            }

            // find decimal value of nibble
            int nextHex = calcDecimal(bits);

            // switch statement appends hex equivalent if nextHex > 9
            // but defaults to appending nextHex as is if <= 9
            switch (nextHex) {
                case 10: sb.append('A');
                    break;
                case 11: sb.append('B');
                    break;
                case 12: sb.append('C');
                    break;
                case 13: sb.append('D');
                    break;
                case 14: sb.append('E');
                    break;
                case 15: sb.append('F');
                    break;
                default: sb.append(nextHex);
            } // end switch

        } // end outer for loop

        // set results to hexEquiv property
        this.hexEquivalent = sb.toString();

    } // end setHex method

    // getters

    public boolean isValidTarget() {
        return isValidTarget;
    }
    public String getTarget() {
        return target;
    }
    public String getDecimalEquivalent() {
        return String.valueOf(decimalEquivalent);
    }
    public String getHexEquivalent() {
        return hexEquivalent;
    }

    // helper methods

    public void validateTarget() {

        // validate input, ignore spaces
        Pattern binRegex = Pattern.compile(BIN_REGEX);
        Matcher binMatcher = binRegex.matcher(this.target);

        if (binMatcher.matches()) {
            this.isValidTarget = true;
            this.target = this.target.replaceAll("\\s+","");
        }
    }

    // calculates base 10 value from base 2
    private int calcDecimal(char[] bits) {

        // running total
        int dec = 0;

        // loop char array
        for (int i=0; i<bits.length; i++) {

            // if bit is on, calculate value and add to dec
            if (bits[i] == '1') {

                // value of on bit is equal 2 to the power
                // of its position in the array plus 1
                dec += Math.pow(2, (bits.length-(i+1)));
            }
        }

        // return final value of dec
        return dec;
    }






}
