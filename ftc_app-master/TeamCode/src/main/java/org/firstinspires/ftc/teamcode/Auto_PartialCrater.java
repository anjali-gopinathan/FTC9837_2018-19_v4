package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

/**
 * Created by Anjali on 12/9/2018.
 */
@Disabled
//@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto partially crater park USE THIS", group="Pushbot")
public class Auto_PartialCrater extends LinearOpMode{
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();
    public void runOpMode(){

        gobbler.init(hardwareMap);

        waitForStart();

        //Go forward
        gobbler.leftDrive.setPower(-1.0);
        gobbler.rightDrive.setPower(-1.0);
        sleep(20000);

        //stop
        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);

        //raise arm
        gobbler.armMotorLeft.setPower(1.0);
        gobbler.armMotorRight.setPower(1.0);
        sleep(500);
        //stop raising arm
        gobbler.armMotorLeft.setPower(0.0);
        gobbler.armMotorRight.setPower(0.0);

        //extend intake
        gobbler.extendIntakeMotor.setPower(1.0);
        sleep(1300);

        gobbler.leftDrive.setPower(0.0);
        gobbler.rightDrive.setPower(0.0);
        gobbler.extendIntakeMotor.setPower(0.0);
        gobbler.armMotorLeft.setPower(0.0);
        gobbler.armMotorRight.setPower(0.0);

    }
}
