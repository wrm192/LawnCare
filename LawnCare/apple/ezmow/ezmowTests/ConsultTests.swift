//
//  ConsultTests.swift
//  ezmowTests
//
//  Created by Jarrod Jung on 2020-12-06.
//

import Foundation
import XCTest

@testable import ezmow

class ConsultTests: XCTestCase {
    func testValidName() {
        let a = Consult(name: "HP")
        XCTAssertTrue(a.validName())
    }
    
    func testValidPhoneNumb() {
        let a = Consult(phoneNumb: "123")
        XCTAssertTrue(a.validPhoneNumb())
    }
    
    func testValidPhoneNumbString() {
        let a = Consult(phoneNumb: "abc")
        XCTAssertFalse(a.validPhoneNumb())
    }
    
    func testValidAdress() {
        let a = Consult(address: "abc")
        XCTAssertTrue(a.validAdress())
    }
}
