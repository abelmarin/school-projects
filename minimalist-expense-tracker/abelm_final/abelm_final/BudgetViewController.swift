//
//  BudgetViewController.swift
//  abelm_final
//
//  Created by Abel Marin on 2/23/21.
//

import UIKit

var totalGlobal: Int = 2000

var rentUtilGlobal: Int = 1200
var transportGlobal: Int = 100
var foodGlobal: Int = 100
var creditGlobal: Int = 100
var leisureGlobal: Int = 100
var otherGlobal: Int = 400

class BudgetViewController: UIViewController {

    @IBOutlet weak var totalLabel: UILabel!
    @IBOutlet weak var rentUtilLabel: UILabel!
    @IBOutlet weak var transportLabel: UILabel!
    @IBOutlet weak var foodLabel: UILabel!
    @IBOutlet weak var creditLabel: UILabel!
    @IBOutlet weak var leisureLabel: UILabel!
    @IBOutlet weak var otherLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.

        rentUtilLabel.text = "$\(thisMonthRent)/$\(rentUtilGlobal)"
        transportLabel.text = "$\(thisMonthTransport)/$\(transportGlobal)"
        foodLabel.text = "$\(thisMonthFood)/$\(foodGlobal)"
        creditLabel.text = "$\(thisMonthCredit)/$\(creditGlobal)"
        leisureLabel.text = "$\(thisMonthLeisure)/$\(leisureGlobal)"
        otherLabel.text = "$\(thisMonthOther)/$\(otherGlobal)"

        totalLabel.text = "$\(thisMonthSpent)/$\(totalGlobal)"
    }
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        rentUtilLabel.text = "$\(thisMonthRent)/$\(rentUtilGlobal)"
        transportLabel.text = "$\(thisMonthTransport)/$\(transportGlobal)"
        foodLabel.text = "$\(thisMonthFood)/$\(foodGlobal)"
        creditLabel.text = "$\(thisMonthCredit)/$\(creditGlobal)"
        leisureLabel.text = "$\(thisMonthLeisure)/$\(leisureGlobal)"
        otherLabel.text = "$\(thisMonthOther)/$\(otherGlobal)"

        totalLabel.text = "$\(thisMonthSpent)/$\(totalGlobal)"
    }

    @IBAction func editBudgetBtn(_ sender: UIButton) {
        let alertController = UIAlertController(title: "Edit Budget", message: "", preferredStyle: .alert)
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "New Rent/Utilities Budget"
        }
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "New Transportation Budget"
        }
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "New Food Budget"
        }
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "New Credit Card Budget"
        }
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "New Leisure Budget"
        }
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "New Other Budget"
        }
        let saveAction = UIAlertAction(title: "Save", style: .default, handler: { alert -> Void in
            if let rentString: String = alertController.textFields![0].text {
                if let rentInt: Int = Int(rentString) {
                    self.rentUtilLabel.text = "$\(thisMonthRent)/$\(rentInt)"
                    rentUtilGlobal = rentInt
                }
            }
            if let transportString: String = alertController.textFields![1].text {
                if let transportInt: Int = Int(transportString) {
                    self.transportLabel.text = "$\(thisMonthTransport)/$\(transportInt)"
                    transportGlobal = transportInt
                }
            }
            if let foodString: String = alertController.textFields![2].text {
                if let foodInt: Int = Int(foodString) {
                    self.foodLabel.text = "$\(thisMonthFood)/$\(foodInt)"
                    foodGlobal = foodInt
                }
            }
            if let creditString: String = alertController.textFields![3].text {
                if let creditInt: Int = Int(creditString) {
                    self.creditLabel.text = "$\(thisMonthCredit)/$\(creditInt)"
                    creditGlobal = creditInt
                }
            }
            if let leisureString: String = alertController.textFields![4].text {
                if let leisureInt: Int = Int(leisureString) {
                    self.leisureLabel.text = "$\(thisMonthLeisure)/$\(leisureInt)"
                    leisureGlobal = leisureInt
                }
            }
            if let otherString: String = alertController.textFields![5].text {
                if let otherInt: Int = Int(otherString) {
                    self.otherLabel.text = "$\(thisMonthOther)/$\(otherInt)"
                    otherGlobal = otherInt
                }
            }
            totalGlobal = rentUtilGlobal + transportGlobal + foodGlobal + creditGlobal + leisureGlobal + otherGlobal
            self.totalLabel.text = "$\(thisMonthSpent)/$\(totalGlobal)"
        })
        let cancelAction = UIAlertAction(title: "Cancel", style: .default, handler: { (action : UIAlertAction!) -> Void in })
        

        alertController.addAction(saveAction)
        alertController.addAction(cancelAction)
        
        self.present(alertController, animated: true, completion: nil)
    }
    
}

