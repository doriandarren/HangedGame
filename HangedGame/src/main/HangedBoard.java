package main;


public class HangedBoard {

	
	/** Arreglo de caracteres que representa la palabra secreta */
	private char wordSecret[]; 
	
	/** Arreglo de caracteres que representa la palabra que el jugador va armando
	 *  al inicio de la partida contiene caracteres '-', tantos como el tamaño de la palabra secreta */
	private char wordPlayer[];
	
	/** fallos cometidos durante la partida actual */
	private int currentfails;
	/** maximo numero de fallos posibles  */
	private int maxFails; 
	/** Partidas ganadas en racha, esto es, consecutivamente */
	private int streak;
	
		
	public HangedBoard(){
		//TODO complete definicion del contructor 
		this.currentfails =0;
		this.maxFails = 0;
		
	}
	
	
	/**
	 * Inicia una partida de ahorcado. 
	 * @param secret arreglo de caracteres con la palabra secreta
	 * @param maxFails numero maximo de fallos posibles 
	 */
	public void startGame(char[] secret, int maxFails){ 
		this.maxFails = maxFails;	
		this.wordSecret = secret;
		this.currentfails=0;
		this.wordPlayer = new char[wordSecret.length];
		
		/*for(char ch: wordPlayer)
			ch='-';*/		
		for(int i=0; i<wordPlayer.length;i++){
			wordPlayer[i]='-';
		} 
	}
	
	/**
	 * Inicia una partida de ahorcado. 
	 * @param secret String con la palabra secreta
	 * @param maxFails numero maximo de fallos posibles 
	 */
	public void startGame(String secret, int maxFails){
		startGame(secret.toCharArray(), maxFails);		
	}
	
	/**
	 * Reinicia todas las variables, el estado del juego queda como al iniciar la aplicacion
	 */
	public void reset(){
		this.streak=0;
	}
	
	
	public boolean hasLetterInWordSecret(char ch){
		if(wordSecret.length>0){
			for(int i=0; i<wordSecret.length;i++){						
				if(ch == wordSecret[i]){
					return true;
				}			
			} 
		}		
		return false;
	}
	
	public boolean hasLetterInWordPlayer(char ch){		
		if(wordPlayer.length>0){
			for(int i=0; i<wordPlayer.length;i++){						
				if(ch == wordPlayer[i]){
					return true;
				}			
			} 
		}		
		return false;
	}
	
	/**
	 * @return si la palabra secreta es igual a la palabra del jugador 
	 */
	public boolean isWinner(){		
		boolean retorno = true;		
		for(int i=0; i<wordSecret.length;i++){						
			if(wordSecret[i]!=wordPlayer[i]){
				retorno = false; 
				break; 
			}
		}
		return retorno; 
	}
	
	/**
	 * @return si fails==maxFailsla 
	 */
	public boolean isGameOver(){	 
		return (currentfails==maxFails); 
	}
	
	
	/**
	 * Si la letra ch hace parte de wordSecret entonces adiciona la letra ch a la palabra del jugador wordPlayer. 
	 * 
	 * El metodo retorna las posiciones de la palabra donde la letra fue adicionada. 
	 * 
	 * E.j: Si la palabra secreta es  SOLO y la palabra del jugador es  - - L - cuando se llama el metodo 
	 * addLetterToWordPlayer('O') debe retornar un arreglo con las posiciones {1,3}
	 * 
	 * Si la letra ch no hace parte de wordSecret entonces retorna un arreglo de cero elementos.
	 * 
	 * @param  ch letra a agregar a la plabra del jugador wordPlayer
	 * @return arreglo de enteros con las posiciones donde ch fue agregada, si la letra 
	 */
	public int[] addLetterToWordPlayer(char ch){
		if(hasLetterInWordPlayer(ch))
			throw new RuntimeException("Error de programacion, wordPlayer ya contiene esta letra."
					+ " Use el metodo hasLetterInWordPlayer() antes de invicar este metodo");
		
		if(!hasLetterInWordSecret(ch)){
			currentfails++;
			return new int[0];
		}
		
		int counter=0;
		
		for(int i=0; i<wordSecret.length;i++){						
			if(ch == wordSecret[i]){
				wordPlayer[i] = ch;
				counter++;
			}
		}
				
		int[] array = new int[counter];			
		counter=0;
		for(int i=0; i<wordSecret.length;i++){						
			if(ch == wordSecret[i]){
				array[counter++] = i;
			}
		}		
		return array; 	
	}


	/**
	 * 
	 * @return palabra del jugador wordPlayer
	 */
	public char[] getWordPlayer() {
		return wordPlayer;
	}


	/**
	 * COntador de racha (strak)
	 * @return retorna el numero de partidas ganadas consecutivas
	 */
	public int getStreak() {
		return streak;
	}

	public int getCurrentfails() {
		return currentfails;
	}

	public int getMaxFails() {
		return maxFails;
	}


	public void addFail() {
		this.currentfails++;		
	}


	public void addStreak() {
		this.streak++;		
	}
	
}
