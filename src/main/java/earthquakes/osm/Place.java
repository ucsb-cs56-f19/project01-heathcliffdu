package earthquakes.osm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.core.type.TypeReference;

public class Place {
  public String type;
  public long place_id;
  public double lat;
  public double lon;
  public String display_name;

  private static Logger logger = LoggerFactory.getLogger(Place.class);

   /**
     * Create a FeatureCollection object from json representation
     * 
     * @param json String of json returned by API endpoint {@code /classes/search}
     * @return a new FeatureCollection object
     * @see <a href=
     *      "https://tools.ietf.org/html/rfc7946">https://tools.ietf.org/html/rfc7946</a>
     */
    public static List<Place> ListFromJSON(String json) {
      try {
          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

          List<Place> place = objectMapper.readValue(json, new TypeReference<List<Place>>(){});
          return place;
      } catch (JsonProcessingException jpe) {
          logger.error("JsonProcessingException:" + jpe);
          return null;
      } catch (Exception e) {
          logger.error("Exception:" + e);
          return null;
      }
  }

}

