import java.util.Scanner;
import java.util.regex.*;

public class P5 {
    static String getId(String tag) {
        Matcher id = Pattern.compile("id *= *\"([^\"]+)\"").matcher(tag);

        if (id.find()) {
            return id.group(1);
        }
        return "";
    }
    static String getStyle(String tag) {
        Matcher style = Pattern.compile("style *= *\"([^\"]+)\"").matcher(tag);

        if (style.find()) {
            return style.group(1).replace("; ", ";\n");
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.contains("style") && line.contains("id")) {
                String id = getId(line);
                String style = getStyle(line);

                System.out.printf("#%s {\n%s\n}\r\n",id, style);
            }
        }
        sc.close();
    }
}