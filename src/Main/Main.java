package Main;

import java.io.IOException;

import Tokenizer.Tokenizer;
import Tokenizer.txtFileTokenizer;
import binInputOutput.binTokenReader;
import binInputOutput.binTokenWriter;



public class Main {

	public static void main(String[] args) throws IOException {
		//create a Tokenizer obj + parse a file("BobbyFicsher.txt") + output tokens
		Tokenizer tk =new txtFileTokenizer();
		tk.loadTokensFromInput("src\\InputDocs\\BobbyFicsher.txt");
		System.out.println(tk.getTokens());
		// write tokenID-tokenVALUE in "BobbyFicsher.bin" file
		binTokenWriter btw =new binTokenWriter("src\\Output\\BobbyFicsher.bin");
		btw.write(tk.getTokens());
		// read from "BobbyFicsher.bin" file and get the token of id =2;
		binTokenReader btr =new binTokenReader("src\\Output\\BobbyFicsher.bin");
		btr.read();
		System.out.println("-------------------");
		System.out.println(btr.getTokenByID(2));
		
	}

}
