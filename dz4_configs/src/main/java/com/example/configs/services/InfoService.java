package com.example.configs.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    @Value("${application.name}")
    private String appName;
    @Value("${application.version}")
    private List<Integer> appVersion;

    public String about() {
        var response = "Welcome to " + appName + ", version ";
        var version = appVersion.get(0) + "." + appVersion.get(1);
        if (appVersion.size() == 3) {
            version += ", build " + appVersion.get(2);
        }
        return response + version;
    }
}
