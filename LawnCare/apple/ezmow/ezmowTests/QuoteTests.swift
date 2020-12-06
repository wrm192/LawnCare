//
//  QuoteTests.swift
//  ezmowTests
//
//  Created by Jarrod Jung on 2020-12-06.
//

import Foundation
import XCTest

@testable import ezmow

class QuoteTests: XCTestCase {
    func testValidArea() {
        let a = Quote(area: "123")
        XCTAssertTrue(a.validArea())
    }
    func testValidAreaString() {
        let a = Quote(area: "abc")
        XCTAssertFalse(a.validArea())
    }
    
    func testValidObstruction() {
        let a = Quote(obstructions: "123")
        XCTAssertTrue(a.validObstructions())
    }
    func testValidObstructionString() {
        let a = Quote(obstructions: "abc")
        XCTAssertFalse(a.validObstructions())
    }
    
}
