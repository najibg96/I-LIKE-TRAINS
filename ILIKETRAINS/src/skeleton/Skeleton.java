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
			case "3":	/*Ez az egyetlen teszteset ami egyszer�s�g�b�l fakad�an nincs k�l�n f�ggv�nyben implement�lva*/
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
	
	/**
	 * 1. tesztesetet megval�s�t� f�ggv�ny
	 * Ez a teszteset a Switch (v�lt�) �t�ll�t�s�nak folyamat�t szeml�lteti
	 */
	private static void test1(){
		currentTest=1;
		write("V�lt�t �ll�t");
		RailCenter center = new RailCenter();
		Switch switchObject = new Switch();
		TrackComponent trackObj2= new TrackComponent();
		TrackComponent trackObj3= new TrackComponent();
		switchObject.change();
	}
	
	/**
	 * 2. tesztesetet megval�s�t� f�ggv�ny
	 * Ez a teszteset a TunnelGate (alag�tsz�j) aktiv�l�s�nak folyamat�t szeml�lteti
	 */
	private static void test2(){
		currentTest=2;
		write("TunnelGate-t �ll�t");
		RailCenter center = new RailCenter();
		Tunnel tunnelObject = Tunnel.getInstance();
		TunnelGate tunnelGateObject = new TunnelGate(tunnelObject);
		tunnelGateObject.change();
	}
	
	/**
	 * 4. tesztesetet megval�s�t� f�ggv�ny
	 * Ez a teszteset a vonat a k�vetkez� p�lyaelemre val� l�p�s�nek folyamat�t szeml�lteti
	 */
	private static void test4(){
		currentTest=4;
		write("Vonat k�vetkez� p�lyaelemre l�p");
		RailCenter center = new RailCenter();
		TrackComponent trackObject= new TrackComponent();
		Engine engineObject = new Engine(center, trackObject, trackObject);
		engineObject.move();
	}


	/**
	 * 5. tesztesetet megval�s�t� f�ggv�ny
	 * Ez a teszteset azt szeml�lteti, ahogy a vonat egy Switch-hez (v�lt�) �r, �s azon �thalad
	 */
	private static void test5() {
		currentTest=5;
		write("Vonat v�lt�hoz �r");	
		RailCenter center = new RailCenter();
		Switch switchObject=new Switch();
		Engine engineObject = new Engine(center,switchObject,switchObject);	
		engineObject.move();
	}

	/**
	 * 6. tesztesetet megval�s�t� f�ggv�ny
	 * Ez a teszteset azt szeml�lteti amint a vonat egy TunnelGate-hez (alag�tsz�j) �r, 
	 * �s azon �thalad (nem felt�tlen�l megy be!)
	 */
	private static void test6() {
		currentTest=6;
		write("Vonat tunnelGate-hez �r");
		RailCenter center = new RailCenter();
		TunnelGate tunnelGateObject = new TunnelGate();
		Engine engineObject = new Engine(center,tunnelGateObject,tunnelGateObject);				
		engineObject.move();
	}
	
	/**
	 * 7. tesztesetet megval�s�t� f�ggv�ny
	 * Ez a teszteset szeml�lteti azoknak a j�t�klogikai l�p�seknek a v�grehajt�s�t, 
	 * amikor a vonat egy �llom�shoz �r
	 */
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

	/**
	 * Ki�r�f�ggv�ny ami a jobb �ttekinthet�s�g �rdek�ben a bekezd�s sz�mnak megfelel� 
	 * tabul�tor ut�n �rja ki a param�ter��l kapott stringet
	 * @param string Ki�rand� sz�veg
	 */
	public static void write(String string) {
		writeIdent();
		System.out.println(string);
	}

	/**
	 * A bekezd�s sz�m�nak megfelel� tabul�tor ki�rat�sa az �ttekinthet�s�g �rdek�ben
	 */
	private static void writeIdent() {
		for(int i=0;i<tabs;i++){
			System.out.print("\t");
		}
	}

	/**
	 * A tesztel� felhaszn�l�val val� kommunik�ci�t megval�s�t� f�ggv�ny,
	 * a param�terk�nt kapott eld�ntend� k�rd�sekre v�r v�laszt
	 * @param string Ez a string egy k�rd�s a tesztel� felhaszn�l� fel�, a standard kimenetre �r�dik ki
	 * @return boolean A tesztel� felhaszn�l� v�lasza a feltett k�rd�sre
	 */
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
	
	

	/**
	 * @return int Az �ppen fut� teszteset sz�ma
	 */
	public static int getCurrentTest() {
		return currentTest;
	}

	/**
	 * A bekezd�s sz�mot n�veli egyel
	 */
	public static void addIndent() {
		tabs++;
	}
	
	/**
	 * A bekezd�s sz�mot cs�kkenti egyel
	 */
	public static void removeIndent() {
		tabs--;
	}
}
