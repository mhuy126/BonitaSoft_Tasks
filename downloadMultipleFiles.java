import org.bonitasoft.engine.bpm.contract.FileInputValue

// Get size of list files
Integer sizeOfListFiles = multipleFilesInput.size();

if (sizeOfListFiles > 0) {
	// Create folder holding download files
	String folderDownloadName = "downloadFilesUpload";
	File downloadFolder = new File(folderDownloadName);
	if (!downloadFolder.exists()) {
		downloadFolder.mkdir();
	}
	
	for (int i=0;i<sizeOfListFiles;i++) {
		// Get content of each file
		FileInputValue fileInputValue = multipleFilesInput.get(i);
		
		// Get filename & content
		String fileName = fileInputValue.getFileName();
		byte[] content = fileInputValue.getContent();
		
		// Write to file
		File fileToWrite = new File(fileName);
		if (!fileToWrite.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(folderDownloadName + "/" + fileName);
			fileOutputStream.write(content);
			fileOutputStream.close();
		}
	}
	return multipleFilesInput;

} else {
	return multipleFilesInput;
}