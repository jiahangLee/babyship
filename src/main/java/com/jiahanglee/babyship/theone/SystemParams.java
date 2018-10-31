package com.jiahanglee.babyship.theone;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "system-params")
public class SystemParams {

    private String upload;
    private String uploadplus;


    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getUploadplus() {
        return uploadplus;
    }

    public void setUploadplus(String uploadplus) {
        this.uploadplus = uploadplus;
    }

    @Override
    public String toString() {
        return "SystemParams{" +
                "upload='" + upload + '\'' +
                ", uploadplus='" + uploadplus + '\'' +
                '}';
    }
}

