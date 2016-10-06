
import java.io.*; 

/*
 *Image_Filter Class
 */
public class Image_Filter extends javax.swing.filechooser.FileFilter
{
	
	protected boolean isImageFile(String ext)
	{
		return (ext.equals("jpg")||ext.equals("png"));
	}
	
	
	public boolean accept(File f)
	{
	    if (f.isDirectory())
	    {
			return true;
	    }

	    String extension = getExtension(f);
		if (extension.equals("jpg")||extension.equals("png"))
		{
			return true;
		}
		return false;
	}
	
	
	public String getDescription()
	{
		return "Supported Image Files";
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
