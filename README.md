# rea toy robot 

The application is a simulation of a toy robot moving on a square tabletop

application should accept the below commands;

- PLACE X,Y,F - X and Y axis indicates the position of the robot while F indicates facing direction
- MOVE - move to a one position forward where the robot is currently facing.
- LEFT - turn left from the direction that the robot is currently facing.
- RIGHT - turn right from the direction that the robot is currently facing.
- REPORT - prints the current status of the robot, eg: 3,3,NORTH

## Flow Chart
Describes the highlevel architecture of the program.
![alt tag](https://github.com/hasanthaera/rea_robot/blob/master/doc/robot.png)



## Prerequisites

- Eclipse
- Java 8
- JUnit 4


## Installing

Please clone or download the rea_robot repository and open the project using eclipse. You could easily run the project from eclipse as a Java Application. 

```
clone https://github.com/hasanthaera/rea_robot.git
```

## Running the tests

JUNIT test cases are included in the test package, to run the test cases write click on the project "Run As" -> "Run Configurations" then double click on the JUnit setting on left pannel of the window then click "Run"

This will excecute the test cases included in the RobotMoverTest class.


## Sample Input/Output - test data

### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Expected output:

    0,1,NORTH

### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Expected output:

    0,0,WEST

### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Expected output

    3,3,NORTH
