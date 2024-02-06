import java.math.BigDecimal;
import java.math.MathContext;

public class EuclideanTaxi implements Taxi {
    private static final int PRICE_COEFFICIENT = 4;


    public BigDecimal getPrice(Point src, Point dest) {
        BigDecimal srcX = new BigDecimal(src.x);
        BigDecimal srcY = new BigDecimal(src.y);
        BigDecimal destX = new BigDecimal(dest.x);
        BigDecimal destY = new BigDecimal(dest.y);
        BigDecimal xDiff = srcX.subtract(destX).multiply(srcX.subtract(destX));
        BigDecimal yDiff = srcY.subtract(destY).multiply(srcY.subtract(destY));

        MathContext mc = new MathContext(10);

        return (xDiff.add(yDiff)).sqrt(mc).multiply(new BigDecimal(PRICE_COEFFICIENT));
    }

    // private static BigDecimal sqrt(BigDecimal A) {
    //     BigDecimal x0 = new BigDecimal("0");
    //     BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
    //     while (!x0.equals(x1)) {
    //         x0 = x1;
    //         x1 = A.divide(x0);
    //         x1 = x1.add(x0);
    //         x1 = x1.divide(BigDecimal.valueOf(2));
    
    //     }
    //     return x1;
    // }
}
