public class Main {
public static void main(String[] args) throws Exception {

    String x = (String) RemoteCaller.creator("create java.lang.String String reshte");
    System.out.println(RemoteCaller.caller("call replaceAll String e, String *", x).toString()); //r*sht*


    StringBuilder sb = (StringBuilder) RemoteCaller.creator("create java.lang.StringBuilder String reshte-ye-man");
    RemoteCaller.caller("call reverse",sb);

    System.out.println(RemoteCaller.caller("call toString", sb)); // nam-ey-ethser
    System.out.println(RemoteCaller.caller("call charAt int 1",sb)); // a


}

}
