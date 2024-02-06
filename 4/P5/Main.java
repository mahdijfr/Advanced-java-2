public class Main {
    
    public static void main(String[] args) {
        // Instance a=new Instance("a", "b", "c", 1, 2, 3, true);
        // Instance b=new Instance("a", "b", "c", 1, 2, 3, true);
        // Instance c=new Instance("d", "b", "e", 1, 4, 3, true);
        // c.setP(false);
        // Instance[] instances={a, b, c};
        // StreamImp streamImp=new StreamImp(instances);
        // String s = streamImp.print();
        // System.out.println(s);
        // /*
        // s = a b c
        // 1 2 3.0
        // true
        // a b c
        // 1 2 3.0
        // true
        // d b e
        // 1 4 3.0
        // false
        // */


        Instance a=new Instance("m", "n", "o", 43, 123456, 2.5, true);
        Instance b=new Instance("m", "l", "t", 17, 37625, 15.54, false);
        Instance c=new Instance("s", "l", "d", 986, 25632, 2.55, false);
        Instance[] instance={a, b, c};
        StreamImp s=new StreamImp(instance);

        // filter = ["n", "n", "n"]
        System.out.println(s.map("a").distinct().print());
    }
}
