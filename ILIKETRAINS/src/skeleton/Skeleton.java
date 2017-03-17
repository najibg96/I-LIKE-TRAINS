package skeleton;

import java.util.Scanner;

import iliketrains.Cart;
import iliketrains.Engine;
import iliketrains.PassengerCart;
import iliketrains.RailCenter;
import iliketrains.Station;
import iliketrains.Switch;
import iliketrains.TrackComponent;
import iliketrains.Tunnel;
import iliketrains.TunnelGate;

public class Skeleton {
	private static int tabs=0;
	private static Scanner reader;
	private static boolean running=true;
	private static int currentTest;

	public static void main(String[] args){
		reader = new Scanner(System.in);
		while(running){
			write("�ss be egy sz�mot!");
			String command=reader.next();
			switch(command){
			case "1":
				test1();
				break;
			case "2":
				test2();
				break;
			case "3":
				write("Kil�p�s a j�t�kb�l");
				break;
			case "4":
				test4();
				break;
			case "5":
				test5();
				break;
			case "6":
				test6();
				break;
			case "7":
				test7();
				break;
			default:
				break;
			}
		}
		reader.close();
	}
	
	private static void test1(){
		currentTest=1;
		write("V�lt�t �ll�t");
		RailCenter center = new RailCenter();
		Switch switchObject = new Switch();
		TrackComponent trackObj2= new TrackComponent();
		TrackComponent trackObj3= new TrackComponent();
		switchObject.change();
	}
	
	private static void test2(){
		currentTest=2;
		write("TunnelGate-t �ll�t");
		RailCenter center = new RailCenter();
		Tunnel tunnelObject = new Tunnel();
		TunnelGate tunnelGateObject = new TunnelGate(tunnelObject);
		tunnelGateObject.change();
	}
	
	private static void test4(){
		currentTest=4;
		write("Vonat k�vetkez� p�lyaelemre l�p");
		RailCenter center = new RailCenter();
		TrackComponent trackObject= new TrackComponent();
		Engine engineObject = new Engine(center, trackObject, trackObject);
		engineObject.move();
	}

	private static void test5() {
		currentTest=5;
		write("Vonat v�lt�hoz �r");	
		RailCenter center = new RailCenter();
		Switch switchObject=new Switch();
		Engine engineObject = new Engine(center,switchObject,switchObject);	
		engineObject.move();
	}

	private static void test6() {
		currentTest=6;
		write("Vonat tunnelGate-hez �r");
		RailCenter center = new RailCenter();
		TunnelGate tunnelGateObject = new TunnelGate();
		Engine engineObject = new Engine(center,tunnelGateObject,tunnelGateObject);				
		engineObject.move();
	}
	
	private static void test7(){
		currentTest=7;
		write("Vonat �llom�shoz �r");
		RailCenter center = new RailCenter();
		TrackComponent trackObject= new TrackComponent();
		Station stationObject=new Station();
		trackObject.setStation(stationObject);
		Engine engineObject = new Engine(center,trackObject,trackObject);
		PassengerCart passengerCartObject=new PassengerCart();
		engineObject.addNext(passengerCartObject);
		engineObject.move();
	}

	public static void write(String string) {
		writeIdent();
		System.out.println(string);
	}

	private static void writeIdent() {
		for(int i=0;i<tabs;i++){
			System.out.print("\t");
		}
	}

	public static boolean askIN(String string) {
		System.out.print(">");
		write(string);
		writeIdent();
		while(true){
			String a=reader.next();
			if(a.equals("I") || a.equals("i"))
				return true;
			else if(a.equals("N") || a.equals("n"))
				return false;
			//EXIT feature
			else if(a.equals("e"))
				System.exit(-1);
			else{
				System.out.print(">");
				write("Nem megfelel� bemenet! (I/N) �jra: ");
				writeIdent();
				}
		}
	}
	
	

	public static int getCurrentTest() {
		return currentTest;
	}

	public static void addIndent() {
		tabs++;
	}
	
	public static void removeIndent() {
		tabs--;
	}
}
