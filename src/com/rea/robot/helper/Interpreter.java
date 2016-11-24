/**
 * 
 */
package com.rea.robot.helper;

import com.rea.robot.domain.Robot;
import com.rea.robot.domain.Robot.FacingDirection;
import com.rea.robot.helper.Command.CommandType;

/**
 * @author LNGHAQ
 *
 */
public class Interpreter {
	public static boolean  isExit = false;
	Robot robot;
	boolean isPlaced = false;
	
	public Interpreter(Robot robot) {
		this.robot = robot;
		this.isPlaced = false;
	}
	
	/**
	 * appropriate action will be executed based on the command entered
	 * @param cmd
	 */
	public void execute(String cmd) {
		String[]  commands = splitCommand(cmd);
		String cmdIgnorecase = commands[0].toLowerCase();
		//if the robot is not place before any other commands, throw an error
		if(!cmdIgnorecase.equals("place") && !isPlaced) {
			throw new IllegalArgumentException("Couldn't find a placed robot, Please PLACE a robot before any other actions");
		}
		
		// execute the action based on the command and the parameters
		switch (cmdIgnorecase) {
		case "place":
			try {
				// when the command in PLACE we expect some parameters along with it
				if (commands.length < 2) {
					throw new IllegalArgumentException("Invalid Arguments");
				}
				
				String[] params = splitCommandParams(commands[1]);
				// if the number parameters are not available inform user
				if (params.length < 3) {
					throw new IllegalArgumentException("Invalid Arguments");
				}
				
				int xPosition = Integer.parseInt(params[0]);
				int yPosition = Integer.parseInt(params[1]);
				String direction = params[2].toUpperCase(); 
				
				//place the robot
				robot.place(xPosition, yPosition, FacingDirection.valueOf(direction));
				isPlaced = true;
			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid Arguments");
			}
			break;
		case "move":
			robot.action(new Command(CommandType.MOVE));
			break;
		case "left":
			robot.action(new Command(CommandType.LEFT));
			break;
		case "right":
			robot.action(new Command(CommandType.RIGHT));
			break;
		case "report":
			robot.action(new Command(CommandType.REPORT));
			break;
		case "exit":
			robot.action(new Command(CommandType.RIGHT));
			break;
		default :
			throw new IllegalArgumentException("Invalid Arguments");
		}
	}
	
	private static String[] splitCommand(String cmd) {
		String[] splittedString = cmd.split(" ");
		return splittedString;
	}
	
	private static String[] splitCommandParams(String cmd) {
		String[] splittedString = cmd.split(",");
		return splittedString;
	}

}
