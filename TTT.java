package ai.lab.project;

import java.util.*;
import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TTT implements ActionListener
{
	JFrame f1;
	JPanel jp1, jp2;
	JTextArea ta1, ta2, ta3, ta4, ta5, ta6, ta7, ta8, ta9, ta0;
	JLabel l1, l2;
	JButton b1, b2;
	public static void main(String []args)
	{
		new TTT();
	}
	TTT()
	{
		f1 = new JFrame("Tic Tac Toe");
		f1.setBounds(780,350,400,400);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
		jp1 = new JPanel();
		jp1.setBounds(0,0,400,400);
		jp1.setBackground(Color.DARK_GRAY);
		jp1.setLayout(null);
		f1.add(jp1);
		
		l1 = new JLabel("Tic Tac Toe");
		l1.setBounds(105,30,250,30);
		l1.setFont(new Font("Arial", Font.PLAIN, 30));
		l1.setForeground(Color.white);
		jp1.add(l1);
		
		b1 = new JButton("Magic Square");
		b1.setBounds(110,120,150,50);
		b1.setFont(new Font("Arial", Font.PLAIN, 15));
		jp1.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Probabilistic");
		b2.setBounds(110,220,150,50);
		b2.setFont(new Font("Arial", Font.PLAIN, 15));
		jp1.add(b2);
		b2.addActionListener(this);
		
		l2 = new JLabel("©Java-Eclipse");
		l2.setBounds(275,325,120,25);
		l2.setFont(new Font("Arial", Font.BOLD, 15));
		l2.setForeground(Color.white);
		jp1.add(l2);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Magic Square"))
		{
			jp1.setVisible(false);
			f1.setVisible(false);
			magicsquare m = new magicsquare();
			m.main(null);
		}
		if(e.getActionCommand().equals("Probabilistic"))
		{
			jp1.setVisible(false);
			f1.setVisible(false);
			TicTacToe t = new TicTacToe();
			t.main(null);
		}
	}
}
