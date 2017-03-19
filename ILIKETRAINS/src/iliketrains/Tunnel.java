package iliketrains;

import java.util.*;

import skeleton.Skeleton;

/**
 * 
 * @author Najib
 *
 */
public class Tunnel {

	Collection<TunnelGate> activeGates;
	
	/**
	 * konstruktor
	 */
	private Tunnel(){
		Skeleton.write("Tunnel constructor");
	}

	/**
	 * Az alag�t referenci�j�nak lek�rdez�se
	 * @return Tunnel Az alag�t referenci�ja
	 */
	public static Tunnel getInstance() {
		Skeleton.write("Tunnel.getInstance() returns reference to singleton tunnel object");
		return new Tunnel();
		//TODO: Ez �gy m�g nem singleton: El kell menteni hogy k�sz�tett�nk-e kor�bban, ha igen akkor azt kell visszaadni, 
		//ha nem csak akkor new
	}

	/**
	 * A param�terk�nt kapott alag�tsz�jat "kikapcsol�" f�ggv�ny
	 * @param gate A kikapcsoland� alag�tsz�j
	 */
	public void disconnect(TunnelGate gate) {
		Skeleton.write("Tunnel.disconnect(TunnelGate t) calls activeGate.removeTunnel()");
		//TODO: implement closing tunnel
		//TODO: Ha van m�sik akt�v akkor azt disconnekt�lni kell
	}

	/**
	 * A param�terk�nt kapott alag�tsz�jat "bekapcsol�" f�ggv�ny
	 * @param gate A bekapcsoland� alag�tsz�j
	 */
	public boolean register(TunnelGate gate) {
		if(gate == null){
			Skeleton.write("Tunnel.register(TunnelGate g) returns false");
			return false;
		}
		else{
			if(Skeleton.askIN("Van-e m�sik akt�v tunnelGate?")){
				Skeleton.write("Tunnel.register(TunnelGate g) calls createTunnel(TunnelGate in, TunnelGate out)");
				Skeleton.addIndent();
				createTunnel(null,null);
				Skeleton.removeIndent();
			}
			Skeleton.write("Tunnel.register(TunnelGate g) returns true");
			return true;
		}
	}

	/**
	 * Alag�t l�tes�t� f�ggv�ny
	 * @param in Az egyik alag�tsz�j
	 * @param out A m�sik alag�tsz�j
	 */
	private void createTunnel(TunnelGate in, TunnelGate out) {
		Skeleton.write("Tunnel.createTunnel(TunnelGate g1, TunnelGate g2) creates tunnel");
		// TODO - implement create track from random number of TrackComponents 
	}

}