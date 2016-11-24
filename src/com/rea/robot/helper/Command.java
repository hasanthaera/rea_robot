package com.rea.robot.helper;


/**
 * @author Hasantha Liyanage
 * Helper class to accept commands for the robot instance
 */
public class Command {

	public enum CommandType {MOVE, REPORT, LEFT, RIGHT}
	//IGNORED will be used to stop robot falling from the table
	public enum CommandStatus {DONE, IGNORED}
	public enum TurnDirection {LEFT, RIGHT}
	
	public Command(CommandType command){
		this.command = command;
	}	

	public Command(CommandType command, TurnDirection turnDirection){
		this.command = command;
		this.turnDirection = turnDirection;
	}
	
	private CommandType command = null;
	private TurnDirection turnDirection = null;
	private int xPosition = 0;
	private int yPosition = 0;

	/**
	 * @return the turnDirection
	 */
	public TurnDirection getTurnDirection() {
		return turnDirection;
	}
	/**
	 * @param turnDirection the turnDirection to set
	 */
	public void setTurnDirection(TurnDirection turnDirection) {
		this.turnDirection = turnDirection;
	}
	/**
	 * @return the xPosition
	 */
	public int getxPosition() {
		return xPosition;
	}
	/**
	 * @param xPosition the xPosition to set
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	/**
	 * @return the yPosition
	 */
	public int getyPosition() {
		return yPosition;
	}
	/**
	 * @param yPosition the yPosition to set
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	/**
	 * @return the command
	 */
	public CommandType getCommand() {
		return command;
	}
}
