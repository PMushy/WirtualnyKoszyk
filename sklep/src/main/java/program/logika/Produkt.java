package program.logika;

public abstract class Produkt {
    private String nazwa;
    private double cena;

    public abstract String getNazwa();

    public abstract double getCena();

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }
}
