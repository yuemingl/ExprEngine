package io.lambdacloud.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import io.lambdacloud.MatlabEngine;

public class TestMatlabFiles {

	public static void main(String[] args) {
		//compile("./test_matlab/spdiags.m");
		compile("./test_matlab/matlab/elmat");
	}
	
	/**
	 * 
	 * @param path folder or file
	 */
	public static void compile(String path) {
		File folder = new File(path);
		File[] listOfFiles = null;
		if(folder.isDirectory())
			listOfFiles = folder.listFiles();
		else
			listOfFiles = new File[] {folder};

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				try {
					StringBuilder sb = new StringBuilder();
					BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
					String line = null;
					while ((line = br.readLine()) != null) {
						sb.append(line).append("\n");
					}
					br.close();
					
					MatlabEngine.exec(sb.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

	}

}
