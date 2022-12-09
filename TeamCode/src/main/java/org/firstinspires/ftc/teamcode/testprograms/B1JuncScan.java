package org.firstinspires.ftc.teamcode.testprograms;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;


import org.firstinspires.ftc.teamcode.utils.Encoders;
import org.firstinspires.ftc.teamcode.utils.hardware;

import java.util.List;

@Autonomous(name= "Blue 1 Hgh Junction Scan")
public class B1JuncScan extends LinearOpMode {

    hardware robot = new hardware();
    ElapsedTime runtime = new ElapsedTime();
    Encoders encoders = new Encoders(robot,/*true,*/ runtime);

    private static final String TFOD_MODEL_ASSET = "PowerPlay.tflite";

    private static final String[] LABELS = {
            "narya",
            "nenya",
            "vilya"
    };

    private static final String VUFORIA_KEY =
            "AS34pyX/////AAAAGaIrZJw2gU9xsxqfbnnb+NRMmLab5C2kQ5nc5YQr0V2hS3svZx7pBKzTz+ivN1giF42Wv8bBcm9gKE69/IPfrHT/nmBsKSyBmg5x0lkmlzYZ16vcd8R8hR6+q97ki1Sn/tjGlKalYvYSL+326CcR1EiJ3C7dWYujBqTJwsqySEXcqrn4ieiQJ4lY8/+U6dBTx/OkBvXxAMgJHl+Qjz5o6TUtQX4WolbO9mOD0bZFdTwSwyzycdKDNXLUjABOcdnx2foEvJqcVPOCfHEh8FEZRHpDB5RLgIqF1kwxCfFXx7MVflrtoLet/e6l9PdmC8nIk5Oo9cC9C6hF8L79A52YouscEKTWVx9pmqPgRYDhXUux";

    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    String ringParkLocation;


    @Override
    public void runOpMode() throws InterruptedException {

        initVuforia();
        initTfod();

        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/
        if (tfod != null) {
            tfod.activate();
            tfod.setZoom(1.0, 4.0/3.0);
        }

        robot.init(hardwareMap);

        robot.Left_Bottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Left_Top.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Right_Bottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Right_Top.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.intakeIn(1);
        encoders.encoderSlider(0.5,1,1,opModeInInit());

        waitForStart();

        if (tfod != null) {
            // getUpdatedRecognitions() will return null if no new information is available since
            // the last time that call was made.
            List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
            if (updatedRecognitions != null) {
                telemetry.addData("# Objects Detected", updatedRecognitions.size());
                ringParkLocation = updatedRecognitions.get(0).getLabel();

            }
        }

        encoders.encoderDrive(0.3,-25,-25,-25,-25,7, opModeIsActive());
        encoders.encoderDrive(0.3,-38,38,-38,38,7, opModeIsActive());
        encoders.encoderSlider(0.7,32,4, opModeIsActive());
        robot.Slider.setPower(0.1);
        encoders.encoderDrive(0.2,-4,-4,-4,-4,4, opModeIsActive());
        sleep(500);
        robot.intakeOut(1);
        encoders.encoderDrive(0.2,5,5,5,5,4, opModeIsActive());
        encoders.encoderSlider(0.5,-34,4, opModeIsActive());
        encoders.encoderDrive(0.5,12,-12,12,-12,3, opModeIsActive());
        switch (ringParkLocation){
            case "nenya":

                break;

            case "narya":

                break;

            case "vilya":
                break;

        }

    }

    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }


    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.75f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 300;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);

        // Use loadModelFromAsset() if the TF Model is built in as an asset by Android Studio
        // Use loadModelFromFile() if you have downloaded a custom team model to the Robot Controller's FLASH.
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
        // tfod.loadModelFromFile(TFOD_MODEL_FILE, LABELS);
    }
}