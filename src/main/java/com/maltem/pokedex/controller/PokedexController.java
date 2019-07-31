package com.maltem.pokedex.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.maltem.pokedex.server.model.Pokemon;
import com.maltem.pokedex.server.model.Stats;
import com.maltem.pokedex.server.model.Type;
import com.maltem.pokedex.server.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


@RestController
public class PokedexController {

    private final AtomicBoolean connected = new AtomicBoolean(false);

    private User currentUser = null;

    @RequestMapping("/pokedex")
    public List<Pokemon> displayAll() throws FileNotFoundException {
        List<Pokemon> myObjects = new ArrayList<>();
        File pokedexFile =  getFileFromResources("pokemon.json");
        try {
            byte[] jsonData = Files.readAllBytes(pokedexFile.toPath());
            ObjectMapper objectMapper = new ObjectMapper();
             myObjects = objectMapper.readValue(jsonData, new TypeReference<List<Pokemon>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return myObjects;
    }

    @RequestMapping("/pokedex/{type}")
    public ResponseEntity<List<Pokemon>> displayType( @PathVariable("type") String typeToCheck) throws FileNotFoundException {
        List<Pokemon> myObjects = new ArrayList<>();
        File pokedexFile = getFileFromResources("pokemon.json");
        try {
            byte[] jsonData = Files.readAllBytes(pokedexFile.toPath());
            ObjectMapper objectMapper = new ObjectMapper();
            myObjects = objectMapper.readValue(jsonData, new TypeReference<List<Pokemon>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Pokemon> collect = myObjects.stream().filter(pokemon -> {
            boolean isFromType = false;
            for (Type type : pokemon.getTypes()) {
                isFromType = type.getName().toLowerCase().equals(typeToCheck);
                if(isFromType) return isFromType;
            }
            return isFromType;
        }).collect(Collectors.toList());


        return new ResponseEntity<List<Pokemon>>(collect,HttpStatus.CREATED);
    }

    @RequestMapping("/pokedex/name/{name}")
    public ResponseEntity<Pokemon> displayPokemonFromName( @PathVariable("name") String nameToCheck) throws FileNotFoundException {
        List<Pokemon> myObjects = new ArrayList<>();
        File pokedexFile = getFileFromResources("pokemon.json");
        try {
            byte[] jsonData = Files.readAllBytes(pokedexFile.toPath());
            ObjectMapper objectMapper = new ObjectMapper();
            myObjects = objectMapper.readValue(jsonData, new TypeReference<List<Pokemon>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<Pokemon> collect = myObjects.stream().filter(pokemon -> {
            return pokemon.getName().toLowerCase().equals(nameToCheck);

        }).findAny();

        if(collect.isPresent()) return new ResponseEntity<Pokemon>(collect.get(),HttpStatus.CREATED);

        return new ResponseEntity<Pokemon>(HttpStatus.BAD_REQUEST);

    }

    @RequestMapping("/pokedex/{type}/{listSize}")
    public List<Pokemon> displayTypeLimited( @PathVariable("type") String typeToCheck,@PathVariable("listSize") int listSize) throws FileNotFoundException {
        List<Pokemon> pokemons = displayType(typeToCheck).getBody();
        return pokemons.subList(0,listSize);
    }


    @RequestMapping("/pokedex/{listSize}")
    public List<Pokemon> displayAllLimited(@PathVariable("listSize") int listSize) throws FileNotFoundException {
        List<Pokemon> pokemons = displayAll();
        return pokemons.subList(0,listSize);
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST,headers = "Accept=*/*",produces = "application/json", consumes="application/json")
    public String logUser(@RequestBody User p1) throws IOException {
        File userFile = getFileFromResources("users.json");
        byte[] jsonData = Files.readAllBytes(userFile.toPath());
        ObjectMapper objectMapper = new ObjectMapper();
        List<User>  users = objectMapper.readValue(jsonData, new TypeReference<List<User>>() {
        });
        if(users.stream().filter(user -> user.getUsername().equals(p1.getUsername())).findAny().isPresent()){
            if(users.stream().filter(user -> user.getUsername().equals(p1.getUsername())).findAny().get().getPassword().equals(p1.getPassword())){
                connected.set(true);
                currentUser =p1;
                return "[INFO] "+p1.getUsername()+ " connected";
            }else{
                return "[INFO] wrong password";
            }
        }else{
            return "[INFO] unknown user...";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout() throws IOException {
        if(connected.get()){
            connected.set(false);
            return "user disconnected";
        }

        return "not connected";
    }


    @RequestMapping(value = "/register", method=RequestMethod.POST,headers = "Accept=*/*",produces = "application/json", consumes="application/json")
    public String registerUser(@RequestBody User p1) throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        File userFile = getFileFromResources("users.json");
        try {
            byte[] jsonData = Files.readAllBytes(userFile.toPath());
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(jsonData, new TypeReference<List<User>>() {});

            if(users.stream().filter(user -> user.getUsername().equals(p1.getUsername())).findAny().isPresent()){
                return "[INFO] "+p1.getUsername()+ " already registered";
            }else{
                try ( OutputStream out = Files.newOutputStream(userFile.toPath())) {
                    users.add(p1);
                    JsonGenerator g = objectMapper.getFactory().createGenerator(out);
                    objectMapper.writeValue(g,  users);
                    g.close();

                    return "[INFO] "+p1.getUsername() + " successfully registered";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p1.getUsername() + " registered";
    }

    // get file from classpath, resources folder
    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }


    @RequestMapping(value = "/team/display", method=RequestMethod.POST,headers = "Accept=*/*",produces = "application/json")
    public List<Pokemon> displayTeam() throws IOException {
        List<Pokemon> team = new ArrayList<>();
        if(connected.get()){
            return currentUser.getPokemons();
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/team/add", method=RequestMethod.POST,headers = "Accept=*/*",produces = "application/json", consumes="application/json")
    public ResponseEntity<String> addPokemon(@RequestBody Pokemon caughtPokemon) throws IOException {
        if(connected.get()){
            currentUser.getPokemons().add(caughtPokemon);
            return new ResponseEntity<String>("new pokemon "+caughtPokemon.getName()+" added to the player team !",HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("[ERROR] user not connected",HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/team/{pokemon}/update", method=RequestMethod.POST,headers = "Accept=*/*",produces = "application/json", consumes="application/json")
    public ResponseEntity<String> updatePokemonStats(String pokemonName,@RequestBody Stats stats) throws IOException {
        if(connected.get()){
            List<Pokemon> pokemon = currentUser.getPokemons().stream().filter(pokemonster -> pokemonster.getName().equals(pokemonName)).collect(Collectors.toList());
            if(pokemon.size() > 1){
                return new ResponseEntity<String>("[ERROR] multiple pokemon with same name, unable to proceed...",HttpStatus.BAD_REQUEST);
            }else if(pokemon.size() == 0){
                return new ResponseEntity<String>("[ERROR] no pokemon with this name...",HttpStatus.BAD_REQUEST);
            }else{
                currentUser.getPokemons().stream().filter(pokemonster -> pokemonster.getName().equals(pokemonName)).findAny().get().setStats(stats);
                saveUserData();
                return new ResponseEntity<String>("pokemon "+pokemonName+" updated with new stats "+stats.toString() ,HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<String>("[ERROR] user not connected",HttpStatus.BAD_REQUEST);
        }
    }

    private void saveUserData() {
        File userFile = getFileFromResources("users.json");
        try {
            byte[] jsonData = Files.readAllBytes(userFile.toPath());
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(jsonData, new TypeReference<List<User>>() {
            });

            for (User user : users) {
                if (user.getUsername().equals(currentUser.getUsername())) {
                    users.set(users.indexOf(user),currentUser);
                }
            }
            JsonNode rootNode = objectMapper.readTree(jsonData);
            ((ObjectNode) rootNode).remove(currentUser.getUsername());
            try ( OutputStream out = Files.newOutputStream(userFile.toPath())) {
                JsonGenerator g = objectMapper.getFactory().createGenerator(out);
                objectMapper.writeValue(g,users);
                g.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
