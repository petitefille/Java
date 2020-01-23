class MyClass<T> {
	String s;
	T t;
	
	MyClass() {
		s = "I am a string";
	}

	public void myMethod(int i, T t) {
		System.out.println(i);
		System.out.println(t);
	}
}

