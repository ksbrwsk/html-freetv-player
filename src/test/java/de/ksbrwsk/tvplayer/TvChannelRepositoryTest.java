package de.ksbrwsk.tvplayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TvChannelRepositoryTest {

    @Autowired
    TvChannelRepository tvChannelRepository;

    @BeforeEach
    void setUp() throws IOException {
        TvChannelInitializr initializr = new TvChannelInitializr(this.tvChannelRepository);
        initializr.process();
        assertThat(this.tvChannelRepository.count()).isEqualTo(158L);
    }

    @Test
    void getListTvChannel() {
        List<TvChannel> listTvChannel = this.tvChannelRepository.getListTvChannel();
        assertThat(listTvChannel.isEmpty()).isFalse();
        assertThat(listTvChannel.size()).isEqualTo(158L);
        listTvChannel.forEach(System.out::println);
    }
}