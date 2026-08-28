package cl.duoc.dsy1105;

public class AppJava {

    public static void main(String[] args) {

        String nombre = "MichiApp";
        String plataforma = "Android";
        int descargas = 1500;
        double puntuacion = 4.7;
        String sitioWeb = null;

        System.out.println("=== INFORMACIÓN DE LA APP ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Descargas: " + descargas);
        System.out.println("Puntuación: " + puntuacion);

        String estado = obtenerEstado(descargas);
        System.out.println("Estado: " + estado);

        if (sitioWeb != null) {
            System.out.println("Sitio web: " + sitioWeb);
        } else {
            System.out.println("Sitio web: No disponible");
        }
    }

    public static String obtenerEstado(int descargas) {
        if (descargas >= 1000) {
            return "Popular";
        }

        return "En crecimiento";
    }
}
