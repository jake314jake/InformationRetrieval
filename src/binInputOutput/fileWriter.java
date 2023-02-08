package binInputOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;


public abstract class  fileWriter {
    protected  String path;
    protected FileOutputStream fos;
    fileWriter(String path){
    	try {
			fos=new FileOutputStream(path,true);
		    this.path=path;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
  public abstract void write(List<?> object);	

}
