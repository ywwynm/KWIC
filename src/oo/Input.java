package oo;

import general.Sentence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 张启 on 2016/1/15.
 * Input
 */
public class Input {

    private String mFileName;
    private List<Sentence> mInputSentences;

    public Input() {
        mInputSentences = new ArrayList<>();
    }

    public Input(String fileName) {
        mFileName = fileName;
    }

    public List<Sentence> input() {
        if (mFileName != null) {
            return inputFromFile();
        } else if (mInputSentences != null) {
            return inputFromKeyboard();
        } else return null;
    }

    private List<Sentence> inputFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        mInputSentences.add(new Sentence(sentence));
        return mInputSentences;
    }

    private List<Sentence> inputFromFile() {
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(mFileName);
            br = new BufferedReader(fr);
            List<Sentence> sentences = new ArrayList<>();
            while (br.ready()) {
                sentences.add(new Sentence(br.readLine()));
            }
            return sentences;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
