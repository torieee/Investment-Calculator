
package InvestmentCalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class InvCalcFX extends Application {
    
    @Override
    public void start(Stage stage) {
        //Pane and boxes
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets (10, 10, 10, 10));
        VBox v = new VBox();
        GridPane gpane = new GridPane();
        gpane.setPadding(new Insets (10, 10, 10, 10));
        gpane.setHgap(10);
        gpane.setVgap(10);
        HBox h = new HBox();
        
        //Title in VBox
        Text title = new Text("Investment Calculator");
        title.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 30));
        
        //VBox Parameters
        v.setAlignment(Pos.CENTER);
        v.setSpacing(15);
        v.getChildren().add(title);
        
        //BEGINNING AMT SETUP AND LAMBDA
        Text startamt = new Text("Beginning Amount: $");
        startamt.setFont(Font.font("Calibri", FontWeight.LIGHT, 15));
        gpane.add(startamt, 0, 0);
        TextField start = new TextField();
        start.setPrefWidth(100);
        start.setPadding(new Insets (10, 10, 10, 10));
        start.setAlignment(Pos.CENTER);
        gpane.add(start, 1, 0); 
        
        
        //MONTHLY CONTRIB SETUP AND LAMBDA
        Text monthlycont = new Text("Monthly Contribution: $");
        monthlycont.setFont(Font.font("Calibri", FontWeight.LIGHT, 15));
        gpane.add(monthlycont, 0, 1);
        TextField monthly = new TextField();
        monthly.setPrefWidth(100);
        monthly.setPadding(new Insets (10, 10, 10, 10));
        monthly.setAlignment(Pos.CENTER);
        gpane.add(monthly, 1, 1);
        
        //YEARS SETUP AND LAMBDA
        Text yearsInv = new Text("Length of Investment: ");
        yearsInv.setFont(Font.font("Calibri", FontWeight.LIGHT, 15));
        gpane.add(yearsInv, 0, 2);
        TextField years = new TextField();
        years.setPrefWidth(100);
        years.setPadding(new Insets (10, 10, 10, 10));
        years.setAlignment(Pos.CENTER);
        gpane.add(years, 1, 2);
        
        //ROR SETUP AND LAMBDA
        Text ror = new Text("Rate of Return: ");
        ror.setFont(Font.font("Calibri", FontWeight.LIGHT, 15));
        gpane.add(ror, 0, 3);
        TextField rate = new TextField();
        rate.setPrefWidth(100);
        rate.setPadding(new Insets (10, 10, 10, 10));
        rate.setAlignment(Pos.CENTER);
        gpane.add(rate, 1, 3);
        
        //HBox for calculate button, tf, and reset buttons
        Button calc = new Button();
        calc.setText("Calculate");
        Button reset = new Button();
        reset.setText("Reset");
        
        //Button properties
        calc.setMaxHeight(20);
        calc.setMaxWidth(100);
        
        reset.setMinHeight(20);
        reset.setMinWidth(75);
        
        TextField finalAmt = new TextField();
        finalAmt.setEditable(false);
        finalAmt.setPrefWidth(100);
        finalAmt.setPadding(new Insets (10, 10, 10, 10));
        finalAmt.setAlignment(Pos.CENTER);
        
        //Calculate button action (lambda)
        calc.setOnMouseClicked(e -> {
            double b = parseAmt(start);
            double m = parseAmt(monthly);
            double y = parseAmt(years);
            double r = parseAmt(rate) / 100;
            finalAmt.setText(String.format("$%.2f", b * Math.pow(1 + r, y)));
        });
        
        //Reset button action (lambda)
        reset.setOnMouseClicked(e -> {
             start.setText("");
             monthly.setText("");
             years.setText("");
             rate.setText("");
        });
        
        
        //VBox Parameters
        h.setAlignment(Pos.CENTER);
        h.setSpacing(10);
        h.setPadding(new Insets(10, 10, 10, 10));
        h.getChildren().addAll(calc, finalAmt, reset);
        
        
        //Adding box elements to pane
        pane.setTop(v);
        pane.setCenter(gpane);
        pane.setBottom(h);
        
        //Scene and contents of scene
        Scene scene = new Scene(pane);
        stage.setTitle("Investment Calculator");
        stage.setScene(scene);
        stage.show();
        
    }
    
    private static double parseAmt (TextField t) 
    {
      return Double.parseDouble(t.getText());
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
