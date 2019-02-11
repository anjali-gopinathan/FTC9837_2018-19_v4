package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 1/26/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="C Tank Auto: Lower + park", group="Pushbot")
public class HankAuto_LowerAndPark extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){

        tank.init(hardwareMap);

        waitForStart();

        //lower
        tank.liftUpMotor.setPower(1.0);
        sleep( 5300);//lower: 4 sec; 4.75, 4.82,
        tank.liftUpMotor.setPower(0.0);
        sleep(500);
        //raise: 8.5
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(1800);

        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(-1.0);
        sleep(1000);

        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(5000);

        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);

    }
}
