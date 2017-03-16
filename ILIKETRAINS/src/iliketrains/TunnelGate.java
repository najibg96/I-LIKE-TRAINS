package iliketrains;

import skeleton.Skeleton;

public class TunnelGate extends TrackComponent implements Controllable {

	private Boolean state;
	private Tunnel tunnel;

	public TunnelGate(TrackComponent next){
		super();
		adjacentTracks.add(next);
		Skeleton.write("TunnelGate constructor");
	}
	
	public void change() {
		// TODO - implement TunnelGate.change
	}

	public void removeTunnelTrack() {
		// TODO - implement TunnelGate.removeTunnelTrack
	}

	@Override
	public TrackComponent getNext(TrackComponent previous) {
		//K�rd�s felvet�s
		Skeleton.addIndent();
		boolean answer=Skeleton.askIN("Akt�v az alag�t?(I/N)");
		if(answer){
		Skeleton.write("tunnelGate returns with trackSetByTunnel");
		}
		else{
			Skeleton.write("tunnelGate returns with nextTrackComponent");
		}
		Skeleton.removeIndent();
		return null;
	}

}