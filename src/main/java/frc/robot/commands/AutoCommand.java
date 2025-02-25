// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PWMDriveSubsystem;

// Command to run different autonomous routines based on start position
public class AutoCommand extends Command {
  private final PWMDriveSubsystem driveSubsystem;
  private final Timer timer;
  private final String startPosition;
  private double seconds = 15.0; // Default duration for autonomous

  // Constructor. Runs only once when the command is first created.
  public AutoCommand(PWMDriveSubsystem driveSubsystem, String startPosition) {
    // Save parameters for later use and initialize timer object.
    this.driveSubsystem = driveSubsystem;
    this.startPosition = startPosition;
    timer = new Timer();

    // Declare subsystems required by this command. This should include any
    // subsystem this command modifies.
    addRequirements(driveSubsystem);
  }

  // Runs each time the command is scheduled. For this command, we handle starting
  // the timer and selecting the correct autonomous function.
  @Override
  public void initialize() {
    // Start timer, uses restart to clear the timer as well in case this command has
    // already been run before
    timer.restart();

    System.out.println("Starting Auto: " + startPosition);

    switch (startPosition) {
      case "Left":
        runLeftAuto();
        break;
      case "Right":
        runRightAuto();
        break;
      default:
        runCenterAuto();
        break;
    }
  }

  // Runs every cycle while the command is scheduled (~50 times per second)
  @Override
  public void execute() {
    // Drive at 1/2 speed
    driveSubsystem.driveArcade(0.5, 0.0);
  }

  // Runs each time the command ends via isFinished or being interrupted.
  @Override
  public void end(boolean isInterrupted) {
    // Stop drive motors
    driveSubsystem.driveArcade(0.0, 0.0);
    System.out.println("Auto Finished: " + startPosition);
  }

  // Runs every cycle while the command is scheduled to check if the command is
  // finished
  @Override
  public boolean isFinished() {
    // Check if timer exceeds seconds, when it has this will return true indicating
    // this command is finished
    return timer.get() >= seconds;
  }

  // Runs autonomous routine for Left Start position
  private void runLeftAuto() {
    System.out.println("Running Left Start Auto!");
    seconds = 2.0; // Example: Drive for 2 seconds
  }

  // Runs autonomous routine for Center Start position
  private void runCenterAuto() {
    System.out.println("Running Center Start Auto!");
    seconds = 2.0; 
  }

  // Runs autonomous routine for Right Start position
  private void runRightAuto() {
    System.out.println("Running Right Start Auto!");
    seconds = 2.0; 
  }
}
