package Utils;

public class FormatterUtil {
    public static String formatMoney(double amount) {
        return (amount == (int) amount) ?
                String.format("%d EGP", (int) amount) :
                String.format("%.2f EGP", amount);
    }
}
