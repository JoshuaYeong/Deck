package vttp2022.deck.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Card {
    private String image;
    private String value;
    private String suit;
    private String code;

    public String getImage() {return image; }
    public void setImage(String image) {this.image = image; }

    public String getValue() {return value; }
    public void setValue(String value) {this.value = value; }

    public String getSuit() {return suit ;}
    public void setSuit(String suit) {this.suit = suit; }

    public String getCode() {return code; }
    public void setCode(String code) {this.code = code; }
    
    public static Card create(JsonObject obj) {
            Card card = new Card();
            card.image = obj.getString("image");
            card.value = obj.getString("value");
            card.suit = obj.getString("suit");
            card.code= obj.getString("code");
            return card;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("image", image)
            .add("value", value)
            .add("suit", suit)
            .add("code", code)
            .build();
    }
    
}
