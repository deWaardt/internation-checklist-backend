package com.example.internationchecklistbackend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.*;
import java.util.Map;

@RestController
public class FSHubController {

    @CrossOrigin(origins = "*")
    @PostMapping("/test")
    public ResponseEntity test (@RequestBody JsonNode jsonNode) throws IOException, InterruptedException {
        System.out.println("Received: ");
        //System.out.println(json);

        System.out.println(jsonNode.get("_data").get("landing_rate"));


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://discord.com/api/webhooks/1243356327309475920/85XW8Dwz3MlvRwz5SjMM2udDi1Kc5zroMPmaCNG2oQCMzB6Cg5DnIQKWU9cfD2og7id-"))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "  \"username\": \"Test\",\n" +
                        "  \"avatar_url\": \"https://i.imgur.com/4M34hi2.png\",\n" +
                        "  \"embeds\": [\n" +
                        "    {\n" +
                        "      \"author\": {\n" +
                        "        \"name\": \"deWaardt\",\n" +
                        "        \"url\": \"https://www.reddit.com/r/cats/\",\n" +
                        "        \"icon_url\": \"https://i.imgur.com/R66g1Pe.jpg\"\n" +
                        "      },\n" +
                        "      \"title\": \"Pilot Flight Completed\",\n" +
                        "      \"description\": \"Text message. You can use Markdown here. *Italic* **bold** __underline__ ~~strikeout~~ [hyperlink](https://google.com) `code`\",\n" +
                        "      \"color\": 15258703,\n" +
                        "      \"fields\": [\n" +
                        "        {\n" +
                        "          \"name\": \"Text\",\n" +
                        "          \"value\": \"More text\",\n" +
                        "          \"inline\": true\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"name\": \"Even more text\",\n" +
                        "          \"value\": \"Yup\",\n" +
                        "          \"inline\": true\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"name\": \"Use `\\\"inline\\\": true` parameter, if you want to display fields in the same line.\",\n" +
                        "          \"value\": \"okay...\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"name\": \"Thanks!\",\n" +
                        "          \"value\": \"You're welcome :wink:\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"thumbnail\": {\n" +
                        "        \"url\": \"https://upload.wikimedia.org/wikipedia/commons/3/38/4-Nature-Wallpapers-2014-1_ukaavUI.jpg\"\n" +
                        "      },\n" +
                        "      \"image\": {\n" +
                        "        \"url\": \"https://upload.wikimedia.org/wikipedia/commons/5/5a/A_picture_from_China_every_day_108.jpg\"\n" +
                        "      },\n" +
                        "      \"footer\": {\n" +
                        "        \"text\": \"Woah! So cool! :smirk:\",\n" +
                        "        \"icon_url\": \"https://i.imgur.com/fKL31aD.jpg\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return ResponseEntity.ok().build();
    }
}
