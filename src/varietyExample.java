import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class varietyExample {
    public static void main(String[] args) {
        mapExamples();
        filterExamples();
        aggregatingOperationsExamples();

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
        List<Integer> pows = pow2.stream().map(d -> {
            String str = Double.toString(d);
            return str.length();
        }).collect(Collectors.toList());
        System.out.println(pows);

    }

    private static void filterExamples() {
        List<String> words = Arrays.asList("tst", "one", "two", "three", "four", "five", "rotator", "deified");
        System.out.println("1. Simple Filtering");
        List<String> longWords = words.stream()
                .filter(s -> s.length() > 3).collect(Collectors.toList());
        System.out.println(longWords);
        System.out.println("2. Little More Complex Filtering");
        List<String> palindrome = words.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println(palindrome);
    }
    private static void aggregatingOperationsExamples(){
        List<String> words = Arrays.stream("Once upon a midnight dreary while I pondered weak and weary".split("\\s+"))
                .collect(Collectors.toList());
        System.out.println("1. Check if all items satisfy a criteria");
        boolean noWordsLongerThan9 =words.stream().allMatch(w -> w.length()<3);
        boolean theSame = words.stream().noneMatch(w -> w.length() <3);
        System.out.println(noWordsLongerThan9);
    }
}
