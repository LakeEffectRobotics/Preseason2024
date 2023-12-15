package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Outtake extends SubsystemBase {

    WPI_TalonSRX outtakeController;

    public Outtake(WPI_TalonSRX outtakeController) {
        this.outtakeController = outtakeController;
    }

    public void setSpeed(Double speed) {
        outtakeController.set(ControlMode.PercentOutput, speed);
    }
    
    /*
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }*/
}
