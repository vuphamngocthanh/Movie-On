package com.casetudy.admin.service.Impl.region;

import com.casetudy.dto.RegionDto;
import com.casetudy.entity.Region;
import com.casetudy.repository.RegionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionService implements IRegionService {
    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;
    public RegionService(RegionRepository regionRepository, ModelMapper modelMapper) {
        this.regionRepository = regionRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Iterable<RegionDto> findAll() {
        List<Region> regionList = regionRepository.findAll();
        return regionList.parallelStream()
                .map(region -> modelMapper.map(region,RegionDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public RegionDto findById(Integer id) {
        return null;
    }

    @Override
    public void save(RegionDto regionDto) {

    }

    @Override
    public void remove(Integer id) {

    }
}