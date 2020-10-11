//
//  HomeView.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct HomeView: View {

    var body: some View {
        
        //if keybaord doesnt come up in sim. shift, cmd, k
        NavigationView{
            Form {
                Section (header: Text("\nEZMow is lawn care made easy, booka service with us and have a lawn mowing robot come to your door steps to take care of the rest! Use the contact us form for any inquiries. \n\n **Employee supervisor will be on site")) {}
                
                Image("Logo")
                    .resizable()
                    .scaledToFit()
                
                
                /*Text ("EZMow is lawn care made easy, booka service with us and have a lawn mowing robot come to your door steps to take care of the rest! Use the contact us form for any inquiries. \n\n **Employee supervisor will be on site")
                    .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .center)*/

        
            }
            .navigationTitle("About Us!")

        }

       /* Button(action: {
            print("Home Button Pushed")
        }) {
            Image ("HomeButton");
        }*/
    }
}


struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
