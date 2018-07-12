import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.Dimension;  
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.io.*;
import java.text.*;
import java.util.*;

public class First extends JFrame implements java.io.Serializable

{
	public static int accountnumber = 0;
	JButton cust;
	JButton emp;
	JLabel  ques;
	JButton b11;
	JButton b12;
	JButton bCA;
	JButton bMA;
	JButton bVA;
	JButton bOT;
	JButton bWC;
	JButton bMS;
	JButton bDA;
	JButton bDC;
	JButton b31;
	JButton b32;
	
	TextArea eva,eba;
	
	JTextField clata;
	JPasswordField clpa;
	JButton clb;
	
	
   JTextField  nf,adf,abf,soif,pnf,pii,acn;
   JPasswordField rupf,upf,repf;
   
    
        
	

public First()
  {
  	
  	ActionEventHandler cb= new ActionEventHandler();
  	ActionEventHandler eb= new ActionEventHandler();
  	
  	
  	Container c= getContentPane();
  	
  	c.setLayout(new BorderLayout());
  	JPanel p1 = new JPanel();
  	JPanel p2 = new JPanel();
  	p1.setLayout(new GridLayout(1,1));
  	p2.setLayout(new GridLayout(1,2));
  	
  	
  	ques= new JLabel("");
  	cust= new JButton ("Customer");
  	emp= new JButton ("Employee");
  	
  	cust.addActionListener(cb);
    emp.addActionListener(eb);
  		
  	p1.add(ques);
  	p2.add(cust);
  	p2.add(emp);
  	
  	c.add(p1,BorderLayout.NORTH);
  	c.add(p2,BorderLayout.CENTER);
  	
  	
  	    Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();  
        int framewidth=this.getSize().width;
        int frameheigth=this.getSize().height;  
        int framelocationX=((dim.width-framewidth)/3);   
        int framelocationY=(dim.height-frameheigth)/3;  
        this.setLocation(framelocationX,framelocationY); 
  	
  	
  }
  
public  class ActionEventHandler implements ActionListener
  {
  	public void actionPerformed(ActionEvent e)
  	{
  		      if(e.getSource()==cust)
  		       {
  		       	
  		       	
  			     cLogin();
  			     
                  			     
  			   }
  			     
  			     
  			    else if(e.getSource()==emp)
  			    {
  				uLogin();
  				}
	
  		
  	}
  	
  	}
  
  
public static void main(String[] args)
  {
  	First x= new First();
  	
  	x.setSize(400,200);
  	x.setResizable(false);
  	x.setDefaultCloseOperation(EXIT_ON_CLOSE);
  	x.show(); 
  		
  	
  	}
  	
  	
  	
public void cLogin()
{
  		    final	JFrame f= new JFrame();
  			f.setLayout(new GridLayout(3,1));
  			JPanel p1=new JPanel();
  			JPanel p2= new JPanel();
  			JPanel p3= new JPanel();
  			JLabel a= new JLabel("Account Number : ");
  			JLabel p= new JLabel(" PIN :                         ");
  			clata= new JTextField(8); 
  			clpa= new JPasswordField(8);
  			clb= new JButton(" Login ");
  			p1.add(a);
  			p1.add(clata);
  			p2.add(p);
  			p2.add(clpa);
  			p3.add(clb);
  			
  			f.add(p1);
  			f.add(p2);
  			f.add(p3);
  	
  		f.setSize(250,130);
  	    f.setResizable(false);
  	    f.setLocationRelativeTo(null);
  		f.show();
  
  	        clb.addActionListener(new ActionListener()
			 {
				public void  actionPerformed(ActionEvent e)
				{
					int accno = Integer.parseInt(clata.getText());
					String acco_number =""+accno;
					
					File fe = new File("C:\\Users\\Ebad\\Documents\\JCreator Pro\\MyProjects\\banks\\"+acco_number);
					
					if(!fe.exists())
					{
						JOptionPane.showMessageDialog(null,"Account does not Exist","Account Error",JOptionPane.ERROR_MESSAGE);
						f.setVisible(false);
						cLogin();
					}
					else if(fe.exists())
					{
						String ps = clpa.getText();
						int pass = Integer.parseInt(ps);
						
						Account x = new Account("","","","",0.0,0);
		
                         	try
	                    {
	                              ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(acco_number));	
                                 x =((Account)input.readObject());
	                    }
	
	              catch(FileNotFoundException er)
     	           {
		                   JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	               }
		
		          catch(IOException er)
	               {
			               JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	               }
			
		         catch(ClassNotFoundException er)
		           {
			               JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
			
		           }
	             if(pass==x.pi)
		          {
		               f.setVisible(false);
			            Customer(acco_number);
		          }
	           	else
		          {
			            JOptionPane.showMessageDialog(null,"The pin you entered is incorrect, Please Try again. ");
			            f.setVisible(false);
 		                cLogin();
		          }
		
						
			}
			
  		         }
			}
		);
			
  
}

