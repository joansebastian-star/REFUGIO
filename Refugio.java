import java.util.ArrayList;

public class Refugio {

    private ArrayList<Animal> animales;

    public Refugio() {
        this.animales = new ArrayList<>();
    }

    public boolean registrarAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (animal.getId() <= 0) {
            System.out.println("Error: el ID debe ser mayor que 0.");
            return false;
        }
        if (buscarPorId(animal.getId()) != null) {
            System.out.println("Error: ya existe un animal con ese ID.");
            return false;
        }
        if (animal.getNombre() == null || animal.getNombre().trim().isEmpty()) {
            System.out.println("Error: el nombre no puede estar vacío.");
            return false;
        }
        if (animal.getEdad() < 0) {
            System.out.println("Error: la edad debe ser mayor o igual a 0.");
            return false;
        }
        animales.add(animal);
        return true;
    }

    public Animal buscarPorId(int id) {
        for (Animal a : animales) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados en el refugio.");
            return;
        }
        for (Animal a : animales) {
            a.mostrarInformacion();
            a.realizarAccion();
            System.out.println("------------------------------------");
        }
    }

    public boolean adoptarAnimal(int id) {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados en el refugio.");
            return false;
        }
        Animal a = buscarPorId(id);
        if (a == null) {
            System.out.println("Animal no encontrado.");
            return false;
        }
        if (a.getEstado().equals("ADOPTADO")) {
            System.out.println("Este animal ya está adoptado.");
            return false;
        }
        a.setEstado("ADOPTADO");
        System.out.println(a.getNombre() + " fue adoptado exitosamente.");
        return true;
    }

    public boolean estaVacio() {
        return animales.isEmpty();
    }
}
