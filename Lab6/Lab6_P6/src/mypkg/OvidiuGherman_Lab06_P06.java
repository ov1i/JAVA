package mypkg;

import java.util.Random;

/* 6. 
 * Write a Java application which implements an exception called OverSaturated. This exception is generated when the
 * saturation of a color has a value over 90 in the HSV color space. Write a method which randomly generated colors in the
 * RGB space and then converts them to the HSB/HSV space (https://www.cs.rit.edu/~ncs/color/t_convert.html). If after
 * the conversion, the color's saturation is over 90, regenerate the color (In the testing phase, use an assertion to verify this
 * internal invariant condition). After 10 consecutive tries to regenerate, throw an exception.
 */

class OverSaturated extends Exception {
	public OverSaturated() {
		super("OverSaturated exception generated\n-------HSV(SAT)>90-------");
	}
}

public class OvidiuGherman_Lab06_P06 {
	
	public static float[] randRGB(Random random) {
		return new float[] {random.nextFloat(0,1), random.nextFloat(0,1), random.nextFloat(0,1)};
	}
	public static float[] RGBtoHSV(float RGB[])
	{
		float r = RGB[0], g = RGB[1], b = RGB[2];
		float min, max, delta;
		float HSV[] = new float[3];
		min = Math.min( r, Math.min(g, b));
		max = Math.max( r, Math.max(g, b));
		
		HSV[2] = max;				
		delta = max - min;
		
		if( max != 0 ) {
			HSV[1] = delta / max;		
		}
		else {
			
			HSV[1] = 0;
			HSV[0] = -1;
			return HSV;
		}
		if( r == max ) {
			HSV[0] = ( g - b ) / delta;		
		}
		else if( g == max ) {
			HSV[0] = 2 + ( b - r ) / delta;	
		}
		else {
			HSV[0] = 4 + ( r - g ) / delta;	
		}
		
		HSV[0] *= 60;				
		
		if( HSV[0] < 0 ) {
			HSV[0] += 360;
		}
		
		return HSV;
	}
	
	public static void main(String[] args) throws Exception {
		Random random = new Random();
		float RGB[], HSV[] = null;
		int counter = 0;
		try {
			while(true) {
				RGB = randRGB(random);
				System.out.println("Attempt " + (counter+1));
				try {
					HSV = RGBtoHSV(RGB);
					assert (HSV[1] * 100 < 90.0f) : counter = 0;
					if(HSV[1] * 100 > 90.0f) {
						throw new OverSaturated();
					}
					else {					
						throw new Exception("Color found succesfully!\n RGB(" + RGB[0] + ", " + RGB[1] + ", " + RGB[2] + ") -> HSV(" + + HSV[0] + ", " + HSV[1] + ", " + HSV[2] + ")");
					}
				} catch(AssertionError except) {			
					System.out.println("Assertion exception(HSV(SAT)>90)");
					counter++; 
				}catch (OverSaturated except) {
					System.out.println(except.getMessage());	
					counter++; 
				}
				if(counter >= 10) {
					throw new Exception("Exception -> failed to find a valid color!");
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
