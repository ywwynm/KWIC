package blackboard;

import general.Sentence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Shifter
 */
public class Shifter {

    private int mShiftedTimes = 0;

    public Shifter() {}

    public boolean circularShift(Blackboard blackboard) {
        Sentence oriSentence = blackboard.getOriSentence();
        List<String> words = oriSentence.toWords();
        /*
            A sentence will produce sentences with same words but different orders.
            Those sentences' size is size of original sentence's words.
         */
        if (mShiftedTimes >= words.size()) {
            // end shifting
            mShiftedTimes = 0;
            return false;
        }

        words.add(words.remove(0));
        Sentence shiftedSentence = new Sentence(words);
        blackboard.setShiftedSentence(shiftedSentence);
        blackboard.setOriSentence(shiftedSentence);
        mShiftedTimes++;

        return true;
    }

}
