package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    public TalonSRX intakeMoter;

    public Intake(TalonSRX intakeMoter) {
        this.intakeMoter = intakeMoter;
    }

    public void setSpeed(Double speed) {
        intakeMoter.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