public void Customer(String account_number)
  	{
  		    JPanel pan= new JPanel();
  		 	JPanel panbot=new JPanel();
  		 	JLabel bott= new JLabel("                                                               ANIASH BANK LIMITED");
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             panbot.add(bott);
             panbot.add(label);
  	       	 pan.setLayout(new GridLayout(3,1));
  	       	 
  		 ActionEventHandler efb= new ActionEventHandler();
  		 ActionEventHandler efb2= new ActionEventHandler();
  		
  		 JFrame frame2 = new JFrame();
  		 
  		 bVA= new JButton("View Account");
  		 bOT= new JButton("Online Transaction");
  		 bWC= new JButton("Change pin");
  		 
  		   	bVA.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					CVA(account_number);				
				}
			}
		);
		
		bOT.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					COT(account_number);			
				}
			}
		);
		
		bWC.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
						CHP(account_number);
				}
			}
		);
		
  		eva= new TextArea(5,5);
  		pan.add(bVA);
  		pan.add(bOT);
  		pan.add(bWC);
  	  	
  		frame2.add(panbot,BorderLayout.SOUTH);
  	    frame2.add(eva,BorderLayout.CENTER);
  		frame2.add(pan,BorderLayout.WEST);
  		frame2.setSize(500,400);
  		frame2.setLocationRelativeTo(null);
  		frame2.show();
  			
  	}
  	
  		
public void CVA(String accn)
{
	
		Account x = new Account("","","","",0.0,0);
		
	try
	{
	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(accn));
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		
		String show = "";
		show+="Name :\t"+x.nam+"\nAddress :\t"+x.addre+"\nSource of Income :\t"+x.sour+"\nPhone Number :\t"+x.phn+"\nAccount Balance :\t"+x.amnt;
  		
  		 eva.setText(show);
	
}
			
public void COT(String accn)
{
 	        ActionEventHandler ss	=	new ActionEventHandler();
 	        ActionEventHandler ani	=	new ActionEventHandler();
 	          
  	 	     
  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel adl= new JLabel("Reciever's account number ");
  		JLabel phl = new JLabel("Amount to transfer ");
  		
  		

  		adf =new JTextField(5);
  		pnf= new JTextField(10);
  	

  	   adf.addActionListener(ss);
  	   pnf.addActionListener(ani);
  	   
  	   
  	    main_pan.add(adl);
  	    main_pan.add(adf);
  	    
  	    main_pan.add(phl);
  	    main_pan.add(pnf);
  	   
  	     JFrame frame3 = new JFrame();
  	    
  	     
  	    
  	    
         b31= new JButton("Do Transcation ");
  		 b32= new JButton("Cancel Transcation");

  	    
  	    
  	    	b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
  	                int ss5 = Integer.parseInt(adf.getText());
  	     
  	                String s5 =""+ss5;
					Account x = new Account("","","","",0.0,0);
		
	try
	{
	       ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(accn));	
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		double s1 = x.amnt;
		
		
		Account y = new Account("","","","",0.0,0);
		
	try
	{
		
	       ObjectInputStream	input1	=	new ObjectInputStream(new FileInputStream(s5));	
          	y =((Account)input1.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"fileClosing");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
	
		double s2 = y.amnt;
 	
					String amo = pnf.getText();
  	                double amoun = Double.parseDouble(amo);
 
					
  	                    double a1 = 0.0;
  	                    double a2 = 0.0;
  	    
	                   	a1 = s1;
	                 	a2 = s2;
		
		             if(amoun<a1)
		        {
		              	a2=a2+amoun;
			            a1 =a1-amoun;
			            modifyA(a1,accn);
					    modifyA(a2,s5);
					    
					     Calendar cal = Calendar.getInstance();
    	                 cal.getTime();
    	                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	                 String time = "";
    	                 time+= sdf.format(cal.getTime());
    	
    	                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                         Date dat = new Date();
                         String date = "";
                         date += dateFormat.format(dat);
        
					    String text = "";
					    text+="\n\n\t\t\tOnline Transcation Done By Customer\n\nSender Account Number:\t"+accn+"\nReciver Account Number:\t"+s5+"\nAmount Send:\t"+amoun+"\nBalance left:\t"+a1+"\nDate of Transcation:\t"+date+"\nTime of Transcation:\t"+time;
					    statementedit(accn,text);
					    
					    JOptionPane.showMessageDialog(null,"Transcation Done!!!");	
  	                    frame3.setVisible(false);
		        }
		        
		     else if(amoun>a1)
		    {
			  JOptionPane.showMessageDialog(null,"Amount you entered is greater than balance","Excess Amount",JOptionPane.ERROR_MESSAGE);
		    }
					
  	   				
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
				}
				
			}
		);
		
         pan.add(b31);
  		 pan.add(b32);
  		 
  		frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(450,300);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();

}

