package Punto2;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Venta> ventas;
    private List<PackTurismo> packs;
    private List<Cliente> clientes;
    private List<Object> proveedores;

    public Agencia(){
        this.clientes = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.packs = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public Cliente agregarCliente(String DNI,String nombre,String telefono){
        Cliente cliente = new Cliente(DNI, nombre, telefono);
        this.clientes.add(cliente);
        return cliente;
    }

    public void agregarProveedores(String ID,String nombre,String tipoDeProveedor,String tipoSub){
        switch (tipoDeProveedor){
            case "t","T","transporte","Transporte" -> {
                Transporte P = new Transporte(ID,nombre,tipoSub);
                this.proveedores.add(P);
            }
            case "h","H","hospedaje","Hospedaje" -> {
                Hospedaje P = new Hospedaje(ID,nombre,tipoSub);
                this.proveedores.add(P);
            }
            default -> {
                Excursion P = new Excursion(ID,nombre,tipoSub);
                this.proveedores.add(P);
            }
        }
    }

    public void agregarPack(String nro,String destino, String IDHos,String IDtrans,List<Excursion> excursiones,int valor){
        Hospedaje hospedaje = (Hospedaje) buscarProveedor(IDHos);
        Transporte transporte = (Transporte) buscarProveedor(IDtrans);

        PackTurismo pack = new PackTurismo(nro,destino,hospedaje,transporte,excursiones,valor);
        this.packs.add(pack);
    }

    public void agregarVenta(String DNI,String nroPack,String fecha,int monto){
        Cliente cliente = buscarCliente(DNI);
        PackTurismo pack = buscarPack(nroPack);

        cliente.sumarCompra();
        Venta venta = new Venta(pack,cliente,fecha,monto);
        this.ventas.add(venta);
    }

    public void agregarVenta(String DNI,String nombre, String telefono,String nroPack,String fecha,int monto){
        Cliente cliente = agregarCliente(DNI,nombre,telefono);
        PackTurismo pack = buscarPack(nroPack);

        Venta venta = new Venta(pack,cliente,fecha,monto);
        this.ventas.add(venta);
    }

    public Cliente buscarCliente(String DNI){
        for (Cliente cliente:this.clientes) {
            if (cliente.esMiDNI(DNI)){
                return cliente;
            }
        }
        return null;
    }

    public PackTurismo buscarPack(String nro){
        for (PackTurismo pack:this.packs) {
            if (pack.esMiNro(nro)){
                return pack;
            }
        }
        return null;
    }

    public Object buscarProveedor(String ID){
        for (Object proveedor:this.proveedores) {
            if (proveedor instanceof Hospedaje hospedaje){
                if (hospedaje.esMiID(ID)){
                    return hospedaje;
                }
            } else if (proveedor instanceof Transporte transporte) {
                if (transporte.esMiID(ID)){
                    return transporte;
                }
            } else if (proveedor instanceof Excursion excursion) {
                if (excursion.esMiID(ID)){
                    return excursion;
                }
            }
        }
        return null;
    }

    public boolean existePack(String nro){
        for (PackTurismo p:this.packs) {
            if (p.esMiNro(nro)){
                p.mostrarPack();
                return true;
            }
        }
        return false;
    }

    public boolean existeCliente(String DNI){
        for (Cliente c:this.clientes) {
            if (c.esMiDNI(DNI)){
                System.out.println(c.mostrarDatos());
                return true;
            }
        }
        return false;
    }

    public boolean existeProveedor(String ID){
        for (Object p:this.proveedores) {
            if (p instanceof Transporte t) {
                if (t.esMiID(ID)){
                    System.out.println(t.mostrarDatos());
                    return true;
                }
            }
            if (p instanceof Hospedaje h) {
                if (h.esMiID(ID)){
                    System.out.println(h.mostrarDatos());
                    return true;
                }
            }
            if (p instanceof Excursion e) {
                if (e.esMiID(ID)){
                    System.out.println(e.mostrarDatos());
                    return true;
                }
            }
        }
        return false;
    }

    public void listadoVentasPorDestino(){
        String[] destinos = new String[this.ventas.size()];
        int[] ventas = new int[this.ventas.size()];


        //Cuento las ventas
        int i = 0;
        for (Venta v:this.ventas){
            if (!seRepite(destinos,v.getPackComprado().getDestino())){
                destinos[i] = v.getPackComprado().getDestino();
                ventas[i] = 1;
                i++;
            } else {
                int j = 0;
                while (j < destinos.length){
                    if (destinos[j] != null) {
                        if(destinos[j].equals(v.getPackComprado().getDestino())) {
                            ventas[j]++;
                        }
                    }
                    j++;
                }
            }
        }


        //Acomodo en base a la cantidad de ventas por destino
        boolean cambio = true;
        while(cambio){
            cambio = false;
            i = 1;
            while (i < destinos.length){
                int auxC;
                String auxD;
                if (destinos[i] != null){
                    if (ventas[i] > ventas[i-1]){

                        //Cant compras
                        auxC = ventas[i];
                        ventas[i] = ventas[i-1];
                        ventas[i-1] = auxC;

                        //Destino
                        auxD = destinos[i];
                        destinos[i] = destinos[i-1];
                        destinos[i-1] = auxD;

                        cambio = true;
                    }
                }
                i++;
            }
        }



        //Muestro por pantalla todas las ventas acomodadas
        for (i = 0; i < destinos.length; i++) {
            if (destinos[i] != null){
                System.out.println((i+1) + " - Destino: " + destinos[i] + " - Cantidad de ventas: " + ventas[i]);
            }
        }

    }

    public boolean seRepite(String[] destinos,String destino){
        for (String d: destinos) {
            if (d != null){
                if (d.equals(destino)) {
                    return true;
                }
            }
        }
        return false;
    }

     public void ListadoDeVentasPorDestino(){
        Venta[] ventas = new Venta[this.ventas.size()];

        int i = 0;
        for (Venta v:this.ventas) {
             ventas[i] = v;
             i++;
        }


        boolean cambio = true;
        while (cambio){
            cambio = false;
            i = 1;
            while (i < ventas.length){
                Venta auxV;
                if (ventas[i].getPackComprado().getDestino().compareToIgnoreCase(ventas[i-1].getPackComprado().getDestino()) > 0){
                    auxV = ventas[i];
                    ventas[i] = ventas[i-1];
                    ventas[i-1] = auxV;

                    cambio = true;
                }
                i++;
            }
        }


         for (Venta v:ventas) {
             System.out.println(v.mostrarDatos());
         }

     }


    public void mostrarPacksTurismo(){
        for (PackTurismo p:this.packs){
            p.mostrarPack();
        }
    }

    public void mostrarVentas(){
        for (Venta v:this.ventas){
            System.out.println(v.mostrarDatos());
        }
    }

    public void mostrarClientes(){
        for (Cliente c:this.clientes) {
            System.out.println(c.mostrarDatos());
        }
    }

    public void mostrarProveedores(){
        System.out.println("----- Proveedores de Hospedajes ------");
        for (Object p:this.proveedores) {
            int i = 1;
            if (p instanceof Hospedaje hospedaje) {
                System.out.println( i + "- " + hospedaje.mostrarDatos());
            }
        }

        System.out.println("----- Proveedores de Transporte ------");
        for (Object p:this.proveedores) {
            int i = 1;
            if (p instanceof Transporte transporte) {
                System.out.println( i + "- " + transporte.mostrarDatos());
            }
        }

        System.out.println("----- Proveedores de Excursiones ------");
        for (Object p:this.proveedores) {
            int i = 1;
            if (p instanceof Excursion excursion) {
                System.out.println( i + "- " + excursion.mostrarDatos());
            }
        }
    }
}
