package net.devstopfix.cb2json;

import java.io.File;
import java.io.FileInputStream;
import junit.framework.TestCase;
import net.sf.cb2java.copybook.Copybook;
import net.sf.cb2java.copybook.CopybookParser;
import static net.devstopfix.cb2json.CB2JSON.*;
import java.io.StringWriter;

/**
 *
 * @author 
 */
public class CB2JSONTest extends TestCase {
    
    public CB2JSONTest(String testName) {
        super(testName);
    }

    /**
     * Test of copybookToJSON method, of class CB2JSON.
     */
    public void testCopybookToJSON() throws Exception {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        String output = copybookToJSON(copybook, new FileInputStream(new File("./target/test-classes/b.input.txt")));
        System.out.println(output);
    }
    
    public void testCopybookToJSONWriter() throws Exception {
        File dataFile = new File("./target/test-classes/b.input.txt");
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/b.copybook")));
        StringWriter output = new StringWriter();
        copybookToJSON(copybook, new FileInputStream(dataFile), output);
        System.out.println(output.toString());
    }
}
