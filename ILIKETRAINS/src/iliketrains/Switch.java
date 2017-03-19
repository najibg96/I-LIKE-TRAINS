package iliketrains;

import skeleton.Skeleton;

public class Switch extends TrackComponent implements Controllable {

	private Boolean state;

	/**
	 * konstruktor
	 */
	public Switch() {
		super();
		Skeleton.write("Switch konstruktor");
	}

	/**
	 * A v�lt� �llapot�t megford�tja, amennyiben nincsen rajta vonat
	 */
	public void change() {
		Skeleton.addIndent();
		if(Skeleton.askIN("Van-e rajta vonat?")){
			Skeleton.write("Switch.change returns with no changes");
		}else{
			if(Skeleton.askIN("Melyik ir�nyba �ll a v�lt�? (I-TrackObj2, N-TrackObj3)")){
				Skeleton.write("Switch.change returns with changes state to TrackObj2");
			}else{
				Skeleton.write("Switch.change returns with changes state to TrackObj3");
			}
		}
		Skeleton.removeIndent();
	}

	/**
	 * A k�vetkez� p�lyaelem lek�rdez�s�re szolg�l� f�ggv�ny (vagyis amerre tov�bb fogunk haladni), 
	 * amennyiben a param�terk�nt megadott p�lyaelem ir�ny�b�l k�zel�t�nk a v�lt� fel�
	 * @param previous Annak a p�lyaelemnek a referenci�ja ahonnan k�zel�t�nk a v�lt� fel�
	 */
	@Override
	public TrackComponent getNext(TrackComponent previous) {
		// K�rd�s felvet�s
		Skeleton.addIndent();
		boolean answer = Skeleton.askIN("V�lt�si ir�nyb�l?(I/N)");
		if (answer) {
			boolean switchChoice = Skeleton.askIN("Balra �ll a v�lt�?(I/N)");
			if(switchChoice)
			Skeleton.write("switch returns with leftTrackComponent");
			else
				Skeleton.write("switch returns with rightTrackComponent");
		} else {
			Skeleton.write("switch returns with nextTrackComponent");
		}
		Skeleton.removeIndent();
		return this;
	}

}