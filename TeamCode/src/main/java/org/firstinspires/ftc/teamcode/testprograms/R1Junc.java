package org.firstinspires.ftc.teamcode.testprograms;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.customutils.Encoders;
import org.firstinspires.ftc.teamcode.customutils.hardware;

@Autonomous(name= "red 1 Junction")
public class R1Junc extends LinearOpMode {

    hardware robot = new hardware();
    ElapsedTime runtime = new ElapsedTime();
    Encoders encoders = new Encoders(robot,/*true,*/ runtime);

    @Override
    public void runOpMode() throws InterruptedException {



        robot.init(hardwareMap);

        robot.Left_Bottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Left_Top.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Right_Bottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Right_Top.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.intakeIn(1);
        encoders.encoderSlider(0.5,1,1,opModeInInit());

        waitForStart();

        encoders.encoderDrive(0.3,-25,-25,-25,-25,7, opModeIsActive());
        encoders.encoderDrive(0.3,38,-38,38,-38,7, opModeIsActive());
        encoders.encoderSlider(0.7,32,4, opModeIsActive());
        robot.Slider.setPower(0.1);
        encoders.encoderDrive(0.2,-4,-4,-4,-4,4, opModeIsActive());
        sleep(500);
        robot.intakeOut(1);
        encoders.encoderDrive(0.2,5,5,5,5,4, opModeIsActive());
        encoders.encoderSlider(0.5,-34,4, opModeIsActive());
        encoders.encoderDrive(0.5,-12,12,-12,12,3, opModeIsActive());

    }
}