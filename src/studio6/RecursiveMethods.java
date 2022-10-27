package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			if (n == 0) {
				return 0;
			}
			else {
				return 1.0 / (Math.pow(2, n)) + geometricSum(n-1);
			}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
			
			if (p % q == 0) {
				return q;
			} 
			else {
				return gcd(q, p%q);
			}
			
			}
			
	
	
	/**
	* Helper for reversed
	* 
	*/
	public static int[] yooo(int[] array, int i, int[] reversed) {
			if (i < array.length-1 / 2) {
				int temp = array[i];
				reversed[i] = array[array.length - i - 1];
				reversed[array.length - i - 1] = temp;
				
				return yooo(array, i + 1, reversed);
			}
			else {
				return reversed;
			}
	}
	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
			int[] empty = new int[0];
			
			int[] reversed = new int[array.length];
			if ( array.length == 1) {
				int[] newOne = new int[1]; newOne[0] = array[0];
				return newOne;
			}
			else if (array.length == 0) {
				return empty;
			}
			else {
				return yooo(array, 0, reversed);
			}
			
		
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
			double bound = 5.0;
			StdDraw.setXscale(-bound, bound);
			StdDraw.setYscale(-bound, bound);
			StdDraw.enableDoubleBuffering();
			if (radius > radiusMinimumDrawingThreshold) {
				StdDraw.circle(xCenter, yCenter, radius);
				circlesUponCircles(xCenter + radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
				circlesUponCircles(xCenter - radius, yCenter, radius / 3.0, radiusMinimumDrawingThreshold);
				circlesUponCircles(xCenter, yCenter + radius, radius / 3.0, radiusMinimumDrawingThreshold);
				circlesUponCircles(xCenter, yCenter - radius, radius / 3.0, radiusMinimumDrawingThreshold);
			}
	}

}
