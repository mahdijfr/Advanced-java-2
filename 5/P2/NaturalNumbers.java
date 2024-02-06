import java.util.Comparator;
import java.util.function.*;
import java.util.stream.IntStream;
// import java.util.stream.Stream;


public class NaturalNumbers {
    int[] nums;

    public NaturalNumbers(){
        nums = IntStream.rangeClosed(1, 100).toArray();
    }

    public Function<Integer, Integer> oddOrEven(){
        return (num) -> num % 2;
    }

    public String oddOrEven(int number){
        return (oddOrEven().apply(number) == 0) ? "Even" : "Odd";
    }

    public Predicate<Integer> isPalindrome(){
        return (num) -> {
            String sNum = String.valueOf(num);
            return sNum.equals(new StringBuilder(sNum).reverse().toString());
        };
    }

    public String isPalindrome(int number){
        return (isPalindrome().test(number)) ? "Palindrome" : "Not Palindrome";
    }

    public Predicate<Integer> isPrime(){
        return (num) -> {
            if (num < 2)
                return false;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) 
                    return false;
            }
            return true;
        };
    }

    public String isPrime(int number){
        return (isPrime().test(number)) ? "Prime" : "Not Prime";
    }

    public Comparator<Integer> comparator(){
        return (num1, num2) -> {
            return num1.compareTo(num2);
        };
    }

    public BiFunction<Integer, Integer, Integer> compare(){
        return (num1, num2) -> {
            return comparator().compare(num1, num2);
        };
    }

    public String compare(int a, int b){
        return String.valueOf(a) 
                + ((compare().apply(a, b) == 0) ? " is equal to " 
                : ((compare().apply(a, b) < 0) ? " is less than " : " is greater than "))
                + String.valueOf(b);

    }

    public int[] collectOdds(){
        return IntStream.of(nums)
            .filter((num) -> oddOrEven().apply(num)==1)
            .toArray();
    }

    public int[] collectEvens(){
        return IntStream.of(nums)
            .filter((num) -> oddOrEven().apply(num)==0)
            .toArray();
    }

    public int[] collectPalindromes(){
        return IntStream.of(nums)
            .filter((num) -> isPalindrome().test(num))
            .toArray();
    }

    public int[] collectPrimes(){
        return IntStream.of(nums)
            .filter((num) -> isPrime().test(num))
            .toArray();
    }

    public int[] collectCompounds(){
        return IntStream.of(nums)
            .filter((num) -> !isPrime().test(num))
            .toArray();
    }

    public int sum(int start, int end){
        return IntStream.of(nums)
            .skip(start)
            .limit(end - start)
            .sum();
    }

    public int[] lessThan(int number){
        return IntStream.of(nums)
            .filter((num) -> compare().apply(num, number) < 0)
            .toArray();
    }

    public int[] greaterThan(int number){
        return IntStream.of(nums)
            .filter((num) -> compare().apply(num, number) > 0)
            .toArray();
    }

    public int weirdOperation(){
        Supplier<IntStream> numStream = () -> {
            return IntStream.of(nums)
                .distinct()
                .filter((num) -> oddOrEven().apply(num)==1)
                .filter((num) -> isPalindrome().test(num));
        };

        return numStream.get().max().getAsInt() + (int)numStream.get().count();
    }

    public String asciiCode(){
        return IntStream.of(nums)
            .sorted()
            .filter((num) -> oddOrEven().apply(num)==0)
            .map((num) -> Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString()))
            .filter((num) -> oddOrEven().apply(num)==1)
            .map((num) -> String.valueOf(num).codePointAt(0))
            .collect(StringBuilder::new,
                    StringBuilder::append,
                    StringBuilder::append)
            .toString();
    }
}
