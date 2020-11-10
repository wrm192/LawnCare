//
//  FAQ.swift
//  ezmow
//
//  Created by Nicolas Smeall on 2020-10-08.
//

import SwiftUI

struct FAQ: View {
    var body: some View {
        NavigationView {
            List {
                
                Section (header: Text(NSLocalizedString("question1", comment: "")).bold().font(.system(size:22)))
                    {}
                Section (header: Text(NSLocalizedString("answer1", comment: "")).bold().font(.system(size:16)).foregroundColor(.red)){
                }
                
                Section (header: Text(NSLocalizedString("question2", comment: "")).bold().font(.system(size:22))){
                }
                Section (header: Text(NSLocalizedString("answer2", comment: "")).bold().font(.system(size:16)).foregroundColor(.red)){
                }
                Section (header: Text(NSLocalizedString("question3", comment: "")).bold().font(.system(size:22))){
                }
                Section (header: Text(NSLocalizedString("answer3", comment: "")).bold().font(.system(size:16)).foregroundColor(.red)){
                }
                Section (header: Text(NSLocalizedString("question4", comment: "")).bold().font(.system(size:22))){
                }
                Section (header: Text(NSLocalizedString("answer4", comment: "")).bold().font(.system(size:16)).foregroundColor(.red)){
                }
                Image("Logo")
                    .resizable()
                    .scaledToFit().offset(x: /*@START_MENU_TOKEN@*/10.0/*@END_MENU_TOKEN@*/, y:50)
            } .navigationBarTitle(NSLocalizedString("faq", comment: ""))
            
        }
        
        
    }
    
    func buttonAction() {
        print("FAQ button psuhed")
    }
    
}


struct FAQ_Previews: PreviewProvider {
    static var previews: some View {
        FAQ()
    }
}
