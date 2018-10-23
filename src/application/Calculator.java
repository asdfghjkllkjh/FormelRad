package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	 
	// Formeln für p (Leistung) 
	public double pAusUundI(double u, double i) {
		double p = u*i;
		return p;
	}

	public double pAusUundR(double u, double r) {
		double p = u * u / r;
		return p;
	}

	public double pAusRundI(double r, double i) {
		double p = i * i * r;
		return p;
	}

	// Formeln für i (Stromstärke)
	public double iAusPundU(double p, double u) {
		double i = p / u;
		return i;
	}

	public double iAusPundR(double p, double r) {
		double i = Math.sqrt(p / r);
		return i;
	}

	public double iAusUundR(double u, double r) {
		double i = u / r;
		return i;
	}
}
