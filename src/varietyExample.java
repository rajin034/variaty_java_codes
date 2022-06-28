import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class varietyExample {
    public static void main(String[] args) {
        mapExamples();

    }

    private static void mapExamples() {
        String s = "1 2 3 4 5 6 7 8 9 10";
        System.out.println("1. Mapping with one argument function: ");
        List<Integer> ints = Arrays.stream(s.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(ints);
        System.out.println("2. Mapping with simple Lambda Expression:");
        List<Double> pow2 = ints.stream().map(x -> Math.pow(2.0, x)).collect(Collectors.toList());
        System.out.println(pow2);
        List<String> doubled = ints.stream().map(i -> i + "_" + i).collect(Collectors.toList());
        System.out.println(doubled);
        System.out.println("Mapping with Complex function");
        List<Integer> pows = pow2.stream().map(d-> {
            String str= Double.toString(d);
            return str.length();
        }).collect(Collectors.toList());

    }
}
