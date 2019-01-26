package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 12/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Tank Auto: Lower only", group="Pushbot")
public class HankAuto_Lower extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){

        tank.init(hardwareMap);

        waitForStart();

        //lower
        tank.liftUpMotor.setPower(1.0);
        sleep( 4750);//lower: 4 sec; 4.75, 4.82,
        //raise: 8.5
        tank.liftUpMotor.setPower(0.0);
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);

    }
}
