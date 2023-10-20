package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * Command that controls drivetrain during normal operation.
 */
public class DriveCommand extends CommandBase  {

	/**
	 * Robot's drivetrain.
	 */
	Drivetrain drivetrain;

	/** Supplier for left side output percent */
	DoubleSupplier leftSupplier;
	/** Supplier for right side output percent */
	DoubleSupplier rightSupplier;

	/**
	 * Create a new DriveCommand
	 * 
	 * @param drivetrain Robot's drivetrain
	 * @param leftSupplier Supplier for left side output percent
	 * @param rightSupplier Supplier for right side output percent
	 */
	public DriveCommand(Drivetrain drivetrain, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
		addRequirements(drivetrain);
		
		this.drivetrain = drivetrain;
		this.leftSupplier = leftSupplier;
		this.rightSupplier = rightSupplier;
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
		drivetrain.stop();
	}

	/**
	 * Called once every 20ms (nominally).
	 */
	@Override
	public void execute() {
		// Get values from the provided double suppliers
		drivetrain.setOutput(leftSupplier.getAsDouble(), rightSupplier.getAsDouble());
	}

	/**
	 * Called when the command ends.
	 * @param interrupted Flag indicating if the command was interrupted
	 */
	@Override
	public void end(boolean interrupted) {
		drivetrain.stop();
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 */
	@Override
	public boolean isFinished() {
		return false;
	}

}