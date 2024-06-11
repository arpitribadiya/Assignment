import java.text.DecimalFormat;
import java.math.BigDecimal;

class TestProgram {
    public static void main(String[] args) {
        System.out.println(formatNumber(new BigDecimal("1000000")));         // 1M
        System.out.println(formatNumber(new BigDecimal("2500000.34")));      // 2.5M
        System.out.println(formatNumber(new BigDecimal("532")));             // 532
        System.out.println(formatNumber(new BigDecimal("1123456789")));      // 1.1B
        System.out.println(formatNumber(new BigDecimal("11100000000000")));   // 11.1T

    }
    
    public static String formatNumber(BigDecimal number) {
        if (number.compareTo(new BigDecimal("1000000000000")) >= 0) {
            return truncateAndFormat(number.divide(new BigDecimal("1000000000000")), "T");
        } else if (number.compareTo(new BigDecimal("1000000000")) >= 0) {
            return truncateAndFormat(number.divide(new BigDecimal("1000000000")), "B");
        } else if (number.compareTo(new BigDecimal("1000000")) >= 0) {
            return truncateAndFormat(number.divide(new BigDecimal("1000000")), "M");
        } else {
            return truncateAndFormat(number, "");
        }
    }
    
    public static String truncateAndFormat(BigDecimal number, String suffix) {
        DecimalFormat formatter = new DecimalFormat("#.#");
        String formattedNumber = formatter.format(number);
        if (formattedNumber.endsWith(".0")) {
            formattedNumber = formattedNumber.substring(0, formattedNumber.length() - 2);
        }
        return formattedNumber + suffix;
    }
}