package iliketrains;

import skeleton.Skeleton;

public class PassengerCart extends Cart {

	PassengerCart nextCart;
	private Color color;
	private boolean passengers;

	/**
	 * konstruktor
	 */
	public PassengerCart(){
		super();
		Skeleton.write("PassengerCart konstruktor");
	}
	
	/**
	 * Az utaskocsi sz�n�t visszaad� f�ggv�ny
	 * @return color Az utaskocsi sz�ne
	 */
	public Color getColor() {
		return this.color;
	}


	/**
	 * Az utasok lesz�ll�t�sa.
	 * @param color Az adott sz�n, amilyen utasokat lesz�ll�tani k�v�nunk
	 * @return Az kocsi referenci�ja
	 */
	public Cart popPassengers(Color color) {
		Skeleton.addIndent();
		boolean empty=Skeleton.askIN("�res m�r a kocsi?");
		if(empty){
			boolean allEmpty=Skeleton.askIN("Ez az utols� kocsi?");
			if(allEmpty){
				
			}else{
				Skeleton.write("Cart.popPassenger calls nextCart.popPassengers(color)");
				this.popPassengers(color);
			}
		}
		else{
			Skeleton.askIN("Egyezik a sz�n?");
		}
		Skeleton.removeIndent();
		return this;
	}


	/**
	 * Utaskocsi hozz�kapcsol�sa ehhez a kocsihoz
	 * @param pCart A kapcsoland� utaskocsi referenci�ja
	 */
	public void addNext(PassengerCart pCart) {
	}

}