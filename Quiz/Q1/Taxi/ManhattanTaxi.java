import java.math.BigDecimal;

public class ManhattanTaxi implements Taxi {
    private static final int PRICE_COEFFICIENT = 3;

    public BigDecimal getPrice(Point src, Point dest) {
        BigDecimal srcX = new BigDecimal(src.x);
        BigDecimal srcY = new BigDecimal(src.y);
        BigDecimal destX = new BigDecimal(dest.x);
        BigDecimal destY = new BigDecimal(dest.y);
        BigDecimal xDiff = srcX.subtract(destX);
        BigDecimal yDiff = srcY.subtract(destY);
        
        return xDiff.abs().add(yDiff.abs()).multiply(new BigDecimal(PRICE_COEFFICIENT));
    }
}
