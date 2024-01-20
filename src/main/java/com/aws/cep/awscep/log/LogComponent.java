package com.aws.cep.awscep.log;

import com.aws.cep.awscep.s3.service.BucketS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogComponent {

    @Value("${size.log}")
    private String sizeLog;

    private final BucketS3Service bucketS3Service;

    private static final String LOG_FILE_PATH = "src/main/resources/log/myapp.log";
    public void logWorker() {

        File file = new File(LOG_FILE_PATH);

        if (!file.exists()) {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    log.info("New File created: " + LOG_FILE_PATH);
                } else {
                    log.error("Can't created file: " + LOG_FILE_PATH);
                    return;
                }
            } catch (IOException e) {
                log.error("Error to created file: " + LOG_FILE_PATH, e);
                return;
            }
        }

        long fileSizeInBytes = file.length();
        long fileSizeInKB = fileSizeInBytes / 1024;

        if (fileSizeInKB >= Integer.parseInt(sizeLog)) {
            this.bucketS3Service.uploadFile(file);
            this.clearLocalFile(file);
        }

        log.info("File size: " + fileSizeInKB + " KB");
    }


    private void clearLocalFile(File file) {
        try (FileOutputStream fos = new FileOutputStream(file, false)) {
            log.info("File cleared successfully: " + file.getName());
        } catch (IOException e) {
            log.error("Failed to clear file: " + file.getName(), e);
        }
    }
}
