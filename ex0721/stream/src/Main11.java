import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Main11 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        double avg = list.stream()
//                .mapToInt(Integer :: intValue)
//                .average()
//                .getAsDouble();

//        System.out.println(avg);

        // 방법 1
//        OptionalDouble optional = list.stream()
//                .mapToInt(Integer :: intValue)
//                .average();
//        if(optional.isPresent()){
//            System.out.println("있을 시 값 : "+optional);
//        }else{
//            System.out.println("리스트에 현재 값이 존재하지 않습니다.");
//        }

        // 방법 2
//        double avg = list.stream()
//                .mapToInt(Integer :: intValue)
//                .average()
//                .orElse(0.0);
//        System.out.println("있을 시 값 : "+avg);

        list.add(100);

        // 방법 3
        list.stream()
                .mapToInt(Integer :: intValue)
                .average()
                .ifPresent(a -> System.out.println("있을 시 값 : "+a));
    }
}
