
public class Test {
    public static void main(String[] args) {
        FileSearchEngine fileSearchEngine = new FileSearchEngine("files");
        String[] subjects = fileSearchEngine.readSubjects();
        fileSearchEngine.arrangeSearches(subjects);
    }
}
