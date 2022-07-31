package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Lab8.fxml"));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(40);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setTitle("RSA Encryption and Decryption");
        primaryStage.setScene(scene);
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        Text actionTarget = new Text();
        grid.add((actionTarget), 0, 1);
        Button gen = new Button("Generate RSA Keys");
        gen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int p = Integer.parseInt(t1.getText());
                int q = Integer.parseInt(t2.getText());
                int e = Integer.parseInt(t3.getText());
                int x = Integer.parseInt(t4.getText());
                int n = p*q;
                int phiN = (p-1)*(q-1);
                int d = RSA.eea(e, phiN);
                int enc = RSA.encryption(x, e, n);
                int dec = RSA.decryption(enc, d, n);
                actionTarget.setText("The private key is: "+String.valueOf(d)+"\nThe public key is: ("+String.valueOf(n)+", "+String.valueOf(d)+")"
                +"\nEncryption: " +enc+"\nDecryption: " +dec);}
        });
        grid.add(t1, 0, 0);
        grid.add(t2, 1, 0);
        grid.add(t3, 2, 0);
        grid.add(gen, 0, 2);
        grid.add(t4, 3, 0);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
