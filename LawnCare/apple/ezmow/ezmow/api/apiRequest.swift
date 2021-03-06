//
//  apiRequest.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-12-04.
//

import Foundation
import SwiftUI
import Combine

struct loginResult: Codable {
    var correctCredentials: Bool
    var message: String
}

struct ServerMessage: Codable {
    var loginResults: [loginResult]
}



class ApiRequest: ObservableObject {
    
    @Published var loading = false
    var quoteResponse = QuoteResponse(quote: "0")
    
    func postRequest(emailRequest: emailRequest, path: String) {
        loading = true
        guard let url = URL(string: "http://10.0.0.44:8080/api/v1/" + path) else { return }

            // let body: [String: String] = ["username": username, "password": password]
        do {
//            let data = try NSData.init(contentsOfFile: path) as Data
//            let finalBody = try! JSONSerialization.jsonObject(with: data, options: .mutableContainers) as? [String:AnyObject]
            let jsonData = try JSONEncoder().encode(emailRequest)
            // let jsonString = String(data: jsonData, encoding: .utf8)!
            var request = URLRequest(url: url)
            request.httpMethod = "POST"
            request.httpBody = jsonData
            request.setValue("application/json", forHTTPHeaderField: "Content-Type")

            URLSession.shared.dataTask(with: request) { (data, response, error) in
                guard let data = data else { return }
                let resData = try! JSONDecoder().decode(ServerMessage.self, from: data)
                print(resData.loginResults)
                self.loading = false
            }.resume()
        
        }catch {
            print("Error getting data")
          
        }
        
    }
    
    func postContact(contactRequest: ContactRequest, path: String) {
        loading = true
        guard let url = URL(string: "http://10.0.0.44:8080/api/v1/" + path) else { return }

            // let body: [String: String] = ["username": username, "password": password]
        do {
//            let data = try NSData.init(contentsOfFile: path) as Data
//            let finalBody = try! JSONSerialization.jsonObject(with: data, options: .mutableContainers) as? [String:AnyObject]
            let jsonData = try JSONEncoder().encode(contactRequest)
            // let jsonString = String(data: jsonData, encoding: .utf8)!
            var request = URLRequest(url: url)
            request.httpMethod = "POST"
            request.httpBody = jsonData
            request.setValue("application/json", forHTTPHeaderField: "Content-Type")

            URLSession.shared.dataTask(with: request) { (data, response, error) in
                //guard let data = data else { return }
//                let resData = try! JSONDecoder().decode(ServerMessage.self, from: data)
//                print(resData.loginResults)
//                self.loading = false
            }.resume()
        
        }catch {
            print("Error getting data")
          
        }
        
    }
    
    func postConsult(consultRequest: ConsultRequest, path: String) {
        loading = true
        guard let url = URL(string: "http://10.0.0.44:8080/api/v1/" + path) else { return }

            // let body: [String: String] = ["username": username, "password": password]
        do {
//            let data = try NSData.init(contentsOfFile: path) as Data
//            let finalBody = try! JSONSerialization.jsonObject(with: data, options: .mutableContainers) as? [String:AnyObject]
            let jsonData = try JSONEncoder().encode(consultRequest)
            // let jsonString = String(data: jsonData, encoding: .utf8)!
            var request = URLRequest(url: url)
            request.httpMethod = "POST"
            request.httpBody = jsonData
            request.setValue("application/json", forHTTPHeaderField: "Content-Type")

            URLSession.shared.dataTask(with: request) { (data, response, error) in
                //guard let data = data else { return }
//                let resData = try! JSONDecoder().decode(ServerMessage.self, from: data)
//                print(resData.loginResults)
//                self.loading = false
            }.resume()
        
        }catch {
            print("Error getting data")
          
        }
        
    }
    
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
