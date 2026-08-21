public class Cliente {

    private String nombre;
    private Carro carro;

    public Cliente(String nombre, Carro carro){
        this.nombre = nombre;
        this.carro = carro;
    }

    public void arrancar(){
        System.out.println("De que tipo es mi carro? " + carro);
    }
}
