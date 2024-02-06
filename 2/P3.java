import java.util.Scanner;
import java.util.regex.*;


public class P3 {
    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    static String reverseDomain(String url) {
        String[] urlParts = url.split("\\.");
        urlParts[1] = reverse(urlParts[1]);
        return String.join("." , urlParts);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rgx = "^[a-zA-Z]{3}\\.\\w{2,}\\.(org|ir|com|net)$";
        
        while (sc.hasNext())
        {
            String str = sc.nextLine();
            if (Pattern.matches(rgx, str))
                System.out.println(reverseDomain(str));
            else
                System.out.println("This URL is uncorrect!");
        }
        sc.close();
    }
}
