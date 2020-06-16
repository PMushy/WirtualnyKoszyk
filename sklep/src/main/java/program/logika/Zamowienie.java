package program.logika;

public class Zamowienie {
    private Koszyk koszyk;
    private MetodaPlatnosci metodaPlatnosci;
    private double suma;

    public Zamowienie(Koszyk koszyk, MetodaPlatnosci metodaPlatnosci) {
        this.koszyk = koszyk;
        this.metodaPlatnosci = metodaPlatnosci;
    }

    public double doZaplaty() {
        if (null != this.koszyk) {
            for (int i = 0; i < this.koszyk.getProdukt().size(); i++) {
                suma += this.koszyk.getProdukt().get(i).getCena() * this.koszyk.getIlosc().get(i);
            }
            return suma;
        }
        return 0;
    }

    public MetodaPlatnosci getMetodaPlatnosci() {
        return metodaPlatnosci;
    }
}
