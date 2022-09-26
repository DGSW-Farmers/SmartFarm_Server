package com.project.smartFarm.domain.soil.presentation;

import com.project.smartFarm.domain.soil.service.SoilService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "토경재배", tags = {"농장 - 토경재배"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/soil")
public class SoilController {

    private final SoilService soilService;

}
