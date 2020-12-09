package com.redflag.project.Calculation;

import com.redflag.project.calculation.CalculationController;
import com.redflag.project.calculation.CalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class CalculationControllerTests {

    @Mock
    CalculationService calculationService;

    CalculationController calculationController;

    double a,b;

    @BeforeEach
    void setup() {
        calculationController = new CalculationController(calculationService);
        a = 20L;
        b = 30L;
    }

    @Test
    void shouldCallCorrectService() throws Exception{

        calculationController.getCalculationService(a, b);
        verify(calculationService, times(1)).calculateCost(anyDouble(), anyDouble());
    }
}
