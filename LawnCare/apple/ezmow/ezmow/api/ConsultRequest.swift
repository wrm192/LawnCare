//
//  ConsultRequest.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-12-04.
//

import Foundation
struct ConsultRequest: Codable {
    let name: String;
    let phoneNumber: String;
    let address: String
    
    init(name: String,
             phoneNumber: String,
             address: String) {
            
            self.name = name
            self.phoneNumber = phoneNumber
            self.address = address
        }
}
