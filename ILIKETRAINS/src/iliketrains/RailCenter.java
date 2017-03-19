package iliketrains;

import java.util.*;

import skeleton.Skeleton;

public class RailCenter {

	Collection<Engine> engines;
	private Boolean collided;
	private int numberOfArrived;
	private int entryPoints;

	/**
	 * konstruktor
	 */
	public RailCenter() {
		Skeleton.write("RailCenter konstruktor");
		
	}

	/**
	 * Az Engineket (mozdony), �s ez�ltal a vonatokat mozgat� fv.
	 */
	public void moveEngines() {
		// TODO - implement RailCenter.moveEngines
	}

	/**
	 * Azt ellen�rzi, hogy minden vonat meg�rkezett-e (vagyis lesz�ll�tott�k az �sszes utast).
	 * Amennyiben igen, �gy a j�t�kos nyert.
	 */
	public void reportArrived() {
		Skeleton.addIndent();
		boolean allTrains=Skeleton.askIN("Minden vonat meg�rkezett?");
		if(allTrains){
			Skeleton.write("NYERT!");
		}
		Skeleton.write("RailCenter.reportArrived() returns");
		Skeleton.removeIndent();
	}

	/**
	 * �tk�z�s megt�rt�nt�nek jelz�s�re szolg�l� f�ggv�ny
	 */
	public void reportCollided() {
		Skeleton.addIndent();
		Skeleton.write("RailCenter.reportCollided() returns");
		Skeleton.removeIndent();
	}

}