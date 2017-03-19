package iliketrains;

import java.util.*;

import skeleton.Skeleton;

public class TrackComponent {

	Cart cart;
	Station station;
	protected List<TrackComponent> adjacentTracks;

	/**
	 * konstruktor
	 */
	public TrackComponent() {
		adjacentTracks = new ArrayList<TrackComponent>();
		Skeleton.write("TrackComponent constructor");
	}

	/**
	 * Szomsz�dos p�lyaelem hozz�kapcsol�sa ehhez
	 * @param track A szomsz�dos p�lyaelem referenci�ja
	 */
	public void addAdjacentTrack(TrackComponent track) {
		// TODO - implement TrackComponent.addAdjacentTrack
	}

	/**
	 * A k�vetkez� p�lyaelem lek�rdez�s�re szolg�l� f�ggv�ny 
	 * (vagyis amerre tov�bb fogunk haladni),
	 * amennyiben a param�terk�nt megadott p�lyaelem ir�ny�b�l k�zel�t�nk
	 * @param previous Annak a p�lyaelemnek a referenci�ja amerr�l k�zel�t�nk
	 * @return TrackComponent A k�vetkez� p�lyaelem referenci�ja
	 */
	public TrackComponent getNext(TrackComponent previous) {
		return this;
	}

	/**
	 * A param�terk�nt megadott kocsi r�helyez�se a p�lyaelemre
	 * @param cart Annak a kocsinak a referenci�ja amit erre a p�lyaelemre k�v�nunk helyezni
	 */
	public void putCart(Cart cart) {
		Skeleton.addIndent();
		Skeleton.write("TrackComponent.putCart returns");
		Skeleton.removeIndent();
	}

	/**
	 * A p�lyaelemen l�v� kocsi elt�vol�t�sa
	 */
	public void removeCart() {
		Skeleton.addIndent();
		Skeleton.write("TrackComponent.removeCart returns");
		Skeleton.removeIndent();
	}

	/**
	 * A p�lyaelemen l�v� kocsi referenci�j�nak lek�rdez�se
	 * @return Cart A p�lyaelemen l�v� kocsi referenci�ja
	 */
	public Cart getCart() {
		return this.cart;
	}

	/**
	 * Annak a lek�rdez�se, hogy ehhez a p�lyaelemhez tartozik-e �llom�s
	 * @return Station Az �llom�s referenci�ja (ha van)
	 */
	public Station hasStation() {
		Skeleton.addIndent();
		boolean stationExist = Skeleton.askIN("Van �llom�s?");
		if (stationExist){
			Skeleton.write("TrackComponent.hasStation returns with station");
			Skeleton.removeIndent();
			return station;
		}
		else{
			Skeleton.write("TrackComponent.hasStation returns with null");	
			Skeleton.removeIndent();
			return null;
		}

	}

	/**
	 * �llom�s hozz�rendel�se ehhez a p�lyaelemhez
	 * @param station A hozz�rendelend� �llom�s referenci�ja
	 */
	public void setStation(Station station) {
		this.station = station;
	}

}