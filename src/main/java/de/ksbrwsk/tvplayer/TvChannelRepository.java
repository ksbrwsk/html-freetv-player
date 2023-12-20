package de.ksbrwsk.tvplayer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Comparator.comparing;

/**
 * The TvChannelRepository class is a Spring Bean that provides methods for managing TV channels in the application.
 * It uses a ConcurrentHashMap to store TV channels, with the channel ID as the key and the TvChannel object as the value.
 * @Component: Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
 * @Slf4j: Lombok annotation, used to provide a logger for the class.
 */
@Component
@Slf4j
public class TvChannelRepository {

    /**
     * A ConcurrentHashMap that stores TV channels, with the channel ID as the key and the TvChannel object as the value.
     */
    private static final ConcurrentHashMap<Long, TvChannel> TVCHANNELS =
            new ConcurrentHashMap<>();

    /**
     * Adds a TV channel to the repository.
     * @param tvChannel The TV channel to add.
     */
    public void addTvChannel(TvChannel tvChannel) {
        TVCHANNELS.put(tvChannel.getId(), tvChannel);
    }

    /**
     * Returns the number of TV channels in the repository.
     * @return The number of TV channels.
     */
    public int count() {
        return TVCHANNELS.size();
    }

    /**
     * Returns the TV channel with the specified ID.
     * @param id The ID of the TV channel.
     * @return The TV channel with the specified ID.
     */
    public TvChannel getTvChannel(Long id) {
        return TVCHANNELS.get(id);
    }

    /**
     * Returns the TV channel with the specified name.
     * @param name The name of the TV channel.
     * @return The TV channel with the specified name.
     * @throws NoSuchElementException if no TV channel with the specified name is found.
     */
    public TvChannel getTvChannelByName(String name) {
        Optional<TvChannel> first = TVCHANNELS.values()
                .stream()
                .filter(tvc -> tvc.getName().equalsIgnoreCase(name))
                .findFirst();
        return first.orElseThrow();
    }

    /**
     * Returns a list of all TV channels in the repository, sorted by name.
     * @return A list of all TV channels.
     */
    public List<TvChannel> getListTvChannel() {
        return TVCHANNELS.values()
                .stream()
                .sorted(comparing(TvChannel::getName))
                .toList();
    }

    /**
     * Removes all TV channels from the repository.
     */
    public void reset() {
        TVCHANNELS.clear();
    }
}