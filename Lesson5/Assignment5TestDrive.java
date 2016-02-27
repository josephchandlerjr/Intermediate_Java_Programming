

public class Assignment5TestDrive{
	public static void main(String[] args){
		Assignment5 a = new Assignment5();
		String[] words = {"Five", "Four", "Three", "Two", "One"};
		for(String word : words){
			System.out.printf("%s = %d\n", word, a.wordToNumber(word));
		}
		for(int i=1; i < 6; i++){
			System.out.printf("%d = %s\n", i, a.numberToWord(i));
		}
	}
}
