package ro.git;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    static Stage window;
    static boolean answer;

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
        int result  = number1*number2 ;

        return  result;
    }



}
