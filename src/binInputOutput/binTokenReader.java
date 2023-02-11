package binInputOutput;

import java.io.DataInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Records.token;
import Tokenizer.Tokenizer;

public class binTokenReader extends fileReader {
	TreeMap<String, Integer> tokens;
	public binTokenReader(String path){
		super(path);
		tokens=new TreeMap<String, Integer>();
	}
	//--------------------------------------------------------------
	@Override
	public void read() {
try (DataInputStream dis = new DataInputStream(super.fis)) {
			
			while(dis.available()>0) {
				int tokenID=dis.readInt();
				String tokenVALUE=dis.readUTF();
				tokens.put(tokenVALUE,tokenID);
			}
			
			
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	
	//----------------------------------------------------------------
	// get token by its id
	/*public token getTokenByID(int id) {
		for(token tk:tokens) {
			if (tk.tokenID()==id)
				return tk;
		}
		// if not exist  (empty token)
		return new token(0,"");
			
	}*/
	
	// get token by its value
	public token getTokenByVALUE(String value) {
			String normValue=Tokenizer.normlize(value);
			// if  exist  
			if (tokens.containsKey(normValue)) {
				return new token(tokens.get(normValue),value);
		       }
			// if not exist  (empty token)
		  return new token(0,"");
	}
	
	// get the max id value 
	int getTokenMaxID() {
		int maxID=0;
		
		    for (Map.Entry<String, Integer> entry : tokens.entrySet()) {
		      if (entry.getValue() > maxID) 
		        maxID = entry.getValue();
		      }
	 return maxID;
	 }
		    
	// GET tokens treeMap 
	public TreeMap<String, Integer> getTokens(){
		return tokens;
		
	}
	
}