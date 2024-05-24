package com.example.internationchecklistbackend.controller;

import com.example.internationchecklistbackend.entities.ArrivalBody;
import com.example.internationchecklistbackend.entities.Author;
import com.example.internationchecklistbackend.entities.Embed;
import com.example.internationchecklistbackend.entities.RequestField;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class FSHubController {

    @CrossOrigin(origins = "*")
    @PostMapping("/test")
    public ResponseEntity test (@RequestBody JsonNode jsonNode) throws IOException, InterruptedException {

        return ResponseEntity.ok().build();

//        System.out.println("Received: ");
//        //System.out.println(json);
//        System.out.println(jsonNode);
//
//        String username = jsonNode.get("_data").get("user").get("name").asText();
//        String useravatar = jsonNode.get("_data").get("user").get("profile").get("avatar_url").asText();
//
//
//        //URL url = new URL("https://discord.com/api/webhooks/1243356327309475920/85XW8Dwz3MlvRwz5SjMM2udDi1Kc5zroMPmaCNG2oQCMzB6Cg5DnIQKWU9cfD2og7id-");
//
//        WebClient webClient = WebClient.builder()
//                .baseUrl("https://discord.com/api/webhooks/1243368161701527573/Wq5TYvKn80Q8wW5xSCKbHAp5XokiK02DF5WmjFd1JY7ppsL5BqRVXfEUcfhktVyGef79")
//                .defaultHeader(org.springframework.http.HttpHeaders.CONTENT_TYPE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
//                .build();
//
//
//
////        requestBody.setEmbeds(Collections.singletonList(embed));
//
//        ArrivalBody arr = new ArrivalBody();
//        arr.username = "Arrivals";
//        arr.avatar_url = "https://www.reddit.com/r/cats/";
//
//        RequestField field1 = new RequestField();
//        field1.name = "🏢 Airline";
//        field1.value = "{airline}";
//
//        RequestField field2 = new RequestField();
//        field2.name = "Flight Plan";
//        field2.value = "🆔 Flight No: {flightno} \n 🛫 Departure {depart}: | 🛬 Arrival: {arrive} \n 📊 Cruise Level: {cruiselvl} \n 🗺️ Route: {route} ";
//
//        RequestField field3 = new RequestField();
//        field3.name = "Aircraft";
//        field3.value = "🗺️ Name: {craftname} \n 🎨 Livery: {craftlivery} \n 🎨 Tail: {crafttail} \n ⛽ Fuel on Departure: {fueldepart} | 🚀 Fuel on Arrival: {fuelarrive} | 🔥 Burned: {fuelused}";
//
//        RequestField field4 = new RequestField();
//        field4.name = "Landing information";
//        field4.value = "🧈 Landing Rate: {fpm} \n 🧭 Pitch: {pitch} / Bank: {bank} \n 🐌 Speed: {tas} \n 🍃 Wind: {wind}";
//
//        ArrayList<RequestField> fields = new ArrayList<>();
//        fields.add(field1);
//        fields.add(field2);
//        fields.add(field3);
//        fields.add(field4);
//
//
//        Author author = new Author();
//        author.name = username;
//        author.url = "https://www.reddit.com/r/cats/";
//        author.icon_url = useravatar;
//
//        Embed embed = new Embed();
//        embed.title = "Pilot Flight Completed";
//        embed.author = author;
//        embed.description = "A flight (id) from (departure) to (arrival) has been completed!";
//        embed.color = 15258703;
//        embed.fields = fields;
//
//        ArrayList<Embed> embeds = new ArrayList<>();
//        embeds.add(embed);
//
//        arr.embeds = embeds;
//
//        // Send the request
//        Mono<String> response = webClient.post()
//                .uri("")
//                .body(Mono.just(arr), ArrivalBody.class)
//                .retrieve()
//                .bodyToMono(String.class);
//
//        // Handle the response
//        response.subscribe(System.out::println);
//
//
//        return ResponseEntity.ok().build();
    }
}
