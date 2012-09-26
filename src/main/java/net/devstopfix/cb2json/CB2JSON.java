package net.devstopfix.cb2json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import net.sf.cb2java.copybook.Copybook;
import net.sf.cb2java.data.Record;

/**
 * Convert data in fixed-position format to JSON using
 * a Copybook layout.
 *
 */
public class CB2JSON 
{
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Parse fixed-format data using the Copybook definition and
     * write the result in JSON format.
     * 
     * @param copybookDefinition
     * @param data
     * @return
     * @throws IOException 
     */
    public static String copybookToJSON(Copybook copybookDefinition, InputStream data) throws IOException {
        List<Record> records = copybookDefinition.parseData(data);
        return objectMapper.writeValueAsString(records.get(0).toMap());
    }
    
    /**
     * Transform fixed-format data from the input stream using Copybook 
     * definition and stream the output as JSON.
     * 
     * @param copybookDefinition
     * @param data
     * @param out
     * @throws IOException 
     */
    public static void copybookToJSON(Copybook copybookDefinition, InputStream data, OutputStream out) throws IOException {
        List<Record> records = copybookDefinition.parseData(data);
        objectMapper.writeValue(out, records.get(0).toMap());
    }
    
    /**
     * Transform fixed-format data from the input stream using Copybook 
     * definition and stream the output as JSON.
     * 
     * @param copybookDefinition
     * @param data
     * @param out
     * @throws IOException 
     */
    public static void copybookToJSON(Copybook copybookDefinition, InputStream data, Writer out) throws IOException {
        List<Record> records = copybookDefinition.parseData(data);
        objectMapper.writeValue(out, records.get(0).toMap());
    }
}
