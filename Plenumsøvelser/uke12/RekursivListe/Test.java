import java.util.Random;

public class Test {

	Test() {
		RecursiveList<String> list = new RecursiveList<String>();

		String sentence = "Dette er en tilfeldig setning med mange ord.";
		String[] words = sentence.split(" ");

		Random r = new Random();

		for (String word : words) {
			if (r.nextBoolean()) {
				list.insert(word);
			} else {
				list.insertRecursive(word);
			}
		}

		// list.print();
		// list.printRecursive();

		// Test iterator:
		for (String s : list) {
			System.out.println(s);
		}
	}
}

/*
[emilyd@fingon RekursivListe]$ java Main
Setter inn: Dette
Setter inn rekursivt: er
Setter inn: en
Setter inn rekursivt: tilfeldig
Setter inn rekursivt: setning
Setter inn: med
Setter inn: mange
Setter inn: ord.
Dette
er
en
tilfeldig
setning
med
mange
ord.
*/

