package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Anjali on 11/9/2018.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto color sensor test BLUE", group="Pushbot")
public class Auto_TestingColorSensorTape_BLUE extends LinearOpMode{
    Hardware9837_geary_v3 geary = new Hardware9837_geary_v3();

    public void runOpMode() {
        geary.init(hardwareMap);

        waitForStart();
        geary.leftMotor.setPower(1.0);
        geary.rightMotor.setPower(1.0);

        telemetry.addData("left RGB: (" + geary.colorSensorLeft.red() + ", " + geary.colorSensorLeft.green() + ", " + geary.colorSensorLeft.blue()  +")", 0);
        telemetry.addData("right RGB: (" + geary.colorSensorRight.red() + ", " + geary.colorSensorRight.green() + ", " + geary.colorSensorRight.blue()  +")", 0);
        sleep(2000);


        geary.leftMotor.setPower(0.0);
        geary.rightMotor.setPower(0.0);
    }


}
