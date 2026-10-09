package proxy;

public class ProxyInventario implements ServicioInventario {
    private ServicioInventarioReal servicioReal;
    private boolean tieneAcceso;

    public ProxyInventario(boolean tieneAcceso) {
        this.servicioReal = new ServicioInventarioReal();
        this.tieneAcceso = tieneAcceso;
    }

    @Override
    public boolean verificarStock(String producto) {
        System.out.println("[Proxy Inventario] Verificando permisos del usuario antes de consultar el servicio real...");
        if (!tieneAcceso) {
            System.out.println("[Proxy Inventario] ACCESO DENEGADO: El usuario no tiene permisos para consultar el inventario.");
            return false;
        }
        System.out.println("[Proxy Inventario] Permiso verificado con éxito.");
        return servicioReal.verificarStock(producto);
    }
}