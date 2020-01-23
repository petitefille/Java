import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Oppgave5 {
	public static void main(String[] args) {
		new Oppgave();
	}
}

class Oppgave {

	private CountDownLatch barrier;

	Oppgave() {
		// Testdata
		Random r = new Random();
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		final int NUM = 64003;
		String[] values = new String[NUM];
		for (int i = 0; i < NUM; i++) {
			String word = "";
			for (int j = 0; j < 4; j++) {
				word += letters[r.nextInt(26)];
			}
			values[i] = word;
		}

		barrier = new CountDownLatch(1);

		// Oppgave b
		Monitor m = new Monitor(barrier);
		int start = 0;
		int per = values.length / 32;
		int stop = per;
		for (int i = 0; i < 32; i++) {
			new SortThread(values, start, stop, m).start();
			start = stop;
			stop = stop + per;
			if (i == 30) {
				stop = values.length - 1;
			}
		}

		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (String word : values) {
			System.out.println(word);
		}
	}

	// Oppgave b
	class SortThread extends Thread {
		private String[] values;
		private int start;
		private int stop;
		private Monitor m;

		public SortThread(String[] values, int start, int stopp, Monitor m) {
			this.values = values;
			this.start = start;
			this.stop = stopp;
			this.m = m;
		}

		public void run() {
			sort(values, start, stop, m);
		}
	}

	// Oppgave a
	public void sort(String[] a, int fom, int tom, Monitor m) {
		boolean changed;

		while (barrier.getCount() == 1) {
			for (int i = fom; i < tom; i++) {
				changed = false;
				for (int j = fom; j < tom; j++) {
					if (a[j].compareTo(a[j + 1]) > 0) {
						if (j == fom || j == tom - 1) {
							m.change(a, j, j + 1);
						} else {
							String tmp = a[j];
							a[j] = a[j + 1];
							a[j + 1] = tmp;
						}
						changed = true;
					}
				}
				if (!changed) {
					m.waitForData();
				}
			}
		}
	}
}

class Monitor {
	private int counter = 0;
	private CountDownLatch barrier;
	
	Monitor(CountDownLatch barrier) {
		this.barrier = barrier;
	}

	public synchronized void waitForData() {
		try {
			counter++;
			if (counter == 32) {
				barrier.countDown();
			}
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Oppgave c
	public synchronized void change(String[] a, int i, int j) {
		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		counter = 0;
		notifyAll();
	}

	public synchronized int getCounter() {
		return counter;
	}
}
