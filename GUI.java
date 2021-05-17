package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


import java.awt.*;


public class Main extends Application {
    static char[][] grumbullimi = new char[10][10];

    static char[][] tpleft=new char[5][5], tpright=new char[5][5];
    static char[][] btmleft=new char[5][5], btmright=new char[5][5];

    static String funksioni_enkriptimit(String teksti, String qelesi1, String qelesi2) {
        String enkriptimi = new String("");
        int n=-1;
        for(int i=0;i<qelesi1.length();i++) {
            n+=1;
            n%=5;
            int m=(int)(i/5);
            tpright[m][n]=qelesi1.charAt(i);
        }
        n=-1;
        for(int i=0;i<qelesi2.length();i++) {
            n+=1;
            n%=5;
            int m=(int)(i/5);
            btmleft[m][n]=qelesi2.charAt(i);}
        int numri = 64;
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++) {
                numri ++;
                if(numri==74)
                    numri++;
                tpleft[i][j]=(char)numri;
                btmright[i][j]=(char)numri;
            }
        String sekuenca = new String("");
        for(int i=0;i<5;i++) {
            for(int j=0;j<10;j++) {
                if(j>4) {
                    int k=j-5;
                    sekuenca=sekuenca+tpright[i][k];
                }
                else {
                    sekuenca=sekuenca+tpleft[i][j];
                }
            }
        }
        for(int i=0;i<5;i++) {
            for(int j=0;j<10;j++) {
                if(j>4) {
                    int k=j-5;
                    sekuenca=sekuenca+btmright[i][k];
                }
                else {
                    sekuenca=sekuenca+btmleft[i][j];
                }
            }
        }
        int ctr=-1;
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++) {
                ctr++;
                grumbullimi[i][j]=sekuenca.charAt(ctr);
            }

        for(int i=0;i<teksti.length();i=i+2) {
            int rreshtat=0, kolonat=0;
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(tpleft[j][k]==teksti.charAt(i)) {
                        rreshtat = j;
                        break;
                    }
                    if(rreshtat!=0)
                        break;
                }
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(btmright[j][k]==teksti.charAt(i+1)) {
                        kolonat = k+5;
                        break;
                    }
                    if(kolonat!=0)
                        break;}
            enkriptimi = enkriptimi + Character.toString(grumbullimi[rreshtat][kolonat]);
            rreshtat = 0; kolonat = 0;
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(btmright[j][k]==teksti.charAt(i+1)) {
                        rreshtat = j+5;
                        break;
                    }
                    if(rreshtat!=0)
                        break;
                }
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(tpleft[j][k]==teksti.charAt(i)) {
                        kolonat = k;
                        break;
                    }
                    if(kolonat!=0)
                        break;
                }
            enkriptimi = enkriptimi + Character.toString(grumbullimi[rreshtat][kolonat]);
        }
        return enkriptimi;
    }

    //implementimi i funksionit te dekriptimit
    static String funksioni_dekriptimit(String enkriptimi, String qelesi1, String qelesi2) {
        String dekriptimi = new String("");
        for(int i=0; i<enkriptimi.length(); i=i+2) {
            int rreshtat=0, kolonat=0;
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(tpright[j][k]==enkriptimi.charAt(i)) {
                        rreshtat = j;
                        break;
                    }
                    if(rreshtat!=0)
                        break;
                }
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(btmleft[j][k]==enkriptimi.charAt(i+1))
                    {

                        kolonat = k;
                        break;
                    }
                    if(kolonat!=0)
                        break;
                }
            dekriptimi = dekriptimi + Character.toString(grumbullimi[rreshtat][kolonat]);
            rreshtat = 0; kolonat = 0;
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++) {
                    if(btmleft[j][k]==enkriptimi.charAt(i+1))
                    {
                        rreshtat = j+5;
                        break;
                    }
                    if(rreshtat!=0)
                        break;
                }
            for(int j=0;j<5;j++)
                for(int k=0;k<5;k++)
                {
                    if(tpright[j][k]==enkriptimi.charAt(i)) {
                        kolonat = k+5;
                        break;
                    }
                    if(kolonat!=0)
                        break;
                }
            dekriptimi = dekriptimi + Character.toString(grumbullimi[rreshtat][kolonat]);
        }
        return dekriptimi;
    }

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{



        window = primaryStage;
        window.setTitle("Four Square");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        // item 1
        Label plainTextLabel = new Label("PlainText");
        GridPane.setConstraints(plainTextLabel,0,0);

        TextField plaintextInput = new TextField();
        GridPane.setConstraints(plaintextInput,1,0);


        // item 2
        Label celesi1Label = new Label("Celesi 1");
        GridPane.setConstraints(celesi1Label,0,1);

        TextField celesi1Input = new TextField();
        GridPane.setConstraints(celesi1Input,1,1);


        // item 3
        Label celesi2Label = new Label("Celesi 2");
        GridPane.setConstraints(celesi2Label,0,2);

        TextField celesi2Input = new TextField();
        GridPane.setConstraints(celesi2Input,1,2);

 // Shfaqja e textit te enkriptuar dhe dekriptuar

 Label enkriptimi = new Label("Teksti i enkriptuar:");
 GridPane.setConstraints(enkriptimi,0,4);

 Label dekriptimi = new Label("Teksti i dekriptuar:");
 GridPane.setConstraints(dekriptimi,0,5);

 //Butoni per ekzekutim
 Button finishButton = new Button("Run");
 GridPane.setConstraints(finishButton,1,3);


 finishButton.setOnAction(e -> {

     String pt = plaintextInput.getText();
  
     String k1 = celesi1Input.getText();
     String k2 = celesi2Input.getText();

     String encrypted_text = funksioni_enkriptimit(pt,k1,k2);
     String decrypted_text = funksioni_dekriptimit(encrypted_text,k1,k1);

     enkriptimi.setText("Teksti i enkriptuar: " + encrypted_text);
     dekriptimi.setText("Teksti i dekriptuar: " + decrypted_text);

 });




 grid.getChildren().addAll(plainTextLabel,plaintextInput,celesi1Label,celesi1Input,celesi2Label,celesi2Input,finishButton,enkriptimi,dekriptimi);

 Scene scene = new Scene(grid,500,500);
 window.setScene(scene);
 window.show();

}


public static void main(String[] args) {
 launch(args);
}
}