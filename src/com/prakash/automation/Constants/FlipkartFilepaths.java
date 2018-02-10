package com.prakash.automation.Constants;

public class FlipkartFilepaths {
	static String ObjRepoFilepath,ConfigPropertiesFilepath,TextFilepath,ExcelFilepath,AppdataFilepath;
	public static String getObjRepoFilepath()
	{
		return ObjRepoFilepath=System.getProperty("user.dir")+"\\src\\com\\prakash\\automation\\ObjectRepository\\ObjRep.properties";
	}
	public static String getConfigPropertiesFilepath()
	{
		return ConfigPropertiesFilepath=System.getProperty("user.dir")+"\\src\\com\\prakash\\automation\\configurationProperties\\FlipkartConfig.properties";
	}
	public static String getTextFilepath()
	{
		return TextFilepath=System.getProperty("user.dir")+"\\src\\com\\prakash\\automation\\ObjectRepository\\TextFile.properties";
	}
	public static String getExcelFilepath()
	{
		return ExcelFilepath=System.getProperty("user.dir")+"\\src\\com\\prakash\\automation\\TestData\\Book1.xlsx";
	}
	public static String getAppDataFilepath()
	{
		return AppdataFilepath=System.getProperty("user.dir")+"\\src\\com\\prakash\\automation\\appData\\FlipkartAppData.txt";
	}

}
