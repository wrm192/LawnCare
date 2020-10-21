//
//  translation.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-10-21.
//

import Foundation

class TranslateService {
    
    func getTranslation(value: String, comment: String) -> String {
        return NSLocalizedString(value, comment: comment);
    }
    
}
