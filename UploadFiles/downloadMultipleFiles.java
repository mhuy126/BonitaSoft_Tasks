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

// Log 

// formInput: {"listUploadFileDocumentInput" : [ ] }
// formOutput: return { listUploadFileDocumentInput: $data.formInput.listUploadFileDocumentInput }
// Result: {listUploadFileDocumentInput=[FileInputValue{id='null'fileName='Library.pdf'}, FileInputValue{id='null'fileName='Couch.pdf'}]}



// Debug From example:
// Step Upload:
// formOutput: { "myMultipleDocumentsDeleteContract": [ { "id": 302, "processInstanceId": 3001, "name": "myMultipleDocuments", "author": 4, "creationDate": 1690988873768, "fileName": "Neighbor.pdf", "contentMimeType": "application/pdf", "contentStorageId": "302", "url": "documentDownload?fileName=Neighbor.pdf&contentStorageId=302", "description": null, "version": "1", "index": 0, "contentFileName": "Neighbor.pdf", "selected": false } ], "myMultipleDocumentsContract": [], "myDocumentContract": null }
//------------------
// Step Download:
// context: { "myDocument_ref": { "id": 301, "processInstanceId": 3001, "name": "myDocument", "author": 4, "creationDate": 1690988873750, "fileName": "Couch.pdf", "contentMimeType": "application/pdf", "contentStorageId": "301", "url": "documentDownload?fileName=Couch.pdf&contentStorageId=301", "description": "A declaration of document store by Bonita BPM Engine attached to DemoUploadFile process instances.", "version": "1", "index": -1, "contentFileName": "Couch.pdf" }, "myMultipleDocuments_ref": [ { "id": 302, "processInstanceId": 3001, "name": "myMultipleDocuments", "author": 4, "creationDate": 1690988873768, "fileName": "Neighbor.pdf", "contentMimeType": "application/pdf", "contentStorageId": "302", "url": "documentDownload?fileName=Neighbor.pdf&contentStorageId=302", "description": null, "version": "1", "index": 0, "contentFileName": "Neighbor.pdf" } ] }
