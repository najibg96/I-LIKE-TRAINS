package iliketrains;

import skeleton.Skeleton;

public class Station {
	Color color;
	
	public Station(){
		Skeleton.write("Station konstruktor");
	}

	/**
	 * Az �llom�s sz�n�nek lek�rdez�s�re szolg�l� fv.
	 * @return Color Az �llom�s sz�ne
	 */
	public Color getColor() {
		Skeleton.addIndent();
		Skeleton.write("Station returns with color");
		Skeleton.removeIndent();
		return color;
	}

}