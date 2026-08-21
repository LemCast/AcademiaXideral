public class Convertible implements Carro {

    private String marca;

    public Convertible(String marca){
        this.marca = marca;
    }

    @Override
    public void arrancar() {
        System.out.println("El vehiculo ha arrancado! Es un Convertible.");
    }

    @Override
    public String toString() {
        return "Marca: " + marca;
    }
}
