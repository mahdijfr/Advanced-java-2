import java.util.Objects;
import java.lang.reflect.*;
import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.Arrays;

class Instance{
    String a;
    String b;
    String c;
    int x=0;
    long y=0;
    double z=0;
    boolean p;
    int boolCounter=0;

    public Instance(){

    }

    public Instance(String a, String b, String c, int x, long y, double z, boolean p) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x = x;
        this.y = y;
        this.z = z;
        this.p = p;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean isP() {
        return p;
    }

    public void setP(boolean p) {
        this.p = p;
        boolCounter++;
    }

    @Override
    public String toString(){
        String ans="";
        if(a!=null){
            ans+=a;
            if(b==null && c==null && (x!=0 || y!=0 || z!=0)){
                ans+="\n";
            } else if(b!=null || c!=null){
                ans+=" ";
            }
        }

        if(b!=null){
            ans+=b;
            if(c==null && (x!=0 || y!=0 || z!=0)){
                ans+="\n";
            } else if(c!=null){
                ans+=" ";
            }
        }

        if(c!=null){
            ans+=c;
            if(x!=0 || y!=0 || z!=0){
                ans+="\n";
            }
        }

        if(x!=0){
            ans+=x;
            if(y==0 && z==0 && (boolCounter!=0 || p)){
                ans+="\n";
            } else if(y!=0 || z!=0){
                ans+=" ";
            }
        }

        if(y!=0){
            ans+=y;
            if(z==0 && (boolCounter!=0 || p)){
                ans+="\n";
            } else if(z!=0){
                ans+=" ";
            }
        }

        if(z!=0){
            ans+=z;
            if(boolCounter!=0 || p){
                ans+="\n";
            }
        }

        if(!p){
            if(boolCounter!=0){
                ans+=p;
            }
        } else {
            ans+=p;
        }


        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instance instance = (Instance) o;
        return x == instance.x && y == instance.y && Double.compare(instance.z, z) == 0 && p == instance.p && boolCounter == instance.boolCounter && Objects.equals(a, instance.a) && Objects.equals(b, instance.b) && Objects.equals(c, instance.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, x, y, z, p, boolCounter);
    }
}

public class StreamImp {
    Instance[] instance;
    int size;

    public StreamImp(Instance[] instance) {
        this.instance = instance;
        this.size= instance.length;
    }

    public String print(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < getSize(); i++){
            sb.append(getInstance()[i].toString()).append("\n");
        }
        return sb.toString();
    }
    //this
    public Instance[] simpleLimit(int num){
        Instance[] newInstances = new Instance[getSize() - num];
        System.arraycopy(getInstance(), 0, newInstances, 0, getSize() - num);
        return newInstances;
    }

    public StreamImp limit(int num){
        return new StreamImp(this.simpleLimit(num));
    }

    //this
    public Instance[] simpleSkip(int num){
        Instance[] newInstances = new Instance[getSize() - num];
        System.arraycopy(getInstance(), num, newInstances, 0, getSize() - num);
        return newInstances;
    }

    public StreamImp skip(int num){
        return new StreamImp(this.simpleSkip(num));
    }

    //this
    public String[] simpleMap(String var){
        String[] newStrings = new String[getSize()];

        for(int i = 0; i < getSize(); i++){
            Method getter = Instance.class.getMethod("get" + var.toUpperCase());

            newStrings[i] = getter.invoke(getInstance()[i]).toString();
        }
        return newStrings;
    }

    public StreamImp map(String var){
        Instance[] newInstances = new Instance[getSize()];

        for(int i = 0; i < getSize(); i++){
            newInstances[i] = new Instance();

            Class in = Instance.class;
            Method getter = in.getMethod("get" + var.toUpperCase(), null);
            Method setter = in.getMethod("set" + var.toUpperCase(), Object.class);


            setter.invoke(newInstances[i], getter.invoke(getInstance()[i]));
        }
        return new StreamImp(newInstances);
    }

    //this
    public String[] simpleFilter(String var, String type){
        String[] newStrings = new String[countObject(simpleMap(var), type)];
        Arrays.fill(newStrings, type);

        return newStrings;
    }

    static int countObject(Object[] objects, Object obj){
        int count = 0;
        for(Object o : objects){
            if(o != null && o.equals(obj)){
                count++;
            }
        }
        return count;
    }

    public StreamImp filter(String var, String type){
        ArrayList<Instance> newInstances = new ArrayList<>();

        for(Instance i : getInstance()){

            switch(var) {
                case "a" : 
                if (i.getA().equals(type)) newInstances.add(i) ; break;
                case "b" :
                if (i.getB().equals(type)) newInstances.add(i) ; break;
                case "c" :
                if (i.getC().equals(type)) newInstances.add(i) ; break;
                case "x" :
                if (String.valueOf(i.getX()).equals(type)) newInstances.add(i) ; break;
                case "y" :
                if (String.valueOf(i.getY()).equals(type)) newInstances.add(i) ; break;
                case "z" :
                if (String.valueOf(i.getZ()).equals(type)) newInstances.add(i) ; break;
                case "p" :
                if (String.valueOf(i.isP()).equals(type)) newInstances.add(i) ; break;
            };
        }
        return new StreamImp(newInstances.toArray(new Instance[newInstances.size()]));
    }

    public int count(){
        return getInstance().length;
    }

    public String sum(String type){
        
        if (type.equals("x")) {
            int sum = 0;

            for (Instance i : getInstance()) {
                sum += i.getX();
            }
            return String.valueOf(sum);
        } else if (type.equals("y")) {
            long sum = 0;

            for (Instance i : getInstance()) {
                sum += i.getY();
            }
            return String.valueOf(sum);
        } else if (type.equals("z")) {
            double sum = 0;

            for (Instance i : getInstance()) {
                sum += i.getZ();
            }
            return String.valueOf(sum);
        }

        return String.join(" ", this.simpleMap(type)) + " ";
    }

    public boolean anyMatch(String var, String value){
        return simpleFilter(var, value).length > 0;
    }

    public boolean allMatch(String var, String value){
        return simpleFilter(var, value).length == getSize();
    }

    public boolean noneMatch(String var, String value){
        return simpleFilter(var, value).length == 0;
    }

    public StreamImp distinct(){
        ArrayList<Instance> blackList = new ArrayList<>();
        
        String[] vars = {"a", "b", "c", "x", "y", "z", "p"};

        for(String var : vars) {
            for (int i = 0; i < getSize(); i++) {
                for (int j = i + 1; j < getSize(); j++) {
                    if (blackList.contains(instance[i])) {
                        break;
                    }
                    else if (isEqual(instance[i], instance[j], var) && !blackList.contains(instance[j])) {
                        blackList.add(instance[j]);
                    }
                }
            }
        }

        ArrayList<Instance> newInstances = new ArrayList<>();
        for (Instance i : getInstance()) {
            if (!blackList.contains(i)) {
                newInstances.add(i);
            }
        }
        
        return new StreamImp(newInstances.toArray(new Instance[newInstances.size()]));
    }

    static boolean isEqual(Instance i1, Instance i2, String var){
        switch(var) {
            case "a" : return i1.getA().equals(i2.getA());
            case "b" : return i1.getB().equals(i2.getB());
            case "c" : return i1.getC().equals(i2.getC());
            case "x" : return i1.getX() == i2.getX();
            case "y" : return i1.getY() == i2.getY();
            case "z" : return i1.getZ() == i2.getZ();
            case "p" : return i1.isP() == i2.isP();
        };
        return false;
    }

    public Instance[] getInstance() {
        return instance;
    }

    public void setInstance(Instance[] instance) {
        this.instance = instance;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
