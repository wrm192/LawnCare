package com.redflag.project.membership;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    MembershipRepository repository;

    public MembershipService(MembershipRepository repository) {
        this.repository = repository;
    }

    public List<Membership> getMemberships () {
        return this.repository.findAll();
    }
}
