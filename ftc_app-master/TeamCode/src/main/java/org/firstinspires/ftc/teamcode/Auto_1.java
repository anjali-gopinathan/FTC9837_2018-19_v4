package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

/**
 * Created by Anjali on 11/28/2018.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Auto testing tracking", group="Pushbot")
public class Auto_1 extends LinearOpMode{
    Hardware9837_gobbler gobbler = new Hardware9837_gobbler();
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AcPpQr7/////AAABmRuQqklau0F7hH15ovElLi8g8xxcFH4hzU6JHV7txfq4WXoLctKsuwc8XqSq/SU10A1VnIUj5HXdhG5Ni8/2X8Z+dWSe4pyn1lwj/Bc7nLV5+6j/8I1wKUrZ6wrjclDvcv+lz/W+TQDnrcLXYOLB8b3/voF9/xd/xTZFi5P2oaA/AOokm2IuadPdTJw1iyEujqs6RJM20C1Kjd9v0FSG07oUlImhPuSV18p/JoP/isRgxQLDxKpGluZbvWZm7yITMciaJ9uPvh7O48UiEzfeOupsFbHIUb0C7DgyzmFTEPwjIuQXbNLZik+IB0upOVabS4Lh572YxBj2rv30Icw99tGVaioIMk2LkoVxI9SH6LdH";

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    private VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the Tensor Flow Object
     * Detection engine.
     */
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {
        int moveTime=100;    //miliseconds

        gobbler.init(hardwareMap);

        waitForStart();


//        telemetry.addData("left RGB: (" + geary.colorSensorLeft.red() + ", " + geary.colorSensorLeft.green() + ", " + geary.colorSensorLeft.blue() + ")", 0);
//        telemetry.addData("right RGB: (" + geary.colorSensorRight.red() + ", " + geary.colorSensorRight.green() + ", " + geary.colorSensorRight.blue() + ")", 0);

        gobbler.leftMotor.setPower(1.0);
        gobbler.rightMotor.setPower(1.0);

        //While left blue is small, keep moving forward.
//        while (     (geary.colorSensorLeft.blue() < 150)// && !(geary.colorSensorLeft.blue()>geary.colorSensorLeft.red() && geary.colorSensorLeft.blue() > geary.colorSensorLeft.green()))
//                &&  (geary.colorSensorRight.blue() < 150)// && geary.colorSensorRight.blue()>geary.colorSensorRight.red() && geary.colorSensorRight.blue() > geary.colorSensorRight.green())
//              ){
        // If the blue value is low on both sensors
        moveTime+=100;
//        }
        sleep(moveTime);

        while (opModeIsActive() && gobbler.leftMotor.isBusy())
        {
            telemetry.addData("encoder-fwd", gobbler.leftMotor.getCurrentPosition() + "  busy=" + gobbler.leftMotor.isBusy());
            telemetry.update();
            idle();
        }

        



        gobbler.leftMotor.setPower(0.0);
        gobbler.rightMotor.setPower(0.0);
        sleep(1000);

        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        initVuforia();

        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        /** Wait for the game to begin */
        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
            /** Activate Tensor Flow Object Detection. */
            if (tfod != null) {
                tfod.activate();
            }

            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        if (updatedRecognitions.size() == 3) {
                            int goldMineralX = -1;
                            int silverMineral1X = -1;
                            int silverMineral2X = -1;
                            for (Recognition recognition : updatedRecognitions) {
                                if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                    goldMineralX = (int) recognition.getLeft();
                                } else if (silverMineral1X == -1) {
                                    silverMineral1X = (int) recognition.getLeft();
                                } else {
                                    silverMineral2X = (int) recognition.getLeft();
                                }
                            }
                            if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                                if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Left");
                                } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                    telemetry.addData("Gold Mineral Position", "Right");
                                } else {
                                    telemetry.addData("Gold Mineral Position", "Center");
                                }
                            }
                        }
                        telemetry.update();
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }

    /**
     * Initialize the Tensor Flow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
    }

}
