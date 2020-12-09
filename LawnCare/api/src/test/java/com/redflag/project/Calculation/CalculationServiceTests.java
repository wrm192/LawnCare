package com.redflag.project.Calculation;

import com.redflag.project.calculation.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({SpringExtension.class})
public class CalculationServiceTests {

    CalculationService calculationService;

    @BeforeEach
    void setup() {
        this.calculationService = new CalculationService();
    }

    @Test
    void shouldReturnCorrectValue() {
        double result = this.calculationService.calculateCost(2, 4);
        assertEquals(result, 36);

        result = this.calculationService.calculateCost(12, 4);
        assertEquals(result, 236);
    }


}
