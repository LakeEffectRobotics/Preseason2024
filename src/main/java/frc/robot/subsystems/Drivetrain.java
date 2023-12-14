package frc.robot.subsystems;

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
		leftControllers.set(left);
		rightControllers.set(right);
	}

	/**
	 * Stop the drivetrain.
	 */
	public void stop(){
		leftControllers.set(0);
		rightControllers.set(0);
	}

}