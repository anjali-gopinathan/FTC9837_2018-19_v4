package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Anjali on 1/18/2019.
 */
@TeleOp(name="TeleOp: Tank", group="Linear Opmode")
public class TestingTankTreads_TeleOp extends LinearOpMode{
    HardwareConfigTankTreads tank = new HardwareConfigTankTreads();
    public void runOpMode(){
        tank.init(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            tank.leftDrive.setPower(gamepad1.left_stick_y);
            tank.rightDrive.setPower(-gamepad1.right_stick_y);
        }

    }
}
