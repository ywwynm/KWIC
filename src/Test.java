import blackboard.KWICSolutionBlackboard;
import oo.KWICSolutionOOStyle;

/**
 * Created by 张启 on 2016/1/15.
 * Test
 */
public class Test {

    public static void main(String... args) {
//        KWICSolutionOOStyle KWICSolutionOOStyle =
//                new KWICSolutionOOStyle.Builder()
//                        .setInOutType(oo.KWICSolutionOOStyle.KEYBOARD)
//                        .setDeleteWordsStrategy(
//                                oo.KWICSolutionOOStyle.DONT_DELETE_WORDS)
//                        .build();
//        KWICSolutionOOStyle.solveKWIC();

        KWICSolutionBlackboard KWICSolutionBlackboard
                = new KWICSolutionBlackboard("input.txt", "output.txt");
        KWICSolutionBlackboard.setWordsToDelete("a", "the", "this", "that");
        KWICSolutionBlackboard.solveKWIC();
    }

}
