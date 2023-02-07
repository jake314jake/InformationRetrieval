package Tokenizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import InputOutput.binWriter;
import Records.token;



public class Tokenizer  {
   private StringTokenizer st;  //parse
   private final String delimiterList=" ,.?!'\";-[]_()+*–";
   private List<token> tokens; //save tokens
   public Tokenizer(){
	   tokens=new ArrayList<>();
	   }
   // parse the file and get the tokens + append to tokens list(tokenIndex=listIndex)
   public void loadTokensFromFile(String filePath) throws IOException {
	int tokenCount=1;   
	String line;
	BufferedReader reader = new BufferedReader(new FileReader(filePath));
	while( (line = reader.readLine())!=null) {
		st = new StringTokenizer(line,delimiterList);
		while(st.hasMoreTokens()) {
			// add the record ( tokenPOSITION-tokenVALUE )
			tokens.add(new token(tokenCount,st.nextToken()));
			// update the count
			tokenCount++;
		}
	}
  }
   // get the  tokens list
   public List<token> getTokens(){
	   return tokens;
   }
 
  }

