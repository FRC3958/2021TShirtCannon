// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arduino extends SubsystemBase {
  private static DigitalOutput pinOne = new DigitalOutput(Constants.pineZeroChannel); 
  private static DigitalOutput pinTwo = new DigitalOutput(Constants.pineOneChannel); 
  private static DigitalOutput pinThree = new DigitalOutput(Constants.pineTwoChannel); 
  private static DigitalInput pinFour = new DigitalInput(Constants.pinThreeChannel); 

  /** Creates a new Arduino. */
  public Arduino() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(pinFour.get() && pinOne.get()) {
      clearAllPins();
    }
  }

  public void test() {
    System.out.println("test was called"); 
    pinOne.set(true); 
    pinTwo.set(false); 
    pinThree.set(true); 


  }

  public void setToNumber(int n, int o) {
    pinOne.set(true); 
    pinTwo.set(n==1);
    pinThree.set(o==1); 
  }


  public void clearAllPins() {
    pinOne.set(false); 
    pinTwo.set(false); 
    pinThree.set(false); 
    System.out.println("cleared output");
    
  }
}
