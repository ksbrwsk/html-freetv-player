package de.ksbrwsk.tvplayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The TvChannel class represents a TV channel in the HTML TV Player application.
 * It is a simple POJO (Plain Old Java Object) with three fields: id, name, and url.
 * The class is annotated with Lombok annotations to automatically generate getters, setters, constructors, and the toString method.
 * @Data: Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
 * @NoArgsConstructor: Generates a no-args constructor.
 * @AllArgsConstructor: Generates a constructor with one parameter for each field in your class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvChannel {
    /**
     * The id of the TV channel.
     */
    Long id;

    /**
     * The name of the TV channel.
     */
    String name;

    /**
     * The URL of the TV channel.
     */
    String url;
}