package fr.lacombe.tdd2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTDD3Test {

    private static HashMap<Integer, String> numbersMapping;

    @BeforeAll
    static void init_arabic_numbers_to_roman_numbers_mapping(){
        numbersMapping = new HashMap<>();
        numbersMapping.put(1,"I");
        numbersMapping.put(2,"II");
        numbersMapping.put(3,"III");
        numbersMapping.put(4,"IV");
        numbersMapping.put(5,"V");
        numbersMapping.put(6,"VI");
        numbersMapping.put(7,"VII");
        numbersMapping.put(8,"VIII");
        numbersMapping.put(9,"IX");
        numbersMapping.put(10,"X");
        numbersMapping.put(20,"XX");
        numbersMapping.put(30,"XXX");
        numbersMapping.put(40,"XL");
        numbersMapping.put(50,"L");
        numbersMapping.put(60,"LX");
        numbersMapping.put(70,"LXX");
        numbersMapping.put(80,"LXXX");
        numbersMapping.put(90,"XC");
        numbersMapping.put(100,"C");
        numbersMapping.put(200,"CC");
        numbersMapping.put(300,"CCC");
        numbersMapping.put(400,"CD");
        numbersMapping.put(500,"D");
        numbersMapping.put(600,"DC");
        numbersMapping.put(700,"DCC");
        numbersMapping.put(800,"DCCC");
        numbersMapping.put(900,"CM");
        numbersMapping.put(1000,"M");
    }

    @Test
    void given_numbers_mapping_when_converting_negative_number_then_error_is_raised() {
        var numberConverter = new ClassicTDD3(numbersMapping);
        assertThrows(IllegalArgumentException.class,  ()->numberConverter.arabicNumbersToRomanNumbers(-35));
    }


    @Test
    void given_number_mapping_when_converting_positive_integer_then_roman_string_is_returned(){
        var numberConverter = new ClassicTDD3(numbersMapping);


        assertEquals("XLII",numberConverter.arabicNumbersToRomanNumbers(42));
        assertEquals("DCCCXLVI",numberConverter.arabicNumbersToRomanNumbers(846));
        assertEquals("MCMXCIX",numberConverter.arabicNumbersToRomanNumbers(1999));
        assertEquals("MVIII",numberConverter.arabicNumbersToRomanNumbers(1008));
    }
}