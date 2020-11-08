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
                Section (header: Text(NSLocalizedString("homeMessage", comment: ""))) {}
                
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
