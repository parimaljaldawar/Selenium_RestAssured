package api.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;


public class DataProviders 
{
    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException 
    {
        String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
        XLUtility xl = new XLUtility(path);
        
        int rowCount = xl.getRowCount("Sheet1");
        int colCount = xl.getCellCount("Sheet1", 1);
        
        List<String[]> data = new ArrayList<>();
        
        for (int i = 1; i <= rowCount; i++) 
        {
            String[] rowData = new String[colCount];
            for (int j = 0; j < colCount; j++) 
            {
                rowData[j] = xl.getCellData("Sheet1", i, j);
            }
            data.add(rowData);
        }
        
        // Convert List to a 2D array
        Object[][] apiData = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) 
        {
            apiData[i] = data.get(i);
        }
        
        return apiData;
    }

    
        @DataProvider(name = "UserNames")
        public Object[] getUserNames() throws IOException 
        {
            String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
            XLUtility xl = new XLUtility(path);
            
            int rowCount = xl.getRowCount("Sheet1");
            
            // Using List to avoid manually managing the array
            List<String> userNames = new ArrayList<>();
            
            for (int i = 1; i <= rowCount; i++) 
            {
                userNames.add(xl.getCellData("Sheet1", i, 1));
            }
            
            // Convert List to an array
            return userNames.toArray(new String[0]);
        }
}

	


	
