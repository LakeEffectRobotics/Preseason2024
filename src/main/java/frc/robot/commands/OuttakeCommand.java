package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Outtake;

public class OuttakeCommand extends CommandBase {

    Outtake outtake;
    DoubleSupplier speed;

    public OuttakeCommand(Outtake outtake, DoubleSupplier speed) {
        addRequirements(outtake);

        this.outtake = outtake;
        this.speed = speed;
    }

    @Override
    public void initialize() {
        outtake.setSpeed(0.0);
    }
    
    @Override
    public void execute() {
        outtake.setSpeed(speed.getAsDouble() / 50);
    }

    @Override
    public void end(boolean interrupted) {
        outtake.setSpeed(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
