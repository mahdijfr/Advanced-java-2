import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileSearchEngine {
    String basePath;

    public FileSearchEngine(String basePath) {
        this.basePath = basePath;
    }

    public static String[] getFileNames(String[] subjects) {
        ArrayList<String> files = new ArrayList<>();
        for (String subject : subjects) {
            for (int i = 0; i < 3; i++) {
                files.add(subject + (i + 1) + ".txt");
            }
        }
        String[] fileArray = new String[files.size()];
        return files.toArray(fileArray);
    }

    public String[] readSubjects() {
        try {
            List<String> subs = Files.readAllLines(Paths.get(basePath + File.separator + "subjects.txt"),
                                                    StandardCharsets.UTF_8);
            return subs.toArray(new String[subs.size()]);
        } catch (IOException e) {
            return new String[0];
        }
    }

    public boolean arrangeSearches(String[] subjects) {
        String[] fileNames = getFileNames(subjects);
        Path resultPath = Paths.get(basePath + File.separator + "result.txt");

        try {
            Files.createFile(resultPath);
        } catch(IOException e) {
            return false;
        }

        for (String fileName : fileNames) {
            Path filePath = Paths.get(basePath + File.separator + fileName);

            if (Files.exists(filePath)) {
                try {
                    Files.writeString(resultPath,
                                    Files.readString(filePath).trim() + "\n",
                                    StandardOpenOption.APPEND);
                } catch (IOException e) {
                    return false;
                }
            }
        }
        return true;
    }
}
