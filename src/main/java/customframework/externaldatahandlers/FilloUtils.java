package customframework.externaldatahandlers;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import customframework.runConfigurations.RunConfiguration;

import java.io.File;
import java.util.HashMap;

public class FilloUtils {

    Fillo fillo = new Fillo();
    Connection conn=null;
    Recordset recordset;
    private static String fileCommonPath = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator+"com"+File.separator+"framework"+File.separator+"tc"+File.separator+"data"+File.separator+"TestData.xlsx";
    public HashMap<String,String> getUserData(String RowName)
    {
        HashMap<String,String> resultSet = new HashMap<>();
        try{
            String sheetName = PropertyFileReader.getConfigProperties("appName");
            conn=fillo.getConnection(fileCommonPath);
            String query= "Select * from "+sheetName+" where UniqueID ='"+RowName+"'";
            recordset = conn.executeQuery(query);
            int counter = recordset.getFieldNames().size()-1;
            while (counter>=0)
            {
                recordset.next();
                RunConfiguration.getInstance().bufferValues.put(recordset.getFieldNames().get(counter), recordset.getField(recordset.getFieldNames().get(counter)));
                counter--;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        recordset.close();
        conn.close();
        return resultSet;

    }
}
