import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		NumberSorter sorter = new SetBitsCountSorterAdapter(
				new SorterBySetBitsCount());
		Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		sorter.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
