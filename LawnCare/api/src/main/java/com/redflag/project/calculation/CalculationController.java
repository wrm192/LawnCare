package com.redflag.project.calculation;

import com.redflag.project.common.constants.ApiConstants;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_BASE + "calculations")
public class CalculationController {

    public CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }
    //get request
    //which takes 2 values, and returns the calculation of the CalculationService.
    @GetMapping
    public double getCalculationService (@Param("area") double area, @Param("obstructions") double obstructions ) throws Exception{
        return this.calculationService.calculateCost(area, obstructions);
    }

}
