package com.redflag.project.calculation;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    double costPerAcre = 20;

    public double calculateCost (double area, double obstructions) {
        return area * 20 - obstructions;
    }
}
