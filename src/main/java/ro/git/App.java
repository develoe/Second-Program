package ro.git;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * Hello world!
 *
 */
public class App extends Application
{   Stage window;
    public boolean result ;
    Button login,close;
    GridPane gridPane = new GridPane();


    public static void main( String[] args )
    {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Main");
        window.setMinWidth(700);
        window.setMinHeight(100);
        window.setOnCloseRequest(event -> {
            event.consume();
            Settings.closeProgramAndSave(window);
        });

        gridPane.setPadding(new Insets(12,12,12,12));



        Label label = new Label("Calculate Binary");
        GridPane.setConstraints(label,1,0);

        // TODO  User


        Label userName = new Label("Number 1 ");
        GridPane.setConstraints(userName,0,1);
        // Input
        TextField userInput = new TextField("0");
        GridPane.setConstraints(userInput,1,1);


        Label number1 = new Label("Number 2");
        GridPane.setConstraints(number1,0,3);
        // Input
        TextField number1Input= new TextField("0");
        GridPane.setConstraints(number1Input,1,3);

        login = new Button("Login");
        close = new Button("Close");
        GridPane.setConstraints(login,2,7);
        GridPane.setConstraints(close,3,7);

        close.setOnAction(event ->  {
            event.consume();
            Settings.closeProgramAndSave(window);
        });


        login.setOnAction(event -> {
            try {


                int nmb1 = Integer.parseInt(number1Input.getText());
                int nmb2 = Integer.parseInt(userInput.getText());
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


        gridPane.getChildren().addAll(label,userName,userInput,number1,number1Input,login,close);


        Scene scene = new Scene(gridPane);

        window.setScene(scene);
        window.show();

    }



//


}
