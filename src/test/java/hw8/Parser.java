package hw8;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import hw8.entities.MetalsColors;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;

public class Parser {
    private static Map<String, MetalsColors> mcData = null;

    private static void loadResource() throws FileNotFoundException {
        JsonReader jsonReader = new JsonReader(new FileReader(Parser.class.getClassLoader()
                .getResource("JDI_ex8_metalsColorsDataSet.json").getFile()));

        Type token = new TypeToken<Map<String, MetalsColors>>() {{
        }}.getType();

        mcData = new Gson().fromJson(jsonReader, token);
    }

    public static Map<String, MetalsColors> getData() throws FileNotFoundException {
        if (Objects.isNull(mcData)) {
            loadResource();
        }
        return mcData;
    }
}
