package com.lea87crzz.AutoPublish.view;

import com.lea87crzz.AutoPublish.object.ITask;
import com.lea87crzz.AutoPublish.object.Process;

public class ViewUtil {
	
	public static TreeNodeTask getTreeNodeFromProcess(Process process){
		TreeNodeTask node = new TreeNodeTask(process);
		for(ITask task:process.getTasks()){
			TreeNodeTask tn=getNodeFromTask(task);
			if(tn!=null){
				node.add(tn);
			}
		}	
		return node;
	}

	private static TreeNodeTask getNodeFromTask(ITask task) {		
		if(task instanceof Process){			
			Process p=(Process)task;			
			return getTreeNodeFromProcess(p);
		}
		TreeNodeTask node = new TreeNodeTask(task);
		return node;
	}

}
