
package earthquakes.controllers;

import earthquakes.osm.Place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.HashMap;

import com.nimbusds.oauth2.sdk.client.ClientReadRequest;


import earthquakes.searches.LocSearch;
import java.util.List;
import earthquakes.services.LocationQueryService;
import earthquakes.repositories.LocationRepository;
import earthquakes.entities.Location;
@Controller
public class LocationsController {

    @GetMapping("/locations/search")
    public String getLocationsSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch LocSearch) {
        return "locations/search";
    }

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

   

    @GetMapping("/locations/results")
    public String getLocationsResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {
        LocationQueryService e = new LocationQueryService();
        model.addAttribute("locSearch", locSearch);
        // TODO: Actually do the search here and add results to the model
        String json = e.getJSON(locSearch.getLocation());
        model.addAttribute("json", json);
        List<Place> place = Place.ListFromJSON(json);
        model.addAttribute("place",place);

        return "locations/results";
    }
    
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/locations")
    public String index(Model model, OAuth2AuthenticationToken token) {
        Iterable<Location> locations= locationRepository.findAll();
        model.addAttribute("locations", locations);
        return "locations/index";
    }

    @PostMapping("/locations/add")
    public String add(Location location, Model model) {
      locationRepository.save(location);
      model.addAttribute("locations", locationRepository.findAll());
      return "locations/index";
    }
}