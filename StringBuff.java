package com.question2;
//Write a program which creates a StringBuffer “This is StringBuffer” and performs the following.
public class StringBuff {
	public static void main(String[] args) {
//Adds the string”- This is a sample program” to existing string and display it.		
		StringBuffer sb=new StringBuffer("This is StringBuffer ");
		sb.append(" This is a sample program");
		System.out.println(sb);
		StringBuffer sb1=new StringBuffer();
		sb1.append(sb);
		sb.insert(21, "Object");
		System.out.println(sb);
		
		//reverse String
		System.out.println(sb.reverse());
		
		//replace "Buffer" with "Builder"
		System.out.println(sb1.replace(sb1.indexOf("Buffer"),sb1.indexOf("Buffer")+"Buffer".length(),"Builder"));
		
	}
	
	

}
