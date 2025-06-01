package chapter16._4_async_pipeline.domain.discount;

import static chapter16.common.Util.delay;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percent;

        Code(int percent) {
            this.percent = percent;
        }

        public int getPercent() {
            return percent;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " +
                Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    public static double apply(double price, Code discountCode) {
        delay(1);
        return format(price * (100 - discountCode.getPercent()) / 100);
    }

    private static double format(double value) {
        return Double.parseDouble(String.format("%.2f", value));
    }
}
