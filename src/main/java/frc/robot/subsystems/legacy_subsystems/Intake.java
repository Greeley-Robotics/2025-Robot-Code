package frc.robot.subsystems.legacy_subsystems;
// package frc.robot.subsystems;

// import java.security.GeneralSecurityException;

// import edu.wpi.first.networktables.GenericEntry;
// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants.IntakeConstants;
// import frc.robot.commands.teleoperated.IntakeCommand;
// import frc.robot.commands.autonomous.AutoIntake;


// public class Intake extends SubsystemBase {
//     private final PWMSparkMax intakeMotor;
//     private boolean isOn;
//     private double temperature;

//     private final GenericEntry nt_IntakeMotorSpeed;

//     public Intake() {
//         intakeMotor = new PWMSparkMax(IntakeConstants.kIntakeMotorPort);
//         isOn = false;

//         ShuffleboardTab tab = Shuffleboard.getTab("Intake");
//         nt_IntakeMotorSpeed = tab.add("Intake Motor Speed", 0).getEntry();
//         intakeMotor.setSafetyEnabled(true);
//     }

//     @Override
//     public void periodic() {
//         // Log motor speeds to shuffleboard
//         nt_IntakeMotorSpeed.setDouble(intakeMotor.get());
//     }


//     public void runIntake() {
//         intakeMotor.set(IntakeConstants.kIntakeMotorSpeed);
//         isOn = !isOn;
//     }

//     /**
//      * Should not be called unless necessary
//      */
//     public void reverseIntake() {
//         intakeMotor.set(-IntakeConstants.kIntakeMotorSpeed); 
//     }

//     /**
//      * Should be configured on the controllo
//      */
//     public void stopIntake() {
//         intakeMotor.set(0.0); 
//         isOn = !isOn;
//     }

//     public void kill() {

//     }

//     public Command autoIntakeCommand() {
//         return new AutoIntake(this);
//     }
// }

