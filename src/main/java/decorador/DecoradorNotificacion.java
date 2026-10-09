package decorador;

public abstract class DecoradorNotificacion implements ServicioNotificacion {
    protected ServicioNotificacion notificacion;

    public DecoradorNotificacion(ServicioNotificacion notificacion) {
        this.notificacion = notificacion;
    }

    @Override
    public void enviar(String mensaje) {
        notificacion.enviar(mensaje);
    }
}