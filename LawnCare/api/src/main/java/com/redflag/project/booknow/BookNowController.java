package com.redflag.project.booknow;

import com.redflag.project.common.constants.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(AppConstants.API_BASE + "book-now")
public class BookNowController {

    private BookNowService bookNowService;

    public BookNowController(BookNowService bookNowService){
        this.bookNowService = bookNowService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendEmail (@RequestBody @Valid BookNowRequest request) throws Exception{
        this.bookNowService.sendEmail(request);
    }
}
