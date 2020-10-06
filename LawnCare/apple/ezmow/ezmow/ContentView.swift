//
//  ContentView.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-10-04.
//

import SwiftUI

struct ContentView: View {
    @State private var selectedTab = 0
    
    var body: some View {
        TabView(selection: $selectedTab) {
            Text ("Tab 1")
                .onTapGesture {
                    self.selectedTab = 1
                }
                .tabItem {
                    Image(systemName: "star")
                    Text("HOME")
                }
            Text ("Tab 2")
                .tabItem {
                    Image(systemName: "star.fill")
                    Text("BOOK")
                }
            Text ("Tab 3")
                .tabItem {
                    Image(systemName: "star")
                    Text("FAQ")
                }
            Text ("Tab 4")
                .tabItem {
                    Image(systemName: "star.fill")
                    Text("CONTACT")
                }
            Text ("Tab 5")
                .tabItem {
                    Image(systemName: "star")
                    Text("QUOTE")
                }
                .tag(1)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
