package fr.lacombe.tdd2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


}