public void CHP(String accn)
{
	        ActionEventHandler nn	=	new ActionEventHandler();
 	        ActionEventHandler ss	=	new ActionEventHandler();
 	        ActionEventHandler ani	=	new ActionEventHandler();
 	          
 	        
  	 	
  	 	     
  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel nl = new JLabel("Old PIN ");
  		JLabel adl= new JLabel("                New PIN");
  		JLabel phl = new JLabel("    Re-Enter New PIN");
  		
  		
  		
  		rupf= new JPasswordField(10);
  		upf =new JPasswordField(7);
  		repf= new JPasswordField(10);
  	
  		
  		
  	
  	   rupf.addActionListener(nn);
  	   upf.addActionListener(ss);
  	   repf.addActionListener(ani);
  	   
  	   
  	    
  	    main_pan.add(nl);
  	    main_pan.add(rupf);
  	    
  	    main_pan.add(adl);
  	    main_pan.add(upf);
  	    
  	    main_pan.add(phl);
  	    main_pan.add(repf);
  	   
  	     JFrame frame3 = new JFrame();
  	    
  	     
  	    
  	    
         b31= new JButton("Change PIN ");
  		 b32= new JButton("Cancel ");
  		   	    

  	    
  	    	b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String p1 = rupf.getText();
					int pin1 = Integer.parseInt(p1);
					
					
					Account x = new Account("","","","",0.0,0);
		
	try
	{
	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(accn));
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		    if(pin1==x.pi)
		    {
		    	
		    		String p2  = upf.getText();
					int pin2 = Integer.parseInt(p2);
					
					String p3  = repf.getText();
					int pin3 = Integer.parseInt(p3);
					
					if(pin2==pin3)
					{
						changep(pin2,accn);
						
					Calendar cal = Calendar.getInstance();
    	            cal.getTime();
    	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	            String time = "";
    	            time+= sdf.format(cal.getTime());
    	
    	            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dat = new Date();
                    String date = "";
                    date += dateFormat.format(dat);
                         
  	           	 String text = "";
  	           	 text+="\n\t\t\tPIN Changed on\n\nDate:\t"+date+"\nTime:\t"+time;
  	           	 statementedit(accn,text);
  	           	 
						JOptionPane.showMessageDialog(null,"PIN Changed");
						frame3.setVisible(false);
					}
					else if(pin2!=pin3)
					{
						JOptionPane.showMessageDialog(null,"PIN does not match with re-entered pin","PIN ERROR",JOptionPane.ERROR_MESSAGE);
					}
		    }
		    else
		    {
		    	JOptionPane.showMessageDialog(null,"Old PIN is not correct please Re-Enter it","OLD PIN ERROR",JOptionPane.ERROR_MESSAGE);
		    }
					
				
  	   				
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
				}
				
			}
		);
		
         pan.add(b31);
  		 pan.add(b32);
  		 
  		 frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(400,300);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();
}
  
  
			
public void uLogin()
{
  		final	JFrame f= new JFrame();
  			f.setLayout(new GridLayout(3,1));
  			JPanel p1=new JPanel();
  			JPanel p2= new JPanel();
  			JPanel p3= new JPanel();
  			JLabel a= new JLabel("Username : ");
  			JLabel p= new JLabel(" Password :      ");
  			clata= new JTextField(8);
  			 
  			
  			clpa= new JPasswordField(8);
  		
  			clb= new JButton(" Login ");
  			p1.add(a);
  			p1.add(clata);
  			p2.add(p);
  			p2.add(clpa);
  			p3.add(clb);
  			
  			f.add(p1);
  			f.add(p2);
  			f.add(p3);
  	
  		f.setSize(250,180);
  	    f.setResizable(false);
  	    f.setLocationRelativeTo(null);
  		f.show();
  
  	    clb.addActionListener(new ActionListener()
  	    	
			{
				public void  actionPerformed(ActionEvent e)
				{
					int pass_correct=1;
					String username_check="1";
					String username_entered=clata.getText();
					String pass_check="1";
					String  pass_entered;
					pass_entered=clpa.getText();
					
					if (pass_entered.equals(pass_check)&&username_check.equals(username_entered))
					 pass_correct=1;
					else
						pass_correct=0;
					
					
                	f.setVisible(false);
 				    if(pass_correct==1)
 				    	Employee();
 				    	else if(pass_correct==0)
 				    	{
 				    		JOptionPane.showMessageDialog(null,"Sorry you are not an authorized person ");
 				    		uLogin();
 				    		}
  		         }
			}
			);
			
  
}
  		
