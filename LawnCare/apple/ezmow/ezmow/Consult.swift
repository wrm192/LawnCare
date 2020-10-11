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
        //if keybaord doesnt come up in sim. shift, cmd, k
        NavigationView{
            Form {

                Section (header: Text("Name")){
                    TextField("Name", text:
                              $name)
                }
                
                Section (header: Text("Phone Number")){
                    TextField("Phone Number", text:
                              $phoneNumb)
                        .keyboardType(.decimalPad)
                }

                Section (header: Text("Addreess")){
                    TextField("Address", text:
                              $address)
                }
                
                Section {
                    Button(action : {print("Quote button psuhed")}, label: {
                        Text("Book Now").bold().foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                    })
                }
        
            }
            .navigationTitle("Book Now")

        }
    }
}

struct Consult_Previews: PreviewProvider {
    static var previews: some View {
        Consult()
    }
}
