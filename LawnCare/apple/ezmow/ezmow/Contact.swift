//
//  Contact.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct Contact: View {
    @State var name = ""
    @State var phoneNumb = ""
    @State var email = ""
    @State var contactMethod = ""
    
    
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

                Section (header: Text("Email")){
                    TextField("Email", text:
                              $email)
                }
                
                //TODO:needs radio buttons and text fields
                
                
                /*Picker(selection: $contactMethod, Label: Text ("Preferred method of contact")) {
                    Text("Email").tag(contactMethod.email)
                    Text("Phone").tag(contactMethod.phone)
                }.pickerStyle(RadioGroupPickerStyle())
                */
                
                Section {
                    Button(action : {print("Quote button psuhed")}, label: {
                        Text("Submit").bold().foregroundColor(/*@START_MENU_TOKEN@*/.blue/*@END_MENU_TOKEN@*/)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                    })
                }
        
            }
            .navigationTitle("Contact Us!")

        }
    }
}

struct Contact_Previews: PreviewProvider {
    static var previews: some View {
        Contact()
    }
}
