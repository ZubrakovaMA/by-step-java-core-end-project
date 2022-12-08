package by.step.java.core.end.project.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class FileDAO {

    public abstract List readFile();

    public boolean saveFile (List<String> file, String filename) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\" + filename + ".txt"));
            for (String str1 : file
            ) {
                bufferedWriter.write(str1);
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }
}