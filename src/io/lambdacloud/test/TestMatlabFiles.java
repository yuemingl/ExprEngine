package io.lambdacloud.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import io.lambdacloud.MatlabEngine;

public class TestMatlabFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("./test_matlab/matlab/elmat");
		File[] listOfFiles = folder.listFiles();

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
