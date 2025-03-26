package config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private static JsonNode webConfig;
    private static JsonNode mobileConfig;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            webConfig = objectMapper.readTree(new File("src/main/resources/config/web-config.json"));
            mobileConfig = objectMapper.readTree(new File("src/main/resources/config/mobile-config.json"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config files", e);
        }
    }

    public static JsonNode getWebConfig() {
        return webConfig;
    }

    public static JsonNode getMobileConfig() {
        return mobileConfig;
    }
}
