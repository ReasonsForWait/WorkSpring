package lambda;

import java.util.function.IntSupplier;

public class Main3 {
    public static void main(String[] args) {
        IntSupplier supplier1 = () -> (int)(Math.random() * 6) + 1;

        System.out.println("주사위 눈의 수는 : "+supplier1.getAsInt());
    }
}
