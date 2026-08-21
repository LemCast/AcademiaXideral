public class Main {

    public static void main(String[] args){

        Cliente cliente = Inyector.getCustomer();

        cliente.arrancar();
    }
}