public void Employee()
{
  		 	JPanel pan= new JPanel();
  		 	JPanel panbot=new JPanel();
  		 	JLabel bott= new JLabel("                                                               ANIASH BANK LIMITED");
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             panbot.add(bott);
             panbot.add(label);
  	       	 pan.setLayout(new GridLayout(8,1));
  	       	 
  		 ActionEventHandler efb= new ActionEventHandler();
  		 ActionEventHandler efb2= new ActionEventHandler();
  		
  		 JFrame frame2 = new JFrame();
  		 bCA= new JButton("Create Account");
  		 bMA= new JButton("Modify Account");
  		 bVA= new JButton("View Account");
  		 bOT= new JButton("Online Transaction");
  		 bWC= new JButton("Withdraw Cash");
  		 bDC = new JButton("Deposit Cash");
  		 bDA=new JButton("Delete Account");
  		 bMS= new JButton("Statement");
  		 
  			bCA.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					createAccount();					
				}
			}
		);
	
  			bMA.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					modifyAccount();					
				}
			}
		);
			bVA.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					vAccount();					
				}
			}
		);
		
	      	bOT.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					onlineTranscation();					
				}
			}
		);
		
		bWC.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					withdraw();
				}
			}
		);
		
			bDC.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					deposit();					
				}
			}
		);
			bMS.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					BankStatement();					
				}
			}
		);
			bDA.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dAccount();					
				}
			}
		);
		
		
		
		eva= new TextArea(5,5);
  		pan.add(bCA);
  		pan.add(bMA);
  		pan.add(bVA);
  		pan.add(bOT);
  		pan.add(bWC);
  		pan.add(bDC);
  	  	pan.add(bMS);
  	  	pan.add(bDA);
  		frame2.add(panbot,BorderLayout.SOUTH);
  	    frame2.add(eva,BorderLayout.CENTER);
  		frame2.add(pan,BorderLayout.WEST);
  		
  		
  		frame2.setSize(600,600);
  		frame2.setLocationRelativeTo(null);

  		frame2.show();
  			

  		
}
  		
  		
public void createAccount()
  	 {
  		    ActionEventHandler nn	=	new ActionEventHandler();
			ActionEventHandler adad	=	new ActionEventHandler();
			ActionEventHandler phph	=	new ActionEventHandler();
			ActionEventHandler abab	=	new ActionEventHandler();
			ActionEventHandler scsc	=	new ActionEventHandler();
			ActionEventHandler pipi	=	new ActionEventHandler();
			ActionEventHandler piapia=new ActionEventHandler();
  	 	     ActionEventHandler awa = new ActionEventHandler();
  	 	     
  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     pan.setLayout(new GridLayout(1,2));
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel nl = new JLabel("Name ");
  		JLabel adl= new JLabel("Address ");
  		JLabel phl= new JLabel("Phone Number ");
  		JLabel abl= new JLabel("Account Balance ");
  		JLabel soil= new JLabel("Source of Income ");
  		JLabel atl= new JLabel("Select Account Type  :     ");
  		JLabel upl= new JLabel("PIN");
  		JLabel rupl= new JLabel("Re-Enter PIN :");
  		JLabel acn1 = new JLabel("Account No.");
  		
  		nf= new JTextField(16);
  		adf =new JTextField(18);
  		pnf= new JTextField(10);
  		abf= new JTextField(10);
  		soif= new JTextField(10);
  		rupf= new JPasswordField(5);
  		upf= new JPasswordField(5);
  		acn = new JTextField(7);
  		String[] atsa= {"Savings","Checking","Money Market"	};
  		
  		JComboBox atList = new JComboBox(atsa);
  	
  	   nf.addActionListener(nn);
  	   adf.addActionListener(adad);
  	   pnf.addActionListener(phph);
  	   abf.addActionListener(abab);
  	   soif.addActionListener(scsc);
  	   rupf.addActionListener(pipi);
  	   upf.addActionListener(piapia);
  	   
  	    
  	    main_pan.add(nl);
  	    main_pan.add(nf);
  	    main_pan.add(adl);
  	    main_pan.add(adf);
  	    main_pan.add(phl);
  	    main_pan.add(pnf);
  	    main_pan.add(soil);
  	    main_pan.add(soif);
  	    main_pan.add(abl);
  	    main_pan.add(abf);
  	    
  		main_pan.add(atl);
  	   // main_pan.add(atList);
  	    
  	    main_pan.add(upl);
  	    main_pan.add(upf);
  	    main_pan.add(rupl);
  	    main_pan.add(rupf);
  	    main_pan.add(acn1);
  	    main_pan.add(acn);
  	    
  	    
  	     b31= new JButton("Create Account ");
  		 b32= new JButton("Cancel");
  		 pan.add(b31);
  		 pan.add(b32);
  		 
  		 
  	    
  	    JFrame frame3 = new JFrame();
  	    
  	    fileqq a = new fileqq(0);
  	    int i = 1;
	
	try{

	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream("accno"));	
          a =((fileqq)input.readObject());
          
          
          	
          a.accountn = a.accountn+i;
		
	
  	      accountnumber = a.accountn;
  	      
          String acnq = ""+accountnumber;
          acn.setText(acnq);
          ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream("accno"));
          outputStream.writeObject(a);
          	
         outputStream.flush();
         outputStream.close();
          	
	}
	

	catch(FileNotFoundException er)
	{
		System.out.print("Unfortunately stopped working");
		
		}
		
		catch(IOException er)
		{
			System.out.print("Unfortunately stopped working");
			}
			
			catch(ClassNotFoundException er)
			{   System.out.print("Unfortunately stopped working");
			} 
				
  	    	b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					  
  	   
					String name = nf.getText();
  	                String address = adf.getText();
  	                String phonenumber = pnf.getText();
  	                String source = soif.getText();
  	                String am = abf.getText();
  	                double amount = Double.parseDouble(am);
  	                String pas = rupf.getText();
              	    String pas1 = upf.getText();
  	                int po = 0;
  	               
  	    
  	               
  	   
  	    if(pas.equals(pas1))
  	         {
  	           	po = Integer.parseInt(pas);
  	           	 createA(name,address,phonenumber,source,amount,po,accountnumber);
  	           	 Statementtemp(accountnumber);
  	           	 
  	           	 		 Calendar cal = Calendar.getInstance();
    	                 cal.getTime();
    	                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	                 String time = "";
    	                 time+= sdf.format(cal.getTime());
    	
    	                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                         Date dat = new Date();
                         String date = "";
                         date += dateFormat.format(dat);
                         
  	           	 String text = "";
  	           	 text+="\n\t\t\tAccount Created on\n\nDate:\t"+date+"\nTime:\t"+time;
  	           	 statementedit(""+accountnumber,text);
  	             JOptionPane.showMessageDialog(null,"Account Created");	
  	             frame3.setVisible(false);
  	         }
  	    else
  	    {
  	        JOptionPane.showMessageDialog(null,"Pin didn't match please re-Enter it","Pin Error",JOptionPane.ERROR_MESSAGE);
  	    }

  	   				
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
					 fileqq a = new fileqq(0);
  	                 int i = 1;
					
	try{

	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream("accno"));	
          a =((fileqq)input.readObject());
          
          
          	
          a.accountn = a.accountn-i;
		
	
          ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream("accno"));
          outputStream.writeObject(a);
          	
         outputStream.flush();
         outputStream.close();
          	
	}
	

	catch(FileNotFoundException er)
	{
		System.out.print("Unfortunately stopped working");
		
		}
		
		catch(IOException er)
		{
			System.out.print("Unfortunately stopped working");
			}
			
			catch(ClassNotFoundException er)
			{   System.out.print("Unfortunately stopped working");
			}
					
					
				}
				
			}
		);
		
  
  		
  		frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(410,450);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();
  			
  		
  	 }
  		
