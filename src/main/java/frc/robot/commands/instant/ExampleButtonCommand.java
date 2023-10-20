package frc.robot.commands.instant;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * Command that prints when the example button is pressed.<br/>
 * This is an instant command, so it will just run once then end
 */
public class ExampleButtonCommand extends InstantCommand  {

	/**
	 * Create a new ExampleButtonCommand
	 */
	public ExampleButtonCommand() {
		// Constructor should just be for setup, not executing the command
		// So nothing to be done here
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
		System.out.println("Example button pressed!");
	}

}