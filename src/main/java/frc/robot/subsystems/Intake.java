package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

//add phoenix in dependencies
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.Intake.*;

public class Intake extends SubsystemBase {
    private final TalonSRX intakeMotor;


    public Intake() {
        intakeMotor = new TalonSRX(intakeMotorID);
    }

    @Override
    public void periodic() {

    }

}
