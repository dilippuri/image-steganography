
import java.io.File;

import java.awt.FlowLayout;
import javax.swing.*;
import java.lang.Object;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
 import java.io.IOException;

import java.net.*;
import java.io.*;
import java.util.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

import java.io.PrintWriter;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;




/*
 *Steganography_Controller Class
 */
public class Steganography_Controller
{
	//Program Variables
	private Steganography_View	view;
	private Steganography		model;
	
	//Panel Displays
	private JPanel		open_panel;
	private JPanel		decode_panel;
	private JPanel		encode_panel;
	//Panel Variables
	private JTextArea 	input;
	private JButton	        encodeButton,decodeButton;
	private JLabel		image_input;
	//Menu Variables
	private JMenuItem 	open;
        private JMenuItem       save;
	private JMenuItem       connect;
	private JMenuItem 	encode;
	private JMenuItem 	decode;
	private JMenuItem 	about;
	private JMenuItem 	exit;
	

	//action event classes
	private Open			ope;
	private Save                    sav;
	private Connect 		con;
	private Encode			enc;
	private Decode			dec;
	private About			abo;
	private EncodeButton	encButton;
	private DecodeButton	decButton;
	
	//decode variable
	private String			stat_path = "";
	private String			stat_name = "";
	
	public Steganography_Controller(Steganography_View aView, Steganography aModel)
	{
		//program variables
		view  = aView;
		model = aModel;
		
		//assign View Variables
		//2 views
		open_panel      = view.getTextPanel();
		encode_panel	= view.getTextPanel();
		decode_panel	= view.getImagePanel();
		//2 data options
		input			= view.getText();
		image_input		= view.getImageInput();
		//2 buttons
		encodeButton	= view.getEButton();
		decodeButton	= view.getDButton();
		//menu
		open			= view.getOpen();
		save 			= view.getSave();	
		connect			= view.getConnect();	
		encode			= view.getEncode();
		decode			= view.getDecode();
		exit			= view.getExit();
		about			= view.getAbout();
		
		//assign action events
		ope = new Open();
		open.addActionListener(ope);
		sav = new Save();
		save.addActionListener(sav);
		con = new Connect();
    		connect.addActionListener(con);
		enc = new Encode();
		encode.addActionListener(enc);
		dec = new Decode();
		decode.addActionListener(dec);
		exit.addActionListener(new Exit());
		abo = new About();
		about.addActionListener(abo);
		encButton = new EncodeButton();
		encodeButton.addActionListener(encButton);
		decButton = new DecodeButton();
		decodeButton.addActionListener(decButton);
         
		
		//encode view as default
		encode_view();
	}
	
	/*
	 *Updates the single panel to display the Encode View.
	 */
	 
	private void open_view()
	{
		update();
		view.setContentPane(decode_panel);
		view.setVisible(true);
	}
	
	
	private void encode_view()
	{
		update();
		view.setContentPane(encode_panel);
		view.setVisible(true);
	}
	
	/*
	 *Updates the single panel to display the Decode View.
	 */
	private void decode_view()
	{
		update();
		view.setContentPane(decode_panel);
		view.setVisible(true);
	}
	
	/*
	 *Encode Class - handles the Encode menu item
	 */
	 

	


	private class Encode implements ActionListener
	{
		/*
		 *handles the click event
		 *@param e The ActionEvent Object
		 */
		public void actionPerformed(ActionEvent e)
		{
			encode_view(); //show the encode view
		}
	}
	
	/*
	 *Decode Class - handles the Decode menu item
	 */
	private class Decode implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			decode_view(); //show the decode view
			
