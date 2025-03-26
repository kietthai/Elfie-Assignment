package utils.device;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeviceChecker {

    public static int getConnectedAndroidDevices() {
        int count = 0;
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(".*device$")) { // Chỉ đếm các thiết bị đang kết nối
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getConnectedIOSDevices() {
        int count = 0;
        try {
            Process process = Runtime.getRuntime().exec("idevice_id -l");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static boolean isEnoughDevicesAvailable(int requiredAndroid, int requiredIOS) {
        int availableAndroid = getConnectedAndroidDevices();
        int availableIOS = getConnectedIOSDevices();

        System.out.println("Available Android Devices: " + availableAndroid);
        System.out.println("Available iOS Devices: " + availableIOS);

        return availableAndroid >= requiredAndroid && availableIOS >= requiredIOS;
    }

    public static boolean waitForDevices(int requiredAndroid, int requiredIOS, int timeoutSeconds) {
        int elapsed = 0;
        while (elapsed < timeoutSeconds) {
            if (isEnoughDevicesAvailable(requiredAndroid, requiredIOS)) {
                return true;
            }
            System.out.println("Chờ thiết bị khả dụng... (" + elapsed + "/" + timeoutSeconds + " giây)");
            try {
                Thread.sleep(5000); // Chờ 5 giây
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            elapsed += 5;
        }
        return false;
    }

}
