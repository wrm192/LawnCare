//
//  ContactTests.swift
//  ezmowTests
//
//  Created by Jarrod Jung on 2020-12-06.
//

import Foundation
import XCTest

@testable import ezmow

class ContacTests: XCTestCase {
    func testValidName() {
        let a = Contact(name: "HP")
        XCTAssertTrue(a.validName())
    }
    
    func testValidPhoneNumb() {
        let a = Contact(phoneNumb: "123")
        XCTAssertTrue(a.validPhoneNumb())
    }
    
    func testValidPhoneNumbString() {
        let a = Contact(phoneNumb: "abc")
        XCTAssertFalse(a.validPhoneNumb())
    }
    
    func testTextField() {
        let a = Contact(textField: "abc")
        XCTAssertTrue(a.validTextField())
    }
    
    func testEmail() {
        let a = Contact(email: "abc")
        XCTAssertTrue(a.validEmail())
    }
    func testEmailAdress() {
        let a = Contact(email: "abc@abc")
        XCTAssertTrue(a.validEmailAdress())
    }
}
