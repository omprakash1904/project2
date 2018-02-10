package com.prakash.automation.Supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ConfigPropertiesReusables {
	static String filepath;
	static FileInputStream fip;
	static Properties pro;
	static FileOutputStream fop;
	static String value;
	static Map<String, String> map;
	public ConfigPropertiesReusables(String filepath) throws IOException
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
			System.out.println("ConfigProperties file is pointing to null");
		return value;
	}
	public static String setProperty(String key,String value) throws IOException
	{
		String NewProperty=null;
		if(pro!=null)
		{
			NewProperty=(String) pro.setProperty(key, value);
		fop=new FileOutputStream(filepath);
		pro.store(fop, "Property is added to ObjRepo properties file");
	}
		else
			System.out.println("ConfigProprties File is pointing to null");
		return NewProperty;
	}
	public static void removeProperty(String key) throws IOException
	{
		if(pro!=null)
		{
			pro.remove(key);
			fop=new FileOutputStream(filepath);
			pro.store(fop, key+" property is removed from ConfigProperties file ");
		}
		else
			System.out.println("ConfigProperties file is pointing to null");
	}
	public static Map<String, String> getAllProperties()
	{
		if(pro!=null)
		{
			Set<Object> k=pro.keySet();
			for(Object keys:k)
			{
				String key=(String)keys;
				String value=pro.getProperty(key);
				map.put(key, value);
			}
		}
		else
			System.out.println("ConfigProperties file is pointing to null");
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
