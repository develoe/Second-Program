package ro.git;


import com.sun.javafx.css.Size;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class App extends Application implements EventHandler<ActionEvent>
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
        window.setMinWidth(500);
        window.setMinHeight(500);
        window.setOnCloseRequest(event -> {
            event.consume();
           Settings.closeProgramAndSave(window);
        });

        gridPane.setPadding(new Insets(12,12,12,12));



        Label label = new Label("This is a main");
        GridPane.setConstraints(label,1,0);

        // TODO  User


        Label userName = new Label("User Name ");
        GridPane.setConstraints(userName,0,1);
        // Input
        TextField userInput = new TextField("a");
        GridPane.setConstraints(userInput,1,1);


        Label number1 = new Label("Number1 ");
        GridPane.setConstraints(number1,0,3);
        // Input
        TextField number1Input= new TextField("Number 2");
        GridPane.setConstraints(number1Input,1,3);


        // TODO Password
        Label password = new Label("Password");
        GridPane.setConstraints(password,0,4);
        // Input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput,1,4);

        login = new Button("Login");
        close = new Button("Close");
        GridPane.setConstraints(login,2,7);
        GridPane.setConstraints(close,3,7);

        close.setOnAction(event ->  {
          event.consume();
          GridPane.setConstraints(label,1,10);

          label.setTextFill(Color.FIREBRICK);
          label.setText("this is close");
        });


        login.setOnAction(event -> {
            try {


                int nmb1 = Integer.parseInt(number1Input.getText());
                int nmb2 = Integer.parseInt(userInput.getText());
                System.out.println(nmb1 + " + " + nmb2 + " = " + Settings.calcSum(nmb1, nmb2));
            }
            catch (NumberFormatException e){
                System.out.println("Nu ai introdus ce trb" + e);
            }
            }
            );


        gridPane.getChildren().addAll(label,userName,userInput,number1,number1Input,password,passwordInput,login,close);


        Scene scene = new Scene(gridPane);

        window.setScene(scene);
        window.show();

    }


    @Override
    public void handle(ActionEvent event) {
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 8);
        actiontarget.setText("Sign in button pressed");



    }

//


}
