package iliketrains;

import skeleton.Skeleton;

public class Cart {

	protected TrackComponent currentTrack;

	/**
	 * A vonatkocsit mozgat� f�ggv�ny, a param�ter��l kapott objektumra mozgat
	 * @param whereTo P�lyaelem amire a kocsit mozgatni k�v�njuk
	 */
	public void moveCart(TrackComponent whereTo) {
		Skeleton.addIndent();
		Skeleton.write("Cart.moveCart calls currentTrack.removeCart()");
		currentTrack.removeCart();
		Skeleton.write("Cart.moveCart calls whereTo.putCart()");
		whereTo.putCart(this);
		Skeleton.write("Cart.moveCart returns");
		Skeleton.removeIndent();
	}

}