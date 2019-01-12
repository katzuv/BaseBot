package robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.subsystems.drivetrain.pure_pursuit.Constants;
import robot.subsystems.drivetrain.pure_pursuit.Path;
import robot.subsystems.drivetrain.pure_pursuit.PurePursue;
import robot.subsystems.drivetrain.pure_pursuit.Waypoint;

/**
 *This command group is used to run several paths one after the other
 *useful for cases of wanting the change the isRelative and isReversed at a certain point in the path
 */
public class TestCommandGroup extends CommandGroup {

    public TestCommandGroup() {
        //Create the path and points.
        Path path = new Path();
        path.appendWaypoint(new Waypoint(0, 0));
        path.appendWaypoint(new Waypoint(0,1));
        path.appendWaypoint(new Waypoint(-1, 2));
        path.appendWaypoint(new Waypoint(-1,3));
        path.appendWaypoint(new Waypoint(-2,4));

        //Generate the path to suit the pure pursuit.
        path.generateAll(Constants.WEIGHT_DATA, Constants.WEIGHT_SMOOTH, Constants.TOLERANCE, Constants.MAX_ACCEL, Constants.MAX_PATH_VELOCITY);
        //Create the path and the points
        Path path2 = new Path();
        path2.appendWaypoint(new Waypoint(0, 0));
        path2.appendWaypoint(new Waypoint(0, 1));
        path2.appendWaypoint(new Waypoint( -1, 2));
        //Generate the path to suit the pure pursuit.
        path2.generateAll(Constants.WEIGHT_DATA, Constants.WEIGHT_SMOOTH, Constants.TOLERANCE, Constants.MAX_ACCEL, Constants.MAX_PATH_VELOCITY);

        //Create a purepursue command
        PurePursue pursue = new PurePursue(path, Constants.LOOKAHEAD_DISTANCE, Constants.kP, Constants.kA, Constants.kV, true, false);
        addSequential(pursue);
        //addSequential(new PurePursue(path, Constants.LOOKAHEAD_DISTANCE, Constants.kP, Constants.kA, Constants.kV, true, true));
        //Print the variables for testing.
        SmartDashboard.putString("pursue command", "start");
        SmartDashboard.putString("last waypoint", path.getWaypoint(path.length()-1).toString());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}