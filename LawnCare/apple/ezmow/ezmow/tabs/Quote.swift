//
//  Quote.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI
import ToastUI

extension String {
    var isInt: Bool {
        return Int(self) != nil
    }
}

struct Quote: View {
    @State var area = ""
    @State var obstructions = ""
    @State private var presentingToast: Bool = false
    var apiRequest = ApiRequest()
    
    var body: some View {
        
        
        //if keybaord doesnt come up in sim. shift, cmd, k
        NavigationView{
            Form {

                Section (header: Text(NSLocalizedString("quoteArea", comment: ""))){
                    TextField(NSLocalizedString("quoteArea", comment: ""), text:
                              $area).keyboardType(.decimalPad)
                }
                              
                                
                Section (header: Text(NSLocalizedString("quoteObstructions", comment: ""))){
                    TextField(NSLocalizedString("quoteObstructions", comment: ""), text:
                                $obstructions)
                }

                
                Section {
                    if (area.isInt && obstructions.isInt) {
                    Button(action : {buttonAction()}, label: {
                        Text(NSLocalizedString("quoteGetQuoteButton", comment: "")).bold().foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                    })
                    } else {
                        Button(action : {buttonAction()}, label: {
                            Text(NSLocalizedString("quoteGetQuoteButton", comment: "")).bold().foregroundColor(.init(red: 0.31, green: 0.34, blue: 0.36))
                                .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                        })
                    }}.toast(isPresented: $presentingToast, dismissAfter: 2.0) {
                    print("Toast dismissed")
                  } content: {
                    ToastView(NSLocalizedString("quoteAPIToast", comment: ""))
                      .toastViewStyle(IndefiniteProgressToastViewStyle())
                  }
                .disabled(area.isEmpty || obstructions.isEmpty)
                .disabled(!area.isInt || !obstructions.isInt)

        
            }
            .navigationBarTitle(NSLocalizedString("quote", comment: ""))

        }
        
    }
    
    func buttonAction() {
        //print("consult button pushed");
        presentingToast = true;
    
        apiRequest.postQuote(quoteRequest: quoteRequest(area: area, obstruction: obstructions), path: "quote")
        print("Submitted")
       
    }
}

struct Quote_Previews: PreviewProvider {
    static var previews: some View {
        Quote()
    }
}
                
