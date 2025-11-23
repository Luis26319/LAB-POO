/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica9;

import java.io.*;

/**
 *
 * @author velaz
 */
public class LectorArchivo extends Thread
{
    
    private File archivo;
    
    public LectorArchivo(File archivo)
    {
        this.archivo = archivo;
    }
    
    @Override
    public void run()
    {
        try(BufferedReader br = new BufferedReader(new FileReader(archivo)))
        {
            String linea;
            while((linea = br.readLine()) != null)
            {
                System.out.println(getName() + "leyendo: " + linea);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }  
            }
            }catch(Exception e)
            {
                System.out.println("Error");
                e.printStackTrace();
            }        
        }
    }

