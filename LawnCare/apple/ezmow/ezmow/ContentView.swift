//
//  ContentView.swift
//  ezmow
//
//  Created by Ryan Moore on 2020-10-04.
//

import SwiftUI

struct ContentView: View {
    @State private var selectedTab = 0

      
    let numTabs = 5;
    let minDragTranslationForSwipe: CGFloat = 50;
    
    var body: some View {
        TabView(selection: $selectedTab) {
            HomeView()
                .tabItem {
                    Image(systemName: "house.fill")
                    Text(NSLocalizedString("home", comment: ""))
                }.tag(0)
                .highPriorityGesture(DragGesture().onEnded(
                    { self.handleSwipe(translation: $0.translation.width) }))
            Consult()
                .tabItem {
                    Image(systemName: "book.fill")
                    Text(NSLocalizedString("consult", comment: ""))
                }.tag(1)
                .highPriorityGesture(DragGesture().onEnded({
                                 self.handleSwipe(translation: $0.translation.width)
                             }))
            FAQ()
                .tabItem {
                    Image(systemName: "star.fill")
                    Text(NSLocalizedString("faq", comment: ""))
                }.tag(2)
                .highPriorityGesture(DragGesture().onEnded({
                                 self.handleSwipe(translation: $0.translation.width)
                             }))
            Contact()
                .tabItem {
                    Image(systemName: "person.fill")
                    Text(NSLocalizedString("contact", comment: ""))
                }.tag(3)
                .highPriorityGesture(DragGesture().onEnded({
                                 self.handleSwipe(translation: $0.translation.width)
                             }))
            Quote()
                .tabItem {
                    Image(systemName: "square.and.pencil")
                    Text(NSLocalizedString("quote", comment: ""))
                }
                .tag(4)
                .highPriorityGesture(DragGesture().onEnded({
                                 self.handleSwipe(translation: $0.translation.width)
                             }))
        }
    }
    
    private func handleSwipe(translation: CGFloat) {
        if translation > minDragTranslationForSwipe && selectedTab > 0 {
            selectedTab -= 1
        } else  if translation < -minDragTranslationForSwipe && selectedTab < numTabs-1 {
            selectedTab += 1
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
