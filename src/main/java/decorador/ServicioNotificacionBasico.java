package decorador;

public class ServicioNotificacionBasico implements ServicioNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[Notificación] " + mensaje);
    }
}