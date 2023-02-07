package binInputOutput;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import Records.token;

public class binTokenWriter extends fileWriter {

	public binTokenWriter(String path) {
		super(path);
		
	}
   public void pushToken(List<token> tokens) {
	   int maxID=0;
	   try (DataOutputStream dos = new DataOutputStream(super.fos)) {
		   for(token tk : tokens) {
			   //write token -ID-Value NB: token id is unique due to maxID++
			   maxID++;
			   dos.writeInt(maxID);
			   dos.writeUTF(tk.tokenVALUE());
		   }
           
      }catch (IOException e) {
	    e.printStackTrace();
	}
    }
}