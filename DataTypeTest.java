package java8;

import java.util.Arrays;

public class DataTypeTest {
    public static void main(String[] args) {

        //int
        int inta = 6;
        System.out.println("inta: " + inta);
        //doublea
        double doublea = 1.2;
        System.out.println("doublea: " + doublea);
        //String
        String stringa = "hellow";
        System.out.println("stringa: " + stringa);
        //char
        char chara = 'g';
        System.out.println("chara: " + chara);

        //To convert a string to charArray
        char[] charArray = stringa.toCharArray();
        System.out.println("charArray: " + charArray[3]);
        System.out.println("Arrays.toString(charArray): " + Arrays.toString(charArray));

        //To convert a character to String
        char charb = 'a';
        String charString1 = Character.toString(charb); //type1
        System.out.println("charString: " + charString1);
        String charString2 = String.valueOf(charb); //type2; allow the all DateType to string..
        System.out.println("charString2: " + charString2);

    }
}
