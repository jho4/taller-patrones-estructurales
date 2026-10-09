package decorador;

public class DecoradorCompresion extends DecoradorNotificacion {
    public DecoradorCompresion(ServicioNotificacion notificacion) {
        super(notificacion);
    }

    @Override
    public void enviar(String mensaje) {
        String mensajeComprimido = "[COMPRIMIDO] " + mensaje;
        super.enviar(mensajeComprimido);
    }
}