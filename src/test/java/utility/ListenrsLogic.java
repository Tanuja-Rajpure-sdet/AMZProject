
package utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.microsoft.playwright.Page.ScreenshotOptions;

public class ListenrsLogic implements ITestListener {

    java.util.Date d1 = new java.util.Date();
    java.util.Date d2 = new java.util.Date(d1.getTime());
    String format = d2.toString();
    String dateFormat = format.replace(":", "");

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);

        try {
            if (BaseTest.page != null && !BaseTest.page.isClosed()) {

                Path folder = Paths.get("test-output", "Screenshot", "Pass");
                Files.createDirectories(folder);

                BaseTest.page.screenshot(new ScreenshotOptions()
                    .setPath(folder.resolve(
                        result.getName() + dateFormat + ".png")));
            }
        } catch (Exception e) {
            System.out.println("Pass screenshot failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        try {
            if (BaseTest.page != null && !BaseTest.page.isClosed()) {

                Path folder = Paths.get("test-output", "Screenshot", "Fail");
                Files.createDirectories(folder);

                BaseTest.page.screenshot(new ScreenshotOptions()
                    .setPath(folder.resolve(
                        result.getName() + dateFormat + ".png")));
            }
        } catch (Exception e) {
            System.out.println("Fail screenshot failed: " + e.getMessage());
        }
    }
}
