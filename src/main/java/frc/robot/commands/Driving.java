// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class Driving extends CommandBase {
  /** Creates a new Driving. */
  private DriveTrain DT;
  private XboxController XC;

  public Driving(DriveTrain TD, XboxController CX) {
    // Use addRequirements() here to declare subsystem dependencies.
    DT = TD; 
    XC = CX;

    addRequirements(TD);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speedLimit = SmartDashboard.getNumber("Speed", 0.75);
    DT.drive(-1*XC.getRawAxis(Constants.LeftJoyStickYAxis)*speedLimit, XC.getRawAxis(Constants.RightJoyStickXAxis)*speedLimit); 

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;

  }
}
