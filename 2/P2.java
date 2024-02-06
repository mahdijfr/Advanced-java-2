import java.util.Scanner;
import java.util.regex.*;

public class P2 {
    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    static String camelCase(String str) {
        str = str.toLowerCase();
        Matcher m = Pattern.compile("[^a-zA-Z]+[a-zA-Z]").matcher(str);
        while (m.find()){
            str = str.replace(m.group(), m.group().toUpperCase());
        }
        
        return String.join("", str.split("[\\W_]+"));
    }
    static String capital(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.toLowerCase();
        sb.append(str.substring(0, 1).toUpperCase());

        Matcher m = Pattern.compile("[^a-zA-Z]+[a-zA-Z]").matcher(str); 
        while (m.find()){
            str = str.replace(m.group(), m.group().toUpperCase());
        }
        sb.append(str.substring(1));

        return sb.toString();
    }
    static String encode(String str) {
        StringBuilder sbEven = new StringBuilder(), sbOdd = new StringBuilder();
        str = reverse(str);

        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0)
                sbEven.append(str.charAt(i));
            else
                sbOdd.append(str.charAt(i));
        }
        return sbEven.append("#-#").append(sbOdd).toString();
    }
    static String decode(String str) {
        StringBuilder sb = new StringBuilder();
        String[] parts = str.split("#-#");
        
        for (int i = 0; i < str.length()-3; i++) {
            if (i % 2 == 0)
                sb.append(parts[0].charAt(i/2));
            else
                sb.append(parts[1].charAt((i-1)/2));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String command = sc.next();
            if (command=="OFF")
                break;
            
            String input = sc.nextLine();
            if (input.length() > 1)
                input = input.substring(1);
            
            switch (command)
            {
                case "to_upper":
                    System.out.println(input.toUpperCase()); break;
                case "to_lower":
                    System.out.println(input.toLowerCase()); break;
                case "camel_case":
                    System.out.println(camelCase(input)); break;
                case "capital":
                    System.out.println(capital(input)); break;
                case "encode":
                    System.out.println(encode(input)); break;
                case "decode":
                    System.out.println(decode(input)); break;
            }
        }
        sc.close();
    }
}
