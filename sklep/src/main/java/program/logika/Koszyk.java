package program.logika;

import java.util.ArrayList;
import java.util.List;

public class Koszyk {
    private List<Produkt> produkt = new ArrayList<Produkt>();
    private List<Integer> ilosc = new ArrayList<Integer>();

    public Koszyk() {
    }

    public void dodajProdukt(Produkt produkt, Integer ilosc){
        this.produkt.add(produkt);
        this.ilosc.add(ilosc);
    }

    public List<Produkt> getProdukt() {
        return produkt;
    }

    public List<Integer> getIlosc() {
        return ilosc;
    }
}
