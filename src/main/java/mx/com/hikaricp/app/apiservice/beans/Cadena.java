package mx.com.hikaricp.app.apiservice.beans;

/**
 * The type Cadena.
 */
public class Cadena {

    /** The valor. */
    private String valor;

    /**
     * Instantiates a new Cadena.
     */
    public Cadena() {

    }

    /**
     * Instantiates a new Cadena.
     *
     * @param valor the valor
     */
    public Cadena(String valor) {
        this.valor = valor;
    }

    /**
     * Gets valor.
     *
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Sets valor.
     *
     * @param valor the valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Cadena { " +
                "valor= '" + valor + '\'' +
                '}';
    }
}
