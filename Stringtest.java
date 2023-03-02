package com.question1;

public class Stringtest {
	
	public static void main(String[] args) {
		String str="Welcome to Java World";
		System.out.println("return the characters at 5th postition :"+str.charAt(4));
		
		//"Welcome ignoring case
		
		if(str.compareToIgnoreCase("Welcome")==0) {
			System.out.println(str);
		}else {
			System.out.println("String is not equal to 'Welcome'");
		}
		
		//concatenates
		
		str.concat("Mahaprabu");//no changes
		str=str.concat("Mahaprabu ");//this line will work cause str=
		System.out.println(str);
		
		//return postion of the first occurence of character 'a'
		char[] chstr=new char[str.length()];
		for(int i=0;i<str.length();i++){
			chstr[i]=str.charAt(i);
			if(chstr[i]=='o') {
				System.out.println("First occurence position is :"+i);
				break;
			}
		}
		
		//Replacing all  'a' letter as 'e'
		
		str=str.replaceAll("a", "e");
		System.out.println(str);
		
		//Returns string between 4th position and 10th position and display it.
		System.out.println(str.substring(3, 9));
		
		//Returns the lowercase of the string and display it.
		
		String lowercase=str.toLowerCase();
		System.out.println("Original string:"+str);
		System.out.println("Lowercase string:"+lowercase);
		
		
		
		
			
		
	}

}
