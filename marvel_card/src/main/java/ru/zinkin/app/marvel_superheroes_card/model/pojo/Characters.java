package ru.zinkin.app.marvel_superheroes_card.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Table(name = "characters")
@Builder
@Valid
public class Characters {
    @Id
    @NotNull(message = "ID не может быть равен null")
    @NotEmpty(message = "ID не может быть пустым")
    @NotBlank(message = "ID не может быть пустым")
    @Column(name = "id",updatable = false,length = 200,nullable = false)
    private String id;
    @NotNull(message = "DURABILITY не может быть равен null")
    @Min(value = 0,message = "DURABILITY не может быть меньше 0")
    @Max(value = 10,message = "DURABILITY не может быть больше 10")
    private Byte DURABILITY;
    @NotNull(message = "ENERGY не может быть равен null")
    @Min(value = 0,message = "ENERGY не может быть меньше null")
    @Max(value = 10,message = "ENERGY не может быть больше 10")
    private Byte ENERGY;
    @NotNull(message = "FIGHTING_SKILLS не может быть равен null")
    @Min(value = 0,message = "FIGHTING_SKILLS не может быть меньше 0")
    @Max(value = 10,message = "FIGHTING_SKILLS не может быть больше 10")
    private Byte FIGHTING_SKILLS;
    @NotNull(message = "INTELLIGENCE не может быть равен null")
    @Min(value = 0,message = "INTELLIGENCE не может быть меньше 0")
    @Max(value = 10,message = "INTELLIGENCE не может быть больше 10")
    private Byte INTELLIGENCE;
    @NotNull(message = "SPEED не может быть равен null")
    @Min(value = 0,message = "SPEED не может быть меньше 0")
    @Max(value = 10,message = "SPEED не может быть больше 10")
    private Byte SPEED;

    @NotNull(message = "STRENGTH не может быть равен null")
    @Min(value = 0,message = "STRENGTH не может быть меньше 0")
    @Max(value = 10,message = "STRENGTH не может быть больше 10")
    private Byte STRENGTH;

    @Column(name = "name",updatable = false,length = 200)
    @NotNull(message = "name не может быть равен null")
    @NotEmpty(message = "name не может быть пустым")
    @NotBlank(message = "ID не может быть пустым")
    private String name;
    @Column(name = "height")
    private Integer height;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "eyes")
    @ElementCollection
    private List<String> eyes;
    @Column(name = "hair")
    @ElementCollection
    private List<String> hair;
    @Column(name = "universe")
    private String universe;
    @Column(name = "other_aliases")
    @ElementCollection
    private List<String> other_aliases;
    @Column(name = "education")
    private String education;
    @Column(name = "place_of_origin")
    private String place_of_origin;
    @Column(name = "known_relatives")
    @ElementCollection
    private List<String> known_relatives;
    @Column(name = "images")
    @NotNull
    private String img;

    @ManyToMany(mappedBy = "characters")
    @JsonIgnore
    private List<Comics> comics;

    public Characters(String id,
                      Byte DURABILITY,
                      Byte ENERGY,
                      Byte FIGHTING_SKILLS,
                      Byte INTELLIGENCE,
                      Byte SPEED,
                      Byte STRENGTH,
                      String name,
                      String img) {
        this.id = id;
        this.DURABILITY = DURABILITY;
        this.ENERGY = ENERGY;
        this.FIGHTING_SKILLS = FIGHTING_SKILLS;
        this.INTELLIGENCE = INTELLIGENCE;
        this.SPEED = SPEED;
        this.STRENGTH = STRENGTH;
        this.name = name;
        this.img = img;
    }

    public Characters(String id,
                      Byte DURABILITY,
                      Byte ENERGY,
                      Byte FIGHTING_SKILLS,
                      Byte INTELLIGENCE,
                      Byte SPEED,
                      Byte STRENGTH,
                      String name,
                      Integer height,
                      Integer weight,
                      List<String> eyes,
                      List<String> hair,
                      String universe,
                      List<String> other_aliases,
                      String education,
                      String place_of_origin,
                      List<String> known_relatives,
                      String img) {
        this.id = id;
        this.DURABILITY = DURABILITY;
        this.ENERGY = ENERGY;
        this.FIGHTING_SKILLS = FIGHTING_SKILLS;
        this.INTELLIGENCE = INTELLIGENCE;
        this.SPEED = SPEED;
        this.STRENGTH = STRENGTH;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.eyes = eyes;
        this.hair = hair;
        this.universe = universe;
        this.other_aliases = other_aliases;
        this.education = education;
        this.place_of_origin = place_of_origin;
        this.known_relatives = known_relatives;
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characters that = (Characters) o;
        return id.equals(that.id) && DURABILITY.equals(that.DURABILITY) && ENERGY.equals(that.ENERGY) && FIGHTING_SKILLS.equals(that.FIGHTING_SKILLS) && INTELLIGENCE.equals(that.INTELLIGENCE) && SPEED.equals(that.SPEED) && STRENGTH.equals(that.STRENGTH) && name.equals(that.name) && Objects.equals(height, that.height) && Objects.equals(weight, that.weight) && Objects.equals(eyes, that.eyes) && Objects.equals(hair, that.hair) && Objects.equals(universe, that.universe) && Objects.equals(other_aliases, that.other_aliases) && Objects.equals(education, that.education) && Objects.equals(place_of_origin, that.place_of_origin) && Objects.equals(known_relatives, that.known_relatives) && Objects.equals(img, that.img) && Objects.equals(comics, that.comics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, DURABILITY, ENERGY, FIGHTING_SKILLS, INTELLIGENCE, SPEED, STRENGTH, name, height, weight, eyes, hair, universe, other_aliases, education, place_of_origin, known_relatives, img, comics);
    }
}
