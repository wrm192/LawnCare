package com.redflag.project.contact;

import com.redflag.project.common.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(AppConstants.API_BASE + "contact")
public class ContactController {

    @Autowired
    public ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    //get request
    //which takes 2 values, and returns the calculation of the CalculationService.
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendEmail(@RequestBody @Valid ContactRequest request) throws Exception{
        this.contactService.sendEmail(request);
    }

}
