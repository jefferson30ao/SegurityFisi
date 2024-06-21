package Datos;

import Entidades.Libro;
import Entidades.Revista;
import Entidades.Tesis;
import Entidades.Volumen;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Registro {

    static ArrayList<Volumen> listaDocumentos = new ArrayList<>(); // Inicialización aquí

    public Registro() {
        // Esto ya no es necesario ya que la lista se inicializa en el momento de la declaración.
        // listaDocumentos = new ArrayList<Volumen>();
    }

    public static ArrayList<Volumen> getListaDocumentos() {
        return listaDocumentos;
    }

    public static void setListaDocumentos(ArrayList<Volumen> listaDocumentos) {
        Registro.listaDocumentos = listaDocumentos;
    }

    public static void agregarDoc(Volumen doc) {
        boolean repetido = false;
        for (Volumen d : listaDocumentos) {
            // Verificar si todos los atributos son iguales
            if (sonIguales(d, doc)) {
                repetido = true;
                if (d instanceof Libro && doc instanceof Libro) {
                    Libro libroExistente = (Libro) d;
                    Libro libroNuevo = (Libro) doc;
                    libroExistente.setCantidad(libroExistente.getCantidad() + libroNuevo.getCantidad());  // Aumentar la cantidad
                    JOptionPane.showMessageDialog(null, "Cantidad aumentada satisfactoriamente");
                } else if (d instanceof Revista && doc instanceof Revista) {
                    Revista revistaExistente = (Revista) d;
                    Revista revistaNueva = (Revista) doc;
                    revistaExistente.setCantidad(revistaExistente.getCantidad() + revistaNueva.getCantidad());  // Aumentar la cantidad
                    JOptionPane.showMessageDialog(null, "Cantidad aumentada satisfactoriamente");
                } else if (d instanceof Tesis && doc instanceof Tesis) {
                    Tesis tesisExistente = (Tesis) d;
                    Tesis tesisNueva = (Tesis) doc;
                    tesisExistente.setCantidad(tesisExistente.getCantidad() + tesisNueva.getCantidad());  // Aumentar la cantidad
                    JOptionPane.showMessageDialog(null, "Cantidad aumentada satisfactoriamente");
                }
                break;
            } 
        }

        if (!repetido) {
            // Verificar que el código del documento a agregar no esté en la lista
            boolean codigoDiferente = true;
            for (Volumen d : listaDocumentos) {
                if (d.getCodigo() == doc.getCodigo()) {
                    // Si el código es igual, mostrar un mensaje de error y marcar que el código no es diferente
                    JOptionPane.showMessageDialog(null, "No se puede agregar el documento porque ya existe uno con el mismo código.");
                    codigoDiferente = false;
                    break;
                }
            }
            // Si el código es diferente, agregar el documento a la lista
            if (codigoDiferente) {
                listaDocumentos.add(doc);
                JOptionPane.showMessageDialog(null, "Documento agregado satisfactoriamente");
            }
        }
    }

    private static boolean sonIguales(Volumen doc1, Volumen doc2) {
        // Verificar que ambos documentos sean del mismo tipo
        if (doc1.getClass() != doc2.getClass()) {
            return false;
        }

        if (doc1 instanceof Libro) {
            Libro libro1 = (Libro) doc1;
            Libro libro2 = (Libro) doc2;
            return libro1.getCodigo() == libro2.getCodigo()
                && libro1.getTitulo().equals(libro2.getTitulo())
                && libro1.getMateria().equals(libro2.getMateria())
                && libro1.getEditorial().equals(libro2.getEditorial())
                && libro1.getPais().equals(libro2.getPais())
                && libro1.getNumeroDePaginas() == libro2.getNumeroDePaginas();
        } else if (doc1 instanceof Revista) {
            Revista revista1 = (Revista) doc1;
            Revista revista2 = (Revista) doc2;
            return revista1.getCodigo() == revista2.getCodigo()
                && revista1.getTitulo().equals(revista2.getTitulo())
                && revista1.getArea().equals(revista2.getArea())
                && revista1.getPais().equals(revista2.getPais())
                && revista1.getNumeroDePaginas() == revista2.getNumeroDePaginas();
        } else if (doc1 instanceof Tesis) {
            Tesis tesis1 = (Tesis) doc1;
            Tesis tesis2 = (Tesis) doc2;
            return tesis1.getCodigo() == tesis2.getCodigo()
                && tesis1.getTitulo().equals(tesis2.getTitulo())
                && tesis1.getGrado().equals(tesis2.getGrado())
                && tesis1.getAsesor().equals(tesis2.getAsesor())
                && tesis1.getPais().equals(tesis2.getPais())
                && tesis1.getNumeroDePaginas() == tesis2.getNumeroDePaginas();
        }

        return false;
    }

    public static void eliminarDoc(int cod) {
        boolean existe = false;
        for (Volumen d : listaDocumentos) {
            if (d.getCodigo() == cod) {
                existe = true;
                listaDocumentos.remove(d);
                JOptionPane.showMessageDialog(null, "Documento eliminado");
                break;
            }
        }
        if (existe == false) {
            JOptionPane.showMessageDialog(null, "No existe un documento con el código ingresado");
        }
    }

    public static void listar() {
        for (Volumen d : listaDocumentos) {
            System.out.println(d.toString());
        }
    }

    public static void ordenarDocumentosPorTitulo() {
        int n = listaDocumentos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listaDocumentos.get(j).getTitulo().compareToIgnoreCase(listaDocumentos.get(j + 1).getTitulo()) > 0) {
                    // Intercambiar listaDocumentos[j] y listaDocumentos[j + 1]
                    Volumen temp = listaDocumentos.get(j);
                    listaDocumentos.set(j, listaDocumentos.get(j + 1));
                    listaDocumentos.set(j + 1, temp);
                }
            }
        }
    }

    public static void Buscar(String titulo) {
        // Ordenar la lista antes de buscar
        ordenarDocumentosPorTitulo();

        // Realizar la búsqueda binaria
        int index = BusquedaBinaria(listaDocumentos, titulo);

        if (index >= 0) {
            System.out.println(listaDocumentos.get(index).toString());
        } else {
            System.out.println("Documento no encontrado.");
        }
    }

    private static int BusquedaBinaria(ArrayList<Volumen> lista, String titulo) {
        int izquierda = 0;
        int derecha = lista.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            Volumen documentoMedio = lista.get(medio);
            int comparacion = documentoMedio.getTitulo().compareToIgnoreCase(titulo);

            if (comparacion < 0) {
                izquierda = medio + 1;
            } else if (comparacion > 0) {
                derecha = medio - 1;
            } else {
                return medio;
            }
        }
        return -1; // No encontrado
    }

    public static boolean verificarDisponibilidad(int codigo, String tipo) {
        boolean disponible = false;
        for (Volumen d : listaDocumentos) {
            if (d.getCodigo() == codigo) {
                if (tipo.equals("Libro") && d instanceof Libro) {
                    Libro libro = (Libro) d;
                    if (libro.getCantidad() > 0) {
                        disponible = true;
                        break;
                    }
                } else if (tipo.equals("Revista") && d instanceof Revista) {
                    Revista revista = (Revista) d;
                    if (revista.getCantidad() > 0) {
                        disponible = true;
                        break;
                    }
                } else if (tipo.equals("Tesis") && d instanceof Tesis) {
                    Tesis tesis = (Tesis) d;
                    if (tesis.getCantidad() > 0) {
                        disponible = true;
                        break;
                    }
                }
            }
        }
        return disponible;
    }

    public static void actualizarCantidad(int codigo, String tipo) {
        for (Volumen d : listaDocumentos) {
            if (d.getCodigo() == codigo) {
                if (tipo.equals("Libro") && d instanceof Libro) {
                    Libro libro = (Libro) d;
                    libro.setCantidad(libro.getCantidad() - 1);
                    break;
                } else if (tipo.equals("Revista") && d instanceof Revista) {
                    Revista revista = (Revista) d;
                    revista.setCantidad(revista.getCantidad() - 1);
                    break;
                } else if (tipo.equals("Tesis") && d instanceof Tesis) {
                    Tesis tesis = (Tesis) d;
                    tesis.setCantidad(tesis.getCantidad() - 1);
                    break;
                }
            }
        }
    }
}
