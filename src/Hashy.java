
public class Hashy {
	int SIZE = 11;
	int HASH = 11;
	public Node[] bucketArray = new Node[SIZE];
	class Node {
		String key;
		Node next;
		
		public Node(String data) {
			this.key = data;
			next = null;
		}
	}
	
	// This method converts a word into it's ASCII value
	int convertToASCII(String data) {
		char[] word = data.toCharArray();
		int sum = 0;
		
		for(int i = 0; i < word.length; i++) {
			sum += word[i];
		}
		return sum/word.length;
	}
	
	// This method is used to store a word within our hash array
	void insert(String data) {
		Node newNode = new Node(data);
		int num = convertToASCII(newNode.key);
		newNode.next = bucketArray[(num % HASH)];
		bucketArray[num%HASH] = newNode;
	}
	
	// This method is used to find a word within our hash array
	boolean find(String lookup) {
		Node tempNode = new Node(lookup);
		int x = (convertToASCII(tempNode.key) % HASH);
		tempNode = bucketArray[x];
		
		if(bucketArray[x].key == lookup) {
			System.out.println("The word " + lookup + " was found at index " + x + "!");
			return true;
		}
		
		if(bucketArray[x].key != lookup && bucketArray[x].key != null) {
			while( tempNode != null) {
				if(tempNode.key.compareTo(lookup) < 0) {
					System.out.println("The word " + lookup + " was found at index " + x + "!");
					return true;
				}
				tempNode = tempNode.next;
			}
		}
		
		System.out.println("The word " + lookup + " was not found!");
		return false;
	}
	
	void display() {
		Node tempNode = new Node(null);
		for(int i = 0; i < SIZE; i ++) {
			tempNode = bucketArray[i];
			System.out.print("Index "+ i + ": ");
			while(tempNode != null) {
				System.out.print(tempNode.key + " ");
				tempNode = tempNode.next;
			}
			System.out.println();
		}
	}
}
