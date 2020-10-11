//
//  FAQ.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct FAQ: View {
    var body: some View {
        NavigationView{
            
            //TODO: make it lead to a page with answers on button push
            Form {
                Button (action: {}){
                    HStack(spacing: 15) {
                        Text("Question 1")
                        Spacer()
                    }.padding()
                    .background(Color.white)
                    .foregroundColor(.black)
                }.cornerRadius(15)
                
                Button (action: {}){
                    HStack(spacing: 15) {
                        Text("Question 2")
                        Spacer()
                    }.padding()
                    .background(Color.white)
                    .foregroundColor(.black)
                }.cornerRadius(15)
                
                Button (action: {}){
                    HStack(spacing: 15) {
                        Text("Question 3")
                        Spacer()
                    }.padding()
                    .background(Color.white)
                    .foregroundColor(.black)
                }.cornerRadius(15)
        
            }
            .navigationTitle("About Us!")
        }
    }
}

struct FAQ_Previews: PreviewProvider {
    static var previews: some View {
        FAQ()
    }
}
