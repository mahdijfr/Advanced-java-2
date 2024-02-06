import java.util.Scanner;
import java.util.regex.*;

public class P4 {
    static int matchCount(String str, String rgx) {
        return str.split(rgx,-1).length-1;
    }
    static boolean isAspirin(String str) {
        return Pattern.matches("^([a-zA-Z]+_\\d+|\\d+_[a-zA-Z]+)$", str);
    }
    static boolean isGelofen(String str) {
        Matcher gelofen = Pattern.compile("(\\.[_\\-]+)|([_\\-]+\\.)").matcher(str);
        Matcher notValid = Pattern.compile("[^\\w\\-\\.]").matcher(str);
        return !notValid.find() && str.contains(".") && !gelofen.find();
    }
    static boolean isVitamin(String str) {
        Matcher vitamin = Pattern.compile("\\).*\\(").matcher(str);
        Matcher notValid = Pattern.compile("[^\\w\\-\\.\\)\\(]").matcher(str);
        int para1 = matchCount(str, "\\)"), para2 = matchCount(str, "\\(");
        return !notValid.find() && !vitamin.find() && (para1!=0 && para2!=0 && para1 == para2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();

            if (isAspirin(str))
                System.out.println("Aspirin");
            else if (isGelofen(str))
                System.out.println("Gelofen");
            else if (isVitamin(str))
                System.out.println("Vitamin");
            else
                System.out.println("Tamom kardim!");
        }
        sc.close();
    }
}
