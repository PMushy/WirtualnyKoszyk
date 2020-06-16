package program.logika.metodyPlatnosci;

import program.logika.MetodaPlatnosci;

public class Gotowka extends MetodaPlatnosci {
    private static final String GOTOWKA = "GOTOWKA";

    public void hello(){
        System.out.print("Place gotowka");
    }

    @Override
    public String toString() {
        return GOTOWKA;
    }
}
