package com.example.FirstJava;

import com.example.FirstJava.model.Player;
import com.google.common.collect.ImmutableList;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("players")
public class FrontController {

    private static final List<Player> testData = ImmutableList.of(new Player(1, "Viv Richards"),
            new Player(2, "Kane Williamson"));

    @GetMapping(value = "/{id}", produces = "application/json")
    public Player getPlayer(@PathVariable int id) {
        return testData.stream().filter(player -> player.getPlayerId() == id).findAny().get();
    }
}
