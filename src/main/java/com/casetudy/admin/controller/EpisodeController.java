package com.casetudy.admin.controller;

import com.casetudy.admin.service.Impl.episode.IEpisodeService;
import com.casetudy.dto.EpisodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin-movie")
public class EpisodeController {
    @Autowired
    private IEpisodeService episodeService;
//    z

}
