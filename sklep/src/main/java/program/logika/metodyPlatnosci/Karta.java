package program.logika.metodyPlatnosci;

import program.logika.MetodaPlatnosci;

public class Karta extends MetodaPlatnosci {
    private static final String KARTA = "KARTA";

    public void hello() {
        System.out.print("Place karta");
    }

    @Override
    public String toString() {
        return KARTA;
    }
}
