//
//  quoteRequest.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-12-04.
//

import Foundation
struct quoteRequest: Codable {
    let area: String;
    let obstruction: String;
    
    init(area: String,
             obstruction: String) {
            
            self.area = area
            self.obstruction = obstruction
        }
}
