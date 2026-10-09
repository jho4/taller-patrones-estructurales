package decorador;

public class DecoradorRegistro extends DecoradorNotificacion {
    public DecoradorRegistro(ServicioNotificacion notificacion) {
        super(notificacion);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[LOG] Guardando registro de envío de notificación en auditoría...");
        super.enviar(mensaje);
    }
}