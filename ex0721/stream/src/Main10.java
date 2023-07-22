import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};

        // 모두 2의 배수인지 확인
        boolean result1 = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0);
        System.out.println("모두 2의 배수인가? : "+result1);

        // 하나라도 3의 배수가 있는가?
        boolean result2 = Arrays.stream(intArr)
                .anyMatch(a -> a%3 == 0);
        System.out.println("하나라도 3의 배수가 있는가? : "+result2);

        // 3의 배수가 없는가?
        boolean result3 = Arrays.stream(intArr)
                .noneMatch(a -> a%3 == 0);
        System.out.println("3의 배수가 없는가? : "+result3);
    }
}
