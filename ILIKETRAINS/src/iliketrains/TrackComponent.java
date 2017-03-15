package iliketrains;

import java.util.*;

import skeleton.Skeleton;

public class TrackComponent {

	Cart cart;
	Station station;
	protected List<TrackComponent> adjacentTracks;

	public TrackComponent(){
		adjacentTracks=new ArrayList<TrackComponent>();
		Skeleton.write("TrackComponent constructor");
	}
	
	public void addAdjacentTrack(TrackComponent track) {
		// TODO - implement TrackComponent.addAdjacentTrack
	}

	public TrackComponent getNext(TrackComponent previous) {
		return this;
	}

	public void putCart(Cart cart) {
		// TODO - implement TrackComponent.putCart
	}

	public void removeCart() {
		// TODO - implement TrackComponent.removeCart
	}

	public Cart getCart() {
		return this.cart;
	}

	public Station hasStation() {
		// TODO - implement TrackComponent.hasStation
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

}