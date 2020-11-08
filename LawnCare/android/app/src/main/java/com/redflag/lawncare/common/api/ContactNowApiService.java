package com.redflag.lawncare.common.api;

import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.common.api.dto.BookNowRequest;
import com.redflag.lawncare.common.api.dto.ContactNowRequest;
import com.redflag.lawncare.contact.ContactFragment;

public class ContactNowApiService extends FragmentApiService<ContactFragment, ContactNowRequest> {
    public ContactNowApiService(ContactFragment parent, ContactNowRequest request) {
        super(parent, request);
    }

    @Override
    protected String doInBackground(ContactNowRequest... contactNowRequests) {
        return this.returnResult("contact");
    }
}
