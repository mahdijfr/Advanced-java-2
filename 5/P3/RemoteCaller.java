import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RemoteCaller {

    // You can add fields, if you need.
    public static Object creator(String command) throws Exception {
    	String[] comps = command.replaceAll(", ", " ").split(" ");
        String className = comps[1];

        ArrayList<Class> argsClass = new ArrayList<Class>();
        ArrayList<Object> argsObject = new ArrayList<Object>();
        objectArrayBuilder(comps, argsClass, argsObject);

        Constructor cons = Class.forName(className).getDeclaredConstructor(argsClass.toArray(new Class[argsClass.size()]));
        cons.setAccessible(true);
        return cons.newInstance(argsObject.toArray());
    }

    public static Object caller(String command, Object baseObject) throws Exception {
        String[] comps = command.replaceAll(", ", " ").split(" ");
        String methodName = comps[1];

        ArrayList<Class> argsClass = new ArrayList<Class>();
        ArrayList<Object> argsObject = new ArrayList<Object>();
        objectArrayBuilder(comps, argsClass, argsObject);

        Method method = baseObject.getClass().getDeclaredMethod(methodName, argsClass.toArray(new Class[argsClass.size()]));
        method.setAccessible(true);
        return method.invoke(baseObject, argsObject.toArray());
    }

    public static void setter(String command, Object baseObject) throws Exception {
        String[] comps = command.replaceAll(", ", " ").split(" ");
        String fieldName = comps[1];

        ArrayList<Class> argsClass = new ArrayList<Class>();
        ArrayList<Object> argsObject = new ArrayList<Object>();
        objectArrayBuilder(comps, argsClass, argsObject);

        Field field = baseObject.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(baseObject, argsObject.get(0));
    }

    private static void objectArrayBuilder(String[] components, ArrayList<Class> argsClass, ArrayList<Object> argsObject) {

        for(int i = 2; i < components.length; i += 2) {
        	switch(components[i]) {
                case "int":
                    argsClass.add(int.class);
                    argsObject.add(Integer.valueOf(components[i+1]));
                    break;
                case "double":
                    argsClass.add(double.class);
                    argsObject.add(Double.valueOf(components[i+1]));
                    break;
                case "String":
                    argsClass.add(String.class);
                    argsObject.add(components[i+1]); 
                    break;
            }
        }
    }

}
