import java.util.Arrays;
import java.util.Collections;

public class NonIncreasingSorter implements NumberSorter {
	@Override
	public void sort(Integer[] numbers) {
		Arrays.sort(numbers, Collections.reverseOrder());
	}

}
