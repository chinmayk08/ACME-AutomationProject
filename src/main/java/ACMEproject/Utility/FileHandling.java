package ACMEproject.Utility;
import ACMEproject.Pages.UseroptionsPage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileHandling {
    Properties properties = new Properties();
    public static WebDriver wd;
    public FileHandling(WebDriver wd) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Acer\\IdeaProjects\\ACME-AutomationProject\\src\\main\\java\\ACMEproject\\Utility\\Testdata.properties");
        properties.load(inputStream);
        this.wd=wd;
    }


    @DataProvider(name = "dataprovidertest")
    public Object[][] data5() throws FilloException {
        String excelpath = "C:\\Users\\Acer\\IdeaProjects\\CalculatorProject\\src\\main\\resources\\Testdata.xlsx";
        Fillo fillo = new Fillo();
        Connection connection = fillo.getConnection(excelpath);

        String query = "select * from Sheet1";
        Recordset recordset = connection.executeQuery(query);

        List<Object[]> dataList = new ArrayList<>();
        while (recordset.next()) {
            List<Object> rowData = new ArrayList<>();
            for (String field : recordset.getFieldNames()) {
                String field1 = recordset.getField(field);
                rowData.add(field1);
            }
            dataList.add(rowData.toArray());
        }
        recordset.close();
        connection.close();

        Object[][] dataArray = new Object[dataList.size()][];
        return dataList.toArray(dataArray);
    }

    public static boolean isfiledownload(String filepath, String filename) throws InterruptedException {

        File dir = new File(filepath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("not exist file");
            return false;
        }
        File[] dirContents = dir.listFiles();

        if (dirContents == null) {
            System.out.println(" null folder");
            return false; // No files in directory
        }
        for (File file : dirContents) {
            WebDriverWait wait= new WebDriverWait(wd,Duration.ofSeconds(5));
            wait.wait(1000);
            if (file.getName().equalsIgnoreCase(filename)) {
                return true; // File found
            }
            System.out.println(file.getName());
        }
        System.out.println("file name not matched");

        return false;
    }
}