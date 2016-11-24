package com.rea.robot.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rea.robot.domain.Robot;
import com.rea.robot.domain.Robot.FacingDirection;
import com.rea.robot.domain.Table;
import com.rea.robot.helper.Command;
import com.rea.robot.helper.Command.CommandStatus;
import com.rea.robot.helper.Command.CommandType;



public class RobotMoverTest {
Table surfaceDetail = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		surfaceDetail = new Table(5, 5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		surfaceDetail = null;
	}

	/**
	 * Test method for PLACE Robot
	 * Once the robot is placed, facing direction should be NORTH
	 */
	@Test
	public void testPlace() {
		// PLCAE robot test
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.place(0, 0, FacingDirection.NORTH);
		assertEquals(FacingDirection.NORTH, robot_A.directionFacing);
				
	}
	
	/**
	 * Test method for MOVE
	 * Robot will be placed 0,0 and MOVE one step forward
	 * Expecting X and Y position values to be updated to 0 and 1
	 * Facing direction should be NORTH
	 */
	@Test
	public void testMove() {
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.place(0, 0, FacingDirection.NORTH);
		assertEquals(FacingDirection.NORTH, robot_A.directionFacing);
		
		// MOVE Robot test
		CommandStatus cs = robot_A.action(new Command(CommandType.MOVE));
		// direction facing should'nt be changed
		assertEquals(FacingDirection.NORTH, robot_A.directionFacing);
		// Command Status DONE indicates the success move
		assertEquals(cs, CommandStatus.DONE);
		// Check the statuses of the positions
		assertEquals(0, robot_A.xPosition);
		assertEquals(1, robot_A.yPosition);
		
	}
	
	/**
	 * Test method for LEFT Turn
	 * Robot is placed 0,0 facing NORTH
	 * Turning LEFT should turn the robot to WEST
	 */
	@Test
	public void testLeft() {
		// PLCAE robot test
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.place(0, 0, FacingDirection.NORTH);
		assertEquals(FacingDirection.NORTH, robot_A.directionFacing);
		
		// MOVE Robot test
		CommandStatus cs = robot_A.action(new Command(CommandType.LEFT));
		// direction facing should be changed to WEST
		assertEquals(FacingDirection.WEST, robot_A.directionFacing);
		// Command Status DONE indicates the success turn
		assertEquals(cs, CommandStatus.DONE);
		
	}
	
	/**
	 * Test method for RIGHT Turn
	 * Robot is placed 0,0 facing NORTH
	 * Turning RIGHT should turn the robot to EAST
	 */
	@Test
	public void testRight() {
		// PLCAE robot test
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.place(0, 0, FacingDirection.NORTH);
		assertEquals(FacingDirection.NORTH, robot_A.directionFacing);
		
		// MOVE Robot test
		CommandStatus cs = robot_A.action(new Command(CommandType.RIGHT));
		// direction facing should be changed to EAST
		assertEquals(FacingDirection.EAST, robot_A.directionFacing);
		// Command Status DONE indicates the success turn
		assertEquals(cs, CommandStatus.DONE);
		
	}
	
	/**
	 * Test method for REPORT.
	 * Robot is placed 1,0 facing NORTH
	 * turn RIGHT
	 * then MOVE
	 * then REPORT
	 * EXPECTED outcome would be 2,0,EAST
	 */
	@Test
	public void testReport() {
		Robot robot_A = new Robot(surfaceDetail);
		robot_A.place(1, 0, FacingDirection.NORTH);
		assertEquals(FacingDirection.NORTH, robot_A.directionFacing);
		
		// TURN Robot test
		robot_A.action(new Command(CommandType.RIGHT));
		// MOVE Robot test
		robot_A.action(new Command(CommandType.MOVE));
		
		// Check the statuses of the positions
		assertEquals(2, robot_A.xPosition);
		assertEquals(0, robot_A.yPosition);
		
		robot_A.action(new Command(CommandType.REPORT));
		// test the report output
		assertEquals("2,0,EAST", robot_A.report);
		
	}
}
