/**
 * 
 */
package com.objectif.informatique.alerte.utils;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author vdibi
 * @param <MultipartFile>
 *
 */
public class FileUploadForm {
	private List<MultipartFile> files;

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}	
}