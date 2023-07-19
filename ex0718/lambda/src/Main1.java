import lambda.LambdaSample1;
import lambda.LambdaSample2;

public class Main1 {
    public static void main(String[] args) {
//        LambdaSample1 lambda1 = new LambdaSample1() {
//            @Override
//            public void value() {
//                System.out.println("이것은 lambda1 입니다.");
//            }
//        };
//        lambda1.value();

        LambdaSample1 lambda2 = (int a) -> {
            System.out.println("이것은 lambda2 입니다."+a);
        };

        lambda2.value(3);

        LambdaSample1 lambda3 = (int a) -> System.out.println("이것은 lambda2 입니다."+a);
        lambda3.value(5);

        // 리턴값이 있는 람다식
        // LambdaSample2 lambda2_1 = (String s) -> {return s};
        LambdaSample2 lambda2_1 = (String s) -> s;

        System.out.println("lambda2_1 출력 : "+lambda2_1.method("안녕하세요"));
    }
}