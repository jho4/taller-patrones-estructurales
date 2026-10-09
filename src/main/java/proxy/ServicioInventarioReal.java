package proxy;

public class ServicioInventarioReal implements ServicioInventario {
    @Override
    public boolean verificarStock(String producto) {
        System.out.println("[Inventario Real] Consultando base de datos... El producto '" + producto + "' tiene stock disponible.");
        return true;
    }
}