package esercizioCalculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach  //prima di ogni test
    void init() {
        calc = new Calculator(); //creo una nuova istanza della classe
    }

    //ADDIZIONE ---------------------------------
    @Test
    @DisplayName("Test metodo somma - caso numeri positivi")
    void addPositiveNumbers() {
        assertEquals(4.0f, calc.add(1.5f, 2.5f));
        //il primo parametro è il risultato atteso
        //il secondo parametro è prodotto dall'utilizzo del metodo che sto testando
    }

    @Test
    @DisplayName("Test metodo somma - caso numeri negativi")
    void addNegativeNumbers() {
        assertEquals(-1.0f, calc.add(1.5f, -2.5f));
    }

    //SOTRRAZIONE ---------------------------------
    @Test
    @DisplayName("Test metodo sottrazione - caso numeri positivi")
    void subtractPositiveNumbers() {
        assertEquals(1.0f, calc.subtract(2.5f, 1.5f));
    }

    @Test
    @DisplayName("Test metodo sottrazione - caso numeri negativi")
    void subtractNegativeNumbers() {
        assertEquals(4.0f, calc.subtract(2.5f, -1.5f));
    }

    @Test
    @DisplayName("Test metodo sottrazione - caso risultato negativo")
    void subtractNegativeResult() {
        assertEquals(-1.0f, calc.subtract(1.5f, 2.5f));
    }

    //DIVISIONE ---------------------------------
    @Test
    @DisplayName("Test metodo divisione - caso base")
    void divide() {
        assertEquals(3.25f, calc.divide(6.5f, 2.0f));
    }

    @Test
    @DisplayName("Test metodo divisione - caso divisore == 0")
    void divideException() {
        assertThrows(
                IllegalArgumentException.class, //tipo di eccezione
                () -> calc.divide(6.5f, 0.0f) //eseguo il metodo passando dati errati
        );
    }

    //MOLTIPLICAZIONE ---------------------------------
    @Test
    @DisplayName("Test metodo moltiplicazione - caso numeri positivi")
    void multiplyPositiveNumbers() {
        assertEquals(3.75f, calc.multiply(2.5f, 1.5f));
    }
    @Test
    @DisplayName("Test metodo moltiplicazione - caso numeri negativi")
    void multiplyNegativeNumbers() {
        assertEquals(-3.75f, calc.multiply(2.5f, -1.5f));
    }

}



