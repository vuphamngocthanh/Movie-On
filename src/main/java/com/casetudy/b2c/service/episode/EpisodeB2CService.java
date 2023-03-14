package com.casetudy.b2c.service.episode;

import com.casetudy.dto.EpisodeDto;
import com.casetudy.entity.Episode;
import com.casetudy.entity.Movie;
import com.casetudy.repository.EpisodeRepository;
import com.casetudy.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeB2CService implements IEpisodeB2CService {
    private final ModelMapper modelMapper;
    private final EpisodeRepository episodeRepository;
    private final MovieRepository movieRepository;

    public EpisodeB2CService(ModelMapper modelMapper, EpisodeRepository episodeRepository,
                             MovieRepository movieRepository) {
        this.modelMapper = modelMapper;
        this.episodeRepository = episodeRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<EpisodeDto> findAll() {
        List<Episode> episodes = episodeRepository.findAll();
        return episodes.parallelStream()
                .map(episode -> modelMapper.map(episode,EpisodeDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public EpisodeDto findById(Integer id) {
        Episode episode = episodeRepository.findByReferenceId(id);
        return modelMapper.map(episode, EpisodeDto.class);
    }
    @Override
    public void save(EpisodeDto episodeDto) {

    }
    @Override
    public void remove(Integer id) {

    }
}
