
public class SkyView {
	private double[][] view;
	
	public SkyView(int numRows, int numCols, double[] scanned) {
		int counter = 0;
		view = new double[numRows][numCols];
		boolean lhtorh = true;
		for (int i = 0; i < numRows; i++) {
			if (lhtorh) {
				for (int j = 0; j < numCols; j++) {
					view[i][j] = scanned[counter];
					counter++;
				}
				lhtorh = false;
			} else {
				for (int j = numCols - 1; j > - 1; j--) {
					view[i][j] = scanned[counter];
					counter++;
				}
				lhtorh = true;
			}
		}
	}
	
	public double getAverage(int startRow, int endRow, int startCol, int endCol) {
		double total = 0;
		int counter = 0;
		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= startCol; j++) {
				total += view[i][j];
				counter++;
			}
		}
		return total / counter;
	}
	
	public void ArrayPrinter() {
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[0].length; j++) {
				System.out.print(view[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] scanned = new double[] {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.1, 1.6, 0.6, 0.9,};
		SkyView arr = new SkyView(4,3,scanned);
		arr.ArrayPrinter();
	}

}
