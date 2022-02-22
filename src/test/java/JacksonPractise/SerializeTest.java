package JacksonPractise;

import ObjectMapperPractice.Car;
import ObjectMapperPractice.Class_1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializeTest {
    @Test
    void generatingJSON_FromCarObjectIntoFileOutputStream() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car();
        car.brand = "BMW";
        car.doors = 4;
        File file = new File("C:\\Users\\fuckyou\\Desktop\\Jackson\\JSON\\jsonOutput.json");
        //serialize
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        objectMapper.writeValue(fileOutputStream, car);
        //deserialize
        Car carTest = objectMapper.readValue(file, Car.class);

        Assertions.assertEquals("BMW", carTest.brand);
        Assertions.assertEquals(4, carTest.doors);

    }
    @Test
    void generatingJSON_FromCarObjectIntoString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car();
        car.brand = "BMW";
        car.doors = 4;
        String pattern = "{\"brand\":\"BMW\",\"doors\":4}";
        String json = objectMapper.writeValueAsString(car);

        Assertions.assertEquals(pattern, json);
    }
    @Test
    void JacksonFormattingDatesAsStrings() throws JsonProcessingException {
        Class_1 class_1 = new Class_1();
        class_1.date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setDateFormat(dateFormat);

        String output = objectMapper.writeValueAsString(class_1);
        Assertions.assertEquals("{\"date\":\"22-02-2022\"}", output);
    }
}
