package blackboard;

import general.Sentence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 张启 on 2016/1/15.
 * Input
 */
public class Input {

    private String mFileName;
    private BufferedReader mBufferedReader;

    private Scanner mScanner;

    public Input() {
        mScanner = new Scanner(System.in);
    }

    public Input(String fileName) {
        mFileName = fileName;
        try {
            FileReader fr = new FileReader(fileName);
            mBufferedReader = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean input(Blackboard blackboard) {
        if (mFileName != null) {
            return inputFromFile(blackboard);
        } else {
            return inputFromKeyboard(blackboard);
        }
    }

    private boolean inputFromFile(Blackboard blackboard) {
        try {
            String sentence = mBufferedReader.readLine();
            if (sentence != null ){
                blackboard.setOriSentence(new Sentence(sentence));
            } else {
                mBufferedReader.close();
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean inputFromKeyboard(Blackboard blackboard) {
        blackboard.setOriSentence(new Sentence(mScanner.nextLine()));
        return true;
    }

}
