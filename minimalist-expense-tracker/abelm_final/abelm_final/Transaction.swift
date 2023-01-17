//
//  Transaction.swift
//  abelm_final
//
//  Created by Abel Marin on 3/14/21.
//

import Foundation

var thisMonthSpent: Int = 1255
var thisMonthTransactions: Int = 6

var thisMonthRent: Int = 1200
var thisMonthTransport: Int = 0
var thisMonthFood: Int = 40
var thisMonthCredit: Int = 0
var thisMonthLeisure: Int = 15
var thisMonthOther: Int = 0

var transactions = [
    // march 2021
    Transaction(name: "McDonalds",
                type: .food,
                amount: 10,
                month: .mar),
    
    Transaction(name: "Rent",
                type: .rent,
                amount: 1200,
                month: .mar),

    Transaction(name: "Movie",
                type: .leisure,
                amount: 15,
                month: .mar),

    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .mar),
    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .mar),
    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .mar),

    // february 2021
    Transaction(name: "Arbys",
                type: .food,
                amount: 10,
                month: .feb),

    Transaction(name: "Rent",
                type: .rent,
                amount: 1200,
                month: .feb),

    Transaction(name: "Drinks",
                type: .leisure,
                amount: 16,
                month: .feb),

    Transaction(name: "Groceries",
                type: .food,
                amount: 10,
                month: .feb),

    // january 2021
    Transaction(name: "Portillos",
                type: .food,
                amount: 14,
                month: .jan),

    Transaction(name: "Rent",
                type: .rent,
                amount: 1200,
                month: .jan),

    Transaction(name: "Movie",
                type: .leisure,
                amount: 10,
                month: .jan),

    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .jan),

    // december 2020
    Transaction(name: "Chick fil a",
                type: .food,
                amount: 17,
                month: .dec),

    Transaction(name: "Rent",
                type: .rent,
                amount: 1000,
                month: .dec),

    Transaction(name: "Movie",
                type: .leisure,
                amount: 14,
                month: .dec),

    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .dec),

    // november 2020
    Transaction(name: "Culvers",
                type: .food,
                amount: 14,
                month: .nov),

    Transaction(name: "Rent",
                type: .rent,
                amount: 1000,
                month: .nov),

    Transaction(name: "Movie",
                type: .leisure,
                amount: 13,
                month: .nov),

    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .nov),

    // october 2020
    Transaction(name: "Subway",
                type: .food,
                amount: 5,
                month: .oct),

    Transaction(name: "Rent",
                type: .rent,
                amount: 1000,
                month: .oct),

    Transaction(name: "Movie",
                type: .leisure,
                amount: 12,
                month: .oct),

    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .oct),

    // september 2020
    Transaction(name: "Wendys",
                type: .food,
                amount: 12,
                month: .sep),

    Transaction(name: "Rent",
                type: .rent,
                amount: 1000,
                month: .sep),

    Transaction(name: "Movie",
                type: .leisure,
                amount: 11,
                month: .sep),

    Transaction(name: "Burger King",
                type: .food,
                amount: 10,
                month: .sep),
]

class Transaction {
    enum `Type`: String {
        case rent = "rent"
        case transport = "transport"
        case food = "food"
        case credit = "credit"
        case leisure = "leisure"
        case other = "other"
    }
    
    enum `Month`: String {
        case mar = "mar"
        case feb = "feb"
        case jan = "jan"
        case dec = "dec"
        case nov = "nov"
        case oct = "oct"
        case sep = "sep"
    }
    
    var name: String
    var type: Type
    var amount: Int
    var month: Month
    
    init(name: String, type: Type, amount: Int, month: Month) {
        self.name = name
        self.type = type
        self.amount = amount
        self.month = month
    }
}
