import java.io.*;
import java.util.*;

public class Ejercicio3 
{
   public static void main(String[] args) 
   {
      Scanner entrada = new Scanner(System.in);
      System.out.print("Introduzca un fichero BMP: ");
      String fichero = entrada.nextLine();
      final int BUFFER_SIZE = 54;
      final int BYTE1 = (int)'B';
      final int BYTE2 = (int)'M';
      try 
      {
         InputStream ficheroEntrada = new FileInputStream( new File(fichero));

         byte[] buf = new byte[BUFFER_SIZE];
         int cantidadLeida = ficheroEntrada.read(buf, 0, BUFFER_SIZE);
         boolean flag = false;
         int profundidad = 0;
         if(cantidadLeida > 0)
         {
            if(buf[0] == BYTE1 && buf[1] == BYTE2)
            {
               flag = true;
               profundidad = buf[28];
            }   
            else
               flag = false;
            
         }              
         ficheroEntrada.close();
       
       
         if(flag)
         {
            System.out.println("Parece un BMP valido.");
            System.out.println("Su profundidad es " + profundidad);
         }
         else
            System.out.println("No parece un BMP valido.");
      } 
      catch (Exception errorDeFichero) 
      {
         System.out.println( "Ha habido problemas: " + errorDeFichero.getMessage() );
      }
   }
}