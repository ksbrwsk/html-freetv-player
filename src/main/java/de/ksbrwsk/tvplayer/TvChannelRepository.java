package de.ksbrwsk.tvplayer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Comparator.comparing;

@Component
@Slf4j
public class TvChannelRepository {

    private static final ConcurrentHashMap<Long, TvChannel> TVCHANNELS =
            new ConcurrentHashMap<>();

    public void addTvChannel(TvChannel tvChannel) {
        TVCHANNELS.put(tvChannel.getId(), tvChannel);
    }

    public int count() {
        return TVCHANNELS.size();
    }

    public TvChannel getTvChannel(Long id) {
        return TVCHANNELS.get(id);
    }

    public TvChannel getTvChannelByName(String name) {
        Optional<TvChannel> first = TVCHANNELS.values()
                .stream()
                .filter(tvc -> tvc.getName().equalsIgnoreCase(name))
                .findFirst();
        return first.orElseThrow();
    }

    public List<TvChannel> getListTvChannel() {
        return TVCHANNELS.values()
                .stream()
                .sorted(comparing(TvChannel::getName))
                .toList();
    }

    public void reset() {
        TVCHANNELS.clear();
    }
}
