package com.Sample_Prep.PreparationCodes;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "Malayalam1";
		
		char[] ch = s1.toCharArray();
		int j =0;
		char[] chout = new char[15];
		for(int i=ch.length-1; i>=0;i--)
		{
			System.out.print(ch[i]);
			chout[j] = ch[i];
			j++;
		}

		
		String s2 = String.valueOf(chout);
		System.out.println("\n"+s2);
		
		StringBuilder ip1 = new StringBuilder();
		ip1.append(s1);
		ip1.reverse();
		System.out.println(ip1);
		
	}

}
