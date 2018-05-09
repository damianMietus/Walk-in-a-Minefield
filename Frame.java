import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame {
	/**
	 * @author Damian Mietus
	 * 	Completed May 5 2018
	 *  Reddit Daily Programmer 
	 *  Challenge #340 [Intermediate] Walk in a Minefield
	 */
	 private JPanel contentPane;
	 private JPanel panelBot = new JPanel();
	 private JPanel subPanelBot1 = new JPanel();
	 protected static JTextArea  field = new JTextArea();
	 private JPanel subPanelTop = new JPanel();
	 private JPanel subPanelBot2 = new JPanel();
	 private JButton btn1 = new JButton("How to Play");
	 private JButton btn2 = new JButton("FAQ");
	 private JButton btn3 = new JButton("Start");
	 private JLabel txt1 = new JLabel("How many mines?");
     protected static JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
     protected static JButton btn21 = new JButton("Begin!");
     private JPanel subPanelBot3 = new JPanel();
     public JTextField inputField = new JTextField();
     private JButton btn31 = new JButton("Execute!");	 
	 private JFrame frame = new JFrame("Minefield");
	 @SuppressWarnings("unused")
	 private static String usersInput = new String();
	 protected static int runFunc = 0;
	 protected static int inpFunc = 0;
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Frame() {
		      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 350, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		panelBot.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panelBot.setPreferredSize(new Dimension(150, 200));
		contentPane.add(panelBot, BorderLayout.SOUTH);	
		
		subPanelBot1.setPreferredSize(new Dimension(200, 170));
		
		subPanelBot1.add(btn1, BorderLayout.NORTH);
		btn1.setPreferredSize(new Dimension(165, 50));	
		
		subPanelBot1.add(btn2, BorderLayout.NORTH);
		btn2.setPreferredSize(new Dimension(165, 50));	
		
		btn3.setPreferredSize(new Dimension(165, 50));
		subPanelBot1.add(btn3, BorderLayout.SOUTH);
		subPanelBot1.setVisible(true);
		
		panelBot.add(subPanelBot1, BorderLayout.SOUTH);
			
		subPanelBot2.setPreferredSize(new Dimension(250, 170));	
		
		txt1.setFont(new Font("", Font.PLAIN, 24));
		subPanelBot2.add(txt1, BorderLayout.NORTH);		
		
		slider.setOpaque(true);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		Dimension d = slider.getPreferredSize();
		slider.setPreferredSize(new Dimension(d.width+50, d.height));
		
		JLabel mineVal = new JLabel("Mines: 0");
		subPanelBot2.add(mineVal, BorderLayout.CENTER);
		
		slider.addChangeListener(new ChangeListener() {
		@Override
		    public void stateChanged(ChangeEvent e) {
			    int value = slider.getValue();
			    mineVal.setText("Mines: "+ value);
			    
		    }
		});
		
		subPanelBot2.add(slider);
				
		btn21.setPreferredSize(new Dimension(165, 50));
		subPanelBot2.add(btn21, BorderLayout.SOUTH);		
		
		subPanelBot3.setPreferredSize(new Dimension(200, 170));		
		
		inputField.setPreferredSize(new Dimension(165, 50));
		subPanelBot3.add(inputField, BorderLayout.CENTER);		
		
		btn31.setPreferredSize(new Dimension(165, 50));
		subPanelBot3.add(btn31, BorderLayout.SOUTH);
		
		subPanelBot3.setVisible(false);
		panelBot.add(subPanelBot3);
		
		subPanelTop.setPreferredSize(new Dimension(150, 300));
		subPanelTop.setBackground(Color.WHITE);
			
		field.setEditable(false);
		field.setPreferredSize(new Dimension(130, 275));
		field.setBackground(Color.WHITE);
		field.setFont(new Font("Courier", Font.PLAIN, 15));
		subPanelTop.add(field);
		
		contentPane.add(subPanelTop, BorderLayout.NORTH);		
		
		subPanelBot2.setVisible(false);
		panelBot.add(subPanelBot2, BorderLayout.SOUTH);	
		
	    btn3.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	            subPanelBot1.setVisible(false);    
	            subPanelBot2.setVisible(true);
	        }  
	        }); 
	    
	    btn21.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){
	            subPanelBot2.setVisible(false);
	            subPanelBot3.setVisible(true);
	            runFunc = 1;
	            
	        }  
	        });
	    
	    btn31.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){
                usersInput = inputField.getText();
                inpFunc = 1;
                subPanelBot3.setVisible(false);
                subPanelBot1.setVisible(true);
                inputField.setText("");
	            
	        }  
	        });
	    
	    btn1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JPanel htp = new JPanel();
	    		 JTextArea intro = new JTextArea("The goal is to get the robot from the\n"
	    		 		                       + "bottom left corner and into the exit\n"
	    				                       + "that is located at the top right corner.\n"
	    		                               + "This is completed by giving the\n"
	    				                       + "following commands to the robot.\n\n"
	    		                               + "Controls:\nI    : Start the engine of the robot\n"
	    				                       + "N  : Moves the robot one square north\n"
	    		                               + "S  : Moves the robot one square south\n"
	    		                               + "E  : moves the robot one square east\n"
	    		                               + "W : moves the robot one square west\n"
	    		                               + "-   : cuts the engine of the robot\n\n"
	    		                               + "Board Objects:\n"
	    		                               + "M : the robot\n0 : open space\n+ : wall\n* : mine\n\n"
	    		                               + "Additional Rules:\n"
	    		                               + "- The robot only moves if the engine \n  was started\n"
	    		                               + "- The engine must be stopped when the\n   exit is reached\n"
	    		                               + "- Walls suppress movement if the robot\n   tries to walk into them\n"
	    		                               + "- Don't touch any mines\n");
	    		 
	    		 intro.setPreferredSize(new Dimension(225, 460));
	    		 intro.setOpaque(false);
	    		 intro.setEditable(false);  		 
	    		 htp.add(intro, BorderLayout.NORTH);    		 
	    		 htp.setPreferredSize(new Dimension(250, 460));
	    		 JOptionPane.showMessageDialog(null,htp,"How to Play",JOptionPane.INFORMATION_MESSAGE);
	    	}
	    });
	    
	    btn2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JPanel faq = new JPanel();
	    		
	      		 JTextArea faqTxt = new JTextArea("Made by Damian Mietus\n\n"
	      		 		+ "This program was made in participation of\n"
	      		 		+ "/r/dailyprogrammer for the following challenge:\n"
	      		 		+ "Challenge #340 [Intermediate] Walk in a Minefield");
	    		
	    		faq.setPreferredSize(new Dimension(300, 100));
	    		faqTxt.setOpaque(false);
	    		faqTxt.setEditable(false);
	    		faq.add(faqTxt);
	    		JOptionPane.showMessageDialog(null,faq,"FAQ",JOptionPane.INFORMATION_MESSAGE);

	    	}
	    });	    
	       
	}

	public void resultMsg(int result) {
		if (result == -1) {
			JOptionPane.showMessageDialog(null, "You have failed.");
		} else if (result == 1) {
			JOptionPane.showMessageDialog(null, "Success!");
		}
		
	}
	
	public  JPanel getContentPane() {
		return contentPane;
	}

	public  void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public  JPanel getPanelBot() {
		return panelBot;
	}

	public void setPanelBot(JPanel panelBot) {
		this.panelBot = panelBot;
	}

	public  JPanel getSubPanelBot1() {
		return subPanelBot1;
	}

	public  void setSubPanelBot1(JPanel subPanelBot1) {
		this.subPanelBot1 = subPanelBot1;
	}

	public  JTextArea getField() {
		return field;
	}

	public  void setField(JTextArea field) {
		Frame.field = field;
	}

	public  JPanel getSubPanelTop() {
		return subPanelTop;
	}

	public  void setSubPanelTop(JPanel subPanelTop) {
		this.subPanelTop = subPanelTop;
	}

	public  JPanel getSubPanelBot2() {
		return subPanelBot2;
	}

	public  void setSubPanelBot2(JPanel subPanelBot2) {
		this.subPanelBot2 = subPanelBot2;
	}

	public  JButton getBtn1() {
		return btn1;
	}

	public  void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public  JButton getBtn2() {
		return btn2;
	}

	public  void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public  JButton getBtn3() {
		return btn3;
	}

	public  void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public  JLabel getTxt1() {
		return txt1;
	}

	public  void setTxt1(JLabel txt1) {
		this.txt1 = txt1;
	}

	public static JSlider getSlider() {
		return slider;
	}

	public static void setSlider(JSlider slider) {
		Frame.slider = slider;
	}

	public static JButton getBtn21() {
		return btn21;
	}

	public static void setBtn21(JButton btn21) {
		Frame.btn21 = btn21;
	}

	public  JPanel getSubPanelBot3() {
		return subPanelBot3;
	}

	public  void setSubPanelBot3(JPanel subPanelBot3) {
		this.subPanelBot3 = subPanelBot3;
	}

	public JTextField getInputField() {
		return inputField;
	}

	public void setInputField(JTextField inputField) {
		this.inputField = inputField;
	}

	public JButton getBtn31() {
		return btn31;
	}

	public void setBtn31(JButton btn31) {
		this.btn31 = btn31;
	}

	public static int getRunFunc() {
		return runFunc;
	}

	public static void setRunFunc(int runFunc) {
		Frame.runFunc = runFunc;
	}
	
}
