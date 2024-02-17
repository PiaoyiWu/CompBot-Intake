package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel;

public class IntakeSubsystem extends SubsystemBase {
    public CANSparkFlex intakeMotor1 = new CANSparkFlex(19, CANSparkLowLevel.MotorType.kBrushless);
    public CANSparkFlex intakeMotor2 = new CANSparkFlex(20, CANSparkLowLevel.MotorType.kBrushless);

    public IntakeSubsystem() {
        SmartDashboard.putNumber("Intake Speed", 0.60);
    }
 
    public void intake(double intakeSpeed) {
        intakeMotor1.set(intakeSpeed);
        intakeMotor2.set(-intakeSpeed);

    }
}
