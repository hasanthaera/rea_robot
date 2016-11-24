/**
 * 
 */
package com.rea.robot.domain;

import com.rea.robot.helper.Command;
import com.rea.robot.helper.Command.CommandStatus;

/**
 * @author Hasantha Liyanage
 * The Robot class contains all the actions related to the robot on the table,
 * this implements Place, Move, Report and other Actions Left and Right behaviors
 */
public class Robot {
	//Facing directions of the robot instance
	public enum FacingDirection {
		NORTH, EAST, SOUTH, WEST
	}

	// Default values
	Table table = null;
	// checking whether the robot is placed on the table surface
	private boolean isOnTable = false;
	// Initially Robot will b facing NORTH
	private FacingDirection directionFacing = FacingDirection.NORTH;
	//dimensions of the table-top 
	private int xPosition = 0;
	private int yPosition = 0;

	public Robot(Table table) {
		if (table == null) {
			throw new IllegalArgumentException("Table detail is null.");
		}
		this.table = table;
	}

	/**
	 * This method will place the robot in the initial position
	 * 
	 * @param xPosition
	 * @param yPosition
	 * @param directionFacing
	 */
	public void place(int xPosition, int yPosition, FacingDirection directionFacing) {

		if (xPosition < 0 || yPosition < 0 || !table.isValidPosition(xPosition, yPosition)) {
			throw new IllegalArgumentException("Invalid postion");
		}

		this.isOnTable = true;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.directionFacing = directionFacing;
	}

	/**
	 * When the Robot is about to take a move and if it is moving to a valid position, 
	 * Move the instance forward, ignore otherwise 
	 * @return CommandStatus
	 */
	private CommandStatus move() {
		CommandStatus commandStatus = null;
		if (isOnTable) {
			switch (directionFacing) {
			case NORTH:
				int northYPosition = yPosition + 1;
				if (table.isValidPosition(xPosition, northYPosition)) {
					yPosition = northYPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}
				break;
			case SOUTH:
				int southYPosition = yPosition - 1;
				if (table.isValidPosition(xPosition, southYPosition)) {
					yPosition = southYPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}
				break;
			case EAST:
				int eastXPosition = xPosition + 1;
				if (table.isValidPosition(eastXPosition, yPosition)) {
					xPosition = eastXPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}
				break;
			case WEST:
				int westXPosition = xPosition - 1;
				if (table.isValidPosition(westXPosition, yPosition)) {
					xPosition = westXPosition;
					commandStatus = CommandStatus.DONE;
				} else {
					commandStatus = CommandStatus.IGNORED;
				}
				break;
			default:
				commandStatus = CommandStatus.IGNORED;
			}
		} else {
			commandStatus = CommandStatus.IGNORED;
		}
		return commandStatus;
	}

	/**
	 * This method is to determine which direction the robot should face based
	 * on the currently faced direction. When the command is RIGHT robot should
	 * move clockwise to the next direction, otherwise anti-clockwise.
	 * 
	 * @param command
	 * @return CommandStatus
	 */
	private CommandStatus turn(Command command) {

		CommandStatus commandStatus = null;

		if (isOnTable) {
			switch (command.getCommand()) {
			case LEFT:
				switch (directionFacing) {
				case NORTH:
					directionFacing = FacingDirection.WEST;
					break;
				case WEST:
					directionFacing = FacingDirection.SOUTH;
					break;
				case SOUTH:
					directionFacing = FacingDirection.EAST;
					break;
				case EAST:
					directionFacing = FacingDirection.NORTH;
					break;
				default:
					break;
				}
				commandStatus = CommandStatus.DONE;
				break;
			case RIGHT:
				switch (directionFacing) {
				case NORTH:
					directionFacing = FacingDirection.EAST;
					break;
				case WEST:
					directionFacing = FacingDirection.NORTH;
					break;
				case SOUTH:
					directionFacing = FacingDirection.WEST;
					break;
				case EAST:
					directionFacing = FacingDirection.SOUTH;
					break;
				default:
					break;
				}
				commandStatus = CommandStatus.DONE;
				break;
			default:
				commandStatus = CommandStatus.IGNORED;
			}
		} else {
			commandStatus = CommandStatus.IGNORED;
		}

		return commandStatus;
	}

	/**
	 * This will print the status report of the movements
	 * @return CommandStatus
	 */
	private CommandStatus report() {
		if (isOnTable) {
			System.out.println(xPosition + "," + yPosition + "," + directionFacing.name());
			return CommandStatus.DONE;
		} else {
			return CommandStatus.IGNORED;
		}
	}

	/**
	 * Other than the place method all the other action methods are determined under this method, 
	 * which includes MOVE, LEFT, RIGHT, REPORT
	 * @param command
	 * @return CommandStatus
	 */
	public CommandStatus action(Command command) {

		if (!isOnTable) {
			return CommandStatus.IGNORED;
		} else {
			CommandStatus commandStatus = null;

			switch (command.getCommand()) {
			case MOVE:
				commandStatus = move();
				break;
			case LEFT:
			case RIGHT:
				commandStatus = turn(command);
				break;
			case REPORT:
				commandStatus = report();
				break;
			default:
				commandStatus = CommandStatus.IGNORED;
			}
			return commandStatus;
		}
	}
}
