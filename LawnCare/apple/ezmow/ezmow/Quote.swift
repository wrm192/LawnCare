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

                Section (header: Text("Area")){
                    TextField("Area", text:
                              $area)
                        .keyboardType(.decimalPad)
                }
                Section (header: Text("Obstructions")){
                    TextField("Obstructions", text:
                              $obstructions)
                        .keyboardType(.decimalPad)
                }

                
                Section {
                    Button(action : {print("Quote button psuhed")}, label: {
                        Text("Get Quote").bold().foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                    })
                }
        
            }
            .navigationTitle("Quote")

        }

    }
}

struct Quote_Previews: PreviewProvider {
    static var previews: some View {
        Quote()
    }
}
