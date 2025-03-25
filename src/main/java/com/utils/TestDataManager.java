package com.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.testng.annotations.DataProvider;

public class TestDataManager {
    private static final String TEST_DATA_FILE = "/testdata/testData.json";
    private static JsonObject allTestData;

    static {
        try (InputStream inputStream = TestDataManager.class.getResourceAsStream(TEST_DATA_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException("Test data file not found: " + TEST_DATA_FILE);
            }
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            allTestData = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            throw new RuntimeException("Error loading test data: " + e.getMessage());
        }
    }

    @DataProvider(name = "jsonDataProvider")
    public static Object[][] jsonDataProvider(Method method) {
        String testCaseName = method.getName(); // Lấy tên test case
        JsonArray testDataArray = allTestData.has(testCaseName) ? allTestData.getAsJsonArray(testCaseName) : new JsonArray();

        Object[][] testData = new Object[testDataArray.size()][1];
        for (int i = 0; i < testDataArray.size(); i++) {
            testData[i][0] = testDataArray.get(i).getAsJsonObject();
        }
        return testData;
    }

    public static JsonArray getTestDataArray(String testCaseName) {
        return allTestData.has(testCaseName) ? allTestData.getAsJsonArray(testCaseName) : new JsonArray();
    }
}