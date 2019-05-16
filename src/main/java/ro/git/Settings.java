package ro.git;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Settings {
    static Stage window;
    static boolean answer;
    static private GridPane gridPane;
    static private Button login,close;



    public static void closeProgramAndSave(Stage window) {
         answer = Check.checkOnMenu("Save" ,"Do you want this save documnet");
        if (answer){
            System.out.println("This file is saved");
            window.close();
        }
        else {
            System.out.println("This file is not saved");
            window.close();
        }
    }
    public static boolean inti(TextField text, String message){
        try {

            int result = Integer.parseInt(text.getText());
            System.out.println("Number the Text is " + result);
            return true;
        }catch (NumberFormatException e){
            System.out.println("You insert a wrong field " + message +" corrects!");
            return false;
        }

    }
    static List<Integer> num = new ArrayList<>();

    public static long calcSum(long number1, long number2){
        long result  = number1+number2 ;

        return  result;
    }
    public static long calcSub(long number1, long number2){

        long result  = number2-number1 ;
        return  result;
    }
    public static long calcSubRev(long number1, long number2){

        long result  = number1-number2 ;
        return  result;
    }
    public static long calcDivizi(long number1, long number2){
        long result  = number1/number2 ;

        return  result;
    }
    public static long calcRemainder(long number1, long number2){
        long result  = number1%number2 ;

        return  result;
    }
    public static long calcMultiply(long number1, long number2){
        long result  = number1*number2 ;

        return  result;
    }


    static void loginAction(Label label,Label label1, Label number1, TextField numberInput1, Label number2, TextField number1Input2, Button login, GridPane gridPane, Button close) {
        login.setOnAction(event -> {
                    try {


                        Long nmb1 = Long.parseLong(number1Input2.getText());
                        long s = binar(nmb1);
                        long nmb2 = Integer.parseInt(numberInput1.getText());
                        long d = binar(nmb2);
                        long nmb3 = Settings.calcSum(d,s);
                        long divizi = Settings.calcDivizi(d,s);
                        long multiply = Settings.calcMultiply(d,s);
                        long remainder = Settings.calcRemainder(d,s);
                        long sub = Settings.calcSub(s,d);
                        long subRev = Settings.calcSubRev(d,s);
                        event.consume();
                        GridPane.setConstraints(label,1,12);
                        GridPane.setConstraints(label1,2,12);

                        label.setTextFill(Color.FIREBRICK);

                        label.setText("Result binary :------> "+ Long.toBinaryString(nmb2) + " + " +Long.toBinaryString(nmb1) + " = " + Long.toBinaryString(nmb3)+"\n"+
                                "Result binary :------> "+ Long.toBinaryString(nmb2) + " / " +Long.toBinaryString(nmb1) + " = " + Long.toBinaryString(divizi)+"\n"+
                                "Result binary :------> "+ Long.toBinaryString(nmb2) + " * " +Long.toBinaryString(nmb1) + " = " + Long.toBinaryString(multiply)+"\n"+
                                "Result binary :------> "+ Long.toBinaryString(nmb2) + " % " +Long.toBinaryString(nmb1) + " = " + Long.toBinaryString(remainder)+"\n"+
//                                "Result binary :------> "+ Long.toBinaryString(nmb2) + " - " +Long.toBinaryString(nmb1) + " = " + Long.toBinaryString(sub)+"\n"+
                                "Result binary :------> "+ Long.toBinaryString(nmb1) + " - " +Long.toBinaryString(nmb2) + " = " + Long.toBinaryString(sub)+"\n"
                        );
                        label1.setTextFill(Color.FIREBRICK);
                        label1.setText("Result :------> "+ d + " + " + s + " = " + nmb3+"\n"+
                                "Result :------> "+ d + " / " + s + " = " +divizi+"\n"+
                                "Result :------> "+ d + " * " + s + " = " + multiply+"\n"+
                                "Result :------> "+ d + " % " + s + " = " + remainder+"\n"+
                                "Result :------> "+ s + " - " + d + " = " + sub+"\n"+
                                "Result :------> "+ d + " - " + s + " = " + subRev+"\n");

                    }
                    catch (NumberFormatException e){
                        System.out.println("Nu ai introdus ce trb");
                    }
                }
        );


        gridPane.getChildren().addAll(label,label1,number1,numberInput1,number2,number1Input2, login, close);
    }

    public static long binar( long binar){
//        Scanner sc = new Scanner(System.in);
        long decimalNumber = 0, j = 1, remainder;
//        System.out.print("Input a binary number: ");
//        binar = sc.nextLong();

        while (binar != 0)
        {
            remainder = binar % 10;
            decimalNumber = decimalNumber + remainder * j;
            j = j * 2;
            binar = binar / 10;
        }
        return decimalNumber;

    }


}
