package core.driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.logging.Logger;

import java.io.*;


public class AppiumDriverManager {
    private static AppiumDriverLocalService appiumService;
    private static final int APPIUM_PORT = 4723; // Đổi nếu cần
    private static AppiumDriverLocalService service;

    public static void startAppiumService() {
        killAppiumServer();
        try {
            File logFile = new File("logs/appium.log");
            logFile.getParentFile().mkdirs(); // Tạo thư mục nếu chưa có
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException("Không thể tạo file Appium", e);
                }
            }

            PrintStream logStream = new PrintStream(new FileOutputStream(logFile));
            service = new AppiumServiceBuilder()
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withLogOutput(logStream)
                    .withArgument(() -> "--log-level", "error")
                    .build();

            service.start(); // Chạy Appium
        } catch (Exception e) {
            throw new RuntimeException("Không thể khởi động Appium", e);
        }
    }


    public static void stopAppiumService() {
        if (appiumService != null) {
            appiumService.stop();
            appiumService = null;
        }
    }

    public static void killAppiumServer() {
        try {
            // Lấy danh sách tiến trình chạy trên hệ thống
            Process process = Runtime.getRuntime().exec("tasklist");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Kiểm tra nếu dòng nào chứa "node.exe" (Appium chạy bằng Node.js)
                if (line.toLowerCase().contains("node.exe")) {
                    // Tìm PID (thường nằm ở vị trí cố định)
                    String[] tokens = line.trim().split("\\s+");
                    String pid = tokens[1]; // PID nằm ở vị trí thứ 2

                    // Kill tiến trình
                    Runtime.getRuntime().exec("taskkill /F /PID " + pid);
                    System.out.println("Appium server (PID: " + pid + ") đã bị kill.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getOrCreateLogFile(String filePath) {
        File logFile = new File(filePath);
        File parentDir = logFile.getParentFile();

        try {
            if (!parentDir.exists()) {
                parentDir.mkdirs(); // Tạo thư mục logs nếu chưa có
            }
            if (!logFile.exists()) {
                logFile.createNewFile(); // Tạo file appium.log nếu chưa có
            }
        } catch (IOException e) {
            throw new RuntimeException("Không thể tạo file log: " + filePath, e);
        }

        return logFile;
    }

}
