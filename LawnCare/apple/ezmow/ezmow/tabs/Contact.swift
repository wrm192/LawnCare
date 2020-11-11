//
//  Contact.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//
//
import SwiftUI
import UIKit

struct Contact: View {
    @State var name = ""
    @State var phoneNumb = ""
    @State var email = ""

    var body: some View {
        
        NavigationView{
            Form {
                
                Section (header:
                            Text(NSLocalizedString("contactName", comment: ""))){
                    TextField(NSLocalizedString("contactName", comment: ""), text:
                                $name)
                }
                
                Section (
                    header: Text(NSLocalizedString("contactPhoneNumber", comment: ""))) {
                    TextField(NSLocalizedString("contactPhoneNumber", comment: ""),
                    text: $phoneNumb)
                    .keyboardType(.decimalPad)
                }
                
                Section (
                    header: Text(NSLocalizedString("contactAddress", comment: ""))) {
                    TextField(NSLocalizedString("contactAddress", comment: ""),
                    text: $email)
                }
                 
                Section(
                    header: Text(NSLocalizedString("contactMethod", comment: ""))) {
                    RadioButtonGroups {
                    selected in print("Selected Choice: \(selected)")
                    }
                 }
                
                Section {
                    Button(action : {buttonAction()},
                           label: {
                            Text(NSLocalizedString("contactSubmitButton", comment: ""))
                            .bold().foregroundColor(.blue)
                            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                    })
                }
            }
            .navigationBarTitle(NSLocalizedString("contact", comment: ""))
        }
        
    }
    
    func buttonAction() {
        print("Submitted")
    }
}

struct RadioButtonField : View {
    
    let id: String
    let label: String
    let size: CGFloat
    let color: Color
    let textSize: CGFloat
    let isMarked: Bool
    let callback: (String) -> ()
    
    init (
          id: String,
          label:String,
          size: CGFloat = 20,
          color: Color = Color.black,
          textSize: CGFloat = 14,
          isMarked: Bool = false,
          callback: @escaping (String) -> ()
    ) {
        self.id = id
        self.label = label
        self.size = size
        self.color = color
        self.textSize = textSize
        self.isMarked = isMarked
        self.callback = callback
    }
    
    var body: some View {
        Button(action: {
            self.callback(self.id)
        }) {
            HStack (alignment: .center, spacing: 10) {
                Image(systemName: self.isMarked ? "largecircle.fill.circle" : "circle")
                    .renderingMode(.original)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: self.size, height: self.size)
                
                Text(label)
                    .font(Font.system(size: textSize))
                
                Spacer()
            }
            .foregroundColor(self.color)
        }.foregroundColor(Color.white)
    }
}

enum Choice: String {
    case phoneNumb = "Phone Number"
    case email = "Email Address"
}

struct RadioButtonGroups: View {
    
    let callback: (String) -> ()
    
    @State var selectedId: String = ""
    
    var body: some View {
            radioNumberButton
            radioEmailButton
    }
    var radioNumberButton: some View {
        RadioButtonField (
            id: Choice.phoneNumb.rawValue,
            label: Choice.phoneNumb.rawValue,
            isMarked: selectedId == Choice.phoneNumb.rawValue ? true : false,
            callback: radioGroupCallback)
        }
    var radioEmailButton: some View {
        RadioButtonField (
            id: Choice.email.rawValue,
            label: Choice.email.rawValue,
            isMarked: selectedId == Choice.email.rawValue ? true : false,
            callback: radioGroupCallback)
        }
    func radioGroupCallback(id: String){
        selectedId = id
        callback(id)
    }
}

struct Contact_Previews: PreviewProvider {
    static var previews: some View {
        Contact()
    }
}
