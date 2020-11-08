//
//  Consult.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct Consult: View {
    @State var name = ""
      @State var phoneNumb = ""
      @State var address = ""
      
      var body: some View {
        // If your keyboad doesn't show up, on the simulation select I/O -> Keyboard -> Connect hardware to device (or something like that) and restart your simulator.
        NavigationView {
          Form {

              Section (header: Text(NSLocalizedString("consultName", comment: ""))){
                  TextField(NSLocalizedString("consultName", comment: ""), text:
                            $name)
              }
              
              Section (header: Text(NSLocalizedString("consultPhoneNumber", comment: ""))){
                  TextField(NSLocalizedString("consultPhoneNumber", comment: ""), text:
                            $phoneNumb)
                      .keyboardType(.decimalPad)
              }

              Section (header: Text(NSLocalizedString("consultAddress", comment: ""))){
                  TextField(NSLocalizedString("consultAddress", comment: ""), text:
                            $address)
              }
              
              Section {
                  Button(action : {buttonAction()}, label: {
                      Text(NSLocalizedString("consultBookNowButton", comment: "")).bold().foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                          .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                  })
              }
      
          } .navigationBarTitle(NSLocalizedString("consult", comment: ""))

        }
       
        
      }

    func buttonAction() {
        print("consult button psuhed")
    }

}


struct Consult_Previews: PreviewProvider {
    static var previews: some View {
        Consult()
    }
}
