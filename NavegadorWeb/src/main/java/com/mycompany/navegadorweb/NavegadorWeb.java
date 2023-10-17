
package com.mycompany.navegadorweb;
import javax.swing.JOptionPane;
public class NavegadorWeb {
    public static void main(String[] args) {
        Pila historial = new Pila();
        int opcion = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. Visitar una página\n" +
                    "2. Retroceder\n" +
                    "3. Avanzar\n" +
                    "4. Mostrar historial\n" +
                    "5. Salir\n" +
                    "Elija una opción",
                    "Navegador Web", JOptionPane.INFORMATION_MESSAGE));

            switch (opcion) {
                case 1:
                    String pagina = JOptionPane.showInputDialog(null,
                            "Ingresa la URL de la página que deseas visitar",
                            "Visitar página", JOptionPane.INFORMATION_MESSAGE);
                    historial.empujar(pagina);
                    break;

                case 2:
                    String paginaAnterior = historial.sacar();
                    if (paginaAnterior != null) {
                        JOptionPane.showMessageDialog(null, "Retrocediendo a: " + paginaAnterior,
                                "Retroceder", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay páginas para retroceder",
                                "Retroceder", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 3:
                    String paginaSiguiente = JOptionPane.showInputDialog(null,
                            "Ingresa la URL de la página siguiente",
                            "Avanzar", JOptionPane.INFORMATION_MESSAGE);
                    historial.empujar(paginaSiguiente);
                    break;

                case 4:
                    if (!historial.estaVacia()) {
                        StringBuilder historialTexto = new StringBuilder("Historial de navegación:\n");
                        Pila tempPila = new Pila();
                        while (!historial.estaVacia()) {
                            String url = historial.sacar();
                            historialTexto.append(url).append("\n");
                            tempPila.empujar(url);
                        }
                        while (!tempPila.estaVacia()) {
                            historial.empujar(tempPila.sacar());
                        }
                        JOptionPane.showMessageDialog(null, historialTexto.toString(),
                                "Historial", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El historial está vacío",
                                "Historial", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Navegador Web cerrado",
                            "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
            }

        } while (opcion != 5);
    }
}
