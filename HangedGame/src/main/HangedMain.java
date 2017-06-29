package main;


/**
 *  Aplicación para jugar Ahorcado similar a la publicada en: 
	http://pasatiempos.elmundo.es/ahorcado/ahorcado.html 
	 
	En este caso la interfaz de usuario se realizará mediante línea de comandos
	
	 Caracteristicas :
	 
	-Iniciar partida
	-Al inicio de cada partida debe mostrarse una pista para la palabra secreta (e.j pais, nombre, provincia, etc) 
	-Durante el juego el usuario podrá reiniciar  la palabra secreta, pero la racha ganadora se reiniciará también. 
	-Cuenta regresiva de fallos
	-Racha ganadora actual y récord de racha ganadora ganadora (con nick si es el caso)
	-Mensaje Partida ganada
	-Mensaje Partida perdida
	-Si el jugador supera el récord de la racha ganadora, mensaje felicitación y opción de guardar su nick (archivo).
	-Salir del juego
	-Diccionario con minimo 20 palabras
	

 * @author campino
 *
 */

public class HangedMain {
	
	
	//private static final int MAX_FAILS = 4;
	
	private static final int STATUS_INIT = 1;

	
	private static final int STATUS_EXIT = 2;
	private static final int STATUS_GAME_OVER = 3;
	private static final int STATUS_WINNER = 5;
	//private static final int STATUS_RESET = 6;

	private static final int STATUS_PLAY = 0;

	private static final int STATUS_LEVEL = 0;

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {		
		
		int score=10;
		//int atteps=0;
		
		
		HangedBoard board = new HangedBoard();
		HangedModel dictionary = new HangedModel("dictionary.txt");
		
		
		String option="";
		int command = STATUS_INIT;
		
		while(command!=STATUS_EXIT){
			
			if(command==STATUS_INIT){
				UserInterface.showMenuInit(score);
				option = UserInterface.scanMenuInicio();
				if(option.equals(UserInterface.OPTION_SALIR)){
					break; 
				}else if(option.equals(UserInterface.OPTION_JUGAR)){
					command = STATUS_PLAY; 
				}else if(option.equals(UserInterface.OPTION_LEVEL)){
					command = STATUS_LEVEL; 
				}
			}else if(command==STATUS_WINNER || command==STATUS_GAME_OVER){
				UserInterface.showMenuAgain(board.isWinner(), board.getStreak()); 
				option = UserInterface.scannOptionMenuEndGame();
				
				if(option.equals(UserInterface.OPTION_SALIR)){
					command=STATUS_INIT; 
					continue;
					
				}else if(option.equals(UserInterface.OPTION_JUGAR)){
					command = STATUS_PLAY;
				}else if(option.equals(UserInterface.OPTION_LEVEL)){
					command = STATUS_LEVEL; 
				}
			}
			
		
			
			if(command == STATUS_PLAY){
				HangedModel.SecretWord secretWord = dictionary.getNextWord();
				//board.reset();
				int loop = loopGame(board, secretWord.word , secretWord.hint);
				
				if(loop == STATUS_EXIT){
					command=STATUS_INIT; 
				}else if(loop == STATUS_WINNER){
					command=STATUS_WINNER; 
				}else if(loop == STATUS_GAME_OVER){
					command=STATUS_GAME_OVER;
				}

			}
			
			if(command == STATUS_LEVEL){
				//UserInterface.showMenuLevel(board.getStreak());
				
			}
			
			
			
		}
		
	}
	
	
	private static int loopGame(HangedBoard board, String word, String hint) { 
		int attepts = 0; 
		int status = 0;
		String command="start"; 
		boolean loop=true;
		
		board.startGame(word.toCharArray() ,attepts); 
		
		String wordPlayer = convertToWordPlayer(board.getWordPlayer());
		
		while(loop){ 
			
			UserInterface.showMenuBoard(wordPlayer, hint, attepts);
			command = UserInterface.scannOpcionMenuBoad();
		
			if(command.equals(UserInterface.OPTION_SALIR)){
				status = STATUS_EXIT; 
				break;
			}
			
			
			if(command.equals(UserInterface.OPTION_REINICIAR)){
				board.reset();
				continue; 
			}
						
			int[] positions = board.addLetterToWordPlayer(command.charAt(0));
			
			if(positions.length==0){
				board.addFail();
				attepts = board.getCurrentfails();
			}	
						
			if(positions.length>0 && board.isWinner()){
				board.addStreak(); 
				status = STATUS_WINNER;  
				break; 
			}else if(board.isGameOver()){
				board.reset();
				status = STATUS_GAME_OVER;
				break; 
			}else if(positions.length>0){
				wordPlayer = convertToWordPlayer(board.getWordPlayer());
				continue; 
			}
			
		}
		
		return status; 
	}	
	
	private static String convertToWordPlayer(char[] charWord){
		String wordPlayer="";
		for(int i=0; i<charWord.length;i++){
			wordPlayer += charWord[i];
		}
		return wordPlayer;
	}
	
}
