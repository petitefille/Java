class BankTeller {
	private static int saldo = 100;

	public static void main(String[] args) throws InterruptedException {
		int tellerAntall = 3;
		Thread[] tellere = new Thread[tellerAntall];

		// Lager traadene
		for (int k=0; k<tellerAntall; k++) {
			tellere[k] = new Thread( new BankTraad());
		}
		// Starter traadene
		for (int k=0; k<tellerAntall; k++) {
			tellere[k].start();
		}
		for ( Thread t : tellere ) {
			t.join();
		}
		System.out.println( saldo );
	} // main slutt

	// Banktellere skal sette inn penger paa saldoen
	private static class BankTraad implements Runnable {
		public void run() {
			int lokalSaldo = saldo;
			lokalSaldo += 20;
			saldo = lokalSaldo;
		}
	}
}
