package com.saurabh.atm.numpad;

/**
 * Created by saurabhkumar on 08/05/17.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberPad extends JFrame implements ActionListener {
	JTextField jtxtDisplay = new JTextField(10);
	JButton[] jbtnNumber = new JButton[10];
	JPanel jpnlKeypad = new JPanel();
	JPanel jpnlDisplaypad = new JPanel();
	int displayNumber;

	public NumberPad() {
		// layout for frame
		setLayout(new BorderLayout());

		// displaypad
		jtxtDisplay.setForeground(Color.GREEN);
		jpnlDisplaypad.add(jtxtDisplay);
		jpnlDisplaypad.setBackground(Color.BLACK);

		// keypad
		jpnlKeypad.setBackground(Color.RED);
		jpnlKeypad.setLayout(new GridLayout(4, 3));
		setTitle("FlowLayout Demo");
		for (int i = 0; i < 10; i++) {
			jbtnNumber[i] = new JButton("" + i);
			jbtnNumber[i].addActionListener(this);
			jpnlKeypad.add(jbtnNumber[i]);
		}
		JButton jbtnPeriod = new JButton(".");
		jbtnPeriod.addActionListener(this);
		jpnlKeypad.add(jbtnPeriod);
		JButton jbtnEqual = new JButton("=");
		jbtnEqual.addActionListener(this);
		jpnlKeypad.add(jbtnEqual);

		add(jpnlDisplaypad, BorderLayout.NORTH);
		add(jpnlKeypad, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(".")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + ".");
		} else if (e.getActionCommand().equals("=")) {
			displayNumber = Integer.parseInt(jtxtDisplay.getText());
			System.out.println(displayNumber);
		} else if (e.getActionCommand().equals("0")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "0");
		} else if (e.getActionCommand().equals("1")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "1");
		} else if (e.getActionCommand().equals("2")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "2");
		} else if (e.getActionCommand().equals("3")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "3");
		} else if (e.getActionCommand().equals("4")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "4");
		} else if (e.getActionCommand().equals("5")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "5");
		} else if (e.getActionCommand().equals("6")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "6");
		} else if (e.getActionCommand().equals("7")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "7");
		} else if (e.getActionCommand().equals("8")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "8");
		} else if (e.getActionCommand().equals("9")) {
			jtxtDisplay.setText(jtxtDisplay.getText() + "9");
		}
	}

	public int getDisplayNumber() {
		return this.displayNumber;
	}

	public void setDisplayNumber(int displayNumber) {
		this.displayNumber = displayNumber;
	}
}
