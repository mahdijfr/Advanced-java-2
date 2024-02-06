import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NaturalNumbers n = new NaturalNumbers();
        // IntStream.of(n.nums).forEach(System.out::print);
        // System.out.println(new StringBuilder(String.valueOf(23)).reverse().toString());
        System.out.println(n.sum(5, 7));
    }
}