public void modifyAccount()
{
  		int accs = Integer.parseInt(JOptionPane.showInputDialog(null,"Account Number :"));
  		String s = ""+accs;
  			
  			ActionEventHandler nn	=	new ActionEventHandler();
			ActionEventHandler adad	=	new ActionEventHandler();
			ActionEventHandler phph	=	new ActionEventHandler();
			ActionEventHandler abab	=	new ActionEventHandler();
			ActionEventHandler scsc	=	new ActionEventHandler();
			ActionEventHandler pipi	=	new ActionEventHandler();
			ActionEventHandler piapia=new ActionEventHandler();
  	 	
  	 	     ActionEventHandler awa = new ActionEventHandler();
  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     pan.setLayout(new GridLayout(1,2));
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel nl = new JLabel("Name ");
  		JLabel adl= new JLabel("Address ");
  		JLabel phl= new JLabel("Phone Number ");
  		JLabel abl= new JLabel("Account Balance ");
  		JLabel soil= new JLabel("Source of Income ");
  		JLabel atl= new JLabel("Select Account Type  :     ");
  		JLabel upl= new JLabel("PIN");

  		
  		nf= new JTextField(16);
  		adf =new JTextField(18);
  		pnf= new JTextField(10);
  		abf= new JTextField(10);
  		soif= new JTextField(10);
  		pii  = new JTextField(5);
  		String[] atsa= {"Savings","Checking","Money Market"	};
  		
  		JComboBox atList = new JComboBox(atsa);
  	
  	   nf.addActionListener(nn);
  	   adf.addActionListener(adad);
  	   pnf.addActionListener(phph);
  	   abf.addActionListener(abab);
  	   soif.addActionListener(scsc);
  	   pii.addActionListener(pipi);
  	 
  	    
  	    main_pan.add(nl);
  	    main_pan.add(nf);
  	    main_pan.add(adl);
  	    main_pan.add(adf);
  	    main_pan.add(phl);
  	    main_pan.add(pnf);
  	    main_pan.add(soil);
  	    main_pan.add(soif);
  	    

  	    
  	     b31= new JButton("Modify Account ");
  		 b32= new JButton("Cancel");
  		 pan.add(b31);
  		 pan.add(b32);
  	    
  	    JFrame frame3 = new JFrame();
  	    
  	    
		Account x = new Account("","","","",0.0,0);
		
	try
	{
	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(s));	
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}

					nf.setText(x.nam);
					adf.setText(x.addre);
					pnf.setText(x.phn);
					soif.setText(x.sour);
					String ams = ""+x.amnt;
					abf.setText(ams);
					String p = ""+x.pi;
					pii.setText(p);
					
					
				
				b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String name = nf.getText();
  	                String address = adf.getText();
  	                String phonenumber = pnf.getText();
  	                String source = soif.getText();
  	                String am = abf.getText();
  	                double amount = Double.parseDouble(am);
  	                String pas = pii.getText();
  	                int po = 0;
  	               
  	           	    po = Integer.parseInt(pas);
  	           	    createA(name,address,phonenumber,source,amount,po,accs);
  	           	    
  	           	    Calendar cal = Calendar.getInstance();
    	            cal.getTime();
    	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	            String time = "";
    	            time+= sdf.format(cal.getTime());
    	
    	            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dat = new Date();
                    String date = "";
                    date += dateFormat.format(dat);
                         
  	           	 String text = "";
  	           	 text+="\n\t\t\tAccount Modified on\n\nDate:\t"+date+"\nTime:\t"+time;
  	           	 statementedit(s,text);
  	           	    
  	                JOptionPane.showMessageDialog(null,"Account Modified");	
  	                frame3.setVisible(false);
  	   	
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
				}
				
			}
		);
  
  		
  		frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(410,450);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();
  	
}
		
