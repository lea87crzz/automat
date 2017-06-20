package com.lea87crzz.AutoPublish.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CapturePane extends JPanel implements Consumer {


	private static final long serialVersionUID = 8629507342258453712L;
	private JTextArea output;

    public CapturePane() {
        setLayout(new BorderLayout());
        output = new JTextArea();
        output.setLineWrap(true);
        add(new JScrollPane(output));
    }

    @Override
    public void appendText(final String text) {
        if (EventQueue.isDispatchThread()) {
            output.append(text);
            output.setCaretPosition(output.getText().length());
        } else {

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    appendText(text);
                }
            });

        }
    }    
    
    public void clear(){
    	output.setText("");
    }
}
