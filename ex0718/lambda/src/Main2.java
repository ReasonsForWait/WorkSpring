import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main2 {
    public static void main(String[] args) {
        Consumer<String> con1 = t -> System.out.println(t + "17");
        con1.accept("java");

        BiConsumer<String, Integer> con2 = (t, u) -> System.out.println(t + u);
        con2.accept("java", 17);
    }
}
