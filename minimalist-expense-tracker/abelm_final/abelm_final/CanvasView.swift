//
//  CanvasView.swift
//  abelm_final
//
//  Created by Abel Marin on 3/15/21.
//

import UIKit

var marchSpentGraph: Int = 128-Int(128*thisMonthSpent/2500)

class CanvasView: UIView {
    override func draw(_ rect: CGRect) {
        if let context = UIGraphicsGetCurrentContext() {
            
            context.setLineWidth(1)
            UIColor.blue.set()
            
            let top =  "$2500"
            top.draw(at: CGPoint(x: 10, y: 10), withAttributes: nil)
            
            let middle =  "$1250"
            middle.draw(at: CGPoint(x: 10, y: 64), withAttributes: nil)
            
            let bottom =  "$0"
            bottom.draw(at: CGPoint(x: 10, y: 108), withAttributes: nil)

            // October to November
             context.move(to: CGPoint(x: 60, y: 76))
             context.addLine(to: CGPoint(x: 124, y: 75))
             context.strokePath()
            
            // November to December
             context.move(to: CGPoint(x: 124, y: 75))
             context.addLine(to: CGPoint(x: 188, y: 75))
             context.strokePath()
            
            // December to January
             context.move(to: CGPoint(x: 188, y: 75))
             context.addLine(to: CGPoint(x: 252, y: 65))
             context.strokePath()
             
            // January to February
             context.move(to: CGPoint(x: 252, y: 65))
             context.addLine(to: CGPoint(x: 316, y: 65))
             context.strokePath()
            
            // February to March (current month)
             context.move(to: CGPoint(x: 316, y: 65))
             context.addLine(to: CGPoint(x: 380, y: marchSpentGraph))
             context.strokePath()
             
            

         }
    }

}
