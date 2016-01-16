package blackboard;

import general.Sentence;

import java.util.Comparator;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Sorter
 */
public class Sorter {

    public static void sortByDictionaryOrder(Blackboard blackboard) {
        List<Sentence> sentences = blackboard.getSortedSentences();
        sentences.add(blackboard.getShiftedSentence());
        oo.Sorter.sortByDictionaryOrder(sentences);
    }

}
