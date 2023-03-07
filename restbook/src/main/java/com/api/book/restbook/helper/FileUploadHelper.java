package com.api.book.restbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    //static path for linux
    // public final String UPLOAD_DIR = "/Users/shivam/Desktop/Shivam/Springboot/restbook/src/main/resources/static/image";

    //dynamic path for linux
    public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {}
    //for windows
    // public final String UPLOAD_DIR_WINDOWS = "\\Users\\shivam\\Desktop\\Shivam\\Springboot\\restbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile file) {
        boolean flag = false;

        try{
            // InputStream is = file.getInputStream();
            // byte data[] = new byte[is.available()];

            // is.read(data);

            // //write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
            // // System.out.println(fos);
            // fos.write(data);

            // fos.flush();
            // fos.close();


            //or we can use Files to copy data from input stream to target folder
            Files.copy(file.getInputStream(), Paths.get( UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            flag = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
