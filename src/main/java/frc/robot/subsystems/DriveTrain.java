// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class DriveTrain extends SubsystemBase {

  // Parts of the Robot
  private static WPI_TalonSRX frontright = new WPI_TalonSRX(Constants.frontrightmotor); 
  private static WPI_TalonSRX frontleft = new WPI_TalonSRX(Constants.frontleftmotor);
  private static WPI_TalonSRX backright = new WPI_TalonSRX(Constants.backrightmotor);
  private static WPI_TalonSRX backleft = new WPI_TalonSRX(Constants.backleftmotor); 

  // Differentiating the front right and left motors
  public static DifferentialDrive D = new DifferentialDrive(backright, backleft);

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    // Setting neutral modes for the parts
    frontright.setNeutralMode(NeutralMode.Coast);
    frontleft.setNeutralMode(NeutralMode.Coast);
    backright.setNeutralMode(NeutralMode.Coast);
    backleft.setNeutralMode(NeutralMode.Coast);


    
    // to set the back wheels to follow the front wheels
    backright.follow(frontright);
    backleft.follow(frontleft);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double forward, double turn) {
    D.arcadeDrive(forward, turn);
    
  }
    
}
