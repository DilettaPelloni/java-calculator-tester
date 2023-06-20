package esercizioTicket;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Ticket {

    //ATTRIBUTI --------------------------------------------------------
    private static final BigDecimal UNIT_PRICE = new BigDecimal(0.21);
    private static final BigDecimal YOUNG_DISC = new BigDecimal(0.2);
    private static final BigDecimal OLD_DISC = new BigDecimal(0.4);
    private final int km;
    private final int age;

    //COSTRUTTORE --------------------------------------------------------
    public Ticket(int km, int age) throws IllegalArgumentException {
        if(!isKmValid(km)) {
            throw new InvalidKmException("Il numero di km deve essere maggiore di 0"); //ho fatto le mie classi per testare anche queste
        }
        if(!isAgeValid(age)) {
            throw new InvalidAgeException("L'età deve essere maggiore o uguale a 0");
        }
        this.km = km;
        this.age = age;
    }

    //GETTERS --------------------------------------------------------
    public int getKm() { return km; }
    public int getAge() { return age; }

    //METODI --------------------------------------------------------
    public BigDecimal getFullPrice() {
        //calcolo il prezzo
        BigDecimal fullPrice = new BigDecimal(km).multiply(UNIT_PRICE).setScale(2,  RoundingMode.CEILING);
        //applico eventuali sconti
        if(age < 18){ fullPrice = scalePrice(fullPrice.subtract(fullPrice.multiply(YOUNG_DISC))); }
        if(age > 65) { fullPrice = scalePrice(fullPrice.subtract(fullPrice.multiply(OLD_DISC))); }
        //ritorno il prezzo
        return fullPrice;
    }

    //utility
    private BigDecimal scalePrice(BigDecimal price) {
        return price.setScale(2,  RoundingMode.CEILING);
    }

    //validatori
    private boolean isKmValid(int num) { return num > 0; }
    private boolean isAgeValid(int num) { return num >= 0; } //age accetta 0, per includere i neonati (●'◡'●)

}
