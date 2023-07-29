if (singleFileInput != null) {
	// Create folder holding download files
	String folderDownloadName = "downloadFilesUpload";
	File downloadFolder = new File(folderDownloadName);
	if (!downloadFolder.exists()) {
		downloadFolder.mkdir();
	}

	// Get filename && content
	String fileName = singleFileInput.getFileName();
	byte[] content = singleFileInput.getContent();

	// Write to file
	File fileToWrite = new File(fileName);
	if (!fileToWrite.exists()) {
		FileOutputStream fileOutputStream = new FileOutputStream(folderDownloadName + "/" + fileName);
		fileOutputStream.write(content)
		fileOutputStream.close();
	}
	return singleFileInput;
}

//return singleFileInput;