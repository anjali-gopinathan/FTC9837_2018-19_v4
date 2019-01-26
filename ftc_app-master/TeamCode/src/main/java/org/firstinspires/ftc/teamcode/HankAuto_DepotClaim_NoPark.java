package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 12/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Tank Auto: Depot Claim Only", group="Pushbot")
public class HankAuto_DepotClaim_NoPark extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){
        long turn135deg_ms = 1350;
        long turn45deg_ms = 435;
        double distance_const = 10.15;
        long a1_cm = 269;
        tank.init(hardwareMap);

        waitForStart();

        //lower
//        tank.liftUpMotor.setPower(-1.0);
//        sleep() //lower: 9 sec
        //raise: 8.5
        //Go forward
        tank.leftDrive.setPower(1.0);
        tank.rightDrive.setPower(1.0);
        sleep(2900);

        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);
        sleep(500);
        //Drop off marker
        tank.markerPusher.setPosition(1.0);
        //turn right because why not
        sleep(1000);
        tank.leftDrive.setPower(-1.0);
        tank.rightDrive.setPower(1.0);
        sleep(turn45deg_ms);

        //stop
        tank.leftDrive.setPower(0.0);
        tank.rightDrive.setPower(0.0);

    }
}
