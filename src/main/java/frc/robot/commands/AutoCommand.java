// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PWMDriveSubsystem;
import frc.robot.subsystems.PWMRollerSubsystem;
import frc.robot.commands.routines.*;

public class AutoCommand {
  public static Command getRoutine(PWMDriveSubsystem driveSubsystem, PWMRollerSubsystem rollerSubsystem, String startPosition) {
    System.out.println("Selected Auto Routine: " + startPosition);

    switch (startPosition) {
      case "Left":
        return new LeftAutoRoutine(driveSubsystem, rollerSubsystem);
      case "Right":
        return new RightAutoRoutine(driveSubsystem, rollerSubsystem);
      case "Center":
        return new CenterAutoRoutine(driveSubsystem, rollerSubsystem);
      default:
        System.out.println("Invalid Auto Routine Selected! Defaulting to Center Left.");
        return new CenterAutoRoutine(driveSubsystem, rollerSubsystem);
    }
  }
}
