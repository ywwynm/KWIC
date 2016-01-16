package blackboard;

import general.Sentence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Blackboard
 */
public class Blackboard {

    private static Blackboard sBlackboard;

    // 单例模式，只有一个黑板
    public static Blackboard getInstance() {
        if (sBlackboard == null) {
            synchronized (Blackboard.class) {
                if (sBlackboard == null) {
                    sBlackboard = new Blackboard();
                }
            }
        }
        return sBlackboard;
    }

    // original sentence
    private Sentence mOriSentence;

    // shifted sentence
    private Sentence mShiftedSentence;

    // sorted sentence. Will not be sorted all the time but at last it will.
    private List<Sentence> mSortedSentences;

    private Blackboard() {
        mSortedSentences = new ArrayList<>();
    }

    public Sentence getOriSentence() {
        return mOriSentence;
    }

    public void setOriSentence(Sentence oriSentence) {
        mOriSentence = oriSentence;
    }

    public Sentence getShiftedSentence() {
        return mShiftedSentence;
    }

    public void setShiftedSentence(Sentence shiftedSentence) {
        mShiftedSentence = shiftedSentence;
    }

    public List<Sentence> getSortedSentences() {
        return mSortedSentences;
    }
}
