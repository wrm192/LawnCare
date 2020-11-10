//
//  Quote.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct Quote: View {
    @State var area = ""
    @State var obstructions = ""
    
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
                }
        
            }
            .navigationBarTitle(NSLocalizedString("quote", comment: ""))

        }
        
    }
    
    func buttonAction() {
        print("consult button pushed");
        
        if (area == "" || obstructions == "") {
            print("empty");
        }
    }
}

struct Quote_Previews: PreviewProvider {
    static var previews: some View {
        Quote()
    }
}
                
