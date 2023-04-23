package imageProcessor;

class Pixels {
	private int R,G,B;  
	public Pixels() {
		R = 0;
		G = 0;
		B = 0;
	}
	public Pixels(int R, int G, int B) {
		this.R = R;
		this.G = G;
		this.B = B;
	}
	public int getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public int getB() {
		return B;
	}
	public void setB(int b) {
		B = b;
	}
}

public class MyImage {
	private int m,n;
	 private Pixels[][] matrix;
	 public MyImage() {
		 this.matrix = null;
		 this.m = 0;
		 this.n = 0;
	 }
	 public MyImage(int m, int n) {
		 this.m = m;
		 this.n = n;
		 matrix = new Pixels[this.m][this.n];
		 
		 for(int i = 0;i < matrix.length;i ++) {
			 for(int j = 0; j < matrix[i].length;j++) {
				 matrix[i][j] = new Pixels();
			 }
		 }
	 }
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void setElement(int arr[], int i, int j) {
		matrix[i][j].setR(arr[0]);
		matrix[i][j].setG(arr[1]);
		matrix[i][j].setB(arr[2]);
	}
	public Pixels getElement(int i, int j) {
		return matrix[i][j];
	}
	public void genMatrix() {
		matrix = new Pixels[m][n];
		for(int i = 0;i < matrix.length;i ++) {
			 for(int j = 0; j < matrix[i].length;j++) {
				 matrix[i][j] = new Pixels();
			 }
		 }
	}
	public void checkPixels(int R, int G, int B) {
		long start = System.nanoTime();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				if(matrix[i][j].getR() < R && matrix[i][j].getG() < G && matrix[i][j].getB() < B) {
					matrix[i][j].setR(0);
					matrix[i][j].setG(0);
					matrix[i][j].setB(0);
				}
			}
		}
		long end = System.nanoTime();
		
		System.out.println("New Image Matrix( ->Smaller than:  [" + R + "," + G + "," + B + "]): ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void canceledPixel(String val) {
		long start = System.nanoTime();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				if(val.toUpperCase().equals("R")) {
					matrix[i][j].setR(0);			
				}
				else if(val.toUpperCase().equals("G")) {
					matrix[i][j].setG(0);
				}
				else if(val.toUpperCase().equals("B")) {
					matrix[i][j].setB(0);
				}
			}
		}
		long end = System.nanoTime();
		
		System.out.println("New Image Matrix(Canceled channel " + val.toUpperCase() +"): ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void grayScaleTransform() {
		long start = System.nanoTime();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				int gScale = (int) (0.21 * matrix[i][j].getR() + 0.71 * matrix[i][j].getG() + 0.07 * matrix[i][j].getB());
 				matrix[i][j].setR(gScale);
				matrix[i][j].setG(gScale);
				matrix[i][j].setB(gScale);
			}
		}
		long end = System.nanoTime();
		
		System.out.println("GrayScale Image Matrix: ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void deletedImage() {
		long start = System.nanoTime();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
					matrix[i][j].setR(0);
					matrix[i][j].setG(0);
					matrix[i][j].setB(0);
				}
			}
		
		long end = System.nanoTime();
		
		System.out.println("Deleted Image Matrix: ");
		printImage();
		System.out.println("Duration: " + ((double)(end-start)/10000) + " ms");
	}
	public void printImage() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length;j++) {
				System.out.print("[" + String.format("%03d", matrix[i][j].getR()) +  "," + String.format("%03d", matrix[i][j].getG()) + "," + String.format("%03d", matrix[i][j].getB()) + "]	");
			}
			System.out.println();
		}
	}
}
