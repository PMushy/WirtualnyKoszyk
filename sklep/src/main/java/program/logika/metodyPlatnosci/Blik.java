package program.logika.metodyPlatnosci;

import program.logika.MetodaPlatnosci;

public class Blik extends MetodaPlatnosci {
    private static final String BLIK = "BLIK";

    public void hello(){
        System.out.print("Place blikiem");
    }

    @Override
    public String toString() {
        return BLIK;
    }
}
