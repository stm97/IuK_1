/**
 * Die Klasse <code>Modulo10Rekursiv</code> berechnet Prüfziffern gemäss 
 * Prüfziffermethode Module 10, rekursiv. Dieses Verfahren wird im Zahlungsaustausch
 * mit Schweizer Banken verwendet.
 * <p>Das folgende Beispiel zeigt die Benutzung dieser Klasse. Die Prüfziffer für
 * die Zeichenfolge <code>313947143000901</code> ist <code>8</code>. Einerseits kann mittels
 * <pre>Modulo10Rekursiv.pruefziffer("313947143000901")</pre>
 * die Prüfziffer berechnet werden, andererseits kann die Prüfziffer ans Ende der 
 * Ziffernfolge angehängt und die komplette Ziffernfolge mittels 
 * <pre>Rekursiv.pruefe("3139471430009018")</pre>
 * überprüft werden.
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
	 * Prüfe die gegebene Ziffernfolge mittels Prüfzifferverfahren
	 * Modulo 10, rekursiv. Die Prüfziffer muss der zu prüfenden Ziffernfolge angehängt sein.
	 * Beispiel: Die Ziffernfolge <code>313947143000901</code> hat die Prüfziffer <code>313947143000901</code>.
	 * <pre>pruefe("313947143000901" + "8")</pre>
	 * liefert <code>true</code>. 
	 * @param ziffernreihe die Ziffernfolge, deren Prüfziffer berechnet werden soll.
	 * @return die Prüfziffer.
	 * @see Modulo10Rekursiv
	 */
	public static boolean pruefe(String ziffernreihe) {
		int letzteZiffer = Character.digit(ziffernreihe.charAt(ziffernreihe.length()-1),10);
		return letzteZiffer == pruefziffer(ziffernreihe.substring(0, ziffernreihe.length()-1));
	}

	/**
	 * Berechne die Prüfziffer der gegebenen Ziffernfolge mit Prüfzifferverfahren
	 * Modulo 10, rekursiv.
	 * @param ziffernreihe die Ziffernfolge, deren Prüfziffer berechnet werden soll.
	 * @return die Prüfziffer.
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
