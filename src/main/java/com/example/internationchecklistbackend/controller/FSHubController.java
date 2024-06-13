package com.example.internationchecklistbackend.controller;

import com.example.internationchecklistbackend.entities.ArrivalBody;
import com.example.internationchecklistbackend.entities.Author;
import com.example.internationchecklistbackend.entities.Embed;
import com.example.internationchecklistbackend.entities.RequestField;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class FSHubController {

    @CrossOrigin(origins = "*")
    @PostMapping("/test")
    public ResponseEntity test(@RequestBody JsonNode jsonNode) throws IOException, InterruptedException {

        //return ResponseEntity.ok().build();

        System.out.println("Received: ");
        //System.out.println(json);
        System.out.println(jsonNode);

        File file = new File("tokeninfo.txt");

        ObjectMapper tokenmapper = new ObjectMapper();
        JsonNode tokenInfo = tokenmapper.readTree(file);

        //System.out.println(tokenInfo.get("token"));

        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("=================================");
        String xPilotToken = tokenInfo.get("token").asText();
        String internationWebhook = tokenInfo.get("internationWebhook").asText();



        String airline = jsonNode.get("_data").get("airline").get("name").asText();

        String flightId = jsonNode.get("_data").get("id").asText();


        String username = jsonNode.get("_data").get("user").get("name").asText();
        String useravatar = jsonNode.get("_data").get("user").get("profile").get("avatar_url").asText();

        String aircraftname = jsonNode.get("_data").get("aircraft").get("icao").asText();
        String livery = jsonNode.get("_data").get("aircraft").get("name").asText();
        String tailnr = jsonNode.get("_data").get("aircraft").get("user_conf").get("tail").asText();

        String landingrate = jsonNode.get("_data").get("landing_rate").asText();
        String landingTAS = jsonNode.get("_data").get("speed_tas").asText();
        String landingBank = jsonNode.get("_data").get("bank").asText();
        String landingPitch = jsonNode.get("_data").get("pitch").asText();
        String windSpeed = jsonNode.get("_data").get("wind").get("speed").asText();
        String windDir = jsonNode.get("_data").get("wind").get("direction").asText();

        WebClient webClient = WebClient.builder()
                .baseUrl(internationWebhook)
                .defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
                .build();


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://fshub.io/api/v3/flight/"+flightId))
                .header("X-Pilot-Token",xPilotToken)
                .build();
        HttpResponse<String> response2 = client.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();
        JsonNode node2 = mapper.readTree(response2.body());

        System.out.println(node2);

        String fuelOnDepart = node2.get("data").get("departure").get("fuel").asText();
        String fuelOnArr = node2.get("data").get("arrival").get("fuel").asText();
        String fuelBurnt = node2.get("data").get("fuel_used").asText();
        String flightNr = node2.get("data").get("plan").get("callsign").asText();
        String cruiseAlt = node2.get("data").get("plan").get("cruise_lvl").asText();
        String route = node2.get("data").get("plan").get("route").asText();

        String depAirportName = node2.get("data").get("departure").get("name").asText();
        String depAirportICAO = node2.get("data").get("departure").get("icao").asText();

        String arrAirportName = node2.get("data").get("arrival").get("name").asText();
        String arrICAO = node2.get("data").get("arrival").get("icao").asText();


        ArrivalBody arr = new ArrivalBody();
        arr.username = "Arrivals";
        arr.avatar_url = "https://www.reddit.com/r/cats/";

        RequestField field1 = new RequestField();
        field1.name = "🏢 Airline";
        field1.value = airline;

        RequestField field2 = new RequestField();
        field2.name = "Flight Plan";
        field2.value = "🆔 Flight No: "+flightNr+" \n 🛫 Departure: "+depAirportName+" ("+depAirportICAO+") | 🛬 Arrival: "+arrAirportName+" ("+arrICAO+") \n 📊 Cruise Level: FL"+cruiseAlt+" \n 🗺️ Route: "+route;

        RequestField field3 = new RequestField();
        field3.name = "Aircraft";
        field3.value = "🗺️ Name: " + aircraftname + " \n 🎨 Livery: " + livery + " \n 🎨 Tail: " + tailnr + " \n ⛽ Fuel on Departure: "+fuelOnDepart+"KG | 🚀 Fuel on Arrival: "+fuelOnArr+"KG | 🔥 Burned: "+fuelBurnt+"KG";

        RequestField field4 = new RequestField();
        field4.name = "Landing information";
        field4.value = "🧈 Landing Rate: " + landingrate + "FPM \n 🧭 Pitch: "+landingPitch+" / Bank: "+landingBank+" \n 🐌 Speed: "+landingTAS+"Kn TS \n 🍃 Wind: "+windSpeed+"Kn heading "+windDir;

        ArrayList<RequestField> fields = new ArrayList<>();
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);


        Author author = new Author();
        author.name = username;
        author.url = "https://www.reddit.com/r/cats/";
        author.icon_url = useravatar;

        Embed embed = new Embed();
        embed.title = "Pilot Flight Completed";
        embed.author = author;
        embed.description = "A [flight](https://fshub.io/flight/" + flightId + "/report) from "+depAirportName+" to "+arrAirportName+" has been completed!";
        embed.color = 15258703;
        embed.fields = fields;

        ArrayList<Embed> embeds = new ArrayList<>();
        embeds.add(embed);

        arr.embeds = embeds;

        // Send the request
        Mono<String> response = webClient.post()
                .uri("")
                .body(Mono.just(arr), ArrivalBody.class)
                .retrieve()
                .bodyToMono(String.class);

        // Handle the response
        response.subscribe(System.out::println);


        return ResponseEntity.ok().build();
    }
}
