import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		
		String[] arr = {"8", "2", "11", "4", "5", "6", "22", "7", "9"};
		ArrayList<String> array = new ArrayList<>();
		
		array.addAll(Arrays.asList(arr));
		array.sort(Comparator.naturalOrder());
		
		System.out.println(array);

	}
}
