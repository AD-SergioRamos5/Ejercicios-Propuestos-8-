import java.io.*;
import java.util.*;

public class Ejercicio2 {
   public static void main(String[] args) 
   {
      Scanner entrada = new Scanner(System.in);
      System.out.print("Introduce el nombre del fichero de entrada: ");
      String fichero = entrada.nextLine();
      
      System.out.println("Copiando fichero binario...");

      try 
      {
         File fichero1 = new File(fichero);
         InputStream ficheroEntrada = new FileInputStream(fichero1);
         PrintWriter ficheroSalida = new PrintWriter(fichero + ".txt");
         
         byte[] buf = new byte[(int)fichero1.length()];
         int cantidadLeida;
         String cadena = "";
         
         ficheroEntrada.read(buf);
         
         for(byte b : buf)
         {
            if(b>=(byte)32 && b<=(byte)126)
               ficheroSalida.print((char)b);
         }
         
         ficheroEntrada.close();
         ficheroSalida.close();
      } 
      catch (Exception errorDeFichero) 
      {
         System.out.println( "Ha habido problemas: " + errorDeFichero.getMessage() );
      }
      System.out.println("Terminado!");
   }
}