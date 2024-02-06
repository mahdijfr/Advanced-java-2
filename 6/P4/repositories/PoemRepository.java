package repositories;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import model.Poem;

public class PoemRepository {
	private Map<String, Poem> poems = new HashMap<>();

	public PoemRepository() {
	}

	public PoemRepository(List<String> files) {
		this.addFiles(files);
	}

	public void addPoem(Poem poem) {
		poems.put(poem.getFilePath(), poem);
	}

	public void addPoems(List<Poem> poems) {
		for (Poem poem : poems) {
			this.addPoem(poem);
		}
	}

	public void addFiles(List<String> files) {
		for (String file : files) {
			this.addPoem(new Poem(file));
		}
	}

	public Map<String, Poem> getPoems() {
		Map<String, Poem> newPoems = new HashMap<>(poems);
		return newPoems;
		
	}

	public Map<String, Poem> search(String keyword) {
		return poems.entrySet().stream()
					.filter(poem -> poem.getValue().contains(keyword))
					.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}
}
