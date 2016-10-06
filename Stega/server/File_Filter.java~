
import java.io.*; 

/*
 *Image_Filter Class
 */
public class File_Filter extends javax.swing.filechooser.FileFilter
{
	
	protected boolean isImageFile(String ext)
	{
		return (ext.equals("txt"));
	}
	
	
	public boolean accept(File f)
	{
	    if (f.isDirectory())
	    {
			return true;
	    }

	    String extension = getExtension(f);
		if (extension.equals("txt"))
		{
			return true;
		}
		return false;
	}
	
	
	public String getDescription()
	{
		return "Supported Text Files";
	}
	
	
	protected static String getExtension(File f)
	{
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1) 
		  return s.substring(i+1).toLowerCase();
		return "";
	}	
}
