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

            boolean liftUp = gamepad1.dpad_up;
            boolean lowerDown = gamepad1.dpad_down;

            boolean rotateTwisterUp = gamepad1.dpad_right;
            boolean rotateTwisterDown = gamepad1.dpad_left;

            tank.leftDrive.setPower(gamepad1.left_stick_y);
            tank.rightDrive.setPower(-gamepad1.right_stick_y);

            if (liftUp){
                tank.liftUpMotor.setPower(1.0);
            }
            else if (lowerDown){
                tank.liftUpMotor.setPower(-1.0);
            }
            else {
                tank.liftUpMotor.setPower(0.0);
            }

            if(rotateTwisterUp){
                tank.rotateTwister.setPosition(tank.rotateTwister.getPosition() >= 0.98 ? 1.0 : tank.rotateTwister.getPosition() + .02);
            }
            else if(rotateTwisterDown){
                tank.rotateTwister.setPosition(tank.rotateTwister.getPosition() <= 0.02 ? 0.0 : tank.rotateTwister.getPosition() - .02);
            }
            else{
                tank.rotateTwister.setPosition(tank.rotateTwister.getPosition());
            }



        }

    }
}
