package br.edu.ifsp.graphql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;

@Controller
public class StarWarController {

    private final List<Human> humans = new ArrayList<>(List.of(
            new Human("1001", "Luke Skywalker",
                    new ArrayList<>(List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI)),
                    new ArrayList<>(), 1.72),
            new Human("1002", "Darth Vader",
                    new ArrayList<>(List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI)),
                    new ArrayList<>(), 2.02)));

    private final List<Droid> droids = new ArrayList<>(List.of(
            new Droid("2001", "R2-D2",
                    new ArrayList<>(List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI)),
                    new ArrayList<>(), "Astromech"),
            new Droid("2002", "C-3PO",
                    new ArrayList<>(List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI)),
                    new ArrayList<>(), "Protocol")));

    private final List<Starship> starships = new ArrayList<>(List.of(
            new Starship(3000, "Millennium Falcon", 34.37),
            new Starship(3001, "X-Wing", 12.5)));

    private Optional<Character> findCharacterById(String id) {
        return Stream.concat(humans.stream(), droids.stream())
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return new Human(
                "1001",
                "Luke Skywalker",
                new ArrayList<>(List.of(episode != null ? episode : Episode.NEWHOPE)),
                new ArrayList<>(),
                1.72);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return droids.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        String lower = text.toLowerCase();
        List<Object> results = new ArrayList<>();
        humans.stream().filter(h -> h.getName().toLowerCase().contains(lower)).forEach(results::add);
        droids.stream().filter(d -> d.getName().toLowerCase().contains(lower)).forEach(results::add);
        starships.stream().filter(s -> s.getName().toLowerCase().contains(lower)).forEach(results::add);
        return results;
    }

    @QueryMapping
    public List<Human> humans() {
        return humans;
    }

    @QueryMapping
    public List<Starship> starships() {
        return starships;
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return findCharacterById(id).orElse(null);
    }

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }

    @MutationMapping
    public Human createHuman(@Argument String id,
                              @Argument String nome,
                              @Argument Double height) {
        Human human = new Human(id, nome, new ArrayList<>(), new ArrayList<>(),
                height != null ? height : 0.0);
        humans.add(human);
        return human;
    }

    @MutationMapping
    public Droid createDroid(@Argument String id,
                              @Argument String nome,
                              @Argument String primaryFunction) {
        Droid droid = new Droid(id, nome, new ArrayList<>(), new ArrayList<>(), primaryFunction);
        droids.add(droid);
        return droid;
    }

    @MutationMapping
    public Starship createStarship(@Argument String id,
                                    @Argument String nome,
                                    @Argument Double length) {
        Starship starship = new Starship(Integer.parseInt(id), nome,
                length != null ? length : 0.0);
        starships.add(starship);
        return starship;
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId,
                                @Argument String friendId) {
        Character character = findCharacterById(characterId)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado: " + characterId));
        Character friend = findCharacterById(friendId)
                .orElseThrow(() -> new RuntimeException("Amigo não encontrado: " + friendId));
        character.getFriends().add(friend);
        return character;
    }
}
