package msc;

import java.io.*;
import java.util.Properties;


/**
 * This class contains static methods designed to deal with reading
 * and writing properties.
 * 
 * @author lmaciak
 *
 */
public class PropsToolkit
{
	
	public static void write(String path, Properties props) throws IOException
	{
		File outfile = new File(path);
			
		if(!outfile.exists())
			outfile.createNewFile();
		
		OutputStream out = new FileOutputStream(outfile);
		props.store(out, "generated by PropsToolkit (c) Lukasz Grzregorz Maciak");
	}
	
	public static Properties read(String path) throws IOException
	{
		File infile = new File(path);
		
		if(!infile.exists())
			infile.createNewFile();
		
		Properties props = new Properties();
	
		InputStream in = new FileInputStream(infile);
		props.load(in);
		
		return props;
		
	}
	
	public static void writeIntoHomeDir(String filename, Properties props) throws IOException
	{
		String path = System.getProperty("user.home") + System.getProperty("file.separator") +  filename;
		write(path, props);
	}
	
	public static Properties readFromHomeDir(String filename) throws IOException
	{
		String path = System.getProperty("user.home") + System.getProperty("file.separator") +  filename;
		return read(path);
	}

}
