package com.rea.robot.domain;

/**
 * @author Hasantha Liyanage (LNGHAQ)
 * This is the table component which the robot is moving,
 * a table could be created by passing the X and Y axis values via the constructor method
 */
public class Table {
	// holds the X and Y axis values
	private int[][] surface = null;
	
	// constructor accepting the X and Y values
	public Table(int length, int width) {
		// if the sizes of the table is invalid this will throw an exception error message
		if (length < 0 || width < 0) {
			throw new IllegalArgumentException("Invalid Surface dimensions");
		}
		// otherwise the surface of the table is created
		surface = new int[length][width];
	}
	
	/**
	 * Check if position is available on the surface
	 */
	public boolean isValidPosition(int xPosition, int yPosition){
		
		try{
			@SuppressWarnings("unused")
			int position = surface[xPosition][yPosition];
		}catch(ArrayIndexOutOfBoundsException arrayException){
			return false;
		}
		
		return true;
	}
}
