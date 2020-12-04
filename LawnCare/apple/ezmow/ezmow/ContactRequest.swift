//
//  ContactRequest.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-12-04.
//

import Foundation
struct ContactRequest: Codable {
    let name: String;
    let comment: String;
    let contactDetails: String
    
    init(name: String,
             comment: String,
             contactDetails: String) {
            
            self.name = name
            self.comment = comment
            self.contactDetails = contactDetails
        }
}
