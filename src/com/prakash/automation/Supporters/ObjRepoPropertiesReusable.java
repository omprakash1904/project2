package com.prakash.automation.Supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ObjRepoPropertiesReusable {
	static String filepath;
	static FileInputStream fip;
	static Properties pro;
	static FileOutputStream fop;
	static String value;
	static Map<String, String> map;
	public ObjRepoPropertiesReusable(String filepath) throws IOException
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
			System.out.println("properties file is pointing to null");
		return value;
	}
	public static void setProperty(String key,String value) throws IOException
	{
		if(pro!=null)
		{
			pro.setProperty(key, value);
		fop=new FileOutputStream(filepath);
		pro.store(fop, "Property is added to ObjRepo properties file");
	}
		else
			System.out.println("properties file is pointing to null");
	}
	public static void removeProperty(String key) throws IOException
	{
		if(pro!=null){
			pro.remove(key);
			fop=new FileOutputStream(filepath);
			pro.store(fop, key+" Property is removed from ObjRepo properties file");
		}
		else
			System.out.println("properties file is pointing to null");
	}
	public static Map<String, String> getAllProperties()
	{
		Set<Object> key=pro.keySet();
		if(pro!=null)
		{
			for(Object k:key)
			{
				String keys=(String)k;
				value=(String) pro.get(keys);
				map.put(keys, value);
			}
		}
		else
			System.out.println("properties file is pointing null");
		return map;
		/*Map<String, String> keyValues=ObjReporeUsables.getAllProperties();
		return keyValues;*/
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
