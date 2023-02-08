package binInputOutput;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Records.token;

public class binTokenReader extends fileReader {
	List<token> tokens;
	public binTokenReader(String path){
		super(path);
		tokens=new ArrayList<>();
	}
	//--------------------------------------------------------------
	@Override
	public void read() {
try (DataInputStream dis = new DataInputStream(super.fis)) {
			
			while(dis.available()>0) {
				tokens.add(new token(dis.readInt(),dis.readUTF()));
			}
			
			
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}

	
	//----------------------------------------------------------------
	// get token by its id
	public token getTokenByID(int id) {
		for(token tk:tokens) {
			if (tk.tokenID()==id)
				return tk;
		}
		// if not exist  (empty token)
		return new token(0,"");
			
	}
	
	// get token by its value
	public token getTokenByVALUE(String value) {
		for(token tk:tokens) {
			
			if (value.equals(tk.tokenVALUE()))
				return tk;
			
		}
		// if not exist  (empty token)
		return new token(0,"");
		}
	
	// get the max id value 
	int getTokenMaxID() {
		int maxID=0;
		for(token tk:tokens) {
			if (tk.tokenID()>maxID)
				maxID=tk.tokenID();
		}
		return maxID;
	}
	
	
}
