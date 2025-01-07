// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command driveForwardAuto(Drivetrain subsystem) {
    return subsystem.driveForwardCommand();
  }

  public static Command driveIntervalAuto(Drivetrain subsystem) {
    return subsystem.driveIntervalCommand();
  }

  public static Command intakeAuto(Intake subsystem) {
    return subsystem.autoIntakeCommand();
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
