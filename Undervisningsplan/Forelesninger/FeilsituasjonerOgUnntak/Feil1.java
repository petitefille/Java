class Feil1 {
	int i;
	public static void main(String [] args) {
		new Feil1().a(null);
	}
	
	void a(Feil1 pek) {
		if (pek == null) {
			throw new NullPointerException("pek maa vaere != null");
		}
		pek.i = 14;
	}
}

/*[emilyd@vor FeilsituasjonerOgUnntak]$ java Feil1
Exception in thread "main" java.lang.NullPointerException: pek maa vaere != null
        at Feil1.a(Feil1.java:9)
        at Feil1.main(Feil1.java:4)
*/