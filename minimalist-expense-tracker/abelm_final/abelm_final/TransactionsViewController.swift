//
//  TransactionsViewController.swift
//  abelm_final
//
//  Created by Abel Marin on 3/14/21.
//

import UIKit
import SwiftUI


class TransactionsViewController: UITableViewController {

    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        tableView.reloadData()
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return months.count
    }
    
    let months: [String] = ["March 2021", "February 2021", "January 2021", "December 2020", "November 2020", "October 2020","September 2020"]

    override func tableView(_ tableView: UITableView, titleForHeaderInSection
                                section: Int) -> String? {
        var returnString: String = ""
        if section == 0 {
            returnString = months[0]
        } else if section == 1 {
            returnString = months[1]
        } else if section == 2 {
            returnString = months[2]
        } else if section == 3 {
            returnString = months[3]
        } else if section == 4 {
            returnString = months[4]
        } else if section == 5 {
            returnString = months[5]
        } else if section == 6 {
            returnString = months[6]
        }
        
        return returnString
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        var returnInt: Int = 0
        if section == 0 {
            returnInt = thisMonthTransactions
        } else if section == 1 {
            returnInt = 4
        } else if section == 2 {
            returnInt = 4
        } else if section == 3 {
            returnInt = 4
        } else if section == 4 {
            returnInt = 4
        } else if section == 5 {
            returnInt = 4
        } else if section == 6 {
            returnInt = 4
        }
        return returnInt
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        var transaction = transactions[0]
        if indexPath.section == 0 {
            transaction = transactions[indexPath.row]
        } else if indexPath.section == 1  {
            transaction = transactions[thisMonthTransactions+indexPath.row]
        }
         else if indexPath.section == 2  {
            transaction = transactions[thisMonthTransactions+indexPath.row+4]
        } else if indexPath.section == 3  {
            transaction = transactions[thisMonthTransactions+indexPath.row+8]
        } else if indexPath.section == 4  {
            transaction = transactions[thisMonthTransactions+indexPath.row+12]
        } else if indexPath.section == 5  {
            transaction = transactions[thisMonthTransactions+indexPath.row+16]
        } else if indexPath.section == 6  {
            transaction = transactions[thisMonthTransactions+indexPath.row+20]
        }
        let cell = tableView.dequeueReusableCell(withIdentifier: transaction.type.rawValue, for: indexPath)
                
        cell.textLabel?.text = transaction.name
        cell.detailTextLabel?.text = "$\(transaction.amount)"
        
        return cell
    }

    /*
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)

        // Configure the cell...

        return cell
    }
    */

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
//    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
//        // Get the new view controller using [segue destinationViewController].
//        // Pass the selected object to the new view controller.
//        if let detailViewController = segue.destination as? ViewController {
//            if let cell = sender as? UITableViewCell {
//                if let indexPath = self.tableView.indexPath(for: cell) {
//                    detailViewController.winner = winners[indexPath.row]
//                }
//            }
//        }
//
//    }
    
}
