package proyectoPreEntrega.sistemaProductos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class sistemaProducto {
    public static void main(String[] args) {

        ArrayList<Productos> productos= productosSuperMercado();
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido al Sistema de Gestión de Productos!");

        while (true) {
            System.out.println(
                    "seleccione la opcion: " +
                            " 1- Consultar Producto" +
                            " 2- Agregar Producto" +
                            " 3- Modificar Producto" +
                            " 4- Eliminar Producto " +
                            " 5- Finalizar"
            );
            int opcionUsuario = sc.nextInt();
            sc.nextLine();
            switch  (opcionUsuario){
                case 1:
                    ConsultarProductoPorNombre(productos);
                    break;
                case 2:
                    AgregarProducto(productos);
                    break;
                case 3:
                    ModificarProducto(productos);
                    break;
                case 4:
                    EliminarProducto(productos);
                    break;
                case 5:
                    System.out.println("gracias por usar la app!");
                    return;
                default:
                    System.out.println("opcion invalida");
                    break;
            }
        }

    }
    //eliminar producto

    public static void EliminarProducto(ArrayList<Productos> productos){
        Scanner sc = new Scanner(System.in);
        System.out.println("nombre del producto a eliminar: ");
        String nombreProducto = sc.nextLine();
        Iterator<Productos> iterator = productos.iterator();

        while(iterator.hasNext()){
            Productos p = iterator.next();

            if(p.getNombre().equals(formatearNombreProducto(nombreProducto))){
                iterator.remove();
                System.out.println("producto eliminado exitosamente");
            }else{
                System.out.println("producto no encontrado...");
            }
        }
    }

    //modificar producto

    public static void ModificarProducto(ArrayList<Productos> productos){
        Scanner sc = new Scanner(System.in);
        System.out.println("que producto desea modificar?: ");
        String producto = sc.nextLine();

        //atributo a modificar

        System.out.println("que que desea modificar?: "+
                "1-precio " +
                " 2-nombre " +
                " 3-stock");
        int atributoProducto = sc.nextInt();

        switch(atributoProducto) {
            case 1:
                for (Productos p : productos) {
                    if (p.getNombre().equals(producto)) {
                            System.out.println("ingrese el nuevo precio del producto: ");
                            double precioProducto = sc.nextDouble();
                                if(precioProducto < 0){ //verifica si la variable es negativo
                                    System.out.println("no se puede poner precio negativo....");
                                }else{
                                    p.setPrecio(precioProducto);
                                    System.out.println("el precio de:" + producto + "fue actualizado con exito!");
                                }
                    }
                }
                break;
            case 2:
                for (Productos p : productos) {
                    if (p.getNombre().equals(producto)) {
                        System.out.println("ingrese el nuevo nombre del producto: ");
                        String nombreProducto = sc.nextLine();
                        p.setNombre(nombreProducto);
                        System.out.println("el nombre de:" + producto + "fue actualizado con exito!");
                    }
                }
            case 3:
                for (Productos p : productos) {
                    if (p.getNombre().equals(producto)) {
                        System.out.println("ingrese el stock del producto:  ");
                        int stockProducto = sc.nextInt();
                        if(stockProducto < 0){ //verifica si la variable es negativo
                            System.out.println("no se puede poner stock negativo....");
                        }else{
                            p.setStock(stockProducto);
                            System.out.println("el stock de:" + producto + "fue actualizado con exito!");
                        }
                    }
                }
        }
    }

    //buscar producto

    public static Productos consultarProductoPorId(ArrayList<Productos> productos){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el id del producto: ");
        int idProducto = sc.nextInt();

        for(Productos p : productos){
            if(p.getId() ==  idProducto){
                return p;
            }
        }
        return null;
    }

    public static void ConsultarProductoPorNombre(ArrayList<Productos> producto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = sc.nextLine();
        Boolean encontrado = false;

        for (Productos p : producto) {
            if(p.getNombre().equals(formatearNombreProducto(nombreProducto))){
                System.out.println("producto encontrado");
                mostrarInfoProducto(p);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            System.out.println("producto no encontrado");
        }

    }

    //agregar producto

    public static void AgregarProducto(ArrayList<Productos> producto) {
        Scanner sc = new Scanner(System.in);

        //nombre

        System.out.println("Ingrese el nombre del producto: ");
        String nombreProducto = sc.nextLine();

        //precio
        System.out.println("ingrese el precio del producto: ");
        Double precioProducto = sc.nextDouble();

        //stock
        System.out.println("ingrese el stock del producto: ");
        int stockProducto = sc.nextInt();

        sc.nextLine();

        producto.add(new Productos(formatearNombreProducto(nombreProducto), precioProducto, stockProducto));
        System.out.println("Producto agregado correctamente");
    }

    //productos
    public static ArrayList<Productos> productosSuperMercado() {
        ArrayList <Productos> productosSuper= new ArrayList<>();

        productosSuper.add(new Productos("coca cola",2500.0,20));
        productosSuper.add(new Productos("pepsi",5000.0,2));
        productosSuper.add(new Productos("fanta",1999.0,40));
        productosSuper.add(new Productos("alfajor jorgelin",1900.0,20));
        productosSuper.add(new Productos("pan frances",2700.0,200));
        productosSuper.add(new Productos("jamon",1500.0,20));
        return productosSuper;
    }

    //mostrar info

    public static void mostrarInfoProducto(Productos producto){
        System.out.println("id: " + producto.getId() +  " nombre: " + producto.getNombre() + " precio: " + producto.getPrecio()
        + "stock: "  + producto.getStock());
    }

    //formatear cadena

    public static String formatearNombreProducto(String nombreProducto){
        return nombreProducto.trim().toLowerCase();
    }
}
