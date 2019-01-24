package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 12/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto: Tank Crater Park", group="Pushbot")
public class HankAuto_CraterPark extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){

        tank.init(hardwareMap);

        waitForStart();

        //Go forward
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(4750);

        //stop
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);

    }
}
