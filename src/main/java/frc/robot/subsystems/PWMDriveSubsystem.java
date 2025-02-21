// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

// Class to drive the robot using PWM
public class PWMDriveSubsystem extends SubsystemBase {
  private final PWMSparkMax leftLeader;
  private final PWMSparkMax leftFollower;
  private final PWMSparkMax rightLeader;
  private final PWMSparkMax rightFollower;

  private final DifferentialDrive drive;

  public PWMDriveSubsystem() {
    // Create brushed motors for drive using PWM ports
    leftLeader = new PWMSparkMax(DriveConstants.LEFT_LEADER_ID);
    leftFollower = new PWMSparkMax(DriveConstants.LEFT_FOLLOWER_ID);
    rightLeader = new PWMSparkMax(DriveConstants.RIGHT_LEADER_ID);
    rightFollower = new PWMSparkMax(DriveConstants.RIGHT_FOLLOWER_ID);

    // Set up differential drive class
    drive = new DifferentialDrive(leftLeader, rightLeader);

    // Configure follower motors to follow the leader manually
    leftFollower.setInverted(leftLeader.getInverted());
    rightFollower.setInverted(rightLeader.getInverted());

    // Left side inverted so that positive values drive both sides forward
    leftLeader.setInverted(true);
    leftFollower.setInverted(true);

    // No CAN timeout or advanced configuration is needed for PWM controllers
  }

  @Override
  public void periodic() {
  }

  // Sets the speed of the drive motors
  public void driveArcade(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }
}
