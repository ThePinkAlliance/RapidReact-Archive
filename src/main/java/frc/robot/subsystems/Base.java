// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.swervedrivespecialties.swervelib.Mk4ModuleConfiguration;
import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Base extends SubsystemBase {
    private AHRS gyro = new AHRS();

  private static final double MAX_VOLTAGE = 12.0;
  public static final double MAX_VELOCITY_METERS_PER_SECOND = 4.14528;
  public static final double MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND = MAX_VELOCITY_METERS_PER_SECOND
      / Math.hypot(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0);

  private final SwerveModule frontLeftModule;
  private final SwerveModule frontRightModule;
  private final SwerveModule backLeftModule;
  private final SwerveModule backRightModule;

  private final SwerveDriveKinematics kinematics = new SwerveDriveKinematics(
    new Translation2d(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
    new Translation2d(Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
    new Translation2d(-Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0),
    new Translation2d(-Constants.DRIVETRAIN_TRACKWIDTH_METERS / 2.0, -Constants.DRIVETRAIN_WHEELBASE_METERS / 2.0));

  private Mk4ModuleConfiguration configuration = new Mk4ModuleConfiguration();


  /** Creates a new Base. */
  public Base() {
    ShuffleboardTab  tab = Shuffleboard.getTab("Drivetrain");

    this.backRightModule = Mk4SwerveModuleHelper.createFalcon500(tab.getLayout("Back Right Module", BuiltInLayouts.kList).withSize(2, 4).withPosition(0, 0), configuration, Mk4SwerveModuleHelper.GearRatio.L1, 
      Constants.BACK_RIGHT_DRIVE_MOTOR_PORT,
      Constants.BACK_RIGHT_STEER_MOTOR_PORT,
      Constants.BACK_RIGHT_CANCODER_ID,
      Constants.BACK_RIGHT_MODULE_STEER_OFFSET);

    this.backLeftModule = Mk4SwerveModuleHelper.createFalcon500(tab.getLayout("Back Left Module", BuiltInLayouts.kList).withSize(2, 4).withPosition(1, 0), configuration, Mk4SwerveModuleHelper.GearRatio.L1, 
      Constants.BACK_LEFT_DRIVE_MOTOR_PORT,
      Constants.BACK_LEFT_STEER_MOTOR_PORT,
      Constants.BACK_LEFT_CANCODER_ID,
      Constants.BACK_LEFT_MODULE_STEER_OFFSET);
      
    this.frontRightModule = Mk4SwerveModuleHelper.createFalcon500(tab.getLayout("Front Right Module", BuiltInLayouts.kList).withSize(2, 4).withPosition(2, 0), configuration, Mk4SwerveModuleHelper.GearRatio.L1, 
      Constants.FRONT_LEFT_DRIVE_MOTOR_PORT,
      Constants.FRONT_LEFT_STEER_MOTOR_PORT,
      Constants.FRONT_LEFT_CANCODER_ID,
      Constants.FRONT_LEFT_MODULE_STEER_OFFSET);

    this.frontLeftModule = Mk4SwerveModuleHelper.createFalcon500(tab.getLayout("Front Left Module", BuiltInLayouts.kList).withSize(2, 4).withPosition(3, 0), configuration, Mk4SwerveModuleHelper.GearRatio.L1, 
      Constants.BACK_RIGHT_DRIVE_MOTOR_PORT,
      Constants.BACK_RIGHT_STEER_MOTOR_PORT,
      Constants.BACK_RIGHT_CANCODER_ID,
      Constants.BACK_RIGHT_MODULE_STEER_OFFSET);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
