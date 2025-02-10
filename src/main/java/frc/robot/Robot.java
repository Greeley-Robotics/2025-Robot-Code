// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

                                    
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.DrivetrainConstants;

import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private final AHRS ahrs = new AHRS(SPI.Port.kMXP);

  /*
   * Initialize the motors for the Differential Drivetrain within the Robots Class
   */
    public final static PWMSparkMax leftLeader = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort0LeftLeader);
    public final static PWMSparkMax leftFollower = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort1LeftFollower);
    public final static PWMSparkMax rightLeader = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort2RightLeader);
    public final static PWMSparkMax rightFollower = new PWMSparkMax(DrivetrainConstants.kMotorControllerPort3RightFollower);
    public DifferentialDrive m_robotDrive;
        
        
          private Command m_driveForwardAuto;
          private Command m_driveIntervalAuto;
        
          private RobotContainer m_robotContainer;
        
  public Robot() {
    leftLeader.setSafetyEnabled(true);
    leftFollower.setSafetyEnabled(true);
    rightLeader.setSafetyEnabled(true);
    rightFollower.setSafetyEnabled(true);
    
  }
    
      public static PWMSparkMax getLeftLeader(){
        return leftLeader;
      }
      public static PWMSparkMax getRightLeader(){
        return rightLeader;
      }
      public static PWMSparkMax getLeftFollower(){
        return leftFollower;
      }
      public static PWMSparkMax getRightFollower(){
        return rightFollower;
      }




  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    
    System.out.println(String.format("[i] navX Connected: %s", ahrs.isConnected()));

    m_robotContainer = new RobotContainer();

    /*
     * Sets up the differential drive aspect of the code
     */
    leftLeader.addFollower(leftFollower);
    rightLeader.addFollower(rightFollower);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightLeader.setInverted(true);

    m_robotDrive = new DifferentialDrive(leftLeader::set, rightLeader::set);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_driveForwardAuto = m_robotContainer.getDriveForwardAuto();
    m_driveIntervalAuto = m_robotContainer.getDriveIntervalAuto();
    // schedule the autonomous command (example)
    if (m_driveForwardAuto != null) {
      m_driveForwardAuto.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_driveForwardAuto != null) {
      m_driveForwardAuto.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
