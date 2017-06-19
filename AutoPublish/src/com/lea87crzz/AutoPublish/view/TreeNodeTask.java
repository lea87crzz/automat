package com.lea87crzz.AutoPublish.view;

import javax.swing.tree.DefaultMutableTreeNode;

import com.lea87crzz.AutoPublish.object.ITask;

public class TreeNodeTask extends DefaultMutableTreeNode {
	
	private static final long serialVersionUID = 7613967332942390831L;
	
	ITask task;
	
	public TreeNodeTask(ITask task){
		super(task.getName());
		this.task=task;
	}

	public ITask getTask() {
		return task;
	}

}
