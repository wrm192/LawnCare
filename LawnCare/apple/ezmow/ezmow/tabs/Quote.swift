//
//  Quote.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI
import ToastUI
import Combine

struct Quote: View {
    @State var area = ""
    @State var obstructions = ""
    @State private var presentingToast: Bool = false
    @ObservedObject var apiRequest = QuoteApiRequest()
    
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
                    Button(action : {buttonAction()}, label: {
                        Text(NSLocalizedString("quoteGetQuoteButton", comment: "")).bold().foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                    })
                }.toast(isPresented: $presentingToast, dismissAfter: 2.0) {
                    print("Toast dismissed")
                  } content: {
                    ToastView(NSLocalizedString("quoteAPIToast", comment: ""))
                      .toastViewStyle(IndefiniteProgressToastViewStyle())
                  }
                .disabled(area.isEmpty || obstructions.isEmpty)

                Section (header: Text(NSLocalizedString("quoteCost", comment: ""))) {
                    TextField("", text: $apiRequest.quoteResponse.quote)
                }
        
            }
            .navigationBarTitle(NSLocalizedString("quote", comment: ""))
            .onReceive(/*@START_MENU_TOKEN@*//*@PLACEHOLDER=Publisher@*/NotificationCenter.default.publisher(for: .NSCalendarDayChanged)/*@END_MENU_TOKEN@*/, perform: { _ in
                /*@START_MENU_TOKEN@*//*@PLACEHOLDER=code@*/ /*@END_MENU_TOKEN@*/
            })

        }
        
    }
    
    func buttonAction() {
        //print("consult button pushed");
        
        if (area == "" || obstructions == "") {
            print("empty");
        }
        
        presentingToast = true;
        
        apiRequest.postQuote(quoteRequest: quoteRequest(area: area, obstruction: obstructions), path: "calculations")
        print("Submitted")
    }
}

struct Quote_Previews: PreviewProvider {
    static var previews: some View {
        Quote()
    }
}
                
