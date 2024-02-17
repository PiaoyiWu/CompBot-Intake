package frc.robot.subsystems;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase{
    public CANSparkFlex shooterLeft;
    public CANSparkFlex shooterRight;
        public CANSparkFlex shooterActuator;

    public SparkPIDController leftShooterPID;
    public SparkPIDController rightShooterPID;


    public Shooter(){
        shooterLeft = new CANSparkFlex(16, CANSparkLowLevel.MotorType.kBrushless);
        shooterRight = new CANSparkFlex(17, CANSparkLowLevel.MotorType.kBrushless);
        shooterActuator = new CANSparkFlex(18, CANSparkLowLevel.MotorType.kBrushless);


        // leftShooterPID = shooterLeft.getPIDController();
        // leftShooterPID.setP(0.0007);
        // leftShooterPID.setI(0.000001);
        // leftShooterPID.setD(0.005);
        // leftShooterPID.setFF(0.001);
        // leftShooterPID.setIZone(2000);
        // rightShooterPID = shooterRight.getPIDController();
        // rightShooterPID.setP(0.0007);
        // rightShooterPID.setI(0.000001);
        // rightShooterPID.setD(0.005);
        // rightShooterPID.setFF(0.001);
        // rightShooterPID.setIZone(2000);
        
        SmartDashboard.setDefaultNumber("Shoot Speed Left", 0.9);
        SmartDashboard.setDefaultNumber("Shoot Speed Right", 0.85);
        SmartDashboard.setDefaultNumber("Linear Actuator Speed", 0.3);

    }

    public void Shoot(){
    
        // leftShooterPID.setReference(SmartDashboard.getNumber("Shoot Speed Left", 3600), ControlType.kVelocity);
        // rightShooterPID.setReference(-SmartDashboard.getNumber("Shoot Speed Right", 3400), ControlType.kVelocity);

        shooterLeft.set(-SmartDashboard.getNumber("Shoot Speed Left", 0.9));
        shooterRight.set(-SmartDashboard.getNumber("Shoot Speed Right", 0.85));


    }
    @Override
    public void periodic(){
        SmartDashboard.putNumber("Left Shooter Rmp", shooterLeft.getEncoder().getVelocity());
        SmartDashboard.putNumber("Right Shooter Rmp", shooterRight.getEncoder().getVelocity());
        
    }
    public void StopShoot(){
        shooterLeft.stopMotor();
        shooterRight.stopMotor();

    }

    public void ShooterActuator(double speed) {
        shooterActuator.set(speed);
    }

    public void StopActuator() {
        shooterActuator.stopMotor();
    }
}
