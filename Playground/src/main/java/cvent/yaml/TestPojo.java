package cvent.yaml;

import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestPojo {
    public String name;
    public int value;

    public MYENUM getMyenum() {
        return myenum;
    }

    public void setMyenum(MYENUM myenum) {
        this.myenum = myenum;
    }

    public MYENUM myenum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


class JavaToYaml {
    public static void main(String[] args) throws IOException {
        // Create an ObjectMapper mapper for YAML
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        // Write object as YAML file
        mapper.writeValue(new File("/Users/saurabh.kumar/GitHub/JAVA/Playground/src/main/resources/TestPojo.yaml"),
                new TestPojo());

        yamlGenerator();


        //////////////

    }

    //http://techsquids.com/java/java-to-yaml-schema-maven-example/

    public static void yamlGenerator() throws IOException {
        TestPojo obj = new TestPojo();
        YamlWriter writer = new YamlWriter(new FileWriter("Object.yaml"));
        writer.getConfig().setClassTag("TestPojo", TestPojo.class);
        writer.write(obj);
        writer.close();
    }
}

