import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BetterClass {

    public static String formatStr(String string, int k) {
        String small = "";
        String big = "";

        if (string.length() < k) {
            return small + " " + big;
        }

        small = string.substring(0, k);
        big = string.substring(0, k);

        for (int i = 1; i <= string.length() - k; i++) {

            String substring = string.substring(i, i + k);
            if (substring.compareTo(small) < 0) {
                small = substring;
            }
            if (substring.compareTo(big) > 0) {
                big = substring;
            }
        }
        return small + "/n" + big;
    }

    public static void compEmail(String company) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]\\w+@\\w+\\.com");
        Matcher matcher = pattern.matcher(company);
        while (matcher.find()) {
            System.out.println("Email : " + matcher.group());
        }
    }

    //подсчет слов в строке
    public static void counting(String s) {
        s = s.toLowerCase();
        Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()))
                .forEach((word, count) ->
                        System.out.printf("%s-%d\n", word, count));
    }
    //Функция вычисления факториала
    public static  int factorial(Scanner sc){
        int num = sc.nextInt();
        if(num<0){
            throw new IllegalArgumentException("Факториал возможен только для положительных чисел!");
        }
        if(num==0){
            return 1;
        }
        int fact=1;
        for (int i = 1; i <=num; i++) {
            fact*=i;
        }
        return fact;
    }



    public static void calculateSomething(Scanner sc) {
        System.out.println("Калькулятор сложения!Введите \"число + число\"");
        String nums = sc.nextLine().trim();
        String[] parts = nums.split("\\+");

        if (parts.length == 2) {
            try {
                int num1 = Integer.parseInt(parts[0].trim());
                int num2 = Integer.parseInt(parts[1].trim());
                System.out.println(num1 + num2);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Ошибка! неверный формат");
        }
        sc.close();
    }

    public  static Integer binarySearch(int[]ar,int item){
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = 0; j < ar.length-i-1; j++) {
                if(ar[j]>ar[j+1]){
                    int temp = ar[j];
                    ar[j]= ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }

       return Arrays.binarySearch(ar,item);

    }

    public static void main(String[] args) {
        try {
         //для binarySearch
            int[]ar = {0,2,-1,4,9};//-10249
            System.out.println(binarySearch(ar, -1));


          //для метода factorial
            Scanner sc = new Scanner(System.in);
            System.out.println(factorial(sc));


            //для метода calculateSomething
            Scanner scanner = new Scanner(System.in);
            calculateSomething(scanner);

            //для метода counting
            String see = "Корабль врезался в Корабль";
            counting(see);

            //для метода formatStr
            String string = "abcdefg";
            int k = 3;
            System.out.println(formatStr(string, k));

            //для метода compEmail
            String companyEmail = "Компания по производству экспериментальных препаратов \"NZT48\"\n" +
                    "наша почта: neoNzt@48company.com";
            compEmail(companyEmail);
            //------------------------
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}