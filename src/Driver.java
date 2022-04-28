import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Hashy newHash = new Hashy();
		File file = new File("text.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			String word = sc.next();
			newHash.insert(word);
		}
		
		newHash.find("dad");
		newHash.find("jet");
		newHash.find("car");
		newHash.find("Speed");
		newHash.find("Hack");
		
		newHash.insert("Speed");
		newHash.find("Speed");
		
		System.out.println();
		
		newHash.display();
	}

}
