import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BetterClass {

public static String formatStr(String string, int k){
    String small= "";
    String big= "";

    if(string.length()<k){
        return small + " " + big;
    }

    small=string.substring(0,k);
    big=string.substring(0,k);

    for (int i = 1; i <=string.length()-k; i++) {

        String substring = string.substring(i, i+k);
        if(substring.compareTo(small)<0){
            small =substring;
        }
        if(substring.compareTo(big)>0){
            big=substring;
        }
    }
return small +"/n"+ big;
}

public static void compEmail(String company){
    Pattern pattern = Pattern.compile("[a-zA-Z0-9]\\w+@\\w+\\.com");
    Matcher matcher = pattern.matcher(company);
    while (matcher.find()){
        System.out.println("Email : " + matcher.group());
    }
}
//подсчет слов в строке
public static void counting(String s){
  s=   s.toLowerCase();
  Arrays.stream(s.split(" "))
          .collect(Collectors.groupingBy(
                  word->word,
                  Collectors.counting()))
          .forEach((word,count)->
                  System.out.printf("%s-%d\n",word,count));
}

public static int searchNum(int[]ar) {
    Map<Integer, Integer> map = new HashMap<>();
   int povtor = Integer.MIN_VALUE;
    for (int i = 0; i <ar.length; i++) {
        if (map.containsKey(ar[i])) {
povtor = ar[i];
return povtor;
        }
        map.put(ar[i], map.getOrDefault(ar[i], 0)+1);
    }

return povtor;
}


    public static void main(String[] args) {
try {
    int[]arrray = {2,1,2,3,3};
    System.out.println("Первое повторяющееся число: " + searchNum(arrray));
    String see = "Корабль врезался в Корабль";
   counting(see);
    String string = "abcdefg";
    int k = 3;
    String companyEmail = "Компания по производству экспериментальных препаратов \"NZT48\"\n" +
            "наша почта: neoNzt@48company.com";
    System.out.println(formatStr(string, k));
    compEmail(companyEmail);
}catch (Exception e){
    System.out.println(e.getMessage());
}
}
}