package program.logika.produkty;

import program.logika.Produkt;

public class Deska extends Produkt {
    private static final String nazwa = "Deska";
    private static final double cena = 8.4;

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
