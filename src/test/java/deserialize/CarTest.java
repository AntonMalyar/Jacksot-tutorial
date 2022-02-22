package deserialize;

import ObjectMapper.practice.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.util.LinkedList;

public class CarTest {
    @Test
    void deserializeJavaObjectsFromJSON() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        Car car = objectMapper.readValue(carJson, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(5, car.doors);
    }
    @Test
    void ReadObjectFromJSONStringReader() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 4 }";
        StringReader stringReader = new StringReader(carJson);
        Car car = objectMapper.readValue(stringReader, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(4, car.doors);
    }
    @Test
    void ReadObjectFromJSON_File() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("C:\\Users\\fuckyou\\Desktop\\Jackson\\JSON\\car.json");
        Car car = objectMapper.readValue(file, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(4, car.doors);
    }
    @Test
    void ReadObjectFromJSONviaURL() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("file:C:\\Users\\fuckyou\\Desktop\\Jackson\\JSON\\car.json");
        Car car = objectMapper.readValue(url, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(4, car.doors);
    }
    @Test
    void ReadObjectFromJSON_InputStream() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = new FileInputStream("C:\\Users\\fuckyou\\Desktop\\Jackson\\JSON\\car.json");
        Car car = objectMapper.readValue(inputStream, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(4, car.doors);
    }
    @Test
    void ReadObjectFromJSON_ByteArray() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        byte[] bytes = carJson.getBytes();
        Car car = objectMapper.readValue(bytes, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(5, car.doors);
    }
    @Test
    void ReadObjectArrayFromJSONArrayString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

        Car[]cars = objectMapper.readValue(jsonArray, Car[].class);

        Assertions.assertEquals("ford", cars[0].brand);
        Assertions.assertEquals("Fiat", cars[1].brand);
    }
    @Test
    void ReadObjectListFromJSON_ArrayString() throws JsonProcessingException {
        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        LinkedList<Car> cars = objectMapper.readValue(jsonArray, new TypeReference<LinkedList<Car>>(){});

        Assertions.assertEquals("ford", cars.get(0).brand);
        Assertions.assertEquals("Fiat", cars.get(1).brand);
    }

}
