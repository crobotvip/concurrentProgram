import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {


        Consumer f = n -> System.out.println(n);

        Consumer f2 = n -> System.out.println(n + "-F2");


        //执行完F后再执行F2的Accept方法
        f2.andThen(f).accept("test");

        //连续执行F的Accept方法
//        f.andThen(f).andThen(f).andThen(f).accept("test1");

    }


}
