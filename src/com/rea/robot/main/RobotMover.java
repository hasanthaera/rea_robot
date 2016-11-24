/**
 * 
 */
package com.rea.robot.main;

import java.io.IOException;

import com.rea.robot.domain.Robot;
import com.rea.robot.domain.Robot.FacingDirection;
import com.rea.robot.domain.Table;
import com.rea.robot.helper.Command;
import com.rea.robot.helper.Command.CommandType;


/**
 * @author Hasantha Liyanage
 * Main method will e
 */
public class RobotMover {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		RobotMover robotMover = new RobotMover();
		robotMover.moveRobot();
	}
	
	
	public void moveRobot(){
		Table surfaceDetail = new Table(5, 5);
		
		//Example A
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.place(0, 0, FacingDirection.NORTH);
		robot_A.action(new Command(CommandType.MOVE));
		robot_A.action(new Command(CommandType.REPORT));
		
		//Example B
		Robot robot_B = new Robot(surfaceDetail);
		robot_B.place(0, 0, FacingDirection.NORTH);
		robot_B.action(new Command(CommandType.LEFT));
		robot_B.action(new Command(CommandType.REPORT));
		
		//Example C
		Robot robot_C = new Robot(surfaceDetail);
		robot_C.place(1, 2, FacingDirection.EAST);
		robot_C.action(new Command(CommandType.MOVE));
		robot_C.action(new Command(CommandType.MOVE));
		robot_C.action(new Command(CommandType.LEFT));
		robot_C.action(new Command(CommandType.MOVE));
		robot_C.action(new Command(CommandType.REPORT));
	}

}
