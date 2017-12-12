package com.ef.carparking.util;

import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

public class UtilTools {
	public static OkHttpClient okHttpClient=new OkHttpClient.Builder().connectTimeout(500, TimeUnit.MILLISECONDS).readTimeout(5, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).build();
	public static Gson sglobalGson = Default0GsonBuilder.build();
	
	
	public static String arrayToString(String[] array)
	{
		if(array==null||array.length==0) return "";
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<array.length;i++)
		{
			sb.append(array[i]);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public static String formatCsvString(String str)
	{
	   if(str==null||str.isEmpty()) return "";
	   return str.replace("\"", "\"\"");
	}
}
