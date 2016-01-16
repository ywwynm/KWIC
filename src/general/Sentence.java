package general;

import general.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Sentence
 */
public class Sentence {

    private String mSentence;

    public Sentence(String sentence) {
        mSentence = sentence;
    }

    public Sentence(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }
        mSentence = sb.substring(0, sb.length() - 1);
    }

    /**
     * Step 2
     *
     * delete some words in original sentence.
     * @param words words to delete.
     */
    public void deleteWords(String... words) {
        for (String word : words) {
            mSentence = StringUtil.deleteWord(mSentence, word);
        }
    }

    public void setSentence(String sentence) {
        mSentence = sentence;
    }

    public ArrayList<String> toWords() {
        return new ArrayList<>(Arrays.asList(mSentence.split(" ")));
    }

    @Override
    public String toString() {
        return mSentence;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sentence)) {
            return false;
        }
        Sentence sentence = (Sentence) obj;
        return mSentence.equals(sentence.mSentence);
    }
}
