package fr.lacombe.tdd2;


import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.round;

public class ClassicTDD2 {

    public double[] statsCalculator(int[] values) {
        if (values == null || values.length == 0) {
            return new double[0];
        }
        DecimalFormat df = new DecimalFormat("0.00");
        var stats = new double[4];
        int max = values[0];
        int min = values[0];
        double sum = 0f;

        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
            if (values[i] < min) {
                min = values[i];
            }
            sum += values[i];
        }
        stats[0] = max;
        stats[1] = min;
        stats[2] = values.length;
        stats[3] = Math.floor(sum / ((double) values.length) * 100) / 100;
        return stats;
    }


    public HashSet<String> generateAllAnagrams(String word){
        if( word == null || word.isBlank()){
            return new HashSet<>();
        }
        var generatedAnagrams = new HashSet<String>();
        generateAnagramsTree(Arrays.asList(word.split("")), generatedAnagrams, "");
        return generatedAnagrams;
    }


    private void generateAnagramsTree(List<String> lettersList, HashSet<String> res, String currentAnagram){
        if(lettersList.isEmpty()){
            res.add(currentAnagram);
            return;
        }
        for (String s : lettersList) {
            generateAnagramsTree(lettersList.stream().filter(l->!l.equals(s)).toList(), res, currentAnagram+s);
        }
    }

}
