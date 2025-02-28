package frc.robot.commands.routines;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PWMDriveSubsystem;
import frc.robot.subsystems.PWMRollerSubsystem;

// Command for Left Start Autonomous
public class LeftAutoRoutine extends Command {
  private final PWMDriveSubsystem driveSubsystem;
  private final PWMRollerSubsystem rollerSubsystem;
  private final Timer timer = new Timer();
  private boolean finished = false;

  public LeftAutoRoutine(PWMDriveSubsystem driveSubsystem, PWMRollerSubsystem rollerSubsystem) {
    this.driveSubsystem = driveSubsystem;
    this.rollerSubsystem = rollerSubsystem;
    addRequirements(driveSubsystem, rollerSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("Running Left Start Auto!");
    timer.restart();
    finished = false;

    // Step 1: Drive forward for 2 seconds
    driveSubsystem.driveForward(0.5);
    Timer.delay(2.0);
    driveSubsystem.stop();

    // Step 2: Activate roller for 1.5 seconds
    System.out.println("Activating rollers...");
    rollerSubsystem.runRoller(0.7, 0.0);
    Timer.delay(1.5);
    rollerSubsystem.runRoller(0.0, 0.0);

    // Step 3: Rotate left
    System.out.println("Turning left...");
    driveSubsystem.rotate(-0.5);
    Timer.delay(1.0);
    driveSubsystem.stop();

    finished = true;
  }

  @Override
  public boolean isFinished() {
    return finished;
  }
}
