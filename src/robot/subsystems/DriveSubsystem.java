/*
 *	  Copyright (C) 2022  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */


package robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Device;
import robotCore.Encoder;
import robotCore.PWMMotor;
import robotCore.Encoder.EncoderType;
import static robot.Constants.DrivetrainConstants.*;

public class DriveSubsystem extends SubsystemBase {
  
  private final PWMMotor m_leftMotor = new PWMMotor(k_leftMotorPWMPin, k_leftMotorDirPin);
  private final PWMMotor m_rightMotor = new PWMMotor(k_rightMotorPWMPin, k_rightMotorDirPin);
  private final Encoder m_rightEncoder = new Encoder(EncoderType.Quadrature, k_rightEncoderIntPin, k_rightEncoderDirPin);
  private final Encoder m_leftEncoder = new Encoder(EncoderType.Quadrature, k_leftEncoderIntPin, k_leftEncoderDirPin);

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    m_leftEncoder.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPower(double leftPower, double rightPower)
  {
      m_leftMotor.set(leftPower);
      m_rightMotor.set(rightPower);
  }

  public Encoder GetLeftEncoder() {
    return (m_leftEncoder);
  }

  public Encoder GetRightEncoder() {
    return (m_rightEncoder);
  }
}
