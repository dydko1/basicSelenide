package upload;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;

public class BaseTest {
    static {
//        Configuration.fileDownload = FileDownloadMode.PROXY; // lub FOLDER
//        Configuration.proxyEnabled = true;                    // dla PROXY
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 6000;
        Configuration.downloadsFolder = "target"; // albo "target/downloads"
    }
}