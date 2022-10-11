package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
        Right_Bottom = hwMap.get(DcMotor.class, "Right Back");
        Right_Top = hwMap.get(DcMotor.class, "Right Front");
        Left_Bottom = hwMap.get(DcMotor.class, "Left Back");
        Left_Top = hwMap.get(DcMotor.class, "Left Front");
        Spinner = hwMap.get(DcMotor.class, "Spinner");
        Right_Top.setDirection(DcMotor.Direction.REVERSE);
        Right_Bottom.setDirection(DcMotor.Direction.REVERSE);
    }



}
