package com.jiangshan.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class FileTask extends RecursiveAction {

	private String suffix;
	
	private String path;
	
	public FileTask(String suffix, String path) {
		this.suffix = suffix;
		this.path = path;
	}

	@Override
	protected void compute() {
		
		File file = new File(path);
		File[] files = file.listFiles();
		if(files!=null) {
			List<FileTask> fileTasks = new ArrayList<FileTask>();
			for (File _file : files) {
				if(!_file.isDirectory()) {
					if(_file.getName().endsWith(suffix)) {
						System.out.println("[file:"+_file.getAbsolutePath()+"]");
					}
				} else {
					FileTask fileTask = new FileTask(suffix, _file.getAbsolutePath());
					fileTasks.add(fileTask);
				}
			}
			if(!fileTasks.isEmpty()) {
				for (FileTask fileTask : invokeAll(fileTasks)) {
//					fileTask.join();
				}
			}
		}
	}

}
