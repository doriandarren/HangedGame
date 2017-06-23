package util;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
	
	
	private static final String PATTERN_TEXT = "[A-Za-z\\s]+";	
	private static final String PATTERN_NUMBER = "[0-9-\\,\\.]+";
	private static final String PATTERN_TEXT_NUMBER = "[A-Za-z0-9-\\,\\.\\s]+";	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private static final String PATTERN_PHONE = "[0-9]{9,15}";
	
	
	/**
	 * Devuelve un String formateado
	 * @param info es un String - pregunta
	 * @param optionFormat 
	 * 				[1- Solo texto] 
	 * 				[2- Texto y Numero] 
	 * 				[3- Validar email] 
	 * 				[4- solo numeros]
	 * 				[5- valida phone]
	 * @return
	 */
	public static String scanLineSecure(String info, int optionFormat){
		String inputStr;		
		do{
			System.out.print(info);
			Scanner reader = new Scanner(System.in);
			inputStr = reader.nextLine();
			inputStr = inputStr.trim();
			
			if(inputStr.isEmpty()){
				System.out.println(" Ingrese un valor...");
			}else if(optionFormat==1){
				boolean val = validateOnlyText(inputStr);
				if(!val){
					System.out.println(" Ingrese solo texto...");
					inputStr="";
				}				
			}else if(optionFormat==2){
				boolean val = validateTextNumber(inputStr);
				if(!val){
					System.out.println(" Ingrese solo texto y números...");
					inputStr="";
				}
			}else if(optionFormat==3){
				boolean valEmail = validateEmail(inputStr);
				if(!valEmail){
					System.out.println(" Ingrese un email válido...");
					inputStr="";
				}
			}else if(optionFormat==4){
				boolean valEmail = validateOnlyNumber(inputStr);
				if(!valEmail){
					System.out.println(" Ingrese solo números...");
					inputStr="";
				}
			}else if(optionFormat==5){
				boolean valEmail = validatePhone(inputStr);
				if(!valEmail){
					System.out.println(" Ingrese Telefono válido...");
					inputStr="";
				}
			}			
		}while(inputStr.isEmpty());	
		return inputStr; 
	}
	

	public static boolean validateOnlyText(String str){
		Pattern pattern = Pattern.compile(PATTERN_TEXT);
		Matcher matcher = pattern.matcher(str);					
		return matcher.matches();
	}
	
	public static boolean validateOnlyNumber(String str){
		Pattern pattern = Pattern.compile(PATTERN_NUMBER);
		Matcher matcher = pattern.matcher(str);		
		return matcher.matches();
	}
	
	public static boolean validateTextNumber(String str){
		Pattern pattern = Pattern.compile(PATTERN_TEXT_NUMBER);
		Matcher matcher = pattern.matcher(str);		
		return matcher.matches();
	}
	
	public static boolean validatePhone(String str){
		Pattern pattern = Pattern.compile(PATTERN_PHONE);
		Matcher matcher = pattern.matcher(str);		
		return matcher.matches();
	}
	
	
	public static boolean validateEmail(String str) {
		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	
	
	
	/*FUNCIONES INICIALES SE USAN POCO +++++++++++++++++++++++++++++*/
	public static int scannInt(){
		Scanner reader = new Scanner(System.in);
		int var = reader.nextInt();
		//reader.close();
		return var;
	}
	
	public static float scannFloat(){
		Scanner reader = new Scanner(System.in);
		float var = reader.nextFloat();
		//reader.close();
		return var;
	}
	
	public static String scannLine(){
		Scanner reader = new Scanner(System.in);
		String var = reader.nextLine();
		//reader.close();
		return var;
	}
	
	
}
