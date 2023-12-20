package de.ksbrwsk.tvplayer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The TvChannelForm class represents the form data for a TV channel in the HTML TV Player application.
 * It is a simple POJO (Plain Old Java Object) with two fields: id and name.
 * The class is annotated with Lombok annotations to automatically generate getters, setters, constructors, and the toString method.
 * @Getter: Generates getters for all fields.
 * @Setter: Generates setters for all fields.
 * @NoArgsConstructor: Generates a no-args constructor.
 * @AllArgsConstructor: Generates a constructor with one parameter for each field in your class.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TvChannelForm {
    /**
     * The id of the TV channel. This field is annotated with @NotNull to indicate that it must not be null when validating the form data.
     */
    @NotNull
    Long id;

    /**
     * The name of the TV channel.
     */
    String name;
}