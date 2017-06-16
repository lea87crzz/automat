package com.lea87crzz.AutoPublish.object.tarea;

import com.lea87crzz.AutoPublish.object.ITask;
import com.lea87crzz.AutoPublish.object.Result;

public abstract class Task implements ITask {

	protected Result result=Result.NOT_EJECUTED;
	
	@Override
	public Result getResult() {		
		return result;
	}

}
