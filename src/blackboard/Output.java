package blackboard;

import general.FileUtil;
import general.Sentence;

import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * Output
 */
public class Output {

    private String mFileName;

    public Output() {

    }

    public Output(String fileName) {
        mFileName = fileName;
    }

    public void output(Blackboard blackboard) {
        List<Sentence> sentences = blackboard.getSortedSentences();
        if (mFileName != null) {
            FileUtil.writeToFile(mFileName, sentences);
        } else {
            sentences.forEach(System.out::println);
        }
    }

}
