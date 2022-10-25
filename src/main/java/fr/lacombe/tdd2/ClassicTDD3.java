package fr.lacombe.tdd2;

import java.util.HashMap;

public class ClassicTDD3 {

    private final HashMap<Integer, String> arabicToRomanMapping;

    ClassicTDD3(HashMap<Integer, String> arabicToRomanMapping){
        this.arabicToRomanMapping = arabicToRomanMapping;
    }


    public String arabicNumbersToRomanNumbers(int number){
        if(number <= 0) {
            throw new IllegalArgumentException("number to convert must be positive");
        }
        var resBuilder = new StringBuilder();
        int hundreds = (number / 100 % 10)*100;
        int tens = (number / 10 % 10)*10 ;
        int ones = number % 10;

        if(number >= 1000){
            resBuilder.append(romanNumber(number / 1000 * 1000));
        }
        if(number >= 100 && hundreds != 0){
            if(hundreds != 0){
                resBuilder.append(romanNumber(hundreds ));
            }
        }
        if(number>=10 && tens != 0){
            resBuilder.append(romanNumber(tens));
        }
        if(ones != 0){
            resBuilder.append(romanNumber(ones));
        }
        return resBuilder.toString();
    }

    private String romanNumber( int number){
        String romanNumber = arabicToRomanMapping.get(number);
        if(romanNumber == null){
            throw new IllegalStateException("Number missing from mapping");
        }
        return romanNumber;
    }

}
