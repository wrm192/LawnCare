//
//  HomeView.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-08.
//

import SwiftUI

struct HomeView: View {
    var body: some View {
        Button(action: {
            print("Home Button Pushed")
        }) {
            Image ("HomeButton");
        }
    }
}


struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
