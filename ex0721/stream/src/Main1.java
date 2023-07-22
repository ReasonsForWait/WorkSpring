import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("홍길동","김삿갓","황진이");
        // 이터레이터 방식
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        // 스트림 방식
        Stream<String> stream = list.stream();
        stream.forEach(name -> System.out.println(name));

    }
}