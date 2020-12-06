//
//  quote.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-12-06.
//

import Foundation
import SwiftUI
import Combine

class QuoteResponse : ObservableObject {
    @Published var quote: String
    
    func update(val: String) {
        print("update val" + val)
        self.quote = val;
    }
    
    init(quote: String) {
        self.quote = quote
    }
    
    func getQuote() -> String {
        return self.quote
    }
}

class QuoteApiRequest: ObservableObject {
    
    @Published var loading = false
    var quoteResponse = QuoteResponse(quote: "0")
    
    func postQuote(quoteRequest: quoteRequest, path: String) {
        loading = true
        let values: String = "?area=" + quoteRequest.area + "&obstructions=" + quoteRequest.obstruction;
        guard let url = URL(string: "http://10.0.0.44:8080/api/v1/" + path + values ) else { return }

        var request = URLRequest(url: url)
        request.httpMethod = "GET"
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")

        URLSession.shared.dataTask(with: request) { (data, response, error) in
            let responseString = String.init(data: data!, encoding: String.Encoding.utf8)
            if(responseString != nil) {
                self.quoteResponse.update(val: responseString!)
            }
            self.loading = false
        }.resume()
    }
}
