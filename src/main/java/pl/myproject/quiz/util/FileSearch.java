/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mariusz Czarny
 */
public final class FileSearch {
  private String fileNameToSearch;
  private final List<String> result = new ArrayList<>();
	
  public String getFileNameToSearch() {
	return fileNameToSearch;
  }

  public void setFileNameToSearch(String fileNameToSearch) {
	this.fileNameToSearch = fileNameToSearch;
  }

  public List<String> getResult() {
	return result;
  }

  public static Boolean searchFileInDirectory(String path, String name) {

	FileSearch fileSearch = new FileSearch();
  
        //try different directory and filename :)
	fileSearch.searchDirectory(new File(path), name);

	int count = fileSearch.getResult().size();
	if(count == 0){
	    System.out.println("\nNo result found!");
	} else if (count == 1) {
            return true;
        }
        else{
	    System.out.println("\nFound " + count + " result!\n");
	    for (String matched : fileSearch.getResult()){
		System.out.println("Found : " + matched);
	    }
	}
        
        return false;
  }

  public void searchDirectory(File directory, String fileNameToSearch) {

	setFileNameToSearch(fileNameToSearch);

	if (directory.isDirectory()) {
	    search(directory);
	} else {
	    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
	}

  }

  private void search(File file) {

	if (file.isDirectory()) {
	  System.out.println("Searching directory ... " + file.getAbsoluteFile());
		
            //do you have permission to read this directory?	
	    if (file.canRead()) {
		for (File temp : file.listFiles()) {
		    if (temp.isDirectory()) {
			search(temp);
		    } else {
			if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {			
			    result.add(temp.getAbsoluteFile().toString());
		    }

		}
	    }

	 } else {
		System.out.println(file.getAbsoluteFile() + "Permission Denied");
	 }
      }

  }
  
    public static List<String> displayDirectoryContents(File dir) {
        List<String> listOfFiles = new ArrayList<>();
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    displayDirectoryContents(file);
                } else {
                    final String filename = file.getName();
                    System.out.println("file:" + filename);
                    listOfFiles.add(filename);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        
        return listOfFiles;
    }


}
