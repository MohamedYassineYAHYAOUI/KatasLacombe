package fr.lacombe.tdd2;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassicTDD2Test {

    @Test
    void should_return_correct_values() {
        var statsCalculator = new ClassicTDD2();
        var stats = statsCalculator.statsCalculator(new int[]{5,6,-3,8,-10});
        assertEquals(4,stats.length);
        assertEquals(8, stats[0]);
        assertEquals(-10, stats[1]);
        assertEquals(5, stats[2]);
        assertEquals(1.2, stats[3]);
    }

    @Test
    void should_return_correct_values2() {
        var statsCalculator = new ClassicTDD2();
        var stats = statsCalculator.statsCalculator(new int[]{6,9,15,-2, 92, 11});
        assertEquals(4,stats.length);
        assertEquals(92, stats[0]);
        assertEquals(-2, stats[1]);
        assertEquals(6, stats[2]);
        assertEquals(21.83, stats[3]);
    }


    @Test
    void given_null_array_should_return_empty_array(){
        var statsCalculator = new ClassicTDD2();
        var stats1 = statsCalculator.statsCalculator(null);
        assertEquals(0, stats1.length);
    }


    @Test
    void given_null_or_blank_should_return_empty_set() {
        var tdd = new ClassicTDD2();

        var set1 = tdd.generateAllAnagrams(null);
        var set2 = tdd.generateAllAnagrams("   ");

        assertEquals(new HashSet<String>(), set1);
        assertEquals(new HashSet<String>(), set2);
    }

    @Test
    void given_word_should_return_all_anagrams(){
        var tdd = new ClassicTDD2();
        var res = tdd.generateAllAnagrams("biro");

        var anagrams = new HashSet<String>();
        anagrams.addAll(List.of("biro","bior","brio","broi","boir","bori","ibro","ibor","irbo","irob","iobr",
                "iorb","rbio","rboi","ribo","riob","roib","robi","obir","obri","oibr", "oirb","orbi", "orib"));

        assertTrue(()->{
            if(res.size() != anagrams.size()){
                return false;
            }
            for (String anagram : anagrams) {
                if(!res.contains(anagram)){
                    return false;
                }
            }
            return true;
        });
    }

    @Test
    void given_word_should_return_all_anagrams2(){
        var tdd = new ClassicTDD2();
        var res = tdd.generateAllAnagrams("tio");
        var anagrams = new HashSet<String>();
        anagrams.addAll(List.of("tio", "toi","ito","iot","oti", "oit"));
        assertTrue(()->{
            if(res.size() != anagrams.size()){
                return false;
            }
            for (String anagram : anagrams) {
                if(!res.contains(anagram)){
                    return false;
                }
            }
            return true;
        });
    }
}