package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Anjali on 1/18/2019.
 */

public class HardwareConfigTankTreads {

    DcMotor leftDrive;
    DcMotor rightDrive;

    public void init(HardwareMap hwMap){
        leftDrive = hwMap.dcMotor.get("leftdrive");
        rightDrive = hwMap.dcMotor.get("rightdrive");

        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
