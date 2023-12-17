import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class ArrayList <T> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final double SIZE_FACTOR = 0.75;
	private static final double SIZE_INCREASE_FACTOR = 1.5;
	private T[] array;
	private int capacity;
	private int size;
	
	public ArrayList() {
		array = (T[])new Object[DEFAULT_CAPACITY];
		size = 0;
		capacity = DEFAULT_CAPACITY;
	}
	
	public void add(int index, T element) {
		if (acceptableSize()){
			addObjectToArray(index, element);
		} else {
			array = getIncreasedSizeArray();
			addObjectToArray(index, element);
		}
	}
	
	public void addAll(Collection<? extends T> collection) {
		for (T element : collection) {
			add(size, element);
		}
	}
	
	public void clear() {
		for (int i = 0; i < size; i++) {
			array[i] = null;
		}
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void remove(int index) {
		array[index] = null;
		for (int i = index; i < size; i++) {
			array[index] = array[index + 1];
		}
		size--;
	}
	
	public boolean remove(Object object) {
		if(contains(object)) {
			remove(indexOf(object));
			return true;
		} else
			return false;
	}
	
	public void sort(Comparator<? super T> c) {
		int low = 0;
		int high = size - 1;
		quickSort(array, low, high, c);
	}
	
	private void quickSort(T[] array, int low, int high, Comparator<? super T> c) {
	    if (array.length == 0 || low >= high) return;

	    int middle = low + (high - low) / 2;
	    T border = array[middle];

	    int i = low, j = high;
	    while (i <= j) {
	        while (c.compare(array[i],border) < 0) i++;
	        while (c.compare(array[j], border) > 0) j--;
	        if (i <= j) {
	            T swap = array[i];
	            array[i] = array[j];
	            array[j] = swap;
	            i++;
	            j--;
	        }
	    }

	    if (low < j) quickSort(array, low, j, c);
	    if (high > i) quickSort(array, i, high, c);
	}
	
	public int indexOf(Object object) {
		for (int i = 0; i < size; i++) {
			if(array[i] == object)
				return i;
		}
		return -1;
	}
	
	public boolean contains(Object object) {
		return indexOf(object) >= 0;
	}
	
	private void addObjectToArray(int index, T element) {
		array[index] = element;
		size++;
	}
	
	private T[] getIncreasedSizeArray() {
		capacity = (int) (capacity * SIZE_INCREASE_FACTOR + 1);
		T[] newArray = (T[])new Object[capacity];
		for (int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	private boolean acceptableSize() {
		return size < capacity * SIZE_FACTOR;
	}
	
	public int size() {
		return size;
	}
	

	@Override
	public String toString() {
		T[] filledArray = (T[]) (new Object[size]);
		for (int i = 0; i < size; i++) {
			filledArray[i] = array[i];
		}
		return Arrays.toString(filledArray);
	}
	
	
	
}
