package int_Pkg;

public interface Int1 {
	int a = 5;
	int b = 4;
	default public int sum() {
		return a + b;
	}
}
