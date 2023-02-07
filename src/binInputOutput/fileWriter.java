package binInputOutput;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Interfaces.Writeable;

public class fileWriter {
    protected  String path;
    protected FileOutputStream fos;
    fileWriter(String path){
    	try {
			fos=new FileOutputStream(path,true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	

}
