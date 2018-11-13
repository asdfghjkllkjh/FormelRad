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

	public boolean calculate() {
		if (leistung != null && spannung != null) {
			strom = pAusUundI(spannung, leistung);
			widerstand = rAusUUndI(spannung, leistung);
		} else if (leistung != null && strom != null) {
			spannung = uAusPUndI(leistung, strom);
			widerstand = rAusPUndI(leistung, strom);
		} else if (leistung != null && widerstand != null) {
			spannung = uAusPUndR(leistung, widerstand);
			strom = iAusPundR(leistung, widerstand);
		} else if (spannung != null && strom != null) {
			leistung = pAusUundI(spannung, strom);
			widerstand = rAusUUndI(spannung, strom);
		} else if (spannung != null && widerstand != null) {
			leistung = pAusUundR(spannung, widerstand);
			strom = iAusUundR(spannung, widerstand);
		} else if (strom != null && widerstand != null) {
			leistung = pAusRundI(widerstand, strom);
			spannung = uAusIUndR(strom, widerstand);
		} else {
			throw new RuntimeException("Not enough args");
		}
		
		long filled = Stream.of(leistung, spannung, strom, widerstand)
                .filter(Objects::nonNull)
                .count();
        if (filled > 2) {
            return false;
        }
        return true;
	}
	
	/* Hier die Methoden mit den Formlen hinzufügen */

	// Formeln für p (Leistung)
	public double pAusUundI(double u, double i) {
		double p = u*i;
		System.out.println("Leistung: "+p);
		return p;
	}

	public double pAusUundR(double u, double r) {
		double p = u * u / r;
		System.out.println("Leistung: "+p);
		return p;
	}

	public double pAusRundI(double r, double i) {
		double p = i * i * r;
		System.out.println("Leistung: "+p);
		return p;
	}

	// Formeln für i (Stromstärke)
	public double iAusPundU(double p, double u) {
		double i = p / u;
		System.out.println("Stromstärke: "+i);
		return i;
	}

	public double iAusPundR(double p, double r) {
		double i = Math.sqrt(p / r);
		System.out.println("Stromstärke: "+i);
		return i;
	}

	public double iAusUundR(double u, double r) {
		double i = u / r;
		System.out.println("Stromstärke: "+i);
		return i;
	}

	// Formeln für u (Spannung)
	public double uAusPUndI(double p, double i) {
		double u = p / i;
		System.out.println("Spannung: "+u);
		return u;
	}

	public double uAusPUndR(double p, double r) {
		double u = Math.sqrt(p * r);
		System.out.println("Spannung: "+u);
		return u;
	}

	public double uAusIUndR(double i, double r) {
		double u = i * r;
		System.out.println("Spannung: "+u);
		return u;
	}

	// Widerstand berechnen
	private double rAusPUndI (double p, double i) {
		double r = p/Math.pow(i, 2);
		System.out.println("Widerstand:" +r);
		return r;
	}

	private double rAusUUndP(double u, double p) {
		double r = Math.pow(u, 2)/p;
		System.out.println("Widerstand:" +r);
		return r;
	}

	private double rAusUUndI(double u, double i) {
		double r = u/i;
		System.out.println("Widerstand:" +r);
		return r;
	}
}
