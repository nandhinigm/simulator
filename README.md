# simulator
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.


Toy Robot Simulator

Description

The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5
units x 5 units.
There are no other obstructions on the table surface.
The robot is free to roam around the surface of the table, but must be prevented from
falling to destruction
Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

Create a production-ready application that can read in commands of the following form:
PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT

How the commands work

PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH,EAST or WEST.
The origin (0,0) can be considered to be the SOUTH WEST most corner.
The first valid command to the robot is a PLACE command, after that, any sequence of
commands may be issued, in any order, including another PLACE command
The application should discard all commands in the sequence until a valid PLACE command has been executed.
MOVE will move the toy robot one unit forward in the direction it is currently facing.
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
REPORT will announce the X, Y and F of the robot - this can be in any form, but standard output is sufficient.
A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.

Constraints:

The toy robot must not fall off the table during movement (this also includes the initial placement of the toy robot).
Any move that would cause the robot to fall must be ignored.

Example
Input and Output:
a)
PLACE 0,0,NORTH
MOVE
REPORT
Output: 0,1,NORTH
b)
PLACE 0,0,NORTH
LEFT
REPORT
Output: 0,0,WEST
c)
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
Output: 3,3,NORTH

How To Build and Execute the Application

Java: Java 1.8
Apache Maven: 3.5.2
Junit: 4.12
Mockito: 1.10.19

To build the application, execute mvn clean install

To start the simulator, 
cd bin/
startSimulator.bat

To stop the application,
QUIT
CTRL+C

