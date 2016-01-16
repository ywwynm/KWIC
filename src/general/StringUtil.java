package general;

/**
 * Created by 张启 on 2016/1/15.
 * String utils
 */
public class StringUtil {

    public static String deleteWord(String src, String word) {
        String ret = src;
        // if the first word should be deleted, delete it.
        ret = ret.replaceFirst(word + " ", "");
        ret = ret.replaceAll(" " + word + " ", " ");

        int lastSpace = src.lastIndexOf(" ");
        if (lastSpace != -1) {
            String lastWord = src.substring(lastSpace + 1, src.length());
            // if the last word should be deleted, delete it.
            if (word.equals(lastWord)) {
                ret = ret.substring(0, lastSpace);
            }
        }
        return ret;
    }
}
