package esercizioCalculator;

public class Calculator {

    //METODI --------------------------------------------------------

    //addizione
    public float add(float num1, float num2) {
        return num1 + num2;
    }

    //sottrazione
    public float subtract(float num1, float num2) {
        return num1 - num2;
    }

    //divisione
    public float divide(float num1, float num2) {
        if(num2 == 0) {
            throw new IllegalArgumentException("Il secondo argomento non può essere un numero negativo");
        }
        return num1 / num2;
    }

    //moltiplicazione
    public float multiply(float num1, float num2) {
        return num1 * num2;
    }

}
