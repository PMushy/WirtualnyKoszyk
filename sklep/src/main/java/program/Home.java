package program;

import javafx.scene.control.ToggleGroup;
import org.omg.CORBA.Environment;
import program.logika.Koszyk;
import program.logika.MetodaPlatnosci;
import program.logika.Produkt;
import program.logika.Zamowienie;
import program.logika.metodyPlatnosci.Blik;
import program.logika.metodyPlatnosci.Gotowka;
import program.logika.metodyPlatnosci.Karta;
import program.logika.produkty.Balon;
import program.logika.produkty.Baton;
import program.logika.produkty.Deska;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.util.Enumeration;

public class Home extends JFrame {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JRadioButton gotowkaRadioButton;
    private JRadioButton kartaRadioButton;
    private JRadioButton blikRadioButton;
    private JButton kupujeButton;
    private JLabel paragon;
    private Zamowienie zamowienie;
    private Koszyk koszyk;
    private MetodaPlatnosci metodaPlatnosci;
    private Produkt balon = new Balon();
    private Produkt baton = new Baton();
    private Produkt deska = new Deska();

    public Home() {
        add(mainPanel);

        this.setVisible(true);
        this.setTitle("Wirtualny koszyk");
        this.setSize(512, 1024);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        koszyk = new Koszyk();
        final ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(gotowkaRadioButton);
        buttonGroup.add(kartaRadioButton);
        buttonGroup.add(blikRadioButton);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = (Integer) spinner1.getValue();
                if (value > 0) {
                    koszyk.dodajProdukt(balon, value);
                    System.out.println("Dodano: " + balon.getNazwa() + " (" + balon.getCena() + "PLN)\nIlosc: " + value);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = (Integer) spinner2.getValue();
                if (value > 0) {
                    koszyk.dodajProdukt(baton, value);
                    System.out.println("Dodano: " + baton.getNazwa() + " (" + baton.getCena() + "PLN)\nIlosc: " + value);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int value = (Integer) spinner3.getValue();
                if (value > 0) {
                    koszyk.dodajProdukt(deska, value);
                    System.out.println("Dodano: " + deska.getNazwa() + " (" + deska.getCena() + "PLN)\nIlosc: " + value);
                }
            }
        });

        kupujeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (null != koszyk && null != getSelectedButtonText(buttonGroup)) {
                    String metoda = getSelectedButtonText(buttonGroup);
                    if (metoda.equals("Gotowka")) {
                        metodaPlatnosci = new Gotowka();
                    } else if (metoda.equals("Karta")) {
                        metodaPlatnosci = new Karta();
                    } else metodaPlatnosci = new Blik();

                    zamowienie = new Zamowienie(koszyk, metodaPlatnosci);
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < koszyk.getProdukt().size(); i++) {
                        sb.append(koszyk.getProdukt().get(i).getNazwa() + " ")
                                .append(koszyk.getIlosc().get(i) + "x ")
                                .append(koszyk.getProdukt().get(i).getCena() + " = ")
                                .append(String.format("%.2f", koszyk.getProdukt().get(i).getCena() * koszyk.getIlosc().get(i)))
                                .append("<br/>");
                    }
                    sb.append("<br/>Do zapłaty: " + String.format("%.2f", zamowienie.doZaplaty()) + "PLN<br/>")
                            .append("Metoda platnosci: " + zamowienie.getMetodaPlatnosci());

                    paragon.setText("<html>" + sb.toString() + "</html>");

                    System.out.println("STWORZONO PARAGON\nDo zapłaty: " + zamowienie.doZaplaty());
                }
            }
        });
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

}
