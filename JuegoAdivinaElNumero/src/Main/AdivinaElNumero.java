/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Cerdan Victor Andres
 */
import java.util.Scanner;
public class AdivinaElNumero {
    private Scanner entrada=new Scanner(System.in);
    private boolean juegoActivo=true;
    
    private int obtenerNumeroAleatorio(int min,int max){
        return min +(int)(Math.random()*((max-min)+1));
    }
    private String obtenerNombreJugador(){
        System.out.println("¿Cuál es tu nombre?");
        String nombreJugador=entrada.nextLine();
        System.out.printf("Bienvenido %s , vamos a comenzar\n", nombreJugador);
        return nombreJugador;
    }
    private int escogeNumero(){
        System.out.println("Elija un numero");
        return entrada.nextInt();
    }
    private void mensaje(int numeroJugador,int numeroJuego){
        if (numeroJuego<numeroJugador){
            System.out.println("Muy Alto, adivina otra vez");  
        }else if(numeroJuego>numeroJugador){
            System.out.println("Muy Bajo,adivina otra vez.");
        }
    }
    public void jugar(){
        String nombreJugador=obtenerNombreJugador();
        while (juegoActivo){
            int intentos=0;
            int max=100;
            int min=0;
            int numeroJuego=obtenerNumeroAleatorio(1, 100);
            System.out.printf("%s he escogido un numero entre %d y %d, adivinalo ",nombreJugador,min,max);
            int numeroJugador;
            do{
                numeroJugador=escogeNumero();
                mensaje(numeroJugador,numeroJuego);
                intentos++;
            }while(numeroJuego!=numeroJugador);    
            
            System.out.printf("Felicitaciones %S has ganado, total de intentos %d",nombreJugador,intentos);
                    
            juegoActivo=jugarNuevamente();
        }
    }
    public boolean jugarNuevamente(){
        System.out.println("¿Jugar Nuevamente?\n1. Si\n2. No");
        int respuesta=entrada.nextInt();
        if (respuesta==1){
            System.out.println("Genial, juguemos otra vez");
            return true;
        }else{
            System.out.println("Fin del Juego,Gracias por Jugar");
            return false;
        }
    }
}
