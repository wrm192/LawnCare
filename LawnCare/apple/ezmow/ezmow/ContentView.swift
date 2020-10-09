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
            HomeView()
                .tabItem {
                    Image(systemName: "house.fill")
                    Text("HOME")
                }.tag(1)
            Consult()
                .tabItem {
                    Image(systemName: "book.fill")
                    Text("CONSULT")
                }.tag(2)
            FAQ()
                .tabItem {
                    Image(systemName: "star.fill")
                    Text("FAQ")
                }.tag(3)
            Contact()
                .tabItem {
                    Image(systemName: "person.fill")
                    Text("CONTACT")
                }.tag(4)
            Quote()
                .tabItem {
                    Image(systemName: "square.and.pencil")
                    Text("QUOTE")
                }
                .tag(5)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
