// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstants;

/** Class to run the rollers using PWM */
public class PWMRollerSubsystem extends SubsystemBase {
  private final PWMSparkMax rollerMotor;

  public PWMRollerSubsystem() {
    // Set up the roller motor as a brushed motor using PWM
    rollerMotor = new PWMSparkMax(RollerConstants.ROLLER_MOTOR_ID);

    // No CAN timeout or advanced configuration is needed for PWM controllers
  }

  @Override
  public void periodic() {
  }

  /** This is a method that makes the roller spin */
  public void runRoller(double forward, double reverse) {
    rollerMotor.set(forward - reverse);
  }
}
