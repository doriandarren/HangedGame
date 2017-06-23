package main;

import util.FileHelper;

/**
 * Esta clase funciona como diccionario de palabras. Las palabras se guardaran en un archivo, cada linea 
 * correspondera a un par palabra:pista
 * 
 * @author campino
 *
 */
public class HangedModel {
	
	final String FILE_NAME;	
	private String[] newWord;

	
	public HangedModel(String fileDictionary){
		FILE_NAME = fileDictionary;
		loadWords();
	}
	
	
	/**
	 * Carga todo el diccionario de palabras desde el fichero
	 */
	private void loadWords(){
		newWord = FileHelper.readFile(FILE_NAME);	
	}
	
	/**
	 * retorna una palabra seleccionada aleatoriamente del arreglo newWord
	 * si no hay mas palabras disponibles en newWord, reinicia los arreglos. 
	 * es decir carga nuevamente las palabras desde el fichero con loadWords()
	 * @return
	 */
	public SecretWord getNextWord(){
		int rdm = (int) (Math.random()*(newWord.length-1));			
		String nextWord = newWord[rdm];		
		if(newWord.length==0){
			loadWords();
		}
		removeFromNewWord(rdm);		
		return new SecretWord(nextWord);
	}
	/*@Deprecated
	public String getNextWord(){		
		int rdm = (int) (Math.random()*(newWord.length-1));		
		String[] phrase = newWord[rdm].split(":");
		removeFromNewWord(rdm);		
		if(newWord.length==0){
			loadWords();
		}		
		return phrase[0]; 
	}*/
		
		
	private String[] removeFromNewWord(int rdm) {
		String arrayNew[]= new String[newWord.length - 1];
		for(int i=0; i<arrayNew.length; i++){			
			if(i>=rdm){				
				arrayNew[i]=newWord[i+1];
			}else{				
				arrayNew[i]=newWord[i];
			}
		}
		return arrayNew;
	}

	
	
	public static class SecretWord{
		public final String word;
		public final String hint;
		
		/**
		 * Recibe palabra secreta en formato de archivo
		 * palabra:pista
		 * @param fileLineWord
		 */		
		private SecretWord(String fileLineWord){
			String[] value = fileLineWord.split(":");
			//TODO validar length
			this.word = value[0];
			this.hint = value[1];
		}
		
	}
	
	
	
}
