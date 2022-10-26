package org.firstinspires.ftc.teamcode.testprograms;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utils.Encoders;
import org.firstinspires.ftc.teamcode.utils.hardware;

@Autonomous
public class Autonmous extends LinearOpMode {

        hardware robot = new hardware();
        ElapsedTime runtime = new ElapsedTime();
        Encoders encoders = new Encoders(robot,true, runtime);
    @Override
    public void runOpMode() throws InterruptedException {

        hardware robot = new hardware();

        robot.init(hardwareMap);

        waitForStart();

        encoders.encoderDrive(0.8,-48,48,-48,48,4);
        encoders.encoderDrive(0.8,32,32,32,32,2);
    }
}