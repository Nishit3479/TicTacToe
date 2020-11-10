package ai.lab.project;

import java.util.*;
import java.util.List;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class magicsquare extends JPanel{
    static String[] board;  
    static String turn;
    static int[] magicSquare = new int[]{4, 9, 2, 3, 5, 7, 8, 1, 6};
    static List<JButton> buttons=new ArrayList<JButton>();
    static JFrame frame=new JFrame();
    static int value=0;
    static String winner = null;
    static JLabel information=new JLabel("<html>Welcome to 2 Player Tic Tac Toe.<br/>X will play first.<br/> Click near the center of a slot to place in:");

    public static void main(String[] args) {
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          TicTacToe ticTacToe=new TicTacToe();
          frame.add(ticTacToe);
          frame.setContentPane(ticTacToe);
 
          frame.setVisible(true);
          board = new String[9];
          turn = "X";
          ticTacToe.board = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
       
        populateEmptyBoard();
       
    }
    static int a=0;
    static void checkWinner() {
        if (hasWon("X")) 
        {
        	information.setText("<html>Congratulations!<br/> X has won!<br/> Thanks for playing.");
        }
        else if (hasWon("O"))
        {
        	information.setText("<html>Congratulations!<br/> O has won!<br/> Thanks for playing.");
        }
        else
        {
        	a++;
            if(a==9)
            {
            	information.setText("<html>It's a draw!");
            }
        	else if(a%2!=0)
            {
            	information.setText("<html>O's turn.<br/> Click near the center of a slot to place O in.");
            }
        	else if(a%2==0)
            {
            	information.setText("<html>X's turn.<br/> Click near the center of a slot to place X in.");
            }
        }
    }

    static boolean hasWon(String player) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                for (int k = 0; k < 9; k++)
                    if (i != j && i != k && j != k)
                        if (board[i] == player && board[j] == player && board[k] == player)
                            if (magicSquare[i] + magicSquare[j] + magicSquare[k] == 15)
                            	{
                            		winner = "1";
                            		return true;
                            	}
        return false;
    }
    static int i=0;
    static void populateEmptyBoard() {
    	frame.setLayout(null);
    	information.setBounds(10,160, 400, 400);   
        frame.add(information);
        int xIncrease=0; 
        int yIncrease=-100;
        for(i=0; i<9; i++) board[i]="Empty";
        
        for(int y=0; y<3; y++){
         
        	xIncrease=0;
        	yIncrease+=100;
            for (int x = 0; x < 3; x++) {
                buttons.add(new JButton(""));
                buttons.get(value).setBounds(xIncrease, yIncrease, 100, 100);
                buttons.get(value).setOpaque(false);
                buttons.get(value).setContentAreaFilled(false);
                buttons.get(value).setBorderPainted(false);
                frame.add(buttons.get(value));
               buttons.get(value).addActionListener(new ActionListener() {
            	   int val=value;
            	   public void actionPerformed(ActionEvent e) {
            		   if(winner==null && board[val]=="Empty") {
            		  board[val]=turn;
            		   buttons.get(val).setText(turn);
          
            		   if (turn.equals("X")) {
                           turn = "O";
                       } else {
                           turn = "X";
                       }
            		 checkWinner();
            		   }
            		   else if(winner!=null) information.setText("The game has already been finished!");
            		   else information.setText("<html>The slot is already taken!<br/> Pick another slot!");
            	   }
               });
                value++;
                xIncrease+=100;
            }
          frame.setBounds(780,350,320,450);
          frame.setResizable(false);
          } 
    }
	 public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
	    	int x=100;
	    	g.setColor(Color.BLACK);
	    	for(int i=0; i<2; i++) {
	    	g.drawLine(0, 0+x, 300,0+x);
	    	if(i==2) break;
	    	g.drawLine(0+x,0,0+x, 300);
	    	x+=100;
	    	}
	    } 
}