public void vAccount()
{
	    int accs = Integer.parseInt(JOptionPane.showInputDialog(null,"Account Number :"));
  		String s = ""+accs;
  		 
  		 File f = new File("C:\\Users\\Ebad\\Documents\\JCreator Pro\\MyProjects\\banks\\"+s);
  		 if(f.exists())
  		 {
  		 
  		Account x = new Account("","","","",0.0,0);
		
	try
	{
	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(s));	
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		
		String show = "";
		show+="Name :\t"+x.nam+"\nAddress :\t"+x.addre+"\nSource of Income :\t"+x.sour+"\nPhone Number :\t"+x.phn+"\nAccount Balance :\t"+x.amnt+"\nPin :\t"+x.pi;
  		
  		 eva.setText(show);
  		 }
  		 
 else
 	JOptionPane.showMessageDialog(null,"Account Does not Exists","Account Error",JOptionPane.ERROR_MESSAGE);

}		
		
public void onlineTranscation()
 {
 	        
 	        ActionEventHandler nn	=	new ActionEventHandler();
 	        ActionEventHandler ss	=	new ActionEventHandler();
 	        ActionEventHandler ani	=	new ActionEventHandler();
 	          
 	        
  	 	
  	 	     
  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel nl = new JLabel("Sender's account number ");
  		JLabel adl= new JLabel("Reciever's account number ");
  		JLabel phl = new JLabel("Amount to transfer ");
  		
  		
  		
  		nf= new JTextField(5);
  		adf =new JTextField(5);
  		pnf= new JTextField(10);
  	
  		
  		
  	
  	   nf.addActionListener(nn);
  	   adf.addActionListener(ss);
  	   pnf.addActionListener(ani);
  	   
  	   
  	    
  	    main_pan.add(nl);
  	    main_pan.add(nf);
  	    
  	    main_pan.add(adl);
  	    main_pan.add(adf);
  	    
  	    main_pan.add(phl);
  	    main_pan.add(pnf);
  	   
  	     JFrame frame3 = new JFrame();
  	    
  	     
  	    
  	    
         b31= new JButton("Do Transcation ");
  		 b32= new JButton("Cancel Transcation");
  		   	    
  	   
  	    
	
  	    
  	    
  	    	b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int ss1 = Integer.parseInt(nf.getText());
  	                int ss5 = Integer.parseInt(adf.getText());
  	     
  	                String s =""+ss1;
  	                String s5 =""+ss5;
  	                
					Account x = new Account("","","","",0.0,0);
		
	try
	{
	       ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(s));	
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		double s1 = x.amnt;
  		 
  	
		
		Account y = new Account("","","","",0.0,0);
		
	try
	{
		
	       ObjectInputStream	input1	=	new ObjectInputStream(new FileInputStream(s5));	
          	y =((Account)input1.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"fileClosing");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
	
		double s2 = y.amnt;
  		

 	
					String amo = pnf.getText();
  	                double amoun = Double.parseDouble(amo);
 
					
  	                    double a1 = 0.0;
  	                    double a2 = 0.0;
  	    
	                   	a1 = s1;
	                 	a2 = s2;
		
		             if(amoun<a1)
		        {
		              	a2=a2+amoun;
			            a1 =a1-amoun;
			            modifyA(a1,s);
					    modifyA(a2,s5);
					    
					     Calendar cal = Calendar.getInstance();
    	                 cal.getTime();
    	                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	                 String time = "";
    	                 time+= sdf.format(cal.getTime());
    	
    	                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                         Date dat = new Date();
                         String date = "";
                         date += dateFormat.format(dat);
        
					    String text = "";
					    text+="\n\t\t\tOnline Transcation\n\nSender Account Number:\t"+s+"\nReciver Account Number:\t"+s5+"\nAmount Send:\t"+amoun+"\nBalance left:\t"+a1+"\nTime of Transcation:\t"+time+"\nDate of Transcation:\t"+date;
					    statementedit(s,text);
					    
					    JOptionPane.showMessageDialog(null,"Transcation Done!!!");	
  	                    frame3.setVisible(false);
		        }
		        
		     else if(amoun>a1)
		    {
			  JOptionPane.showMessageDialog(null,"Amount you entered is greater than balance","Excess Amount",JOptionPane.ERROR_MESSAGE);
		    }
					
  	   				
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
				}
				
			}
		);
		
         pan.add(b31);
  		 pan.add(b32);
  		 
  		 frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(450,300);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();
 
  		
  	

 	
 }			
 			
