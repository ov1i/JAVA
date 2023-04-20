package int_Pkg;

public interface Int2 {
	double a = 4.3;
	double b = 3.4;
	default double product() {
		return a * b;
	}
}
