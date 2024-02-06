package util;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {
	public static String getFileContents(String filePath) {
		try {
			return new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static List<String> getDirectoryFilesList(String dir) {
		List<String> files = new ArrayList<>();

		try {
			Files.walk(Paths.get(dir))
					.filter(Files::isRegularFile)
					.forEach(filePath -> files.add(filePath.toAbsolutePath().toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return files;
	}

}
