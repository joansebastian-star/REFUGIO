public class Animal {

    private int id;
    private String nombre;
    private int edad;
    private String estado;

    public Animal(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.estado = "DISPONIBLE";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id
                + " | Nombre: " + nombre
                + " | Edad: " + edad
                + " | Estado: " + estado);
    }

    public void realizarAccion() {
        System.out.println(nombre + " realiza una acción genérica.");
    }
}
