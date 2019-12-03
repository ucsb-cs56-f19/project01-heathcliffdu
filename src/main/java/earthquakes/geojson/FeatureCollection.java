package earthquakes.geojson;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import earthquakes.geojson.FeatureCollection;


public class FeatureCollection {
  public String type;

  private static Logger logger = LoggerFactory.getLogger(FeatureCollection.class);

   /**
     * Create a FeatureCollection object from json representation
     * 
     * @param json String of json returned by API endpoint {@code /classes/search}
     * @return a new FeatureCollection object
     * @see <a href=
     *      "https://tools.ietf.org/html/rfc7946">https://tools.ietf.org/html/rfc7946</a>
     */
    public static FeatureCollection fromJSON(String json) {
      try {
          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

          FeatureCollection featureCollection = objectMapper.readValue(json, FeatureCollection.class);
          return featureCollection;
      } catch (JsonProcessingException jpe) {
          logger.error("JsonProcessingException:" + jpe);
          return null;
      } catch (Exception e) {
          logger.error("Exception:" + e);
          return null;
      }
  }

  public Metadata metadata;

  public List<Feature> features;
}

