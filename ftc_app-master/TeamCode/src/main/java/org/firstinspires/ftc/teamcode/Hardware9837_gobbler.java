package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Anjali on 10/19/2018.
 */

class Hardware9837_gobbler {
    //Drive train:
    DcMotor rightDrive;
    DcMotor leftDrive;

    //arm, intake, extend intake
    DcMotor intakeMotor;
    DcMotor extendIntakeMotor;

    DcMotor armMotorLeft;
    DcMotor armMotorRight;

    ColorSensor colorSensorLeft;
    ColorSensor colorSensorRight;

    //Pushes marker into depot
    Servo markerPusher;

    //Pulls up robot
    DcMotor liftUpMotor;        //twister
    Servo rotateTwister;     //inside = closer to inside of robot

    //HardwareMap hwMap = null;
    //private ElapsedTime period  = new ElapsedTime();

    public void init(HardwareMap hwMap){
        //set direction of motors facing opposite directions
        rightDrive = hwMap.dcMotor.get("rightDrive");   //port zero hub A
        leftDrive = hwMap.dcMotor.get("leftDrive");     //port 1 hub A

        colorSensorLeft = hwMap.colorSensor.get("colorSensorLeft");
        colorSensorRight = hwMap.colorSensor.get("colorSensorRight");
//
        markerPusher = hwMap.servo.get("marker pusher");
        markerPusher.setPosition(0.75);
//
        intakeMotor = hwMap.dcMotor.get("intake");          //port 0 hub b
        armMotorLeft = hwMap.dcMotor.get("arm left motor"); // port 2 hub A
        armMotorRight = hwMap.dcMotor.get("arm rightol motor");//port 3 hub A
        extendIntakeMotor = hwMap.dcMotor.get("extend intake");//port 1 hub b
        //set brakes on motor
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extendIntakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //lift motor set to current configuration
        liftUpMotor = hwMap.dcMotor.get("lift motor");
//
        rotateTwister = hwMap.servo.get("rotate twister");
        rotateTwister.setPosition(0);


        //Dcmotors: CW by default   cw on left side = forward
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setDirection(DcMotor.Direction.FORWARD);

        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
        armMotorLeft.setDirection(DcMotor.Direction.FORWARD);
        armMotorRight.setDirection(DcMotor.Direction.REVERSE);

        extendIntakeMotor.setDirection(DcMotor.Direction.FORWARD);

        liftUpMotor.setDirection(DcMotor.Direction.FORWARD);

        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        //set pwr to 0
        rightDrive.setPower(0.0);
        leftDrive.setPower(0.0);
        intakeMotor.setPower(0.0);
        armMotorLeft.setPower(0.0);
        armMotorRight.setPower(0.0);
        extendIntakeMotor.setPower(0.0);
        liftUpMotor.setPower(0.0);
        

    }
}
