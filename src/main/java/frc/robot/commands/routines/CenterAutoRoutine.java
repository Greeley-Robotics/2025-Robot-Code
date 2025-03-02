package frc.robot.commands.routines;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PWMDriveSubsystem;
import frc.robot.subsystems.PWMRollerSubsystem;

public class CenterAutoRoutine extends Command {
  private final PWMDriveSubsystem driveSubsystem;
  private final PWMRollerSubsystem rollerSubsystem;
  private final Timer timer = new Timer();
  private int step = 0;

  public CenterAutoRoutine(PWMDriveSubsystem driveSubsystem, PWMRollerSubsystem rollerSubsystem) {
    this.driveSubsystem = driveSubsystem;
    this.rollerSubsystem = rollerSubsystem;
    addRequirements(driveSubsystem, rollerSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("Running Center Auto!");
    timer.reset();
    timer.start();
    step = 0;
  }

  @Override
  public void execute() {
    switch (step) {
      case 0: // Drive forward 74 inches
        driveSubsystem.driveForward(0.5);
        if (timer.get() > 2.5) { 
          step++;  
          timer.reset(); 
        } 
        break;

      case 1: // Roller Outtake
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
    return step > 1;
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
    rollerSubsystem.runRoller(0.0, 0.0);
    System.out.println("Center Auto Finished");
  }
}
