package program.logika.produkty;

import program.logika.Produkt;

public class Baton extends Produkt {
    private static final String nazwa = "Baton";
    private static final double cena = 2.5;

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return nazwa + ' ' + cena;
    }
}
