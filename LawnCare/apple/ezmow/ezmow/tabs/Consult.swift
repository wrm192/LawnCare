//
//  Consult.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI
import ToastUI

struct Consult: View {
    @State var name = ""
    @State var phoneNumb = ""
    @State var address = ""
    @State private var presentingToast: Bool = false
    var apiRequest = ApiRequest()
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
                    }
                  )
              }.toast(isPresented: $presentingToast, dismissAfter: 2.0) {
                print("Toast dismissed")
              } content: {
                ToastView(NSLocalizedString("consultAPIToast", comment: ""))
                  .toastViewStyle(IndefiniteProgressToastViewStyle())
              }
              .disabled(name.isEmpty || phoneNumb.isEmpty || address.isEmpty)

      
          } .navigationBarTitle(NSLocalizedString("consult", comment: ""))

        }
       
        
      }

    func buttonAction() {
     
        //print("consult button psuhed")
        presentingToast = true;

        apiRequest.postConsult(consultRequest: ConsultRequest(name: name, phoneNumber: phoneNumb, address: address), path: "book-now")
        print("Submitted")
    }

}

struct Consult_Previews: PreviewProvider {
    static var previews: some View {
        Consult()
    }
}
