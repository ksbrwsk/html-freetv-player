package de.ksbrwsk.tvplayer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HtmlFreeTvPlayerController {
    private static final String PAGE_INDEX = "index";
    private static final String PAGE_START = "start";
    private static final String PAGE_CHANNELS = "channels";

    private final TvChannelRepository tvChannelRepository;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        addCommonModelAttributes(model);
        List<TvChannel> listTvChannel = this.tvChannelRepository.getListTvChannel();
        TvChannel first = listTvChannel.getFirst();
        TvChannelForm tvChannelForm = new TvChannelForm(first.getId(), first.getName());
        model.addAttribute("tvChannels", listTvChannel);
        model.addAttribute("tvChannel", tvChannelForm);
        return PAGE_INDEX;
    }

    @GetMapping(value = {"/channels"})
    public String channels(Model model) {
        addCommonModelAttributes(model);
        List<TvChannel> listTvChannel = this.tvChannelRepository.getListTvChannel();
        model.addAttribute("tvChannels", listTvChannel);
        return PAGE_CHANNELS;
    }

    @GetMapping(value = {"/start"})
    public String start(Model model, @NotNull @RequestParam("id") Long id) {
        addCommonModelAttributes(model);
        TvChannel tvChannel = this.tvChannelRepository.getTvChannel(id);
        model.addAttribute("tvChannelUrl", tvChannel.getUrl());
        log.info("requested tv station -> {}-{}", tvChannel.getId(), tvChannel.getName());
        return PAGE_START;
    }

    @PostMapping(value = "/start")
    public String start(Model model,
                        @Valid @ModelAttribute("tvChannel") TvChannelForm form,
                        BindingResult bindingResult) {
        TvChannel tvChannel = this.tvChannelRepository.getTvChannel(form.getId());
        model.addAttribute("tvChannelUrl", tvChannel.getUrl());
        log.info("requested tv station -> {}-{}", tvChannel.getId(), tvChannel.getName());
        return PAGE_START;
    }

    private void addCommonModelAttributes(@NotNull Model model) {
        model.addAttribute("titleMessage", "HTML TV Player");
        model.addAttribute("appInfo", "HTML TV Player");
    }
}
