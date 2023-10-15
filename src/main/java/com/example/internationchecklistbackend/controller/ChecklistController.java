package com.example.internationchecklistbackend.controller;

import com.example.internationchecklistbackend.entities.Checklist;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ChecklistController {
    @CrossOrigin(origins = "*")
    @PostMapping("/checklist")
    public ResponseEntity saveChecklist(@RequestBody Checklist checklist) {
        System.out.println(checklist);

        try (FileOutputStream fileOut = new FileOutputStream("checklists/"+checklist.id);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            // Write the object to the file
            objectOut.writeObject(checklist);
            System.out.println("Object has been serialized and saved to yourObject.ser");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return ResponseEntity.status(200).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/checklist/{id}")
    public ResponseEntity<Checklist> getChecklist(@PathVariable String id) {
        System.out.println(id);

        try (FileInputStream fileIn = new FileInputStream(id);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Checklist yourObject = (Checklist) objectIn.readObject();
            System.out.println("Object has been deserialized from yourObject.ser");

            return ResponseEntity.ok(yourObject);

            // Use the deserialized object as needed
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/checklists")
    public ResponseEntity<List<Checklist>> getAllChecklists() {
        List<Checklist> toReturn = new ArrayList<>();

        File folder = new File("checklists");
        File[] listOfFiles = folder.listFiles();
        JSONObject json = new JSONObject();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try (FileInputStream fileIn = new FileInputStream(file);
                     ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                    Checklist yourObject = (Checklist) objectIn.readObject();
                    toReturn.add(yourObject);
                    System.out.println("Object has been deserialized from yourObject.ser");

                    // Use the deserialized object as needed
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return ResponseEntity.internalServerError().build();
                }
            }
        }
        return ResponseEntity.ok(toReturn);
    }
}
