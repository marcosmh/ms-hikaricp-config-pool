package mx.com.hikaricp.app.apiservice.beans;

/**
 * The type Response.
 */
public class Response {

    /** The status. */
    private long status;

    /** The ok. */
    private boolean ok;

    /** The mensaje. */
    private String mensaje;

    /**
     * Instantiates a new Response.
     */
    public Response() {

    }

    /**
     * Instantiates a new Response.
     *
     * @param status  the status
     * @param ok      the ok
     * @param mensaje the mensaje
     */
    public Response(long status, boolean ok, String mensaje) {
        this.status = status;
        this.ok = ok;
        this.mensaje = mensaje;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public long getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(long status) {
        this.status = status;
    }

    /**
     * Is ok boolean.
     *
     * @return the boolean
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * Sets ok.
     *
     * @param ok the ok
     */
    public void setOk(boolean ok) {
        this.ok = ok;
    }

    /**
     * Gets mensaje.
     *
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Sets mensaje.
     *
     * @param mensaje the mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
