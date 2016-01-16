package oo;

import general.Sentence;

import java.io.*;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * OO-style KWIC solution
 */
public class KWICSolutionOOStyle extends AbstractKWICSolution {

    /**
     * 建造者模式
     */
    public static class Builder {

        private KWICSolutionOOStyle mSolution = new KWICSolutionOOStyle();

        public Builder setInOutType(int inOutType) {
            mSolution.mInOutType = inOutType;
            if (inOutType == KEYBOARD) {
                mSolution.mInput = new Input();
                mSolution.mOutput = new Output();
            }
            return this;
        }

        public Builder setDeleteWordsStrategy(int deleteWordsStrategy) {
            if (deleteWordsStrategy == READ_CONFIGURATION) {
                BufferedReader br = null;
                try {
                    FileReader fr = new FileReader("conf.ini");
                    br = new BufferedReader(fr);
                    // br.read() will return a char value.
                    int strategy = br.read() - 48;
                    if (strategy == DELETE_WORDS || strategy == DONT_DELETE_WORDS) {
                        mSolution.mDeleteWordStrategy = strategy;
                    } else mSolution.mDeleteWordStrategy = DONT_DELETE_WORDS;
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                mSolution.mDeleteWordStrategy = deleteWordsStrategy;
            }
            return this;
        }

        public Builder serWordsToDelete(String... words) {
            mSolution.mWordsToDelete = words;
            return this;
        }

        public Builder setInputFileName(String fileName) {
            if (mSolution.mInOutType == FILE) {
                mSolution.mInput = new Input(fileName);
            }
            return this;
        }

        public Builder setOutputFileName(String fileName) {
            if (mSolution.mInOutType == FILE) {
                mSolution.mOutput = new Output(fileName);
            }
            return this;
        }

        public KWICSolutionOOStyle build() throws IllegalStateException {
            if (mSolution.mInOutType == FILE &&
                    (mSolution.mInput == null || mSolution.mOutput == null)) {
                throw new IllegalStateException(
                        "Type is file but you didn't provide " +
                                "input filename or output filename");
            }
            return mSolution;
        }
    }

    public static final int FILE = 0;
    public static final int KEYBOARD = 1;

    public static final int DONT_DELETE_WORDS = 0;
    public static final int DELETE_WORDS = 1;
    public static final int READ_CONFIGURATION = 2;

    private int mInOutType = -1;

    private Input mInput;
    private Output mOutput;

    private int mDeleteWordStrategy = DONT_DELETE_WORDS;
    private String[] mWordsToDelete;

    @Override
    protected List<Sentence> input() {
        if (mInput != null) {
            return mInput.input();
        } else return null;
    }

    @Override
    protected List<Sentence> prepare(List<Sentence> sentences) {
        if (sentences == null) {
            return null;
        }
        if (mDeleteWordStrategy == DELETE_WORDS && mWordsToDelete != null) {
            for (Sentence sentence : sentences) {
                sentence.deleteWords(mWordsToDelete);
            }
        }
        return sentences;
    }

    @Override
    protected List<Sentence> shift(List<Sentence> sentences) {
        Shifter shifter = new Shifter(sentences);
        return shifter.circularShift();
    }

    @Override
    protected void sort(List<Sentence> sentences) {
        Sorter.sortByDictionaryOrder(sentences);
    }

    @Override
    protected void output(List<Sentence> sentences) {
        mOutput.output(sentences);
        if (mInOutType == KEYBOARD) {
            // execute again and again.
            solveKWIC();
        } else {
            System.out.println("Finished! Please check the output file.");
        }
    }
}
