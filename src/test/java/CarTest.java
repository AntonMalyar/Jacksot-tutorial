import ObjectMapper.practice.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void deserializeJavaObjectsFromJSON() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
        Car car = objectMapper.readValue(carJson, Car.class);

        Assertions.assertEquals("Mercedes", car.brand);
        Assertions.assertEquals(5, car.doors);
    }

}
