package iliketrains;

import skeleton.Skeleton;

public class Engine extends Cart {

	private RailCenter center;
	private PassengerCart firstPassengerCart;
	private TrackComponent previous;

	/**
	 * konstruktor
	 * @param center A p�ly�hoz tartoz� RailCenter referenci�ja
	 * @param curr A jelenlegi p�lyaelem amin az Engine (mozdony) tart�zkodik
	 * @param prev Az el�z� mozg�si esem�ny sor�n elhagyott p�lyaelem
	 */
	public Engine(RailCenter center,TrackComponent curr,TrackComponent prev){
		this.center=center;
		currentTrack=curr;
		previous=prev;
		Skeleton.write("Engine constructor");
	}
	
	/**
	 * A mozdony mozgat�sa. El�sz�r megk�rdezi az aktu�lis s�nt�l, hogy melyik a k�vetkez� s�n,
	 * majd �tk�z�sellen�riz azon a s�nen, �s r�l�p a s�nre.
	 * Ha a 7-es teszteset van, akkor ez kimarad (csak ism�tl�s lenne) �s csak az �llom�s ellen�rz�s t�rt�nik meg
	 */
	public void move() {
		Skeleton.addIndent();
		if(Skeleton.getCurrentTest()==7){									//A hetes teszteset
			Skeleton.write("Engine.move calls Engine.checkStation()");
			checkStation();
		}		
		else{																//A t�bbi teszteset
			Skeleton.write("Engine.move calls getNext('previous')");
			TrackComponent next=currentTrack.getNext(previous);
			previous=currentTrack;
			Skeleton.write("Engine.move calls Engine.checkCollision()");
			if(!checkCollison()){
			Skeleton.write("Engine.move calls Cart.moveCart('next')");
			moveCart(next);	
			}	
		}
		
		Skeleton.write("Engine.move returns");
		Skeleton.removeIndent();
	}

	/**
	 * �tk�z�sellen�rz�s. Az Engine (mozdony) halad el�re, emiatt csak ez a kocsi mehet bele valamibe,
	 * �gyh�t ennek az oszt�lynak a felel�ss�ge az �tk�z�sek detekt�l�sa
	 * @return
	 */
	private boolean checkCollison() {
		Skeleton.addIndent();
		if(Skeleton.askIN("Foglalt a k�vetkez� s�n?")){
			Skeleton.write("�tk�z�s, VESZTETT�L!");
			Skeleton.write("Engine.checkCollicion calls center.reportCollided()");
			center.reportCollided();
			Skeleton.removeIndent();
			return true;
		}else{
			Skeleton.write("Engine.checkCollision() returns false");
			Skeleton.removeIndent();
			return false;
		}
	}

	/**
	 * �llom�sdetekt�l�s. Ellen�rzi, hogy a vonat �ppen �llom�son halad-e �t, �s amennyiben igen,
	 * lesz�ll�tja az utasokat a specifik�ci�nak megfelel�en. Ha minden kocsi �res, azt jelzi a RailCenter fel�
	 */
	private void checkStation() {
		Skeleton.addIndent();
		Station s=currentTrack.hasStation();
		if(s!=null){
			Skeleton.write("Engine.checkStation calls station.getColor()");
			s.getColor();
			Skeleton.write("Engine.checkStation calls firstPassengerCart.popPassengers(color)");
			firstPassengerCart.popPassengers(null);
			boolean finished=Skeleton.askIN("Minden kocsi �res?");
			if(finished){
				Skeleton.write("Engine.checkStation calls center.reportArrived()");
				center.reportArrived();
			}
		}		
		Skeleton.write("Engine.checkStation() returns");
		Skeleton.removeIndent();
	}

	/**
	 * Utaskocsi hozz�kapcsol�sa az Engine-hez (mozdony).
	 * @param pCart A kapcsoland� utaskocsi referenci�ja
	 */
	public void addNext(PassengerCart pCart) {
		firstPassengerCart=pCart;
	}

}