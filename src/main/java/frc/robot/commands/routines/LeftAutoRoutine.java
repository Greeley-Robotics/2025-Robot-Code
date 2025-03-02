package frc.robot.commands.routines;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PWMDriveSubsystem;
import frc.robot.subsystems.PWMRollerSubsystem;

public class LeftAutoRoutine extends Command {
  private final PWMDriveSubsystem driveSubsystem;
  private final PWMRollerSubsystem rollerSubsystem;
  private final Timer timer = new Timer();
  private int step = 0;

  public LeftAutoRoutine(PWMDriveSubsystem driveSubsystem, PWMRollerSubsystem rollerSubsystem) {
    this.driveSubsystem = driveSubsystem;
    this.rollerSubsystem = rollerSubsystem;
    addRequirements(driveSubsystem, rollerSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("Running Left Auto!");
    timer.reset();
    timer.start();
    step = 0;
  }

  @Override
  public void execute() {
    switch (step) {
      case 0: // Drive forward 100 inches
        driveSubsystem.driveForward(0.5);
        if (timer.get() > 3.0) { 
          step++;  
          timer.reset(); 
        } 
        break;

      case 1: // Rotate 45° counter-clockwise
        driveSubsystem.rotate(-0.5);
        if (timer.get() > 1.0) { 
          step++;  
          timer.reset(); 
        } 
        break;

      case 2: // Drive forward 10.375 inches
        driveSubsystem.driveForward(0.5);
        if (timer.get() > 0.5) { 
          step++;  
          timer.reset(); 
        } 
        break;

      case 3: // Roller Outtake
        System.out.println("Running Roller Outtake...");
        rollerSubsystem.runRoller(0.7, 0.0);
        if (timer.get() > 1.5) { 
          step++;  
          timer.reset(); 
        } 
        break;

      default:
        driveSubsystem.stop();
        rollerSubsystem.runRoller(0.0, 0.0);
        break;
    }
  }

  @Override
  public boolean isFinished() {
    return step > 3;
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
    rollerSubsystem.runRoller(0.0, 0.0);
    System.out.println("Left Auto Finished");
  }
}
