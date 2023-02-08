package Tokenizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import Records.token;

public class txtFileTokenizer extends Tokenizer  {
     private final String delimiterList=" ,.?!'\";-[]_()+*–";
     public txtFileTokenizer() {
    	 super();
     }
	@Override
	public void loadTokensFromInput(String filePath) {

		int tokenCount=1;   
		String line;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			while( (line = reader.readLine())!=null) {
				st = new StringTokenizer(line,delimiterList);
				while(st.hasMoreTokens()) {
					// add the record ( tokenPOSITION-tokenVALUE )
					super.tokens.add(new token(tokenCount,st.nextToken()));
					// update the count
					tokenCount++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  
		
	}
	 
}
