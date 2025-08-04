public class Main {
	public static void main(String[] args) {
		System.out.println("Hello, World!");

		for (int i = 1; i <= 5; i++) {
			System.out.println("Current value: " + i);
		}
	}

	public int add(int a, int b) {
		// added comment
		return a + b;
	}

	// A method that simulates longer processing to help reproduce background test runs
	public int slowDouble(int n) {
		try {
			Thread.sleep(500L); // simulate work
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return n * 2;
	}
}