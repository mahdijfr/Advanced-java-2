import java.util.Scanner;
import java.lang.Math;

public class P1 {

    static int facialExp(String str)
    {
        int exp = 0;
        int len = str.length();

        for(int i = 1; i < len; i++){
            switch (str.charAt(i))
            {
                case ')':
                    exp++; break;
                case '(':
                    exp--;
            }
        }
        return exp;
    }
    static StringBuilder toText(int exp)
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Math.abs(exp); i++)
            sb.append("so ");
        sb.append((exp > 0) ? "happy" : "sad");

        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int exp = facialExp(str);

        if (exp == 0)
            System.out.println(":|");
        else
            System.out.println(toText(exp));

        sc.close();
    }
}