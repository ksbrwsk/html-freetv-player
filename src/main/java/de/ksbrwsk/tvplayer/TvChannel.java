package de.ksbrwsk.tvplayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvChannel {
    Long id;
    String name;
    String url;
}
