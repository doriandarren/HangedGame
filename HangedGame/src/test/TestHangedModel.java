package test;

import java.util.logging.Handler;

import org.junit.Assert;
import org.junit.Test;

import main.HangedModel;

public class TestHangedModel {

	@Test
	public void testGetNextWord(){		
		
		
		HangedModel han = new HangedModel("file.txt");
		HangedModel.SecretWord secretWord = han.getNextWord();
		
		
		
		
		
	}
	
	
	
	
}
