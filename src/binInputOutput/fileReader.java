package binInputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class fileReader {
	  protected  String path;
	    protected FileInputStream fis;
	     fileReader(String path){
	    	try {
				fis=new FileInputStream(path);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	
	

}
