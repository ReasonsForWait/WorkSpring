import java.util.Arrays;
import java.util.List;

public class Main6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동","김근형","김자바","김근형","신민철");

        // distinct
        names.stream().distinct().forEach(m -> System.out.println(m));
        System.out.println("---------------------------------");

        // filter 1
        names.stream().filter(m -> m.contains("길")).forEach(m -> System.out.println(m));
        System.out.println("---------------------------------");

        // filter 2
        names.stream().distinct()
                .filter(m -> m.startsWith("김"))
                .forEach(m -> System.out.println(m));


    }
}
