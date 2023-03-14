package com.casetudy.admin.service.Impl.region;

import com.casetudy.admin.service.IGeneralService;
import com.casetudy.dto.RegionDto;

public interface IRegionService extends IGeneralService<RegionDto> {
    Iterable<RegionDto> findAll();
}