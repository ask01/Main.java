import java.util.Scanner;

public class Main {

    static boolean bl1;
    static boolean bl2;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = in.nextLine();
        String[] splinter = input.split(" ");
        int arrlength = splinter.length;
        if (arrlength != 3) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                System.exit(0);
            }
        }
        if (!splinter[1].equals("+") && !splinter[1].equals("-") && !splinter[1].equals("*") && !splinter[1].equals("/")) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("т.к. строка не является математической операцией");
                System.exit(0);
            }
        }

        if (splinter[0].equals("I") || splinter[0].equals("II") || splinter[0].equals("III") || splinter[0].equals("IV") || splinter[0].equals("V") || splinter[0].equals("VI") || splinter[0].equals("VII") || splinter[0].equals("VIII") || splinter[0].equals("IX") || splinter[0].equals("X")) {
            bl1 = true;
        } else {
            bl1 = false;
        }

        if (splinter[2].equals("I") || splinter[2].equals("II") || splinter[2].equals("III") || splinter[2].equals("IV") || splinter[2].equals("V") || splinter[2].equals("VI") || splinter[2].equals("VII") || splinter[2].equals("VIII") || splinter[2].equals("IX") || splinter[2].equals("X")) {
            bl2 = true;
        } else {
            bl2 = false;
        }

        if(bl1 != bl2)
            try {
                throw new Exception();
            } catch(Exception e) {
                System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                System.exit(0);
            }
        System.out.println(calc(input));
    }

    static int toArabic(String splinter) {

        if (splinter.equals("I")) return 1;
        if (splinter.equals("II")) return 2;
        if (splinter.equals("III")) return 3;
        if (splinter.equals("IV")) return 4;
        if (splinter.equals("V")) return 5;
        if (splinter.equals("VI")) return 6;
        if (splinter.equals("VII")) return 7;
        if (splinter.equals("VIII")) return 8;
        if (splinter.equals("IX")) return 9;
        if (splinter.equals("X")) return 10;
        return 55;
    }

    static String toRoman(String result) {
        if (result.equals("1")) return "I";
        if (result.equals("2")) return "II";
        if (result.equals("3")) return "III";
        if (result.equals("4")) return "IV";
        if (result.equals("5")) return "V";
        if (result.equals("6")) return "VI";
        if (result.equals("7")) return "VII";
        if (result.equals("8")) return "VIII";
        if (result.equals("9")) return "IX";
        if (result.equals("10")) return "X";
        if (result.equals("11")) return "XI";
        if (result.equals("12")) return "XII";
        if (result.equals("13")) return "XIII";
        if (result.equals("14")) return "XIV";
        if (result.equals("15")) return "XV";
        if (result.equals("16")) return "XVI";
        if (result.equals("17")) return "XVII";
        if (result.equals("18")) return "XVIII";
        if (result.equals("19")) return "XIX";
        if (result.equals("20")) return "XX";
        if (result.equals("21")) return "XXI";
        if (result.equals("24")) return "XXIV";
        if (result.equals("25")) return "XXV";
        if (result.equals("27")) return "XXVII";
        if (result.equals("28")) return "XVIII";
        if (result.equals("30")) return "XXX";
        if (result.equals("32")) return "XXXII";
        if (result.equals("35")) return "XXXV";
        if (result.equals("36")) return "XXXVI";
        if (result.equals("40")) return "XL";
        if (result.equals("42")) return "XLII";
        if (result.equals("45")) return "XLV";
        if (result.equals("48")) return "XLVIII";
        if (result.equals("49")) return "XLIX";
        if (result.equals("50")) return "L";
        if (result.equals("54")) return "LIV";
        if (result.equals("56")) return "LVI";
        if (result.equals("60")) return "LX";
        if (result.equals("63")) return "LXIII";
        if (result.equals("64")) return "LXIV";
        if (result.equals("70")) return "LXX";
        if (result.equals("72")) return "LXXII";
        if (result.equals("80")) return "LXXX";
        if (result.equals("81")) return "LXXXI";
        if (result.equals("90")) return "XC";
        if (result.equals("100")) return "C";
        return String.valueOf(77);
    }

    public static String calc(String input) {

        int ch1 = 0;
        int ch2 = 0;
        String result = null;
        String[] splinter = input.split(" ");

        if (bl1 && bl2) {
            ch1 = toArabic(splinter[0]);
            ch2 = toArabic(splinter[2]);}

        else {
            ch1 = Integer.parseInt(splinter[0]);
            ch2 = Integer.parseInt(splinter[2]);
        }
        if (ch1 < 1 || ch1 > 10) {
            try {
                throw new Exception();
            }
            catch (Exception e) {
                System.out.println("т.к. первое число не входит в диапазон от 1 до 10 включительно") ;
                }
        }
        if (ch2 < 1 || ch2 > 10) {
            try {
                throw new Exception();
            }
            catch (Exception e) {
                System.out.println("т.к. второе число не входит в диапазон от 1 до 10 включительно") ;
                System.exit(0);
            }
        }
        if(bl1 & bl2 & ch1 <= ch2 & splinter[1].equals("-"))
            try {
                throw new Exception();
            } catch(Exception e) {
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел и нуля");
                System.exit(0);
            }

        if(bl1 & bl2 & ch1 < ch2 & splinter[1].equals("/"))
            try {
                throw new Exception();
            } catch(Exception e) {
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел и нуля");
                System.exit(0);
            }


        switch (splinter[1]) {
            case "+":
                result = String.valueOf(ch1 + ch2);
                break;
            case "-":
                result = String.valueOf(ch1 - ch2);
                break;
            case "*":
                result = String.valueOf(ch1 * ch2);
                break;
            case "/":
                result = String.valueOf(ch1 / ch2);
                break;
    }
        if(bl1){
            result = toRoman(result);
        }
return result;}
}




