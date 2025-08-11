package customframework.externaldatahandlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UserDefinedPropertyFileReader {

    private static Properties properties;

    private static String fileCommonPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator;

    static {
        properties = new Properties();
        loadTestExecutionProperties();
        loadConfigProperties();

    }

    public static void loadTestExecutionProperties() {
        File file = new File(fileCommonPath + "testExecution.properties");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadConfigProperties() {
        File file = new File(fileCommonPath + "config.properties");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
