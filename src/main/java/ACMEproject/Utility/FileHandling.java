package ACMEproject.Utility;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
public class FileHandling {

        @DataProvider(name = "dataprovidertest")
        public Object[][] data5() throws FilloException {
            String excelpath="C:\\Users\\Acer\\IdeaProjects\\CalculatorProject\\src\\main\\resources\\Testdata.xlsx";
            Fillo fillo=new Fillo();
            Connection connection=fillo.getConnection(excelpath);

            String query="select * from Sheet1";
            Recordset recordset= connection.executeQuery(query);

            List<Object[]> dataList= new ArrayList<>();
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

            Object[][] dataArray=new Object[dataList.size()][];
            return dataList.toArray(dataArray);
        }
    }
