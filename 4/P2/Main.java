package P2;
abstract class AbstractClass{

    final void func(){

        if(this instanceof Child){

            System.out.print("not ");

        }

        System.out.println("func here");

    }

    abstract void func1(int a);

    abstract void func2();

    abstract AbstractClass func3(int a);

}

class Parent extends AbstractClass{

    int a=3;

    void func1(int a){
        System.out.println(a/2);
    }

    void func2(){
        System.out.println("did nothing");
    }

    Child func3(int a){
        Child c = new Child();
        c.a = a;

        return c;
    }

    void func4(){
        for (int i = 0; i < a-1; i++) {
            System.out.print("doing the thing ");
        }

        System.out.println("doing the thing");
    }
    

}

final class Child extends Parent{

    @Override
    void func1(int a){
        System.out.println(a*4);
    }

    @Override
    void func2(){
        (new Parent()).func();
    }

    @Override
    void func4(){
        System.out.println("the a is: " + a);
    }

}

public class Main {

    public static void main(String[] args) {

        int a = 10;

        Parent reference = new Parent();

        reference.func();

        reference.func1(a);

        reference.func2();

        reference = new Child();

        reference.func();

        reference.func1(a);

        reference.func2();

        reference = new Parent();

        reference.func4();

        reference.func3(10).func4();

    }

}