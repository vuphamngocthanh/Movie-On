package com.casetudy.admin.service.Impl.episode;

import com.casetudy.dto.EpisodeDto;
import com.casetudy.entity.Episode;
import com.casetudy.repository.EpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {


    private final ModelMapper modelMapper;
    private final EpisodeRepository episodeRepository;
    public EpisodeService(ModelMapper modelMapper, EpisodeRepository episodeRepository) {
        this.modelMapper = modelMapper;
        this.episodeRepository = episodeRepository;
    }
    @Override
    public Iterable<EpisodeDto> findAll() {
        List<Episode> episodeList = episodeRepository.findAll();
        return episodeList.parallelStream()
                .map(episode -> modelMapper.map(episode, EpisodeDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public EpisodeDto findById(Integer id) {
        Episode episode = episodeRepository.findById(id).get();
        return modelMapper.map(episode,EpisodeDto.class);
    }

//    @Override
//    public void save(EpisodeDto episodeDto) {
//        Episode episode = modelMapper.map(episodeDto, Episode.class);
//        episodeRepository.save(episode);
//    }
      @Override
      public void save(EpisodeDto episodeDto) {
         Episode episode = modelMapper.map(episodeDto, Episode.class);
         episodeRepository.save(episode);
    }

    @Override
    public void remove(Integer id) {
    }

}