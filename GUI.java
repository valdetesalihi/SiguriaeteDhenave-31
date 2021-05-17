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