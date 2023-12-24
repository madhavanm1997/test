package java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamTest {
    public static void main(String[] args) {

        //Array to using stream
        int[] a = {2, 1, 4, 2, 8, 9, 6};
        System.out.println(".....Array to using stream.....");
        IntStream streamArray1 = Arrays.stream(a);
        //System.out.println("streamArray1:: " + streamArray1.max()); // throw a error if it is use..
        OptionalInt inter = streamArray1.max();
        System.out.println("inter:: " + inter.getAsInt());

        //List to using stream
        System.out.println();
        System.out.println(".....List to using stream.....");
        List<Integer> list1 = Arrays.asList(2, 4, 3, 12, 7, 6, 9, 5);
        System.out.println("list1:: " + list1);
        Stream<Integer> streamList1 = list1.stream();
        System.out.println("streamList:: " + streamList1.count());

        //Stream map
        System.out.println();
        System.out.println(".....Stream map.....");
        list1.stream().map(n -> n * n).forEach(System.out::println);
        List listMap = list1.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println();

        //stream filter
        System.out.println();
        System.out.println(".....Stream filter.....");
        List listFilter = list1.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("listFilter:: " + listFilter);

        //stream sorted
        System.out.println();
        System.out.println(".....Stream sorted....");
        List<Integer> listSorted = list1.stream().sorted().collect(Collectors.toList());
        System.out.println("listSorted:: "+listSorted);

        //stream reduce
        System.out.println();
        System.out.println(".....Stream Reduce.....");
        System.out.println(list1.stream().reduce(0,(c,b)->c+b));
        //def de=7;
    }
}
