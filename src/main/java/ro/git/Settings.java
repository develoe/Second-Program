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

public class Settings {
    static Stage window;
    static boolean answer;
    static private GridPane gridPane;
    static private Button login,close;


    public static void closeProgram(){
        System.out.println("This file is not save");
        window.close();
    }
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

    public static int calcSum(int number1, int number2){
        int result  = number1+number2 ;

        return  result;
    }


    static void loginAction(Label label, Label number1, TextField numberInput1, Label number2, TextField number1Input2, Button login, GridPane gridPane, Button close) {
        login.setOnAction(event -> {
                    try {


                        int nmb1 = Integer.parseInt(number1Input2.getText());
                        int nmb2 = Integer.parseInt(numberInput1.getText());
                        int nmb3 = Settings.calcSum(nmb1,nmb2);
                        event.consume();
                        GridPane.setConstraints(label,1,12);

                        label.setTextFill(Color.FIREBRICK);

                        label.setText("Result :------> "+ Integer.toBinaryString(nmb2) + " + " +Integer.toBinaryString(nmb1) + " = " + Integer.toBinaryString(nmb3));
                    }
                    catch (NumberFormatException e){
                        System.out.println("Nu ai introdus ce trb");
                    }
                }
        );


        gridPane.getChildren().addAll(label,number1,numberInput1,number2,number1Input2, login, close);
    }


}
