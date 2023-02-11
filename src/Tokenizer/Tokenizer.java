package Tokenizer;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

import Records.token;



public abstract class Tokenizer  {
	protected StringTokenizer st;  //parse
	protected List<token> tokens; //save tokens
	protected Tokenizer(){
	   tokens=new ArrayList<>();
	   }
   // parse the file and get the tokens + append to tokens list(tokenIndex=listIndex)
    public abstract  void loadTokensFromInput(String filePath) ;
   // get the  tokens list
    public List<token> getTokens(){
	   return tokens;
   }
    public static String normlize(String str) {
    	return str.toLowerCase();
    }
 
  }
