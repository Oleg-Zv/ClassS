
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


    public static void main(String[] args) {
try {
    String string = "abcdefg";
    int k = 3;
    formatStr(string, k);
}catch (Exception e){
    System.out.println(e.getMessage());
}
}
}