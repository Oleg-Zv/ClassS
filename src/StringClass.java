import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringClass {

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


    public static void main(String[] args) {
try {
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