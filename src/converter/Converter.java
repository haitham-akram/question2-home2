/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Haitham
 */
public class Converter extends Application {
    RadioButton far;
    RadioButton kelv;
     TextField text;
     Label lab1;
    @Override
    public void start(Stage primaryStage) {
        Label lab = new Label("Enter Celsius temperature");
         lab1 = new Label("");
        text = new TextField();
         far = new RadioButton("Fahrenheit");
         kelv = new RadioButton("Kelvin");
        ToggleGroup group = new ToggleGroup();
        far.setToggleGroup(group);
        kelv.setToggleGroup(group);
        HBox hbox = new HBox(10,far,kelv);
        VBox vbox = new VBox(10,lab,text,hbox,lab1);
        vbox.setPadding(new Insets(15));
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
       RadioHandler handler = new RadioHandler();
        far.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);
        kelv.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);
       
        Scene scene = new Scene(vbox, 300, 200);
        
        primaryStage.setTitle("Temperature Conversion!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   class RadioHandler implements EventHandler<Event>{
       
        @Override
        public void handle(Event event) {
           double ce= Double.parseDouble(text.getText());
           if (event.getSource() == far) {  
           double re= ce*9/5+32 ;
           lab1.setText(Double.toString(re));
           }else if (event.getSource() == kelv){   
           double re= ce+ 273.15 ;
           lab1.setText(Double.toString(re));
           } 
        }
   
   
   
   
   }
}
