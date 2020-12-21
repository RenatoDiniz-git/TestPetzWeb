package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void tirar(WebDriver Navegador, String arquivo) {
        File screenshot = ((TakesScreenshot) Navegador).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(arquivo));
        } catch (Exception e) {
            System.out.println("Arquivo não copiado, segue mensagem de erro:" + e.getMessage());
        }
    }

}
