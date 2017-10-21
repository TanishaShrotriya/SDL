
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Tictactoe extends JFrame implements Serializable {
	
	JPanel game;
	JButton[][] buttonArray;
	JButton getChoice;

	Tictactoe(){


		this.setSize(400,400); 
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		game=new JPanel();
		game.setBounds(0,0,400,400);
		game.setLayout(null);
		game.setBackground(new Color(0,0,0));
		buttonArray = new JButton[3][3];
		
		int k=100;
		int j=100;
		for(int i=0;i<3;i++) {
			
			for(int m=0;m<3;m++) {
				
			    buttonArray[i][m]= new JButton();
			    buttonArray[i][m].setBounds(j,k,70,70);
			    buttonArray[i][m].setBackground(new Color(100,100,210));
			    game.add(buttonArray[i][m]);
			    j=j+80;
			}
			j=100;
			k=k+80;
		}
		
		getChoice= new JButton();
	    getChoice.setBounds(j,k,80,80);
	    getChoice.setBackground(new Color(100,100,210));
	    //game.add(getChoice);
	
	    this.add(game);
	    this.setVisible(true); //set visibility of frame to true
	    
    
    }
	
	public JLabel createLabel(JLabel l ,String name, int d) {

	    l = new JLabel(name);
	    l.setBounds(330,d,100,30);
	    l.setOpaque(true);
	    //change color of the JLabel
	    l.setBackground(Color.white);
	    l.setFont(new Font("Seriff",Font.BOLD+Font.ITALIC,12));
	    l.setVisible(true);
	    return l;
	}
	public JTextField createTextfield(JTextField t,int d) {
		t = new JTextField();
	    t.setBounds(440,d,300,30);
	    t.setVisible(true);
        return t;
	}
	
	

}