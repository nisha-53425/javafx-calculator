package application;

import java.lang.Math;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdvCalculator extends Application {
   Button permutate,combine,sin,cos,tan,power,fact,plus,minus,multiply,divide,log,ln,mod,binToDec,decToBin,clear;
   Label ans; TextField text1,text2;
	@Override
	public void start(Stage primaryStage) {
		//creating operator buttons
		permutate=new Button("nPr");
		permutate.setPrefWidth(60);
		 combine=new Button("nCr");
		combine.setPrefWidth(60);
         log=new Button("log");
		log.setPrefWidth(60);
		ln=new Button("ln");
		ln.setPrefWidth(60);
		 power=new Button("^");
		power.setPrefWidth(60);
		 fact=new Button("x!");
		fact.setPrefWidth(60);
		 sin=new Button("sin");		
		sin.setPrefWidth(60);
		 cos=new Button("cos");
		cos.setPrefWidth(60);
		 tan=new Button("tan");
		tan.setPrefWidth(60);
		 plus=new Button("+");
		plus.setPrefWidth(60);
		 minus=new Button("-");
		minus.setPrefWidth(60);
		 multiply=new Button("*");
		multiply.setPrefWidth(60);
		 divide=new Button("/");
		divide.setPrefWidth(60);
		 mod=new Button("%");
		mod.setPrefWidth(60);
		 binToDec=new Button("B->D");
		binToDec.setPrefWidth(60);
		 decToBin=new Button("D->B");
		decToBin.setPrefWidth(60);
		//Button decToOct=new Button("D->O");
		HBox hbox1=new HBox(permutate,combine,log,ln);
		hbox1.setSpacing(10);
		HBox hbox2=new HBox(power,sin,cos,tan);
		hbox2.setSpacing(10);

		HBox hbox3=new HBox(fact,mod,binToDec,decToBin);
		hbox3.setSpacing(10);

		HBox hbox4=new HBox(plus,minus,multiply,divide);
		hbox4.setSpacing(10);


		ans=new Label("");
		ans.setStyle("-fx-border-color:#000;-fx-padding:5px");
		ans.setPrefWidth(125);
		 text1=new TextField();
		 text1.requestFocus();
		 text2=new TextField();
	     clear=new Button("Reset");
		clear.setPrefWidth(70);
		HBox hbox5=new HBox(text1,text2);
		hbox5.setSpacing(10);

		HBox hbox6=new HBox(ans);
		hbox6.setAlignment(Pos.CENTER);

		HBox hbox7=new HBox(clear);
		hbox7.setAlignment(Pos.CENTER);

		VBox vbox=new VBox(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6,hbox7);
		vbox.setPadding(new Insets(13));
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		Scene scene=new Scene(vbox,290,350);
		primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
        
		permutate.setOnAction(e->binaryOp(e));
		combine.setOnAction(e->binaryOp(e));
	    log.setOnAction(e->unaryOp(e));
		ln.setOnAction(e->unaryOp(e));
		fact.setOnAction(e->unaryOp(e));
		power.setOnAction(e->binaryOp(e));
		sin.setOnAction(e->unaryOp(e));
		cos.setOnAction(e->unaryOp(e));
		tan.setOnAction(e->unaryOp(e));
		plus.setOnAction(e->binaryOp(e));
		minus.setOnAction(e->binaryOp(e));
		multiply.setOnAction(e->binaryOp(e));
		divide.setOnAction(e->binaryOp(e));
		mod.setOnAction(e->binaryOp(e));
		clear.setOnAction(e->binaryOp(e));




		
	}

	private void unaryOp(ActionEvent e) {
		double num1=Double.parseDouble(text1.getText());
		double answer;
		if(e.getSource()==sin) {
			answer=Math.sin(num1);
			ans.setText(""+answer);
		}
		if(e.getSource()==cos) {
			answer=Math.cos(num1);
			ans.setText(""+answer);
		}
		if(e.getSource()==tan) {
			answer=Math.tan(num1);
			ans.setText(""+answer);
		}
		if(e.getSource()==ln) {
			answer=Math.log(num1);
			ans.setText(""+answer);
		}
		if(e.getSource()==log) {
			answer=2.303*(Math.log(num1));
			ans.setText(""+answer);
		}
		if(e.getSource()==fact) {
			int fac=1;
			int n=(int)num1;
			for(int i=n;i>1;i--)
				fac=fac*i;
			ans.setText(""+fac);
		}
	}

	private void binaryOp(ActionEvent e) {
		double num1,num2,answer;
		
		if(e.getSource()==clear)
		{
			text1.setText("");
			text2.setText("");
			ans.setText("");
			text1.requestFocus();
			return;
		}
		num1=Double.parseDouble(text1.getText());
		num2=Double.parseDouble(text2.getText());
		if(e.getSource()==plus)
		{
			answer=num1+num2;
			ans.setText(""+answer);
		}
		if(e.getSource()==minus)
		{
			answer=num1-num2;
			ans.setText(""+answer);
		}
		if(e.getSource()==multiply)
		{
			answer=num1*num2;
			ans.setText(""+answer);
		}
		if(e.getSource()==divide)
		{
			answer=num1/num2;
			ans.setText(""+answer);
		}
		if(e.getSource()==mod)
		{
			answer=num1%num2;
			ans.setText(""+answer);
		}
		if(e.getSource()==permutate)
		{    int fact1,fact2;
			int n=(int)num1;
			int r=(int)num2;
			fact1=n;
			for(int i=n-1;i>=1;i--) {
				fact1=fact1*i;
			}
			int num=n-r;
			fact2=num;
			for(int i=num-1;i>=1;i--) {
				fact2=fact2*i;
			}
			answer=fact1/fact2;
			
			ans.setText(""+answer);
		}
		if(e.getSource()==combine)
		{
			int n=(int)num1;
			int r=(int)num2;
			int num=n-r;
			int fact1=1,fact2=1,fact3=1;
			for(int i=n;i>1;i--) {
				fact1=fact1*i;
			}
			for(int i=r;i>1;i--) {
				fact2=fact2*i;
			}
			for(int i=num;i>1;i--) {
				fact3=fact3*i;
			}
			answer=fact1/(fact2*fact3);
			ans.setText(""+answer);
		}
		if(e.getSource()==power)
		{
			int n=(int)num1;
			int r=(int) num2;
			answer=Math.pow(n, r);
			ans.setText(""+answer);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
