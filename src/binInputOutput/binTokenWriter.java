package binInputOutput;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import Records.token;

public class binTokenWriter extends fileWriter {

	public binTokenWriter(String path) {
		super(path);
	
	}
	//---------------------------------------------------------------------
	@Override
	public void write(List<?> object) {
		// Object her is a token object<<<
		// load the previous cont of the bin file
		binTokenReader btr =new binTokenReader(super.path);
		btr.read();
		
		   try (DataOutputStream dos = new DataOutputStream(super.fos)) {
			   int maxID=btr.getTokenMaxID();
			   for(Object tk : object) {
				   //write token -ID-Value NB: token id is unique due to maxID++
				   //check if token already exist (0----> not exist
				 
				    if(     btr
						   .getTokenByVALUE(((token) tk).tokenVALUE())
						   .equals(token.NotMatchToken)
						   )
				   {
				   maxID++;
				   dos.writeInt(maxID);
				   dos.writeUTF(((token) tk).tokenVALUE());}
			       }
	        
	   }catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
   //--------------------------------------------------------------------------

}