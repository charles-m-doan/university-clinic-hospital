package uch;

import java.util.ArrayList;
import java.util.Random;

public class Global {

	public static final String NEWLINE = System.getProperty("line.separator");
	public static final Random random = new Random(System.nanoTime());

	private Global()
		{
		}

	public static int getValueBetweenRange(int min, int max)
		{
		int randomValue = min + random.nextInt((max - min) + 1);
		return randomValue;
		}

	public static void printStringArray(String[] strArr)
		{
		for (int i = 0; i < strArr.length; i++)
			{
			System.out.println(strArr[i]);
			}
		}

	public static void printStringArrayList(ArrayList<String> stringList)
		{
		for (String str : stringList)
			{
			System.out.println(str);
			}
		}

	public static String stringArrayListToString(ArrayList<String> stringList)
		{
		StringBuilder sb = new StringBuilder();
		for (String str : stringList)
			{
			sb.append(NEWLINE + str);
			}
		return sb.toString();
		}
}
