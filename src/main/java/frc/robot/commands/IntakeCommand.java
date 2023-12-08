package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {

    private Intake intake;
    private DoubleSupplier speed;

    public IntakeCommand(Intake intake, DoubleSupplier speed) {
        addRequirements(intake);

        this.intake = intake;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        intake.setSpeed(0.0);
    }

    @Override
    public void execute() {
        intake.setSpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interupted) {
        intake.setSpeed(0.0);
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}
