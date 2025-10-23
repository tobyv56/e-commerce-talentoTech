package proyectoPreEntrega.sistemaProductos;

public class productosSP {
    public static void main(String []args){

    }
}

class Productos{
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    static int contadorId = 0;

    public Productos(String nombre,Double precio,int stock){
        this.id = contadorId;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;

        contadorId++;
    }

    //id

    public int getId(){
        return id;
    }

    //stock
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //precio

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //nombreProducto

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}