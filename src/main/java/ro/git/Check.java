package ro.git;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Check {
   static Stage window;
   static boolean result;
    public static boolean checkOnMenu(String titlu, String message){

    window = new Stage();
    window.setMinHeight(300);
    window.setMinWidth(300);
    window.setTitle(titlu);
    window.initModality(Modality.APPLICATION_MODAL);

    Button close = new Button("No");
    close.setOnAction(event -> {

        window.close();
        result = false;
    });
    Button save = new Button("Yes");
    save.setOnAction(event -> {
        result=true;
        window.close();
    });




    Label label = new Label(message);

    VBox layout = new VBox(20);
    layout.getChildren().addAll(label,save,close);
    layout.setAlignment(Pos.TOP_CENTER);
    Scene scene = new Scene(layout);

    window.setScene(scene);
    window.showAndWait();

    return result;
}
}
