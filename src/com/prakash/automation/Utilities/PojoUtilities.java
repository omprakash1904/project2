package com.prakash.automation.Utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.prakash.automation.Constants.FlipkartFilepaths;
import com.prakash.automation.Supporters.AppData;
import com.prakash.automation.Supporters.ConfigPropertiesReusables;
import com.prakash.automation.Supporters.ExcelFileReusables;
import com.prakash.automation.Supporters.ObjRepoPropertiesReusable;
import com.prakash.automation.Supporters.TextFileReusables;

public class PojoUtilities {
	private static ObjRepoPropertiesReusable ObjRepoObject;
	private static ConfigPropertiesReusables ConfigPropertiesObj;
	private static TextFileReusables TextFileObj;
	private static ExcelFileReusables ExcelFileObj;
	private static AppData AppDataObj;
	public static ObjRepoPropertiesReusable getObjRepoPropertiesReusableObject() throws IOException
	{
		return ObjRepoObject=new ObjRepoPropertiesReusable(FlipkartFilepaths.getObjRepoFilepath());
	}
	public static ConfigPropertiesReusables getConfigPropertiesReusablesObject() throws IOException
	{
		return ConfigPropertiesObj=new ConfigPropertiesReusables(FlipkartFilepaths.getConfigPropertiesFilepath());
	}
	public static TextFileReusables getTextFileReusablesObject() throws IOException
	{
		return TextFileObj=new TextFileReusables(FlipkartFilepaths.getTextFilepath());
	}
	public static ExcelFileReusables getExcelFileReusablesObject() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		return ExcelFileObj=new ExcelFileReusables(FlipkartFilepaths.getExcelFilepath());
	}
	public static AppData getAppData() throws IOException
	{
		return  AppDataObj=new AppData(FlipkartFilepaths.getAppDataFilepath());
	}

}
