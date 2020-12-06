//
//  Contact.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//
//
import SwiftUI
import UIKit
import Combine
import ToastUI

struct Contact: View {
    @State var name = ""
    @State var phoneNumb = ""
    @State var email = ""
    @State var textField = "";
    @State private var presentingToast: Bool = false
    var apiRequest = ApiRequest()
    var body: some View {
        
        NavigationView{
            Form {
            
                Section {
                    TextField(NSLocalizedString("contactName", comment: ""), text:
                                $name)

                    TextField(NSLocalizedString("contactPhoneNumber", comment: ""), text: $phoneNumb)
                    
                    TextField(NSLocalizedString("contactAddress", comment: ""), text: $email)
                    RadioButtonGroups {
                    selected in print("Selected Choice: \(selected)")
                    }
                    MultilineTextView(text: $textField)
                 }
                
                
                Section {
                    Button(action : {buttonAction()},
                           label: {
                            Text(NSLocalizedString("contactSubmitButton", comment: ""))
                            .bold().foregroundColor(.blue)
                                .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)
                               
                           }
                    )
                    
                }.toast(isPresented: $presentingToast, dismissAfter: 2.0) {
                    print("Toast dismissed")
                  } content: {
                    ToastView(NSLocalizedString("contactAPIToast", comment: ""))
                      .toastViewStyle(IndefiniteProgressToastViewStyle())
                  }
                .disabled(name.isEmpty || phoneNumb.isEmpty || email.isEmpty || textField.isEmpty)

               
            }.navigationBarTitle(NSLocalizedString("contact", comment: ""))
        }
        
    }
    
    func buttonAction() {
        presentingToast = true;
        
        apiRequest.postContact(contactRequest: ContactRequest(name: name, comment: textField, contactDetails: email), path: "contact")
    }
}



struct MultilineTextView: UIViewRepresentable {
//    @Binding var text: String
//
//    func makeUIView(context: Context) -> UITextView {
//        let view = UITextView()
//        view.isScrollEnabled = true
//        view.isEditable = true
//        view.isUserInteractionEnabled = true
//        text = view.text
//        view.
//        print("in make ui view")
//        return view
//    }
//
//    func updateUIView(_ uiView: UITextView, context: Context) {
//        print("in update ui view")
//        text = uiView.text
//    }
    @Binding var text: String


        func makeUIView(context: Context) -> UITextView {
            let view = UITextView()
            view.isScrollEnabled = true
            view.isEditable = true
            view.isUserInteractionEnabled = true
            view.backgroundColor = UIColor.white
            view.textColor = UIColor.black
            view.font = UIFont.systemFont(ofSize: 17)
            view.delegate = context.coordinator
            return view
        }

        func updateUIView(_ uiView: UITextView, context: Context) {
            uiView.text = text
        }

        func frame(numLines: CGFloat) -> some View {
            let height = UIFont.systemFont(ofSize: 17).lineHeight * numLines
            return self.frame(height: height)
        }

        func makeCoordinator() -> MultilineTextView.Coordinator {
            Coordinator(self)
        }

        class Coordinator: NSObject, UITextViewDelegate {
            var parent: MultilineTextView

            init(_ parent: MultilineTextView) {
                self.parent = parent
            }

            func textViewDidChange(_ textView: UITextView) {
                parent.text = textView.text
            }
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
