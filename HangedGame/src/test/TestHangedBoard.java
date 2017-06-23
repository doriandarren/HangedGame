package test;

import org.junit.Assert;
import org.junit.Test;

import main.HangedBoard;

public class TestHangedBoard {

	@Test
	public void testAddLetterToWordPlayer(){
		
		HangedBoard board = new HangedBoard(); 
		
		board.startGame("PERRO",2);   
		int[] results = board.addLetterToWordPlayer('R'); 
		int[] expected= new int[]{2,3}; 
			
		char[] charExpected = "--RR-".toCharArray();		
		
		Assert.assertArrayEquals(expected,results);		
		Assert.assertArrayEquals(charExpected,board.getWordPlayer()); 
	}
	
	
	@Test
	public void testIsWiner(){
		
		HangedBoard board = new HangedBoard(); 
		
		board.startGame("PERRO",2);   
		int[] results = board.addLetterToWordPlayer('R'); 
		results = board.addLetterToWordPlayer('P');
		results = board.addLetterToWordPlayer('E');
		results = board.addLetterToWordPlayer('O');
		
		boolean res = board.isWinner();
		
		Assert.assertEquals(res, true);
		
		
	}
			
	
	

	@Test
	public void testGameOver(){		
		HangedBoard board = new HangedBoard();		
		board.startGame("PERRO",2);   
		int[] results = board.addLetterToWordPlayer('R'); 
		results = board.addLetterToWordPlayer('X');
		results = board.addLetterToWordPlayer('C');
		results = board.addLetterToWordPlayer('O');
		
		boolean res = board.isGameOver();
		
		Assert.assertEquals(res, true);
	}
			
	
	
	
	
	
	
}
