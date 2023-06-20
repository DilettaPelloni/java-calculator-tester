package esercizioTicket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    @DisplayName("Test creazione biglietto - km negativi")
    void createNewTicketNegativeKm() {
        assertThrows(
                InvalidKmException.class,
                () -> new Ticket(-5, 20)
        );
    }

    @Test
    @DisplayName("Test creazione biglietto - km == 0")
    void createNewTicketZeroKm() {
        assertThrows(
                InvalidKmException.class,
                () -> new Ticket(0, 20)
        );
    }

    @Test
    @DisplayName("Test creazione biglietto - età negativa ")
    void createNewTicketNegativeAge() {
        assertThrows(
                InvalidAgeException.class,
                () -> new Ticket(100, -20)
        );
    }

    @Test
    @DisplayName("Test creazione biglietto - età == 0 ")
    void createNewTicketZeroAge() {
        Ticket ticket = new Ticket(100,0); //la creazione deve andare a buon fine
        assertEquals(0, ticket.getAge()); //quindi se provo a prendere l'età dovrei trovare 0
    }

    @Test
    @DisplayName("Test metodo calcolo prezzo - età < 18 ")
    void getFullPriceYoung() {
        Ticket ticket = new Ticket(100,6); //creo il biglietto
        assertEquals(new BigDecimal("16.80"), ticket.getFullPrice());
    }

    @Test
    @DisplayName("Test metodo calcolo prezzo - età > 65 ")
    void getFullPriceOld() {
        Ticket ticket = new Ticket(100,80); //creo il biglietto
        assertEquals(new BigDecimal("12.60"), ticket.getFullPrice());
    }

    @Test
    @DisplayName("Test metodo calcolo prezzo - età > 18 e < 65 ")
    void getFullPrice() {
        Ticket ticket = new Ticket(100,30); //creo il biglietto
        assertEquals(new BigDecimal("21.00"), ticket.getFullPrice());
    }


}