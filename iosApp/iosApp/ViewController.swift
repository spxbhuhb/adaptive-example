//
//  ViewController.swift
//  iosApp
//
//  Created by Istvan Zoltan Toth on 22/05/2024.
//

import UIKit
import Shared

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        Shared.MainKt.main(rootView: view, trace: true)
    }

}

