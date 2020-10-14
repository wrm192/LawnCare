//
//  HomeView.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct HomeView: View {

    var body: some View {
        
        NavigationView{
            Form {
                Section (header: Text("\nEZMow is lawn care made easy, booka service with us and have a lawn mowing robot come to your door steps to take care of the rest! Use the contact us form for any inquiries. \n\n **Employee supervisor will be on site")) {}
                
                Image("Logo")
                    .resizable()
                    .scaledToFit()
        
            }
            .navigationTitle("About Us!")

        }

    }
}


struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
