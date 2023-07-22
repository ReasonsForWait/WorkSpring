import java.util.Arrays;
import java.util.List;

public class Main7 {
    public static void main(String[] args) {
        List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println("-------------------------------------------------");

        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        int result = inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i=0;i< strArr.length;i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                }).sum();
        System.out.println(result);

    }
}
