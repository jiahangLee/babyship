package com.jiahanglee.babyship.theone;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "system-params")
public class SystemParams {

    private String upload;
    private String uploadplus;
    private String web_url;
    private String web_url2;

    public String getWeb_url2() {
        return web_url2;
    }

    public void setWeb_url2(String web_url2) {
        this.web_url2 = web_url2;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

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
                ", web_url='" + web_url + '\'' +
                ", web_url2='" + web_url2 + '\'' +
                '}';
    }
}

