package oo;

import general.Sentence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Shifter
 */
public class Shifter {

    private List<Sentence> mSentences;

    public Shifter(List<Sentence> sentences) {
        mSentences = sentences;
    }

    public List<Sentence> circularShift() {
        List<Sentence> shiftedSentences = new ArrayList<>();
        for (Sentence sentence : mSentences) {
            shiftedSentences.add(sentence);
            List<String> words = sentence.toWords();
            for (int i = 0; i < words.size() - 1; i++) {
                // remove first element and add it to the end of the list.
                words.add(words.remove(0));
                shiftedSentences.add(new Sentence(words));
            }
        }
        return shiftedSentences;
    }

}
