import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.String;
import java.util.*;

class A extends Thread
{
public void run()
{

System.out.println("Hello Welcome To Airline Booking System\n ");
System.out.println("Which Airline services You Will be Using?\n");
System.out.println("1.IndiGo\n");
System.out.println("2.AirIndia\n");
System.out.println("3.SpiceJet\n");
System.out.println("4.GoAir\n");
System.out.println("5.Vistara\n");
System.out.println("6.For Ticket Cancellation \n");
System.out.println("7.Exit \n");
}

}

class B extends Thread
{
public void run()
{
System.out.println("AVAILABLE AIRLINES WITH COSTS:");
System.out.println("\nAIRLINE       ECONOMY    PREMIUM\n");
System.out.println("\n1.INDIGO      3500       5000\n");
System.out.println("\n2.AIR INDIA   4500       6000\n");
System.out.println("\n3.SPICE JET   5500       7000\n");
System.out.println("\n4.GO AIR      6500       8000\n");
System.out.println("\n5.VISTARA     7500       9000\n");
}
}


class Airline
{


public static void reservation()
{
System.out.println("Which Airline services You Will be Using?\n");
System.out.println("1.IndiGo\n");
System.out.println("2.AirIndia\n");
System.out.println("3.SpiceJet\n");
System.out.println("4.GoAir\n");
System.out.println("5.Vistara\n");
System.out.println("6.For Ticket Cancellation \n");
System.out.println("7.Exit \n");
}


public static void Book(String name,int a,int b,String code) throws IOException
{

System.out.println("                     Welcome to "+name+"  Airlines !!           \n\n");
System.out.println("Is it a 1.One-way Trip or 2.Round Trip \n");
System.out.println("Enter the Respective Number\n");
 Scanner scan = new Scanner (System.in);
int Trip = scan.nextInt();
Details();
System.out.println("Please Enter Number Of Travellers ");
int j=0;
 int Nop = scan.nextInt();
 while(j<Nop)
{
System.out.println("Please Enter sno :");
 String Name1 = scan.nextLine();
System.out.println("Please Enter Your Name :");
 String Name = scan.nextLine(); 
System.out.println("Your Age Please:");
 String Age = scan.nextLine();
FileWriter file=new FileWriter("Database.txt",true);
BufferedWriter buff =new BufferedWriter(file);
buff.write(Name);
buff.newLine();
buff.write(Age);
buff.newLine();
buff.write("    ");
buff.close();
j++;
}
System.out.println(" Enter Your Phone Number : ");
String PhoneNumber = scan.nextLine();
int x = PhoneNumber.length();
 String Bookingid = code+PhoneNumber.substring(x/2);
 int amount =0;
 System.out.println("What Class would you prefer sir 1.Economy or 2.Premium");
System.out.println("Enter the Respective Number");
 int sclass = scan.nextInt();
if(sclass == 1)
{
 amount = Nop*a+100;
if(Trip==1)
System.out.println("Total Amount to be paid:" +amount);
else
System.out.println("Total Amount to be paid:" +2*amount);
}
if(sclass == 2)
{
 amount = Nop*b+150;
if(Trip==1)
System.out.println("Total Amount to be paid:" +amount);
else
System.out.println("Total Amount to be paid:" +2*amount);
}
System.out.println("Your BookingId is " +Bookingid);
System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
FileWriter file=new FileWriter("Database.txt",true);
BufferedWriter buff =new BufferedWriter(file);
buff.write(Bookingid);
buff.newLine();
buff.write(PhoneNumber);
buff.newLine();
String e = String.valueOf(amount);
buff.write(e);
buff.newLine();
buff.write("    ");
buff.close();
}


public static void Cancellation() throws IOException{
System.out.println("Please Enter the BookingId Your Ticket");
Scanner scan = new Scanner (System.in);
String a = scan.nextLine();
System.out.println("The Booking Has been Cancelled With BookingId:" +a);
System.out.println("THANK YOU FOR USING OUR SEVICES");
System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
FileWriter file=new FileWriter("Database.txt",true);
BufferedWriter buff =new BufferedWriter(file);
buff.write(a);
buff.newLine();
buff.write("HAS BEEN CANCELLED");
buff.newLine();
buff.close();
}

public static void Details() throws IOException{
Scanner scan = new Scanner (System.in);
 System.out.println("Please Enter From  which Airport You are Boarding");
 String From = scan.nextLine(); 
 System.out.println("Please Enter Which Airport You wanted to go ");
 String To = scan.nextLine(); 
System.out.println("Please Enter Date of Departure ");
 String DOD = scan.nextLine();
System.out.println("Your Gmail Please:");
 String Mail = scan.nextLine();
FileWriter file=new FileWriter("Database.txt",true);
BufferedWriter buff =new BufferedWriter(file);
buff.write(DOD);
buff.newLine();
buff.write(From);
buff.newLine();
buff.write(To);
buff.newLine();
buff.write(Mail);
buff.newLine();
buff.close();
}

public static void main(String[] args) throws IOException
{
Scanner scan = new Scanner (System.in);
System.out.println("                     Welcome to AIRLINE RESERVATION SYSTEM!!"                    );
A t1=new A();
B t2=new B();
t2.start();
t1.start();
System.out.println("Enter your choice");
int c = scan.nextInt();
if(c>=1 && c<=6)
{
while(c>=1 && c<=6)
{
if (c == 1){
    Book("INDIGO",3500,5000,"IN");
    }
   if( c == 2){
    Book("AIR INDIA",4500,6000,"AI");
    }
   if(c == 3){
    Book("SPICEJET",5500,7000,"SP");
    }
   if(c == 4){
    Book("GOAIR",6500,8000,"GO");
    }
   if(c == 5){
     Book("VISTARA",7500,9000,"VI");
    }
   if(c == 6){
     Cancellation();
    }
reservation();
System.out.println("Enter your choice");
c = scan.nextInt();

}
if(c==7)
{
System.out.println("Thank you for choosing AIRLINE RESERVATION SYSTEM!");
}
else
{
System.out.println("enter a valid number from 1 to 7");
}
}
}
}