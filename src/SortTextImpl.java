import java.util.Arrays;
import java.util.Collections;

public class SortTextImpl extends SortText {

	@Override
	void sortText(String[] txt, boolean descending) {
		// TODO Auto-generated method stub
		if (descending) {
			Arrays.sort(txt, Collections.reverseOrder());
			System.out.println(Arrays.toString(txt));
		} else {
			Arrays.sort(txt);
			System.out.println(Arrays.toString(txt));
		}

	}

	@Override
	String[] stringToArray(String str) {
		// TODO Auto-generated method stub
		String[] result = str.split("\\r?\\n");
		return result;
	}

	@Override
	String arrayToString(String[] array) {
		// TODO Auto-generated method stub
		String str = String.join("\n", array);
		return str;
	}

}
