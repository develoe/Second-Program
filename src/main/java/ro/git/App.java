package ro.git;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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

        Display display = new Display().invoke();
        Label label = display.getLabel();
        Label number1 = display.getNumber1();
        TextField numberInput1 = display.getNumberInput1();
        Label number2 = display.getNumber2();
        TextField number1Input2 = display.getNumber1Input2();


        Settings.loginAction(label, number1, numberInput1, number2, number1Input2, login, gridPane, close);


        Scene scene = new Scene(gridPane);

        window.setScene(scene);
        window.show();

    }

    private class Display {
        private Label label;
        private Label number1;
        private TextField numberInput1;
        private Label number2;
        private TextField number1Input2;

        public Label getLabel() {
            return label;
        }

        public Label getNumber1() {
            return number1;
        }

        public TextField getNumberInput1() {
            return numberInput1;
        }

        public Label getNumber2() {
            return number2;
        }

        public TextField getNumber1Input2() {
            return number1Input2;
        }

        public Display invoke() {
            gridPane.setPadding(new Insets(12,12,12,12));


            label = new Label("Calculate Binary");
            GridPane.setConstraints(label,1,0);

            // TODO  Number


            number1 = new Label("Number 1 ");
            GridPane.setConstraints(number1,0,1);
            // Input
            numberInput1 = new TextField("0");
            GridPane.setConstraints(numberInput1,1,1);


            number2 = new Label("Number 2");
            GridPane.setConstraints(number2,0,3);
            // Input
            number1Input2 = new TextField("0");
            GridPane.setConstraints(number1Input2,1,3);

            login = new Button("Login");
            close = new Button("Close");
            GridPane.setConstraints(login,2,7);
            GridPane.setConstraints(close,3,7);

            close.setOnAction(event ->  {
                event.consume();
                Settings.closeProgramAndSave(window);
            });
            return this;
        }
    }


//


}
