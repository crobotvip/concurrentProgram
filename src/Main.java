import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {


        Consumer f = n -> System.out.println(n);

        Consumer f2 = n -> System.out.println(n + "-F2");


        //ִ����F����ִ��F2��Accept����
        f2.andThen(f).accept("test");

        //����ִ��F��Accept����
//        f.andThen(f).andThen(f).andThen(f).accept("test1");

    }


}
