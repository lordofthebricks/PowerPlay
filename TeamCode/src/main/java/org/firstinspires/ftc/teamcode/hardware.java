package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class hardware {

    //motors
    public DcMotor Right_Bottom;
    public DcMotor Right_Top;
    public DcMotor Left_Bottom;
    public DcMotor Left_Top;
    public DcMotor Spinner;

    HardwareMap hwMap = null;

    public void init(HardwareMap ahwMap){

        hwMap = ahwMap;
        Right_Bottom = hwMap.get(DcMotor.class, "Right_Bottom");
        Right_Top = hwMap.get(DcMotor.class, "Right_Top");
        Left_Bottom = hwMap.get(DcMotor.class, "Left_Bottom");
        Left_Top = hwMap.get(DcMotor.class, "Left_Top");
        Spinner = hwMap.get(DcMotor.class, "Spinner");

    }



}
