package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
    private final TalonFX leftLeadMotor;
    private final TalonFX leftFollowMotor;
    private final TalonFX rightLeadMotor;
    private final TalonFX rightFollowMotor;
    private final Pigeon2 gyro;
    private final DutyCycleOut leftDutyCycle = new DutyCycleOut(0);
    private final DutyCycleOut rightDutyCycle = new DutyCycleOut(0);
    
    public TankDrive() {
        leftLeadMotor = new TalonFX(Constants.Drive.leftLeadMotorID);
        leftFollowMotor = new TalonFX(Constants.Drive.leftFollowMotorID);
        rightLeadMotor = new TalonFX(Constants.Drive.rightLeadMotorID);
        rightFollowMotor = new TalonFX(Constants.Drive.rightFollowMotorID);
        configureMotors();
        gyro = new Pigeon2(Constants.Drive.pigeonID);
        gyro.getConfigurator().apply(new Pigeon2Configuration());
        zeroHeading();
    }
    
    private void configureMotors() { // this is stolen
        TalonFXConfiguration motorConfig = new TalonFXConfiguration();
        motorConfig.MotorOutput.NeutralMode = Constants.Drive.neutralMode;
        motorConfig.CurrentLimits.SupplyCurrentLimitEnable = Constants.Drive.enableCurrentLimit;
        motorConfig.CurrentLimits.SupplyCurrentLimit = Constants.Drive.currentLimit;
        motorConfig.CurrentLimits.SupplyCurrentThreshold = Constants.Drive.currentThreshold;
        motorConfig.CurrentLimits.SupplyTimeThreshold = Constants.Drive.currentThresholdTime;
        motorConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = Constants.Drive.openLoopRamp;
        
        leftLeadMotor.getConfigurator().apply(motorConfig);
        leftFollowMotor.getConfigurator().apply(motorConfig);
        rightLeadMotor.getConfigurator().apply(motorConfig);
        rightFollowMotor.getConfigurator().apply(motorConfig);

        leftLeadMotor.setInverted(Constants.Drive.leftInverted);
        leftFollowMotor.setInverted(Constants.Drive.leftInverted);
        rightLeadMotor.setInverted(Constants.Drive.rightInverted);
        rightFollowMotor.setInverted(Constants.Drive.rightInverted);

        leftFollowMotor.setControl(new DutyCycleOut(0, true, false, false, leftLeadMotor));
        rightFollowMotor.setControl(new DutyCycleOut(0, true, false, false, rightLeadMotor));
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
        leftSpeed *= Constants.Drive.maxSpeed;
        rightSpeed *= Constants.Drive.maxSpeed;
        leftDutyCycle.Output = leftSpeed / Constants.Drive.maxSpeed;
        rightDutyCycle.Output = rightSpeed / Constants.Drive.maxSpeed;
        
        leftLeadMotor.setControl(leftDutyCycle);
        rightLeadMotor.setControl(rightDutyCycle);
    }
    public Rotation2d getHeading() {
        return Rotation2d.fromDegrees(gyro.getYaw().getValue());
    }
    
    public void zeroHeading() {
        gyro.setYaw(0);
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("heading", getHeading().getDegrees());
        SmartDashboard.putNumber("Left:", leftLeadMotor.getDutyCycle().getValue());
        SmartDashboard.putNumber("Right:", rightLeadMotor.getDutyCycle().getValue());
    }
}