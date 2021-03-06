package iliketrains;

/**
 * Controllable interfész, ami deklarálja, hogy milyen attributumokkal, függvényekkel
 * kell rendelkeznie egy olyan pályaelemnek, ami kapcsolható
 */
public interface Controllable {

	/**
	 * Általános változtatás (control-funkcionalitás) absztrakt függvénye.
	 */
	void change();
	
	/**
	 * Az azonosító függvényt abszrakt verziója
	 */
	int getId();

	/**
	 * A típust visszaadó függvény absztrakt verziója
	 *
	 * @return Típus
	 */
	String getType();
}