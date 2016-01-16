package oo;

import general.Sentence;

import java.util.Comparator;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Sorter
 */
public class Sorter {

    public static void sortByDictionaryOrder(List<Sentence> sentences) {
        sentences.sort(new Comparator<Sentence>() {
            @Override
            public int compare(Sentence s1, Sentence s2) {
                return s1.toString().compareTo(s2.toString());
            }
        });
    }

}
