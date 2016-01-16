package general;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by 张启 on 2016/1/15.
 * File utils
 */
public class FileUtil {

    public static boolean writeToFile(String fileName, List<Sentence> sentences) {
        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            final int size = sentences.size();
            for (int i = 0; i < size; i++) {
                bw.write(sentences.get(i).toString());
                if (i != size - 1) {
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
