public class Inyector {

    static Cliente getCustomer(){
        Carro Convertible = new Convertible("Mazda");
        Carro Sedan = new Sedan("Dodge");

        return new Cliente("Guiseppe", Convertible);

    }
}
