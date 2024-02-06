public class SetBitsCountSorterAdapter implements NumberSorter {
    SorterBySetBitsCount sorter;

    public SetBitsCountSorterAdapter (SorterBySetBitsCount sorter) {
        this.sorter = sorter;
    }

    @Override
    public void sort(Integer[] numbers) {
        String[] binNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            binNumbers[i] = Integer.toBinaryString(numbers[i]);
        }
        
        sorter.sortBySetBitsCount(binNumbers);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(binNumbers[i], 2);
        }
    }
}