			//start path of displayed File Chooser
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setFileFilter(new Image_Filter());
			int returnVal = chooser.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File directory = chooser.getSelectedFile();
				try{
					String image = directory.getPath();
					stat_name = directory.getName();
					stat_path = directory.getPath();
					stat_path = stat_path.substring(0,stat_path.length()-stat_name.length()-1);
					stat_name = stat_name.substring(0, stat_name.length()-4);
					image_input.setIcon(new ImageIcon(ImageIO.read(new File(image))));
				}
				catch(Exception except) {
				//msg if opening fails
				JOptionPane.showMessageDialog(view, "The File cannot be opened!", 
					"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	
	// open class
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

private class About implements ActionListener
{
	        public void actionPerformed(ActionEvent e)
{
     		JFrame frame = new JFrame("About_US");
                JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());
	 
	        JLabel label1 = new JLabel("Kushal Jangid");
		ImageIcon iconLogo = new ImageIcon("k.png");
		label1.setIcon(iconLogo);

          	JLabel j = new JLabel ("Kushal, Dilip & Raghuvar");
	       
		panel.add(label1);
	        frame.add(panel);
	        frame.setSize(400, 400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        frame.setVisible(true);
}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		private class Open implements ActionListener
	{
		
	        public void actionPerformed(ActionEvent e)
		{
               JLabel background=new JLabel(new ImageIcon("a.png"));
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setFileFilter(new File_Filter());
			int returnVal = chooser.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File directory = chooser.getSelectedFile();
				try{
					String image = directory.getPath();
					stat_name = directory.getName();
					stat_path = directory.getPath();
					stat_path = stat_path.substring(0,stat_path.length()-stat_name.length()-1);
					stat_name = stat_name.substring(0, stat_name.length()-4);

					FileReader fr = new FileReader(image); 
					BufferedReader br = new BufferedReader(fr);

				        input.read(br,"filename");	
										
 
				}
				catch(Exception except) {
				//msg if opening fails
				JOptionPane.showMessageDialog(view, "The File cannot be opened!", 
					"Error!", JOptionPane.INFORMATION_MESSAGE);

		}
	}
	}
	}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		private class Connect implements ActionListener
	{
	        public void actionPerformed(ActionEvent e)
{       
 class transferfile extends Thread
{
    Socket ClientSoc;

    DataInputStream din;
    DataOutputStream dout;
    
    transferfile(Socket soc)
    {
        try
        {
            ClientSoc=soc;                        
            din=new DataInputStream(ClientSoc.getInputStream());
            dout=new DataOutputStream(ClientSoc.getOutputStream());
            System.out.println("New Client Connected to the Server...");
            start();
            
        }
        catch(Exception ex)
        {
        }        
    }
    void SendFile() throws Exception
    {        
        String filename=din.readUTF();
        File f=new File(filename);
        if(!f.exists())
        {
            dout.writeUTF("File Not Found");
            return;
        }
        else
        {
            dout.writeUTF("READY");
            FileInputStream fin=new FileInputStream(f);
            int ch;
            do
            {
                ch=fin.read();
                dout.writeUTF(String.valueOf(ch));
            }
            while(ch!=-1);    
            fin.close();    
            dout.writeUTF("File Receive Successfully");                            
        }
    }
    
    void ReceiveFile() throws Exception
    {
        String filename=din.readUTF();
        if(filename.compareTo("File not found")==0)
        {
            return;
        }
        File f=new File(filename);
        String option;
        
        if(f.exists())
        {
            dout.writeUTF("File Already Exists");
            option=din.readUTF();
        }
        else
        {
            dout.writeUTF("SendFile");
            option="Y";
        }
            
            if(option.compareTo("Y")==0)
            {
                FileOutputStream fout=new FileOutputStream(f);
                int ch;
                String temp;
                do
                {
                    temp=din.readUTF();
                    ch=Integer.parseInt(temp);
                    if(ch!=-1)
                    {
                        fout.write(ch);                    
                    }
                }while(ch!=-1);
                fout.close();
                dout.writeUTF("File Send Successfully");
            }
            else
            {
                return;
            }
            
    }


    public void run()
    {
        while(true)
        {
            try
            {
            System.out.println("Waiting for Command ...");
            String Command=din.readUTF();
            if(Command.compareTo("GET")==0)
            {
                System.out.println("\tGET Command Received ...");
                SendFile();
                continue;
            }
            else if(Command.compareTo("SEND")==0)
            {
                System.out.println("\tSEND Command Receiced ...");                
                ReceiveFile();
                continue;
            }
            else 
                {
		System.out.println("\tDisconnect Command Received ...");
                break;
}
            }
            catch(Exception ex)
            {
            }
        }
 }
}       

try {

final   ServerSocket soc=new ServerSocket(5217);
        System.out.println("Server Started Ruuning.......... ");
            System.out.println("Waiting for new Connection ...");
            transferfile t=new transferfile(soc.accept());
        
encode_view();   
}

catch(IOException e7)
{
System.out.println("Wrong Connections");
}

}
         }
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		private class Save implements ActionListener
	{
		
	        public void actionPerformed(ActionEvent e)
		{

		File file;

		// create and display dialog box to get file name
		JFileChooser dialog = new JFileChooser();

		// Make sure the user didn't cancel the file chooser
		if (dialog.showSaveDialog(input) == JFileChooser.APPROVE_OPTION) {

			// Get the file the user selected
			file = dialog.getSelectedFile();

			try {
				// Now write to the file
				PrintWriter output = new PrintWriter(new FileWriter(file));
				output.println(input.getText());
				output.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(input, "Can't save file "
						+ e1.getMessage());
			}
		}
		}
	}


	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 *Exit Class - handles the Exit menu item
	 */

	private class Exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0); //exit the program
		}
	}
		//Open Button
	

	
	
	/*
	 *Encode Button Class - handles the Encode Button item
	 */
	private class EncodeButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			//start path of displayed File Chooser
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setFileFilter(new Image_Filter());
			int returnVal = chooser.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				File directory = chooser.getSelectedFile();
				try{
					String text = input.getText();
					String ext  = Image_Filter.getExtension(directory);
					String name = directory.getName();
					String path = directory.getPath();
					path = path.substring(0,path.length()-name.length()-1);
					name = name.substring(0, name.length()-4);
					
					String stegan = JOptionPane.showInputDialog(view,
									"Enter output file name:", "File name",
									JOptionPane.PLAIN_MESSAGE);
					
					if(model.encode(path,name,ext,stegan,text))
					{
						JOptionPane.showMessageDialog(view, "The Image was encoded Successfully!", 
							"Success!", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(view, "The Image could not be encoded!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
					}
					//display the new image
					decode_view();
					image_input.setIcon(new ImageIcon(ImageIO.read(new File(path + "/" + stegan + ".png"))));
				}
				catch(Exception except) {
				//msg if opening fails
				JOptionPane.showMessageDialog(view, "The File cannot be opened!", 
					"Error!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
	}
	
	
	/*
	 *Decode Button Class - handles the Decode Button item
	 */
	private class DecodeButton implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String message = model.decode(stat_path, stat_name);
			System.out.println(stat_path + ", " + stat_name);
			if(message != "")
			{
				encode_view();
				JOptionPane.showMessageDialog(view, "The Image was decoded Successfully!", 
							"Success!", JOptionPane.INFORMATION_MESSAGE);

				input.setText(message);
			}
			else
			{
				JOptionPane.showMessageDialog(view, "The Image could not be decoded!", 
							"Error!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	
	

	
	
	/*
	 *Updates the variables to an initial state
	 */
	public void update()
	{
		input.setText("");			//clear textarea
		image_input.setIcon(null);	//clear image
		stat_path = "";				//clear path
		stat_name = "";				//clear name
	}
	
	/*
	 *Main Method for testing
	 */
	public static void main(String args[])
	{
          
	final   JFrame frame = new JFrame("Image Steganography Toolkit");
                JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());
	 
	        JLabel label = new JLabel("");
	  ImageIcon iconLogo = new ImageIcon("a.gif");
          label.setIcon(iconLogo);
          JLabel j = new JLabel ("Kushal, Dilip & Raghuvar");
	        JButton button = new JButton();
	        button.setText("Enter Here (Server)!");
	 
                panel.add(j);
	        panel.add(label);
	        panel.add(button);
	 
	        frame.add(panel);
	        frame.setSize(900, 400);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        frame.setVisible(true);

button.addActionListener( new ActionListener()
{ 
   
    public void actionPerformed(ActionEvent e)
    {
	frame.setVisible(false); 
      new Steganography_Controller(
									new Steganography_View("Steganography(Server)"),
									new Steganography()
									);
    }
}
);
										
	}
}


