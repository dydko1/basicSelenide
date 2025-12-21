package upload;

import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.assertThat;


public class DownloadDemoQATest extends BaseTest {


    @Test
    public void downloadPlayground() throws IOException {
        open("https://demoqa.com/upload-download");

        SelenideElement downloadButton = $("#downloadButton");

        // 1. Pobierz plik (Selenide czeka aż się zapisze)
        File downloaded = downloadButton.download(DownloadOptions.using(FileDownloadMode.PROXY));

        // 2. Podstawowe asercje na pliku
        assertThat(downloaded)
                .as("Plik powinien istnieć po pobraniu")
                .exists();

        long size = Files.size(downloaded.toPath());
        assertThat(size)
                .as("Plik nie powinien być pusty")
                .isGreaterThan(0L);
    }

    @Test
    public void checkDemoQaDownloadHref() {
        open("https://demoqa.com/upload-download");

        String href = $("#downloadButton").getAttribute("href");

        Assert.assertTrue(
                href.startsWith("data:image/jpeg;base64,"),
                "Href przycisku download nie jest data:image/jpeg;base64"
        );
    }
}