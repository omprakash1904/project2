package com.prakash.automation.Supporters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AppData {
	static String filepath;
	static FileInputStream fip;
	static FileOutputStream fop;
	static Properties pro;
	static String value;
	static String newKey;
	static Map<String, String> map;
	public AppData(String filepath) throws IOException
	{
		this.filepath=filepath;
		fip=new FileInputStream(filepath);
		pro=new Properties();
		pro.load(fip);	
	}
	public static String getProperty(String key)
	{
		if(pro!=null)
			value=pro.getProperty(key);
		else
			System.out.println("TextfileProperties file is pointing to null");
		return value;
	}
	public static String setProperty(String key,String value) throws IOException
	{
		if(pro!=null)
		{
			newKey=(String) pro.setProperty(key, value);
			fop=new FileOutputStream(filepath);
			pro.store(fop, "new key is added to TextFileProperties");
		}
		else
			System.out.println("TextFileProperties file is pointing to null");
		return newKey;
	}
	public static void removeProperty(String key) throws IOException
	{
		if(pro!=null)
		{
			pro.remove(key);
			fop=new FileOutputStream(filepath);
			pro.store(fop, key+"property is removed from TextFileProperties");
		}
		else
			System.out.println("textProperties file is pointing to null");
	}
	public static Map<String, String> getAllProperties()
	{
		if(pro!=null)
		{
			Set<Object> key=pro.keySet();
			for(Object keys:key)
			{
				String k=(String)keys;
				value=pro.getProperty(k);
				map.put(k, value);
			}
		}
		else
			System.out.println("TextProperties file is pointing to null");
		return map;
	}
	
}
