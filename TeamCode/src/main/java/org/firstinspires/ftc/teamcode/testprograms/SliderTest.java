package org.firstinspires.ftc.teamcode.testprograms;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.utils.*;

@Disabled
@Autonomous
public class SliderTest extends LinearOpMode {
//    private ElapsedTime runtime = new ElapsedTime();
//    hardware robot = new hardware();
//    Encoders encoders = new Encoders(robot,opModeIsActive(), runtime);

    @Override
    public void runOpMode() throws InterruptedException {

        ElapsedTime runtime = new ElapsedTime();
        hardware robot = new hardware();
        Encoders encoders = new Encoders(robot,/*true,*/ runtime);


        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            encoders.encoderSlider(0.7,10,3, opModeIsActive());

            encoders.encoderSlider(0.5,-10,3, opModeIsActive());


        }
    }
}
