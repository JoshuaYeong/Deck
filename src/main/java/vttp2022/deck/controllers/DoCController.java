package vttp2022.deck.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.deck.models.Deck;
import vttp2022.deck.services.DoCService;

@Controller
@RequestMapping(path="/deck")
public class DoCController {

    @Autowired
    private DoCService docSvc;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postDeck(Model model) {
        Deck deck = docSvc.createDeck();

        model.addAttribute("deck", deck);
        model.addAttribute("cards", List.of());
        model.addAttribute("action", "/deck/%s".formatted(deck.getDeckId()));

        return "game";
    }

    @PostMapping(path="/{deckId}")
    public String postDeckId(@PathVariable String deckId, 
        @RequestBody MultiValueMap<String, String> form, Model model) {

            Integer count = Integer.parseInt(form.getFirst("draw_count"));

            Deck deck = docSvc.drawCards(deckId, count);

            model.addAttribute("deck", deck);
            model.addAttribute("cards", deck.getCards());

            return "game";

    }

}
