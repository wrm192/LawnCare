//
//  AppView.swift
//  ezmow
//
//  Created by Jarrod Jung on 2020-10-04.
//

import SwiftUI

struct AppView: View {
    var body: some View {
        TabView {
            ContentView().tabItem {Image(systemName: "list.dash")
                Text("Menu")
            }
            
            OrderView().tabItem {
                Image(systemName: "square.and.pencil")
                Text("Order")
            }
        }
       // Text("Hello, world!")
       //     .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static let order = Order()
    static var previews: some View {
        AppView().environmentObject(order)
    }
}
