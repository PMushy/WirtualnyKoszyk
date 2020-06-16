package program.logika.produkty;

import program.logika.Produkt;

public class Balon extends Produkt {
    private static final String nazwa = "Balon";
    private static final double cena = 0.2;


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
