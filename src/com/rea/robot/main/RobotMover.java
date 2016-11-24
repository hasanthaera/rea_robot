
package com.rea.robot.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rea.robot.domain.Robot;
import com.rea.robot.domain.Table;
import com.rea.robot.helper.Interpreter;


/**
 * @author Hasantha Liyanage (LNGHAQ)
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
		Robot robot = new Robot(surfaceDetail);
		Interpreter interpreter = new Interpreter(robot);
		while (!Interpreter.isExit) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String cmd;
			
			try {
				cmd = reader.readLine();
				if (cmd != null) {
					interpreter.execute(cmd);
				}
			} catch (IOException e) {
				System.out.println("Invalid Input");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