public void withdraw()
{
	        ActionEventHandler nn	=	new ActionEventHandler();
 	        ActionEventHandler ss	=	new ActionEventHandler();
 	          
 	        
  	 	
  	 	     
  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel nl = new JLabel("Account number ");
  		JLabel adl= new JLabel("Amount to withdraw ");
  		
  		
  		
  		
  		nf= new JTextField(9);
  		adf =new JTextField(12);
  		
  	
  	   nf.addActionListener(nn);
  	   adf.addActionListener(ss);
  	   
 
  	    main_pan.add(nl);
  	    main_pan.add(nf);
  	    
  	    main_pan.add(adl);
  	    main_pan.add(adf);
  	    
  	  
  	   
  	     JFrame frame3 = new JFrame();
  	    
  	     
  	    
  	    
         b31= new JButton("Continue");
  		 b32= new JButton("Cancel");
  		   	    
  	   
  	    
  	    
  	    	b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int ss1 = Integer.parseInt(nf.getText());
  	                String s =""+ss1;
  	     
  	     
  	     
			Account x = new Account("","","","",0.0,0);
		
	try
	{
	       ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(s));	
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		double s1 = x.amnt;
	
					
					String amo = adf.getText();
  	                double amoun = Double.parseDouble(amo);
 
		if(amoun<=s1)
	     	{
			        s1 = s1-amoun;
			        modifyA(s1,s);
			        
			        Calendar cal = Calendar.getInstance();
    	            cal.getTime();
    	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	            String time = "";
    	            time+= sdf.format(cal.getTime());
    	
    	            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dat = new Date();
                    String date = "";
                    date += dateFormat.format(dat);
                         
  	           	 String text = "";
  	           	 text+="\n\t\t\tAmount Withdrawn\n\nAmount Withdrawn:\t"+amoun+"\nDate:\t"+date+"\nTime:\t"+time;
  	           	 statementedit(s,text);
  	           	 
			     JOptionPane.showMessageDialog(null,"Amount Left in your account is RS "+s1);
			     frame3.setVisible(false);
	     	}
		else if(amoun>s1)
		{
		    JOptionPane.showMessageDialog(null,"You dont have this much amount in your account","Insufficent Balance",JOptionPane.ERROR_MESSAGE);
		}	
  	   				
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
				}
				
			}
		);
		
         pan.add(b31);
  		 pan.add(b32);
  		 
  		 frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(450,300);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();
		      
}

public void deposit()
{
	        ActionEventHandler nn	=	new ActionEventHandler();
 	        ActionEventHandler ss	=	new ActionEventHandler();

  		 	 JPanel pan= new JPanel();
  		 	 JPanel pantop= new JPanel();
  		 	
  		 	 ImageIcon icon = new ImageIcon("1.jpg");
             JLabel label = new JLabel(icon);
             
             ImageIcon icon2 = new ImageIcon("3.jpg");
             JLabel label2 = new JLabel(icon2);
             pantop.add(label);
  		 	 pantop.add(new JLabel("          ANIASH BANK LIMITED")); 
  		     
  		
  		
  		JPanel main_pan= new JPanel();
  		JLabel nl = new JLabel("Account number ");
  		JLabel adl= new JLabel("Amount to Deposit ");
  		
  		
  		
  		
  		nf= new JTextField(9);
  		adf =new JTextField(12);
  		
  	
  	   nf.addActionListener(nn);
  	   adf.addActionListener(ss);
  	   
 
  	    main_pan.add(nl);
  	    main_pan.add(nf);
  	    
  	    main_pan.add(adl);
  	    main_pan.add(adf);
  	    
  	  
  	   
  	     JFrame frame3 = new JFrame();
  	    
  	     
  	    
  	    
         b31= new JButton("Continue");
  		 b32= new JButton("Cancel");
  		   	    
  	   
  	    
  	    
  	    	b31.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int ss1 = Integer.parseInt(nf.getText());
  	                String s =""+ss1;
  	     
  	     
  	     
			Account x = new Account("","","","",0.0,0);
		
	try
	{
	       ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(s));	
          	x =((Account)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		double s1 = x.amnt;
	
					
					String amo = adf.getText();
  	                double amoun = Double.parseDouble(amo);
 
		if(amoun<=s1)
	     	{
			        s1 = s1+amoun;
			        modifyA(s1,s);
			        
			        	 Calendar cal = Calendar.getInstance();
    	                 cal.getTime();
    	                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	                 String time = "";
    	                 time+= sdf.format(cal.getTime());
    	
    	                 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                         Date dat = new Date();
                         String date = "";
                         date += dateFormat.format(dat);
                         
  	           	 String text = "";
  	           	 text+="\n\t\t\tAmount Depoisted\n\nAmount Depoist:\t"+amoun+"\nDate:\t"+date+"\nTime:\t"+time;
  	           	 statementedit(s,text);
  	           	 
			        JOptionPane.showMessageDialog(null,"Amount Deposited in Account");
			        frame3.setVisible(false);
	     	}
  	   				
				}
	
			}
		);
		
			b32.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					frame3.setVisible(false);
				}
				
			}
		);
		
         pan.add(b31);
  		 pan.add(b32);
  		 
  		 frame3.add(label2,BorderLayout.WEST);
  		frame3.add(pantop, BorderLayout.NORTH);
  		frame3.add(pan,BorderLayout.SOUTH);
  		frame3.add(main_pan,BorderLayout.CENTER);
  		frame3.setSize(450,300);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();
	
}
 				
public void BankStatement()
{
	    String s= JOptionPane.showInputDialog(null,"Account Number :");
	    String fs = "";
	    fs+=s+"log";
	    eba = new TextArea(10,10);
	    JFrame frame3 = new JFrame();
	    
	    
	    
  		    
  		stat x = new stat("");
		
	try
	{
	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(fs));	
          	x =((stat)input.readObject());
	}
	
	    catch(FileNotFoundException er)
     	{
		    JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
	    }
		
		catch(IOException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
			
		catch(ClassNotFoundException er)
		{
			JOptionPane.showMessageDialog(null,"Unfortunately stopped working");
		}
		
		 String show = "";
		 show+= x.statement;
		
  		 eba.setText(show);
  		
	
  		frame3.add(eba,BorderLayout.CENTER);
  		frame3.setSize(410,450);
  		frame3.setResizable(false);
  		frame3.setLocationRelativeTo(null);
  		frame3.show();	
}
  					
