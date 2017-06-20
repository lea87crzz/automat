package com.lea87crzz.AutoPublish.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
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
        
        createMenu();
        
        CapturePane cp=new CapturePane();
        CheckboxTree checkboxTree = new CheckboxTree(yourRoot);
        checkboxTree.expandAll();
        
        checkboxTree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				TreeNodeTask tnt=(TreeNodeTask)arg0.getPath().getLastPathComponent();
				cp.clear();
				System.out.println(tnt.getTask().getName());
				System.out.println(tnt.getTask().getDescription());
				
			}
		});
        
        setPreferredSize(new Dimension(700, 400));
        
        GridBagLayout layout=new GridBagLayout();        
        setLayout(layout);
        
        GridBagConstraints constraintscb = new GridBagConstraints();
        constraintscb.gridx = 0;
        constraintscb.gridy = 1;
        constraintscb.gridwidth = 1;
        constraintscb.gridheight = 1;
        constraintscb.weighty = 1.0;
        constraintscb.fill=GridBagConstraints.VERTICAL;
        constraintscb.anchor = GridBagConstraints.NORTHWEST;
        add(checkboxTree,constraintscb);
        
    	JButton b1 = new JButton("EXCECUTE");
        b1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.clear();
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
        GridBagConstraints  constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
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
        
        PrintStream ps = System.out;
        System.setOut(new PrintStream(new StreamCapturer(cp, ps)));
        add(cp,constraintsT); 
        
        

    }
	
   
    
    private void createMenu() {
    	//Create the menu bar.
    	JMenuBar menuBar = new JMenuBar();

    	//Build the first menu.
    	JMenu menu = new JMenu("File");	
    	menuBar.add(menu);    	
    	JMenuItem menuItem = new JMenuItem("Open");		
		menu.add(menuItem);
		menuItem = new JMenuItem("Save");		
		menu.add(menuItem);
		menuItem = new JMenuItem("Save as...");		
		menu.add(menuItem);
		menuItem = new JMenuItem("Exit");	
		menuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
    	
		
		menu = new JMenu("Help");	
	    menuBar.add(menu);
	    menuItem = new JMenuItem("About");		
		menu.add(menuItem);
	    	
	    	
    	  GridBagConstraints constraintscb = new GridBagConstraints();
          constraintscb.gridx = 0;
          constraintscb.gridy = 0;
          constraintscb.gridwidth = 1;
          constraintscb.gridheight = 2;
          constraintscb.fill=GridBagConstraints.HORIZONTAL;
          constraintscb.anchor=GridBagConstraints.EAST;
          constraintscb.weightx = 1.0;
    	add(menuBar,constraintscb);
    	
    	
		
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
