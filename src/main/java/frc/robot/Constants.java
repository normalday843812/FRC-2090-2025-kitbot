package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.lib.util.COTSTalonFXSwerveConstants;
import frc.lib.util.SwerveModuleConstants;
import com.ctre.phoenix6.signals.NeutralModeValue;

public final class Constants {
    public static final double stickDeadband = 0.1;

    public static final class Drive {
        public static final int leftLeadMotorID = 1;
        public static final int leftFollowMotorID = 2;
        public static final int rightLeadMotorID = 3;
        public static final int rightFollowMotorID = 4;
        
        public static final int pigeonID = 1;
        
        public static final NeutralModeValue neutralMode = NeutralModeValue.Brake;
        public static final boolean leftInverted = false; // TODO: Adjust?
        public static final boolean rightInverted = true; // TODO: Adjust?
        public static final int currentLimit = 40;
        public static final int currentThreshold = 60;
        public static final double currentThresholdTime = 0.1;
        public static final boolean enableCurrentLimit = true;
        
        public static final double openLoopRamp = 0.25;
        
        public static final double maxSpeed = 1.5;
    }
    
}