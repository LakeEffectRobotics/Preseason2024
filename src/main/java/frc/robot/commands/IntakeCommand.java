// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {

  Intake intake; 
  DoubleSupplier speed;
  /** Creates a new IntakeCommand. */
  public IntakeCommand(Intake intake, DoubleSupplier speed) {
    addRequirements(intake);
    this.intake = intake;
    this.speed = speed; 
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake.setSpeed(0.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.setSpeed(speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.setSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}