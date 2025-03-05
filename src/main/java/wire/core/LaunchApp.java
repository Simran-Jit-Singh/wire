package wire.core;

import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LaunchApp {
    private static IOSDriver driver;

    public static void startApp() {

        String deviceName = System.getProperty("deviceName");
        if (deviceName == null) {
            throw new RuntimeException("Device not found");
        }

        DesiredCapabilities caps = getCapabilities(deviceName);
        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL: " + e.getMessage());
        }
    }

    public static JSONObject loadConfig() {
        try (InputStream inputStream = LaunchApp.class.getClassLoader().getResourceAsStream("config.json")) {
            if (inputStream == null) {
                throw new RuntimeException("Device configuration file not found");
            }
            String jsonString = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();
            return new JSONObject(jsonString);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load capabilities: " + e.getMessage());
        }
    }

    public static DesiredCapabilities getCapabilities(String deviceName) {
        JSONObject config = loadConfig();

        JSONObject deviceConfig = config.getJSONObject(deviceName);
        DesiredCapabilities caps = new DesiredCapabilities();

        for (String key : deviceConfig.keySet()) {
            caps.setCapability(key, deviceConfig.getString(key));
        }

        String appPath = System.getProperty("user.dir") + "/qa-code-challenge/app/Wire.ipa";
        caps.setCapability("app", appPath);

        return caps;
    }
}
