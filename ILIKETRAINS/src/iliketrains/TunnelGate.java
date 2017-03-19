package iliketrains;

import skeleton.Skeleton;

/**
 * 
 * @author Najib
 *
 */
public class TunnelGate extends TrackComponent implements Controllable {

	private Boolean state;  //Meg van nyomva vagy nem
	private Tunnel tunnel;

	/**
	 * konstruktor
	 * @param t Annak az alag�tnak a referenci�ja, amihez az alag�tsz�junkat a l�trehoz�s pillanat�ban kapcsolni szeretn�nk
	 */
	public TunnelGate(Tunnel t){
		super();
		Skeleton.write("TunnelGate constructor");
		tunnel = t;
	}
	
	/**
	 * konstruktor
	 */
	public TunnelGate(){
		super();
		Skeleton.write("TunnelGate constructor");
	}

	/* (non-Javadoc)
	 * @see iliketrains.Controllable#change()
	 */
	public void change() {
		Skeleton.addIndent();
		if(Skeleton.askIN("Van-e rajta vonat?")){
			Skeleton.write("TunnelGate.change() changes nothing");
		}else{
			if(Skeleton.askIN("Akt�v a tunnelGate?")){
				if(Skeleton.askIN("Van-e m�sik akt�v tunnelGate?")){
					tunnel.disconnect(this);
						removeTunnel(); //Nem itt a helye, a disconnect h�vja ha van m�sik akt�v
				}else{
					tunnel.disconnect(this);
				}
			}
			else{
				if(Skeleton.askIN("Van-e m�sik kett� akt�v tunnelGate?")){
					Skeleton.write("TunnelGate.change() calls tunnel.register(this)");
					Skeleton.addIndent();
					tunnel.register(null);
					Skeleton.removeIndent();
					Skeleton.write("TunnelGate.change() changes nothing");
				}
				else {
					Skeleton.write("TunnelGate.change() calls tunnel.register(this)");
					Skeleton.addIndent();
					tunnel.register(this);
					Skeleton.removeIndent();
					Skeleton.write("TunnelGate.change() connected this gate");
				}
			}
		}
		Skeleton.write("TunnelGate.change() returns");
		Skeleton.removeIndent();
	}

	/**
	 * A jelenlegi alag�tsz�j "kikapcsol�sa" a hozz� tartoz� alag�tb�l
	 * (megh�vja az alag�t megfelel� f�ggv�ny�t)
	 */
	public void removeTunnel() {
		Skeleton.addIndent();
		Skeleton.write("TunnelGate.removeTunnelTrack()");
		Skeleton.removeIndent();
	}

	/* (non-Javadoc)
	 * @see iliketrains.TrackComponent#getNext(iliketrains.TrackComponent)
	 */
	@Override
	public TrackComponent getNext(TrackComponent previous) {
		//K�rd�s felvet�s
		Skeleton.addIndent();
		boolean answer = Skeleton.askIN("Akt�v az alag�t?(I/N)");
		if(answer){
		Skeleton.write("tunnelGate returns with trackSetByTunnel");
		}
		else {
			Skeleton.write("tunnelGate returns with nextTrackComponent");
		}
		Skeleton.removeIndent();
		return this;
	}

}