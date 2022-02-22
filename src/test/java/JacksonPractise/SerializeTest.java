package JacksonPractise;

import ObjectMapper.practice.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

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
}
