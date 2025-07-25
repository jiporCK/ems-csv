import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonConverter {

    public static void main(String[] args) throws IOException {

//        Employee employee = new Employee(1,"koko",300.0,"IT" );

        List<Employee> employees = new ArrayList<>() {{
            add(new Employee(1, "tho", 3000.0, "Smash"));
            add(new Employee(2, "hulk", 300.0, "Smash"));
            add(new Employee(3, "ironman", 10000.0, "AI"));
        }};

        Path path = Paths.get("src/employee.json");

        ObjectMapper mapper = new ObjectMapper();

//        mapper.writeValue(path.toFile(), employees);

//        List<Employee> employeeList = mapper.readValue(path.toFile(),
//                new TypeReference<>() {
//                });
//
//        employeeList.forEach(System.out::println);

        JsonNode jsonNode = mapper.readTree(path.toFile());
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        String prettyJson = writer.writeValueAsString(jsonNode);

        System.out.println(prettyJson);




    }

}
