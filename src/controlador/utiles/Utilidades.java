/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;

import com.google.gson.Gson;
import controlador.Listas.ListaEnlazada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import javax.swing.JComboBox;
import modelo.Arbol;
import controlador.ArbolController;
import controlador.PosicionController;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import modelo.Posicion;
import modelo.enums.Orientacion;
import modelo.jarra.Jarra;

/**
 *
 * @author ivangonzalez
 */
public class Utilidades {

    public static String DISCARPDATA = "data";
    public static Gson gson = new Gson();

    public static JComboBox cargarComboOrientacion(JComboBox cbx) {
        cbx.removeAllItems();
        for (Orientacion orientacion : Orientacion.values()) {
            cbx.addItem(orientacion);
        }
        return cbx;
    }

    public static Orientacion getOrientacionCombo(JComboBox cbx) {
        return (Orientacion) cbx.getSelectedItem();
    }

    public static JComboBox cargarComboPosiciones(JComboBox cbx, PosicionController pc) throws Exception {
        cbx.removeAllItems();
        for (int i = 0; i < pc.getPosiciones().getSize(); i++) {
            cbx.addItem(pc.getPosiciones().obtener(i));
        }
        return cbx;
    }

    public static Posicion getPosicionCombo(JComboBox cbx) {
        return (Posicion) cbx.getSelectedItem();
    }

    public static JComboBox cargarComboEstado(JComboBox cbx, Jarra j) throws Exception {
        cbx.removeAllItems();
        for (int i = 0; i <= j.getCapacidad(); i++) {
            cbx.addItem(i);
        }
        return cbx;
    }

    public static String capitalizar(String nombre) {
        char[] aux = nombre.toCharArray();
        aux[0] = Character.toUpperCase(aux[0]);
        return new String(aux);
    }

    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
//            System.out.println(aux.getName());
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }

        return atributo;
    }

    public static Object transformarDato(Field atributo, String dato) {
        Object transformar = null;
        if (atributo.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            if (atributo.getType().getSimpleName().equals("Integer")) {
                transformar = Integer.parseInt(dato);
            }
        } else if (atributo.getType().isEnum()) {
            Enum enumeracion = Enum.valueOf((Class) atributo.getType(), dato.toString());
            transformar = enumeracion;
        } else if (atributo.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
            transformar = Boolean.parseBoolean(dato);
        } else {
            transformar = dato;
        }
        return transformar;
    }

    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean IsPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    public static Boolean isObject(Class clase) {
        return (!IsPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase));
    }

    public static Double calcularDistancia(Double y, Double y1, Double x, Double x1) {
        Double yy = y - y1;
        Double xx = x - x1;
        return redondear(Math.sqrt((yy * yy) + (xx * xx)));
    }

    public static Double redondear(Double dato) {
        return Math.round(dato * 100.0) / 100.0;
    }

    public static boolean guardarJson(ArbolController arbolController) {
//        Gson gson = new Gson();
        String json = gson.toJson(arbolController);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DISCARPDATA + File.separatorChar + "data.json"))) {
            bw.write(json);
            System.out.println("ArbolController Guardado");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public static ArbolController cargarJson() {
        String fichero = "";
//        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(DISCARPDATA + File.separatorChar + "data.json"));
            String linea = "";
            while ((linea = br.readLine()) != null) {
                fichero = fichero + linea;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        ArbolController arboles = gson.fromJson(fichero, ArbolController.class);
        return arboles;
    }

    public static boolean guardarJsonPosiciones(PosicionController posicionController) {
//        Gson gson = new Gson();
        String json = gson.toJson(posicionController);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DISCARPDATA + File.separatorChar + "posiciones.json"))) {
            bw.write(json);
            System.out.println("Posiciones guardadas");
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public static PosicionController cargarJsonposicionController() {
        String fichero = "";
//        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(DISCARPDATA + File.separatorChar + "posiciones.json"));
            String linea = "";
            while ((linea = br.readLine()) != null) {
                fichero = fichero + linea;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        PosicionController posiciones = gson.fromJson(fichero, PosicionController.class);
        return posiciones;
    }

    public static boolean guardarGrafoJson(GrafoNoDirigidoEtiquetado grafoNoDirigidoEtiquetado) {
//        Gson gson = new Gson();
        String json = gson.toJson(grafoNoDirigidoEtiquetado);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DISCARPDATA + File.separatorChar + "grafo.json"))) {
            bw.write(json);
            System.out.println("Grafo Guardado");
            return true;
        } catch (Exception e) {
//            System.out.println("Error: " + e);
            e.printStackTrace();
            return false;
        }
    }

    public static GrafoNoDirigidoEtiquetado cargarGrafoJson() {
        String fichero = "";
//        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader(DISCARPDATA + File.separatorChar + "grafo.json"));
            String linea = "";
            while ((linea = br.readLine()) != null) {
                fichero = fichero + linea;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        GrafoNoDirigidoEtiquetado gnde = gson.fromJson(fichero, GrafoNoDirigidoEtiquetado.class);
        return gnde;
    }

}
