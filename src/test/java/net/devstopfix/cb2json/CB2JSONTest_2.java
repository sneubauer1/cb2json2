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
public class CB2JSONTest_2 extends TestCase {

    public CB2JSONTest_2(String testName) {
        super(testName);
    }

    /**
     * Test of copybookToJSON method, of class CB2JSON.
     */
    public void testCopybookToJSON() throws Exception {
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/MSG5101.copybook")));
        String output = copybookToJSON(copybook, new FileInputStream(new File("./target/test-classes/5101.txt")));
        System.out.println(output);
    }

    public void testCopybookToJSONWriter() throws Exception {
        File dataFile = new File("./target/test-classes/5101.txt");
        Copybook copybook = CopybookParser.parse("B", new FileInputStream(new File("./target/test-classes/MSG5101.copybook")));
        StringWriter output = new StringWriter();
        copybookToJSON(copybook, new FileInputStream(dataFile), output);
        System.out.println(output.toString());
    }
}