public void dAccount()
{

  	 String s_da= JOptionPane.showInputDialog(null,"Account Number :");
  	 String lg = "";
  	 lg = ""+s_da+"log";
  	 
  	 File f = new File("C:\\Users\\Ebad\\Documents\\JCreator Pro\\MyProjects\\banks\\"+s_da);
  	 File f2 = new File("C:\\Users\\Ebad\\Documents\\JCreator Pro\\MyProjects\\banks\\"+lg);
  	 if(!f.exists())
  	 {
  	 	JOptionPane.showMessageDialog(null,"Account does not exist.");
  	 	dAccount();
  	 }
  	 else
  	 {
  	   JFrame dACF= new JFrame("Confirm Delete Account");
  	   dACF.setLayout(new FlowLayout());
  	   JPanel p0 = new JPanel();
  	   JPanel p1 = new JPanel();
  	 
  	  JButton nda= new JButton("No");
  	  JButton yda= new JButton("Yes");
  	 
  	 yda.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					f.delete();
					f2.delete();	
					dACF.setVisible(false);				
				}
			}
		);
		
		nda.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dACF.setVisible(false);				
				}
			}
		);
  	 
  	 
  	  p1.add(yda);
  	  p1.add(nda);
  	  dACF.add(p0);
  	  dACF.add(p1);
  	  dACF.setSize(300,100);
  	   dACF.setResizable(false);
  		dACF.setLocationRelativeTo(null);
  	  dACF.show();
  	  
  	  
  	 }
  	 
  	
}
  			
  	
  		
public static void createA(String na,String add,String phnm,String src,double amo,int pinnm,int acc)
   {
		
		String acc1 = ""+acc;
	    Account x= new Account(na,add,phnm,src,amo,pinnm);
		
		
		try{
		
		
		ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream(acc1));
		
		 outputStream.writeObject(x);	
         outputStream.flush();
         outputStream.close();

		
		}
		
		catch(FileNotFoundException e)
		{
			System.out.print("closing ");
		}
		
		catch(IOException e)
		{
			System.out.print("closing ");
		}
		
	}			
	
public static void modifyA(double amc,String acc)
  {
	   
	 	Account	x_temp=new Account("","","","",0.0,0);
	try{

	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(acc));	
          x_temp =((Account)input.readObject());
          	
          double s = amc;
		  x_temp.amnt = s; 
			
          ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream(acc));
          outputStream.writeObject(x_temp);
          	
         outputStream.flush();
         outputStream.close();

	}
	

	     catch(FileNotFoundException e)
	   {
	     	System.out.print("Unfortunately stopped working");	
	   }
		
		catch(IOException e)
		{
			System.out.print("Unfortunately stopped working");
		}
			
			catch(ClassNotFoundException e)
			{
				System.out.print("Unfortunately stopped working");
			}   

  }		
 
public static void changep(int pine,String acco)
{
		Account	x_temp=new Account("","","","",0.0,0);
	try{

	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(acco));	
          x_temp =((Account)input.readObject());
          	
          int pis = pine;
		  x_temp.pi = pis;
			
          ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream(acco));
          outputStream.writeObject(x_temp);
          	
         outputStream.flush();
         outputStream.close();

	}
	

	     catch(FileNotFoundException e)
	   {
	     	System.out.print("Unfortunately stopped working");	
	   }
		
		catch(IOException e)
		{
			System.out.print("Unfortunately stopped working");
		}
			
			catch(ClassNotFoundException e)
			{
				System.out.print("Unfortunately stopped working");
			}   

}

public static void Statementtemp(int acc)
{
	String acc1 = ""+acc+"log";
	    stat x= new stat("");
		
		
		try{
		
		
		ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream(acc1));
		
		 outputStream.writeObject(x);	
         outputStream.flush();
         outputStream.close();

		
		}
		
		catch(FileNotFoundException e)
		{
			System.out.print("closing ");
		}
		
		catch(IOException e)
		{
			System.out.print("closing ");
		}
		
}

public static void statementedit(String acc,String statem)
{
		String acc1 = ""+acc+"log";
	    stat x= new stat("");
	    
		stat x_temp=new stat("");
	try{

	      ObjectInputStream	input	=	new ObjectInputStream(new FileInputStream(acc1));	
          x_temp =((stat)input.readObject());
          	
          String w = "";
          w+=statem;
          x_temp.statement+=w; 
			
          ObjectOutputStream	outputStream	=	new ObjectOutputStream(new FileOutputStream(acc1));
          outputStream.writeObject(x_temp);
          	
         outputStream.flush();
         outputStream.close();

	}
	

	     catch(FileNotFoundException e)
	   {
	     	System.out.print("Unfortunately stopped working");	
	   }
		
		catch(IOException e)
		{
			System.out.print("Unfortunately stopped working");
		}
			
			catch(ClassNotFoundException e)
			{
				System.out.print("Unfortunately stopped working");
			}   

}

}
