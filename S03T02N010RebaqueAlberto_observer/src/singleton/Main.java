package singleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Instanciamos el agente (Observable)
		Agente agente = new Agente();
		
		//Instanciamos tres agencias (Observers).
		Agencia agencia1 = new Agencia(agente, "Agencia 1");
		Agencia agencia2 = new Agencia(agente, "Agencia 2");
		Agencia agencia3 = new Agencia(agente, "Agencia 3");
		
		//Eliminamos una de ellas para verificar que el método removeObsever() funciona.
		agente.removeObserver(agencia2);
		
		int option;
		double dowJones;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Escoja opción:");
			System.out.println("1 - Introducir valor del índice Dow Jones.");
			System.out.println("0 - Salir.");
			
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Inserte valor del índice Dow Jones (último valor " + BigDecimal.valueOf(agente.getLastDowJones()).setScale(2, RoundingMode.HALF_UP) + " puntos). Nota: solo se notifican cambios mayores de 0,1 puntos.");
					dowJones = sc.nextDouble();
					agente.dowJonesChanged(dowJones);
					break;
				case 0:
					System.out.println("Fin del programa.");
					break;
				default:
					System.out.println("Opción incorrecta, vuelva a intentarlo.");
			}
		} while (option != 0);
		
	}

}
