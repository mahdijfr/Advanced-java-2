
public class SorterBySetBitsCount {
	public void sortBySetBitsCount(String[] binaryNumbers) {
		int maxBitCount = 32;
		int[] indexMap = new int[maxBitCount + 1];
		String[][] map = new String[maxBitCount + 1][binaryNumbers.length];
		for (String binaryNumber : binaryNumbers) {
			int count = this.setBitsCount(binaryNumber);
			map[count][indexMap[count]++] = binaryNumber;
		}
		int index = 0;
		for (int i = 0; i < maxBitCount; i++) {
			for (int j = 0; j < indexMap[i]; j++) {
				binaryNumbers[index++] = map[i][j];
			}
		}
	}

	private int setBitsCount(String binaryNumber) {
		int count = 0;
		for (int i = 0; i < binaryNumber.length(); i++) {
			if (binaryNumber.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
}
