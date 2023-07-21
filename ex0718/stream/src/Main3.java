import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("가가가","나나나","다다다","라라라","마마마");

        // 순차처리
        Stream<String> stream = list.stream();
//        stream.forEach(s -> Main3.print(s));
        stream.forEach(Main3 :: print);

        System.out.println("-----------------------------------------------");

        // 병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(Main3 :: print);
    }

    public static void print(String str){
        System.out.println(str);
    }
}
