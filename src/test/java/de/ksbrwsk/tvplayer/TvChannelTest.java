package de.ksbrwsk.tvplayer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TvChannelTest {

    @Test
    void create() {
        var tvChannel = new TvChannel(1L, "Das Erste HD", "https://mcdn.daserste.de/daserste/de/master.m3u8");
        assertThat(tvChannel.getId()).isEqualTo(1L);
        assertThat(tvChannel.getName()).isEqualTo("Das Erste HD");
        assertThat(tvChannel.getUrl()).isEqualTo("https://mcdn.daserste.de/daserste/de/master.m3u8");
    }
}