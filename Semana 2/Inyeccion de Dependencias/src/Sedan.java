public class Sedan implements Carro{
    private String marca;

    public Sedan(String marca){
        this.marca = marca;
    }

    @Override
    public void arrancar() {
        System.out.println("El vehiculo ha arrancado! Es un Sedan.");
    }

    @Override
    public String toString() {
        return "Marca: " + marca;
    }
}
