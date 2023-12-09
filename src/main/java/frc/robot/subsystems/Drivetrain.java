package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Subsystem representing the Robot's drivetrain.
 */
public class Drivetrain extends SubsystemBase  {

	/**
	 * Motor controllers on left side.
	 */
	MotorControllerGroup leftControllers;
	/**
	 * Motor controllers on right side.
	 */
	MotorControllerGroup rightControllers;

	// Robot track width 19"
	// TODO find actual width of track
	public final DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Units.inchesToMeters(24));

	// Max speed in m/s because idk
	// TODO change to something else
	public final double MAX_SPEED = 4;


	/**
	 * Create a new Drivetrain.
	 * 
	 * @param leftControllers Motor controllers on left side
	 * @param rightControllers Motor controllers on right side
	 */
	public Drivetrain(MotorControllerGroup leftControllers, MotorControllerGroup rightControllers) {
		this.leftControllers = leftControllers;
		this.rightControllers = rightControllers;
	}
	
	/**
	 * Set the drivetrain output, using tank controls.
	 * @param left left side output percent, [-1, 1]
	 * @param right right side output percet, [-1, 1]
	 */
	public void setOutput(double left, double right){
		leftControllers.set(-left);
		rightControllers.set(right);
	}

	public void arcadeDrive(double speed, double rotation) {
        DifferentialDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(new ChassisSpeeds(speed, 0, rotation));
        setOutput(wheelSpeeds.leftMetersPerSecond / 4.4, wheelSpeeds.rightMetersPerSecond / 4.4);
    }

	/**
	 * Stop the drivetrain.
	 */
	public void stop(){
		leftControllers.set(0);
		rightControllers.set(0);
	}

}