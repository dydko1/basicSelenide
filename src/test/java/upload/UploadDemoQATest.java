package upload;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class UploadDemoQATest {

    @Test
    public void uploadPlayground() {
        open("https://demoqa.com/upload-download");

        // 1. Upload z classpath
        $("#uploadFile")
                .uploadFromClasspath("test-upload.txt");

        // 2. Asercja ścieżki/nazwy
        $("#uploadedFilePath")
                .shouldBe(visible)
                .shouldHave(text("test-upload.txt"));
    }
}