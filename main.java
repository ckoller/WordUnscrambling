import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class main {
	static File f = new File("C:/Users/koller/workspace/WordUnscrambling/src/wordlist.txt");
	static File e = new File("C:/Users/koller/workspace/WordUnscrambling/src/input.txt");
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> inputlist = new ArrayList<String>();
	static ArrayList<String> permutatedInput = new ArrayList<String>();

	static Set<String> result = new LinkedHashSet<String>(list);

	public static void main(String args[]) throws FileNotFoundException{
		Scanner s = new Scanner(f);
		while (s.hasNext()){
			list.add(s.next());
		}
		s.close();
		Scanner y = new Scanner(e);
		while (y.hasNext()){
			inputlist.add(y.next());
		}
		y.close();	
		//create all posible combination from inputlist and put it in the list permutatedInput
		for (int i=0; i<inputlist.size(); i++){
			String tempinput = inputlist.get(i);
			permuteString("", tempinput);
		}
		for (int i=0; i<permutatedInput.size(); i++){
			String tempinput = permutatedInput.get(i);
			for (int k=0; k<list.size(); k++) {
				String temp = list.get(k);
				if(tempinput.equals(temp)){
					result.add(temp);
				}
			}
		}
		System.out.println("result: " + result);
	}
	//method that create all possible combinations from a word
	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1)
			permutatedInput.add(beginningString + endingString);
		for (int i = 0; i < endingString.length(); i++) {
			try {
				String newString = endingString.substring(0, i) + endingString.substring(i + 1);

				permuteString(beginningString + endingString.charAt(i), newString);
			} catch (StringIndexOutOfBoundsException exception) {
				exception.printStackTrace();
			}
		}
	}
}