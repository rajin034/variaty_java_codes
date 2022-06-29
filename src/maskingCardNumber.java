import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maskingCardNumber {
    public static void main(String[] args) {
        String a[]
                = new String[] { "1111222233334444", "2222333344445555","3333444455556666", "44455556666777777" };
        List<String> num = Arrays.asList(a);
        System.out.println(cardNumberMask(num));


    }

    public static List<String> cardNumberMask(List<String> cardNumbers) {

        /*List<String> maskedCardNumbers = cardNumbers.stream().map(cardNumber -> maskCard(cardNumber)).collect(Collectors.toList());

        System.out.println(maskedCardNumbers);
        return maskedCardNumbers;
        *//*return cardNumber.substring(0, 4) + "****" + cardNumber.substring(cardNumber.length() - 4);*/
        List<String> finalList = new ArrayList<>();
        for(String num: cardNumbers){
            finalList.add(maskCard(num));
        }
        return finalList;
    }

    public static String maskCard(String input) {
        String str1 = input.substring(0, 4);

        /*String str2 = input.substring(4, input.length() - 4);*/
        String str3 = input.substring(input.length() - 4);
        String str4 =  str1 + "********" + str3;
        return str4;
    }
}

