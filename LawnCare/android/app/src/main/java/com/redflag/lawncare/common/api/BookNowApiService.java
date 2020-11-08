package com.redflag.lawncare.common.api;

import androidx.fragment.app.Fragment;

import com.redflag.lawncare.book.BookNowFragment;
import com.redflag.lawncare.common.api.dto.BookNowRequest;

public class BookNowApiService extends FragmentApiService<BookNowFragment, BookNowRequest> {

    public BookNowApiService(BookNowFragment parent, BookNowRequest request) {
        super(parent, request);
    }

    @Override
    protected String doInBackground(BookNowRequest... bookNowRequests) {

        return this.returnResult("book-now");
    }
}
