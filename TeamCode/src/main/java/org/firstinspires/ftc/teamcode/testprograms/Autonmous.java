package org.firstinspires.ftc.teamcode.testprograms;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utils.Encoders;
import org.firstinspires.ftc.teamcode.utils.hardware;

@Autonomous(name= "Blue1 Junction Only")
public class Autonmous extends LinearOpMode {

    hardware robot = new hardware();
    ElapsedTime runtime = new ElapsedTime();
    Encoders encoders = new Encoders(robot,true, runtime);

    @Override
    public void runOpMode() throws InterruptedException {



        robot.init(hardwareMap);

        robot.Left_Bottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Left_Top.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Right_Bottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Right_Top.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        encoders.encoderDrive(0.05,-24,-24,-24,-24,3);
        encoders.encoderDrive(0.05,-36,36,-36,36,3);
        encoders.encoderSlider(0.7,34,6);
        robot.Slider.setPower(0.1);
        encoders.encoderDrive(0.05,-9,-9,-9,-9,2);
        robot.intakeOut(1);
        encoders.encoderDrive(0.5,9,9,9,9,2);
        encoders.encoderSlider(0.5,-34,6);

    }
}