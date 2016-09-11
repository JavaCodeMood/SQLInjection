package com.example.defense;

public class QueryParser {


	public static void main(String[] args) {
		String query1="select * from table where attribute='UserInput'";
		String query2="select * from table where attribute='UserInput'or 1=1";
		String[] tokens=query1.split("[\\s']|(--)");
		String[] tokens2=query2.split("[\\s']|(--)");
		System.out.println("Tokens:");
		for(int i=0;i<tokens.length;i++){
			System.out.println(i+":"+tokens[i]);
		}
		System.out.println("Tokens2:");
		for(int i=0;i<tokens2.length;i++){
			System.out.println(i+":"+tokens2[i]);
		}
		if(tokens.length==tokens2.length){
			System.out.println("No Injection");
		}else{
			System.out.println("There is injection!");
		}
	}

}
