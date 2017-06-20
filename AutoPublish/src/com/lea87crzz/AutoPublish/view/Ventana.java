package com.lea87crzz.AutoPublish.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import com.lea87crzz.AutoPublish.TestLea;
import com.lea87crzz.AutoPublish.object.ITask;
import com.lea87crzz.AutoPublish.object.Process;

import eu.floraresearch.lablib.gui.checkboxtree.CheckboxTree;

public class Ventana extends JPanel {
	

	private static final long serialVersionUID = -1262635960024699178L;
	

	private Ventana() {    	
    	Process p=TestLea.getProcessDspace6();
        TreeNode yourRoot = ViewUtil.getTreeNodeFromProcess(p);
        
        CheckboxTree checkboxTree = new CheckboxTree(yourRoot);
        checkboxTree.expandAll();
        
        GridBagLayout layout=new GridBagLayout();        
        setLayout(layout);
        
        GridBagConstraints constraintscb = new GridBagConstraints();
        constraintscb.gridx = 0;
        constraintscb.gridy = 0;
        constraintscb.gridwidth = 1;
        constraintscb.gridheight = 2;
        constraintscb.weighty = 1.0;
        constraintscb.fill=GridBagConstraints.VERTICAL;
        constraintscb.anchor = GridBagConstraints.NORTHWEST;
        add(checkboxTree,constraintscb);
        
    	JButton b1 = new JButton("EXCECUTE");
        b1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				TreePath[] checks=checkboxTree.getCheckingPaths();
				System.out.println(checks);
				Process temp=new Process("");
				for(int i=0;i<checks.length;i++){
					TreeNodeTask nodeTask=(TreeNodeTask)checks[i].getLastPathComponent();
					ITask task=nodeTask.getTask();
					
					if(task instanceof Process){
						temp.addTask(new Process(task.getName()));
					} else{
						temp.addTask(task);
					}
				}
				temp.execute();
			}
		});
        //b1.setVerticalTextPosition(AbstractButton.CENTER);
        //b1.setHorizontalTextPosition(AbstractButton.LEADING); 
        GridBagConstraints  constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.SOUTHWEST;
        add(b1,constraints);      
        
        GridBagConstraints  constraintsT = new GridBagConstraints();
        constraintsT.gridx = 1;
        constraintsT.gridy = 1;
        constraintsT.gridwidth = 2;
        constraintsT.gridheight = 2;
        constraintsT.weighty = 1.0;
        constraintsT.weightx = 1.0;
        constraintsT.fill = GridBagConstraints.BOTH;
        constraintsT.anchor = GridBagConstraints.EAST;
        
        CapturePane cp=new CapturePane();
        PrintStream ps = System.out;
        System.setOut(new PrintStream(new StreamCapturer(cp, ps)));
        add(cp,constraintsT); 
        
        

    }
	
   
    
    private static void createAndShowGUI() {    	 
        //Create and set up the window.
        JFrame frame = new JFrame("Automata");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        //Create and set up the content pane.
        Ventana newContentPane = new Ventana();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);        
    }

    public static void main(String[] args) {
    	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI(); 
             }
         });;
    }

}
