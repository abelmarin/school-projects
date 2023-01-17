//
//  HomeViewController.swift
//  abelm_final
//
//  Created by Abel Marin on 2/23/21.
//

import UIKit

class HomeViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {

    @IBOutlet weak var lineGraph: CanvasView!
    @IBOutlet weak var transactionsLabel: UILabel!
    var pickerView = UIPickerView()
    var typeValue: Transaction.`Type` = .rent
    
    override func viewDidLoad() {
        super.viewDidLoad()
        transactionsLabel.text = "McDonald's  $10\nRent  $1200\nMovie  $15\nBurger King  $10\nBurger King  $10\n"
        // Do any additional setup after loading the view.
    }
    
    let typeList: [String] = ["rent", "transport", "food", "credit", "leisure", "other"]

    @IBAction func addTransactionBtn(_ sender: UIButton) {
   
        let alert = UIAlertController(title: "Add New Transaction", message: "\n\n\n\n\n\n", preferredStyle: .alert)
        
        let pickerFrame = UIPickerView(frame: CGRect(x: 5, y: 20, width: 250, height: 140))
        
        alert.view.addSubview(pickerFrame)
        alert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Transaction Name"
        }
        alert.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Transaction Amount (Must be int)"
        }
        
        pickerFrame.dataSource = self
        pickerFrame.delegate = self
        
        alert.addAction(UIAlertAction(title: "Cancel", style: .cancel, handler: nil))
        alert.addAction(UIAlertAction(title: "OK", style: .default, handler: { (UIAlertAction) in
    
            if let nameString: String = alert.textFields![0].text {
                if let amountString: String = alert.textFields![1].text {
                    if let amountInt: Int = Int(amountString) {
                        if let oldString: String = self.transactionsLabel.text {
                            let newString: String = "\(nameString)  $\(amountInt)\n\(oldString)"
                            self.transactionsLabel.text = newString
                            let newTransaction: [Transaction] = [Transaction(name: "\(nameString)", type: self.typeValue, amount: amountInt, month: .mar)]
                            let oldTransactions: [Transaction] = transactions
                            
                            // Update global values
                            transactions = newTransaction + oldTransactions
                            thisMonthTransactions += 1
                            thisMonthSpent += amountInt
                            if self.typeValue == .rent {
                                thisMonthRent += amountInt
                            } else if self.typeValue == .transport {
                                thisMonthTransport += amountInt
                            } else if self.typeValue == .food {
                                thisMonthFood += amountInt
                            } else if self.typeValue == .credit {
                                thisMonthCredit += amountInt
                            } else if self.typeValue == .leisure {
                                thisMonthLeisure += amountInt
                            } else if self.typeValue == .other {
                                thisMonthOther += amountInt
                            }
                            
                            // Reset typeValue
                            self.typeValue = .rent
                            
                            marchSpentGraph = 128-Int(128*thisMonthSpent/2500)
                            self.lineGraph.setNeedsDisplay()
                            
                        }
                    }
                }
            }
            
            
        }))
        self.present(alert,animated: true, completion: nil )
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return typeList.count
    }
    
    // MARK: UIPickerViewDelegate
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return typeList[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if row == 0 {
            typeValue = .rent
        } else if row == 1 {
            typeValue = .transport
        } else if row == 2 {
            typeValue = .food
        } else if row == 3 {
            typeValue = .credit
        } else if row == 4 {
            typeValue = .leisure
        } else if row == 5 {
            typeValue = .other
        }
        
    }
    
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
}




