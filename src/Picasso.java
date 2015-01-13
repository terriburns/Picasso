/**
 * An awesome and simple recursive graphic using Processing
 * Triangle Rotation based on:
 * http://www.youtube.com/watch?v=uFjcBnN9MTU
 * 
 * @author: [Terri Burns, tcb286]
 */

import processing.core.PApplet;

public class Picasso extends PApplet {
	// CONSTANTS
	static final int WINDOW_WIDTH = 700;
	static final int WINDOW_HEIGHT = 700; 
	static final int TRIANGLE_HEIGHT = 600;
	//Parameters for original triangle
	static float HALF = 0.5f;
	static float x1 = HALF * WINDOW_WIDTH;
	static float y1 = (HALF * WINDOW_HEIGHT) - (HALF* TRIANGLE_HEIGHT);
	static float x2 = (HALF * WINDOW_WIDTH) - (HALF * TRIANGLE_HEIGHT);
	static float y2 = (HALF * WINDOW_HEIGHT) + (HALF * TRIANGLE_HEIGHT);
	static float x3 = (HALF * WINDOW_WIDTH) + (HALF * TRIANGLE_HEIGHT);
	static float y3 = (HALF * WINDOW_HEIGHT) + (HALF * TRIANGLE_HEIGHT);
	
	
	public void setup() {
		size(WINDOW_WIDTH, WINDOW_HEIGHT);
		background(161, 21, 21);
	}

	public void draw() {
		drawTriangle(x1, y1, x2, y2, x3, y3);
		
	}

	/**
	 * This is a recursive function that draws a triangle inside of the last
	 * @param x_1 (x coordinate of first point)
	 * @param y_1 (y coordinate of first point)
	 * @param x_2 (x coordinate of second point)
	 * @param y_2 (y coordinate of second point)
	 * @param x_3 (x coordinate of third point)
	 * @param y_3 (y coordinate of third point)
	 */
	private void drawTriangle(float x_1, float y_1, float x_2, float y_2, float x_3, float y_3) {		
		//base case
		if (distance(x_1,  y_1,  x_2,  y_2) <= 1) {
			return;
		}
		triangle(x_1, y_1, x_2, y_2, x_3, y_3); 
		int red = (int)(Math.random() * 256); 
        int green = (int)(Math.random() * 256);
        int blue = (int)(Math.random() * 256);
		fill(red, green, blue);
		stroke(255); //add border color so we can actually see the different triangles
		
		
		// draw recursive triangles	
		// use midpoint formula to determine coordinates for next triangle
		float X_1 = (x_1 + x_2) / 2;
		float Y_1 = (y_1 + y_2) / 2;
		float X_2 = (x_2 + x_3) / 2;
		float Y_2 = (y_2 + y_3) / 2;
		float X_3 = (x_1 + x_3) / 2;
		float Y_3 = (y_1 + y_3) / 2;
			
		drawTriangle(X_1, Y_1, X_2, Y_2, X_3, Y_3);

	}
	/**
	 * This function uses the distance formula to find the distance between two points of a triangle.
	 * Good for determining triangle size, which we just for our recursive function's base case
	 * @param X1 (x coordinate of first point)
	 * @param Y1 (y coordinate of first point)
	 * @param X2 (x coordinate of second point)
	 * @param Y2 (y coorinate of second point)
	 * @return distance between two points of the triangle
	 */
	private float distance(float X1, float Y1, float X2, float Y2) {		
		return (float) (Math.sqrt((Math.pow(X2-X1, 2) + Math.pow(Y2-Y1, 2))));
		
	}
	
}
