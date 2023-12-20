package de.ksbrwsk.tvplayer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * The TvChannelInitializr class is responsible for initializing TV channels in the application.
 * It is annotated with @Component to indicate that it is a Spring Bean.
 * @RequiredArgsConstructor is a Lombok annotation that generates a constructor with required fields.
 * @Slf4j is a Lombok annotation that provides a logger for the class.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class TvChannelInitializr {
    private final static String DATA_FILE_NAME = "channels.csv";

    private final TvChannelRepository tvChannelRepository;

    /**
     * The process method is scheduled to run every 23 hours.
     * It logs an info message and then calls the processData method.
     * @throws IOException if an I/O error occurs
     */
    @Scheduled(timeUnit = TimeUnit.HOURS, fixedRateString = "23")
    public void process() throws IOException {
        log.info("");
        this.processData();
    }

    /**
     * The processData method loads TV channels from a CSV file, resets the TV channel repository,
     * and then adds the loaded TV channels to the repository.
     * @throws IOException if an I/O error occurs
     */
    private void processData() throws IOException {
        log.info("Start loading tv channels from {} ...", DATA_FILE_NAME);
        this.tvChannelRepository.reset();
        Resource resource = new ClassPathResource(DATA_FILE_NAME);
        String str = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        String[] tmp = str.split("\n");
        List<String> strings = List.of(tmp);
        List<TvChannel> tvcs = strings
                .stream()
                .skip(1) // headers
                .map(this::splitTvChannelTuple)
                .map(this::createTvChannel)
                .toList();
        this.tvChannelRepository.reset();
        tvcs.forEach(this.tvChannelRepository::addTvChannel);
        log.info("successfully loaded {} items from {}", this.tvChannelRepository.count(), DATA_FILE_NAME);
    }

    /**
     * The createTvChannel method creates a new TvChannel object from a tuple of strings.
     * @param tuple a tuple of strings representing a TV channel
     * @return a new TvChannel object
     */
    private TvChannel createTvChannel(String[] tuple) {
        var id = Long.parseLong(tuple[0]);
        var name = tuple[1];
        var url = tuple[2];
        return new TvChannel(id, name, url);
    }

    /**
     * The splitTvChannelTuple method splits a string into a tuple of strings.
     * @param s a string representing a TV channel
     * @return a tuple of strings
     */
    private String[] splitTvChannelTuple(String s) {
        s = s.replaceAll("(\r\n|\r)", "");
        return s.split(";");
    }
}