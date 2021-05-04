import java.util.Scanner;
public class FourSquare{
static char[][] aggregate = new char[10][10];
static char[][] TL=new char[5][5], TR=new char[5][5];
static char[][] BL=new char[5][5], BR=new char[5][5];
//encryption function
static String encrypt(String pt, String key1, String key2) {
    String encpt = new String("");
    int n=-1;
    for(int i=0;i<key1.length();i++) {
        n+=1;
        n%=5;
        int m=(int)(i/5);
        TR[m][n]=key1.charAt(i);
    }
n=-1;
for(int i=0;i<key2.length();i++) {
n+=1;
n%=5;
int m=(int)(i/5);
BL[m][n]=key2.charAt(i);

}
int num = 64;
for(int i=0;i<5;i++)
for(int j=0;j<5;j++) {
num++;
if(num==74)
num++;
TL[i][j]=(char)num;
BR[i][j]=(char)num;
}
String seq = new String("");
for(int i=0;i<5;i++) {
for(int j=0;j<10;j++) {
if(j>4) {
int k=j-5;
seq=seq+TR[i][k];
}
else {
seq=seq+TL[i][j];
}
}
}
  
for(int i=0;i<5;i++) {
    for(int j=0;j<10;j++) {
    if(j>4) {
    int k=j-5;
    seq=seq+BR[i][k];
    }
    else {
    seq=seq+BL[i][j];
    }
    }
    }
    int ctr=-1;for(int i=0;i<10;i++)
    for(int j=0;j<10;j++) {
    ctr++;
    aggregate[i][j]=seq.charAt(ctr);
    }

    for(int i=0;i<pt.length();i=i+2) {
        int row=0, col=0;
        for(int j=0;j<5;j++)
        for(int k=0;k<5;k++) {
        if(TL[j][k]==pt.charAt(i)) {
        row = j;
        break;
        }
        if(row!=0)
        break;
        }
        for(int j=0;j<5;j++)
        for(int k=0;k<5;k++) {
        if(BR[j][k]==pt.charAt(i+1)) {
        col = k+5;
        break;
        }
        if(col!=0)
break;

}
encpt = encpt + Character.toString(aggregate[row][col]);

row = 0; col = 0;
for(int j=0;j<5;j++)
for(int k=0;k<5;k++) {
if(BR[j][k]==pt.charAt(i+1)) {
row = j+5;
break;
}
if(row!=0)
break;
}
for(int j=0;j<5;j++)
for(int k=0;k<5;k++) {
  if(TL[j][k]==pt.charAt(i)) {
    col = k;
    break;
}
   if(col!=0)
    break;

}
 encpt = encpt + Character.toString(aggregate[row][col]);

}
return encpt;
}

}







    //Kujdes, Mos shkruani poshte!!!

public static void main(String[] args) {
System.out.print("Enter plaintext: ");
Scanner scan = new Scanner(System.in);
String pt = scan.nextLine();
System.out.print("Enter key 1: ");
String key1 = scan.nextLine();
System.out.print("Enter key 2: ");
String key2 = scan.nextLine();
String encpt = encrypt(pt,key1,key2);
String decpt = decrypt(encpt,key1,key2);
System.out.println("Encrypted text: "+encpt);
System.out.println("Decrypted text: "+decpt);
scan.close();
}
}
