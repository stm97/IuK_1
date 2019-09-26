/**
 * Die Klasse <code>Modulo10Rekursiv</code> berechnet Pr�fziffern gem�ss 
 * Pr�fziffermethode Module 10, rekursiv. Dieses Verfahren wird im Zahlungsaustausch
 * mit Schweizer Banken verwendet.
 * <p>Das folgende Beispiel zeigt die Benutzung dieser Klasse. Die Pr�fziffer f�r
 * die Zeichenfolge <code>313947143000901</code> ist <code>8</code>. Einerseits kann mittels
 * <pre>Modulo10Rekursiv.pruefziffer("313947143000901")</pre>
 * die Pr�fziffer berechnet werden, andererseits kann die Pr�fziffer ans Ende der 
 * Ziffernfolge angeh�ngt und die komplette Ziffernfolge mittels 
 * <pre>Rekursiv.pruefe("3139471430009018")</pre>
 * �berpr�ft werden.
 * </p>
 * 
 * @see <a href="http://WWW.SIC.CH/de/dl_tkicch_dta.pdf">DTA - Standards und Formate</a>
 *    
 * @version 1.0
 * @author Martin Studer
 */
public class Modulo10Rekursiv {
	private static int[] KOMBINATIONSZEILE = {0,9,4,6,8,2,7,1,3,5};
	private static int[][] KOMBINATIONSTABELLE;
	static {
		KOMBINATIONSTABELLE = new int[KOMBINATIONSZEILE.length][KOMBINATIONSZEILE.length];
		for (int zeile=0;zeile<KOMBINATIONSZEILE.length; zeile++) {
			for (int spalte = 0; spalte<KOMBINATIONSZEILE.length; spalte ++) {
				int spalteInZeile = (spalte+zeile) %KOMBINATIONSZEILE.length; 
				KOMBINATIONSTABELLE[zeile][spalte] = KOMBINATIONSZEILE[spalteInZeile];
			}
		}
	}
	
	/**
	 * Pr�fe die gegebene Ziffernfolge mittels Pr�fzifferverfahren
	 * Modulo 10, rekursiv. Die Pr�fziffer muss der zu pr�fenden Ziffernfolge angeh�ngt sein.
	 * Beispiel: Die Ziffernfolge <code>313947143000901</code> hat die Pr�fziffer <code>313947143000901</code>.
	 * <pre>pruefe("313947143000901" + "8")</pre>
	 * liefert <code>true</code>. 
	 * @param ziffernreihe die Ziffernfolge, deren Pr�fziffer berechnet werden soll.
	 * @return die Pr�fziffer.
	 * @see Modulo10Rekursiv
	 */
	public static boolean pruefe(String ziffernreihe) {
		int letzteZiffer = Character.digit(ziffernreihe.charAt(ziffernreihe.length()-1),10);
		return letzteZiffer == pruefziffer(ziffernreihe.substring(0, ziffernreihe.length()-1));
	}

	/**
	 * Berechne die Pr�fziffer der gegebenen Ziffernfolge mit Pr�fzifferverfahren
	 * Modulo 10, rekursiv.
	 * @param ziffernreihe die Ziffernfolge, deren Pr�fziffer berechnet werden soll.
	 * @return die Pr�fziffer.
	 * @see Modulo10Rekursiv
	 */
	public static int pruefziffer(String ziffernreihe) {
		int uebertrag = 0;
		for (int index=0; index<ziffernreihe.length(); index++) {
			int ziffer = Character.digit(ziffernreihe.charAt(index), 10);
			uebertrag = KOMBINATIONSTABELLE[ziffer][uebertrag]; 
		}
		return (10-uebertrag) % 10;
	}
}
