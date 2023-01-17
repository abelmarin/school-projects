//
//  ProfileViewController.swift
//  abelm_final
//
//  Created by Abel Marin on 2/23/21.
//

import UIKit

class ProfileViewController: UIViewController {

    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var emailLabel: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }
    
    @IBAction func editProfileBtn(_ sender: UIButton) {
        
        let alertController = UIAlertController(title: "Edit Profile", message: "", preferredStyle: .alert)
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Enter New Username"
        }
        alertController.addTextField { (textField : UITextField!) -> Void in
            textField.placeholder = "Enter New Email"
        }
        let saveAction = UIAlertAction(title: "Save", style: .default, handler: { alert -> Void in
            self.nameLabel.text = alertController.textFields![0].text
            self.emailLabel.text = alertController.textFields![1].text
        })
        let cancelAction = UIAlertAction(title: "Cancel", style: .default, handler: { (action : UIAlertAction!) -> Void in })
        

        alertController.addAction(saveAction)
        alertController.addAction(cancelAction)
        
        self.present(alertController, animated: true, completion: nil)
        
        
//        if let title = sender.currentTitle {
//            nameLabel.text = "\(title)"
//        }
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
