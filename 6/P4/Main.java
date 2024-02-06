import repositories.PoemRepository;
import util.FileUtils;

public class Main {
	public static void main(String[] args) {
		PoemRepository repo = new PoemRepository(
				FileUtils.getDirectoryFilesList("/home/nima"));
		for (String filePath : repo.search("zemestan").keySet()) {
			System.out.println(filePath);
		}
	}
}
