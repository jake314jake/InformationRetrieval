package Records;

public record token(int tokenID,String tokenVALUE) {
	public static final token NotMatchToken=new token(0,"");
}
