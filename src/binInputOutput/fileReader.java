package binInputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public abstract class fileReader {
	  protected  String path;
	    protected FileInputStream fis;
	     fileReader(String path){
	    	try {
				fis=new FileInputStream(path);
				this.path=path;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("FileNotFound");
				e.printStackTrace();
			}
	    	
	    }
	     
	public abstract void read();

}
