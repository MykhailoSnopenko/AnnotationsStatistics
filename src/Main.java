import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            IllegalAccessException, NoSuchFieldException,
            InstantiationException {
        Map<Class<?>, Integer> result = new HashMap<>();
        Class<?> cls = JavaDeveloper.class;

        System.out.println(analize(cls));
        System.out.println(analizingAnnotation(cls));

    }
    //Решение с помощью рекурсии
    public static Map<Class<? extends Annotation>, Integer> analizingAnnotation(Class<?> cl) {
        Map<Class<? extends Annotation>, Integer> result = new HashMap<>();
        result.put(ProgrammerAnnotation.class, 0);
        result.put(JavaDevAnnotation.class, 0);
        result.put(EmployeeAnnotation.class, 0);
        return analizingAnnotation(cl, result);
    }

    public static Map<Class<? extends Annotation>, Integer> analizingAnnotation(Class<?> cl, Map<Class<? extends Annotation>, Integer> result) {

        if (!(cl.equals(Object.class))) {

            for (Class<? extends Annotation> annotation : result.keySet()) {
                for (Method method : cl.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(annotation)) {
                        Integer n = result.get(annotation);
                        result.put(annotation, n + 1);
                    }
                }
                for (Field field : cl.getDeclaredFields()) {
                    if (field.isAnnotationPresent(annotation)) {
                        Integer n = result.get(annotation);
                        result.put(annotation, n + 1);
                    }
                }
                for (Constructor<?> constructor : cl.getDeclaredConstructors()) {
                    if (constructor.isAnnotationPresent(annotation)) {
                        Integer n = result.get(annotation);
                        result.put(annotation, n + 1);
                    }
                }
            }
            result = analizingAnnotation(cl.getSuperclass(), result);
        }

        return result;
    }

    //Решение с помощью цикла
    public static List<Class<?>> getClassList(Class<?> startClass) {
        List<Class<?>> classList = new ArrayList<>();
        for (; !startClass.equals(Object.class);) {
            classList.add(startClass);
            startClass = startClass.getSuperclass();
        }
        return classList;
    }

    public static Map<Class<? extends Annotation>, Integer> analize(Class<?> cl) {
        Map<Class<? extends Annotation>, Integer> result = new HashMap<>();
        result.put(ProgrammerAnnotation.class, 0);
        result.put(JavaDevAnnotation.class, 0);
        result.put(EmployeeAnnotation.class, 0);
        List<Class<?>> classList = getClassList(cl);
        for (Class<?> cls : classList) {
            for (Class<? extends Annotation> annotation : result.keySet()) {

                for (Method method : cls.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(annotation)) {
                        Integer n = result.get(annotation);
                        result.put(annotation, n + 1);
                    }
                }
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(annotation)) {
                        Integer n = result.get(annotation);
                        result.put(annotation, n + 1);
                    }
                }
                for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                    if (constructor.isAnnotationPresent(annotation)) {
                        Integer n = result.get(annotation);
                        result.put(annotation, n + 1);
                    }
                }
            }
        }
        return result;
    }
}