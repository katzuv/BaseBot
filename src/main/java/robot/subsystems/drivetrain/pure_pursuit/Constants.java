package robot.subsystems.drivetrain.pure_pursuit;

public class Constants {
    //DRIVING CONSTANTS
    public final static double LOOKAHEAD_DISTANCE = 0.3; //in meters
    public final static double ROBOT_WIDTH = 0.6; //the distance between the left and right wheels on the robot

    //PATH GENERATION CONSTANTS
    static final double SPACING_BETWEEN_WAYPOINTS = 0.1524; //meters
    static final double MAX_ACCEL = 2;

    //SMOOTHING CONSTANTS (pure numbers)
    final static double WEIGHT_SMOOTH = 0.85;
    final static double WEIGHT_DATA = 1 - WEIGHT_SMOOTH;
    final static double TOLERANCE = 0.001;

    //DRIVING CONSTANTS (pure numbers)
    public final static double kV = 0;
    public final static double kA = 0;
    public final static double kP = 0;

    public final static double STOP_SPEED_THRESH = 0.1; //the speed the robot could stop at the end of the path.
}