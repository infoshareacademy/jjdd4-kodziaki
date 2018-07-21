package com.infoshare.kodziaki.cdi;

import com.infoshare.kodziaki.exceptions.UserCsvReaderNotFound;

import javax.enterprise.context.RequestScoped;


import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessorBean {

    private static final String SETTINGS_FILE = "settings.properties";

    public File uploadCsvReader(Part filePart) throws IOException, UserCsvReaderNotFound {

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        if (fileName == null || fileName.isEmpty()) {
            throw new UserCsvReaderNotFound("No user image has been uploaded");
        }

        File file = new File(getUploadCsvReadersPath() + fileName);

        InputStream fileContent = filePart.getInputStream();
        OutputStream os = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileContent.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        fileContent.close();
        os.flush();
        os.close();

        return file;
    }

    public String getUploadCsvReadersPath() throws IOException {
        Properties settings = new Properties();
        settings.load(Thread.currentThread()
                .getContextClassLoader().getResource(SETTINGS_FILE).openStream());
        return settings.getProperty("Upload.Path.Images");
    }
}


