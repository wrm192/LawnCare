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
                    Image(systemName: "house.fill")
                    Text("HOME")
                }
            Text ("Tab 2")
                .tabItem {
                    Image(systemName: "book.fill")
                    Text("CONSULT")
                }
            Text ("Tab 3")
                .tabItem {
                    Image(systemName: "star.fill")
                    Text("FAQ")
                }
            Text ("Tab 4")
                .tabItem {
                    Image(systemName: "person.fill")
                    Text("CONTACT")
                }
            Text ("Tab 5")
                .tabItem {
                    Image(systemName: "square.and.pencil")
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
