package dataloader;

import org.junit.Test;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import static junit.framework.Assert.*;

public class CsvLoaderTest {

    
    /**
     * Test Scenario: The application wants to read a csv dataset
     * but the String is invalid(empty String).
     * Expected Output: csvDataLoader throws an IOException.
     */

    @Test(expected = IOException.class)
    public void testCsvFileEmptyStringForTree() throws IOException {

        CsvDataLoader.MapLoader.parseFile("nonExistent.csv");
    }


    @Test
    public void testValidCsvFileForTree() throws IOException {

        File file = new File("test_data/dummy.csv");
        TreeMap dataSet = CsvDataLoader.MapLoader.parseFile(file);
        assertNotNull(dataSet);
        assertFalse("finish this test", true);
    }


    /**
     * This is the same test as above
     * but for type Table.
     */

    @Test(expected = IOException.class)
    public void testCsvFileEmptyStringForTable() throws IOException {

        CsvDataLoader.TableLoader.parseFile("nonExistent.csv");
    }


    /** This is the same test as above
     * but for type Table.
     */

    @Test
    public void testValidCsvFileForTable() throws IOException {

        File file = new File("test_data/dummy.csv");
        Table dataSet = CsvDataLoader.TableLoader.parseFile(file);

        assertNotNull(dataSet);
        assertEquals(dataSet.columns().size(), 3);
        assertEquals(dataSet.rowCount(), 1);

    }
}
