import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapParser {

    static public final class Svg {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JsonProperty("rect")
        private List<Map<String, String>> rects;
        @JacksonXmlElementWrapper(useWrapping = false)
        @JsonProperty("polygon")
        private List<Map<String, String>> polygons;
        @JacksonXmlElementWrapper(useWrapping = false)
        @JsonProperty("text")
        private List<Map<String, String>> texts;
        @JacksonXmlElementWrapper(useWrapping = false)
        @JsonProperty("circle")
        private List<Map<String, String>> circles;
    }



    //private record Label(Point point, String text) {}
    public List<Label> labels = new ArrayList<>();


    private List<Land> lands = new ArrayList<>();

    private List<Town> cities = new ArrayList<>();

    public List<Land> getLands() {
        return lands;
    }
    public List<Town> getCities() {
        return cities;
    }



    private void parseText(Map<String, String> params) {
        addLabel(params.get(""), new Point (Double.parseDouble(params.get("x")), Double.parseDouble(params.get("y"))));
    }

    private void addLabel(String text, Point bottomLeft) {
        labels.add(new Label(bottomLeft, text));
    }


    void matchLabelsToTowns() {

    }

    void addCitiesToLands() {





    }

    void parse(String path) {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(path);
        try {
            Svg svg = xmlMapper.readValue(file, Svg.class);
            for(var item : svg.texts) {
                parseText(item);
            }
            matchLabelsToTowns();
            addCitiesToLands();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

