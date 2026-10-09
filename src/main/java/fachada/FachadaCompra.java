package fachada;

import adaptador.AdaptadorPago;
import adaptador.ProcesadorPago;
import adaptador.ServicioPagoExterno;
import decorador.DecoradorCompresion;
import decorador.DecoradorRegistro;
import decorador.ServicioNotificacion;
import decorador.ServicioNotificacionBasico;
import proxy.ProxyInventario;
import proxy.ServicioInventario;

public class FachadaCompra {
    private ServicioInventario inventarioProxy;
    private ProcesadorPago procesadorPago;
    private ServicioNotificacion servicioNotificacion;

    public FachadaCompra(boolean usuarioAutorizado) {
        // 1. Configuración de Proxy para verificación de acceso
        this.inventarioProxy = new ProxyInventario(usuarioAutorizado);

        // 2. Configuración de Adaptador para el servicio externo de pago
        ServicioPagoExterno servicioExterno = new ServicioPagoExterno();
        this.procesadorPago = new AdaptadorPago(servicioExterno);

        // 3. Combinación de Decoradores: Registro + Compresión + Notificación Básica
        ServicioNotificacion basico = new ServicioNotificacionBasico();
        ServicioNotificacion conRegistro = new DecoradorRegistro(basico);
        this.servicioNotificacion = new DecoradorCompresion(conRegistro);
    }

    public void realizarCompra(String producto, double monto) {
        System.out.println("==================================================");
        System.out.println("   INICIANDO PROCESO DE COMPRA EN TIENDA DEPORTIVA");
        System.out.println("==================================================");

        // Paso 1: Consultar stock mediante Proxy
        if (!inventarioProxy.verificarStock(producto)) {
            System.out.println("\n[Fachada] Proceso cancelado: No se tienen permisos de inventario.");
            return;
        }

        // Paso 2: Procesar el pago mediante Adapter
        procesadorPago.procesarPago(monto);

        // Paso 3: Enviar la notificación enviada con Decoradores combinados
        String mensaje = "Compra exitosa del producto '" + producto + "' por $" + monto;
        servicioNotificacion.enviar(mensaje);

        System.out.println("==================================================");
        System.out.println("   COMPRA FINALIZADA CON ÉXITO");
        System.out.println("==================================================\n");
    }
}