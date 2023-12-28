package java8;

//To check a generics class
class Test1<T> {
    T obj;

    public Test1(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

//To check a generics class
class Test2<T, U> {
    T obj1;
    U obj2;

    Test2(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void toDisplay() {
        System.out.println("obj1: " + obj1);
        System.out.println("obj2: " + obj2);
    }
}

//To check a generics methods
class Test3 {
    static <T> void getGenericsDateType(T element) {
        System.out.println("element: " + element + ", element.getClass(): " + element.getClass());
    }
}

public class GenericFunctionTest {
    public static void main(String[] args) {

        Test1<Integer> test1 = new Test1<>(12);
        System.out.println("test1.getObj(): " + test1.getObj());
        System.out.println("test1.obj: " + test1.obj);

        Test2<String, Integer> test2 = new Test2<>("madhavan", 25);
        System.out.println("test2: " + test2);
        System.out.println("test2.obj1: " + test2.obj1);
        System.out.println("test2.obj2: " + test2.obj2);
        test2.toDisplay();

        Test3.getGenericsDateType(11);
        Test3.getGenericsDateType("madhavan");
    }
}
