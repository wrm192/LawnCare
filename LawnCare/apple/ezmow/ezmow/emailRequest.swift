//
//  emailRequest.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-12-04.
//

import Foundation

struct emailRequest : Codable {
    
    let name: String;
    let address: String;
    let phoneNumber: String
    
    init(name: String,
             address: String,
             phoneNumber: String) {
            
            self.name = name
            self.address = address
            self.phoneNumber = phoneNumber
        }
}
