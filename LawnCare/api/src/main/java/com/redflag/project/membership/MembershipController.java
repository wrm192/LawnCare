package com.redflag.project.membership;

import com.redflag.project.common.constants.ApiConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.API_BASE + "membership")
public class MembershipController {

    MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<Membership> getMemberships() {
        return this.membershipService.getMemberships();
    }
}
