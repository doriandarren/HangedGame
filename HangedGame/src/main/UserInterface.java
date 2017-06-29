package main;

import util.Input;

public class UserInterface {

	public static final String OPTION_SALIR = "SALIR";
	public static final String OPTION_JUGAR = "JUGAR";
	public static final String OPTION_LEVEL = "LEVEL";
	public static final String OPTION_REINICIAR = "REINICIAR";  
	
	
	public static void clearScreen(){		
		for(int i=0; i<50;i++){
			System.out.println();
		}
	}
	
	//Eduard github.com/lordespirit/HangedGame/tree/edu
	//lordespirit/HangedGame
	public static void showMenuInit(int score){
		clearScreen();
		System.out.println("*********************************************************");
		System.out.println("\t\tJUEGO DEL AHORCADO");
		System.out.println("*********************************************************");
		System.out.println("\t\tMenú");
		System.out.println("[jugar] Jugar\t[salir] Salir\t[level] Level");
		System.out.println("*********************************************************");
		System.out.println("Racha actual de " + score);
		System.out.print("Elige una opción: ");	
	}
	
	public static String scanMenuInicio(){
		String option;
		boolean isOKI = false; 
		do{
			option = Input.scannLine().toUpperCase();
			isOKI = !(option.equals(OPTION_JUGAR)||
							  option.equals(OPTION_SALIR)||
							  option.equals(OPTION_LEVEL)); 	
			if(isOKI)
				System.out.println("Opción no válida. Vuelva a intentarlo: ");
			 
		}while(isOKI);
		return option;
	}

	
	//Dorian:  
	public static void showMenuBoard(String wordPlayer, String hint, int attepts){				
			clearScreen();
			System.out.println("*********************************************************");
			System.out.println("\t\tSTAR GAME");
			System.out.println("\t\tMenú");
			System.out.println("[salir] Salir\t[reiniciar] reiniciar");
			System.out.println("*********************************************************");
			System.out.println("\nPista : " + hint);					
			char[] c = wordPlayer.toCharArray();
			System.out.print("\t");	
			for(int i=0; i<c.length;i++){
				System.out.print(c[i] + " ");			
			}				
			System.out.println("\nIntentos : " + attepts);			
				
	}
	
	
	//Luis:  github.com/lgenis/HangedGame/
	public static String scannOpcionMenuBoad(){
		String valid=null;
		while(valid==null){
			System.out.print("Escribe tu letra: ");
			String option=Input.scannLine().toUpperCase();
			
				if (option.equals(OPTION_SALIR)){
					valid=option; 
					break;
				}else if(option.equals(OPTION_REINICIAR)){
					valid=option;
					break;
				}else if(option.length()==1){
					valid=option;
					break;
				}else{
					System.out.println(option + " No es opcion valida,Vuelva a intentarlo ");
				}
		}		
		return valid;
	}
	

	public static void showMenuAgain(boolean winner, int streak){
		if (winner){
			clearScreen();
			System.out.println("\n\n\t\t\t HAS GANADO \t\t\t");
			System.out.print("\n\n\t\t Felicidades llevas " + streak + " racha");
			if (streak>1)
				System.out.print("s\n");			
		}else{
			clearScreen();
			System.out.println("\n\t\t\t ----- ");
			System.out.println("\t\t\t |   | ");
			System.out.println("\t\t\t |   O ");
			System.out.println("\t\t\t |  /|\\ ");
			System.out.println("\t\t\t |   ^ ");
			System.out.println("\t\t\t |_____");
			System.out.println("\n\t\t\t GAME OVER");			
		}
	}
	
	
	public static String scannOptionMenuEndGame(){	
		System.out.println("Quieres continuar jugando? [Si/No]: ");
		String key= Input.scannLine().toUpperCase();
		boolean validOpc=false;
		String isKeyOk=null;		
		do{
			switch (key) {
			case "SI":
				isKeyOk = OPTION_JUGAR;
				validOpc=true;
				break;
			case "NO":
				isKeyOk = OPTION_SALIR;
				validOpc=true;
				break;
			default:
				System.out.print("\n\n\t Opcion no valida. Teclea Si o No. ");
				break;
			}
		}while(!key.isEmpty() && validOpc==false);		
		return isKeyOk; 
	}
	
	
	public static void showMenuLevel(int level){
		
	}
	
	public static int scannMenuLevel(){
		
		return 0;
	}
	
		
		
}
