package blackboard;

/**
 * Created by 张启 on 2016/1/15.
 * controller
 */
public class KWICSolutionBlackboard {

    public static final int FILE = 0;
    public static final int KEYBOARD = 1;

    private int mInOutType = KEYBOARD;

    private Blackboard mBlackboard;

    private Input mInput;
    private Output mOutput;
    private Shifter mShifter;

    private String[] mWordsToDelete;

    public KWICSolutionBlackboard() {
        mInput = new Input();
        mOutput = new Output();
        init();
    }

    public KWICSolutionBlackboard(String inputFileName, String outputFileName) {
        mInput = new Input(inputFileName);
        mOutput = new Output(outputFileName);
        mInOutType = FILE;
        init();
    }

    private void init() {
        mBlackboard = Blackboard.getInstance();
        mShifter = new Shifter();
    }

    public void setWordsToDelete(String... wordsToDelete) {
        mWordsToDelete = wordsToDelete;
    }

    public void solveKWIC() {
        if (mInOutType == FILE) {
            while (mInput.input(mBlackboard)) {
                if (mWordsToDelete != null) {
                    mBlackboard.getOriSentence().deleteWords(mWordsToDelete);
                }
                while (mShifter.circularShift(mBlackboard)) {
                    Sorter.sortByDictionaryOrder(mBlackboard);
                }
            }
            mOutput.output(mBlackboard);
            System.out.println("Finished! Please check the output file.");
        } else if (mInOutType == KEYBOARD) {
            while (mInput.input(mBlackboard)) {
                if (mWordsToDelete != null) {
                    mBlackboard.getOriSentence().deleteWords(mWordsToDelete);
                }
                while (mShifter.circularShift(mBlackboard)) {
                    Sorter.sortByDictionaryOrder(mBlackboard);
                }
                mOutput.output(mBlackboard);
            }
        }
    }

}
