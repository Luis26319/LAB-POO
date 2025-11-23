/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica9;

import java.io.*;
import java.util.Scanner;


/**
 *
 * @author velaz
 */
public class RunPractica9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        File carpeta = new File("datos");
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("Carpeta creada");
        } else {
            System.out.println(" Carpeta ya existe");
        }

        File archivo = new File(carpeta, "productos.txt");
        try {
            if (archivo.createNewFile()) {
                System.out.println(" Archivo creado");
            } else {
                System.out.println(" Archivo ya existe");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

        System.out.println("\n=== Registro de productos ===");
        System.out.print("¿Cuantos productos quieres agregar?: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 1; i <= n; i++) {
                System.out.println("\nProducto #" + i);
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine(); 

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Categoria: ");
                String categoria = sc.nextLine();

                bw.write(id + "," + nombre + "," + categoria);
                bw.newLine();
            }
            System.out.println("Productos guardados correctamente.");
        } catch (IOException e) {
            System.out.println(" Error al escribir en el archivo: " + e.getMessage());
        }

        System.out.println("\n=== Lectura del archivo ===");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // 5. Listar archivos en la carpeta datos
        System.out.println("\n=== Archivos en la carpeta 'datos' ===");
        File[] archivos = carpeta.listFiles();
        if (archivos != null) {
            for (File f : archivos) {
                System.out.println(f.getName());
            }
        }
    }
}

    

