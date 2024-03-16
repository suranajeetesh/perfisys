package com.pqc.perfisys.viewmodel

import androidx.lifecycle.ViewModel
import com.example.newbasicstructure.util.extensionFunction.mutableLiveData
import com.pqc.perfisys.data.local.HistoryModel
import com.pqc.perfisys.data.local.PersonData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplitifyViewModel @Inject constructor() : ViewModel() {

    val historyList = mutableLiveData(
        arrayListOf(
            HistoryModel("Apples", "25", "Sarah", "12-06-2020", "09:45"),
            HistoryModel("Bananas", "15", "John", "05-11-2021", "15:10"),
            HistoryModel("Oranges", "40", "Emily", "17-09-2018", "11:30"),
            HistoryModel("Grapes", "35", "Chris", "28-02-2022", "14:55"),
            HistoryModel("Milk", "2", "Jessica", "08-04-2019", "08:20"),
            HistoryModel("Bread", "1", "David", "19-07-2023", "17:35"),
            HistoryModel("Cheese", "3", "Sophia", "25-10-2020", "10:15"),
            HistoryModel("Yogurt", "4", "Daniel", "02-12-2021", "13:40"),
            HistoryModel("Tomatoes", "8", "Emma", "14-05-2017", "16:25"),
            HistoryModel("Potatoes", "10", "Michael", "03-08-2024", "19:50"),
            HistoryModel("Carrots", "6", "Olivia", "21-11-2016", "07:15"),
            HistoryModel("Onions", "7", "William", "30-01-2022", "12:05"),
            HistoryModel("Spinach", "12", "Ava", "10-03-2018", "18:30"),
            HistoryModel("Broccoli", "9", "James", "01-09-2015", "21:55"),
            HistoryModel("Chicken", "3", "Isabella", "27-06-2023", "22:40"),
            HistoryModel("Beef", "5", "Matthew", "04-10-2020", "05:00"),
            HistoryModel("Pork", "7", "Ella", "16-12-2019", "16:45"),
            HistoryModel("Salmon", "2", "Andrew", "23-08-2016", "14:20"),
            HistoryModel("Shrimp", "8", "Grace", "07-02-2022", "09:35"),
            HistoryModel("Rice", "10", "Benjamin", "18-05-2014", "11:10"),
            HistoryModel("Pasta", "6", "Chloe", "29-09-2023", "20:45"),
            HistoryModel("Biscuits", "4", "Lucas", "09-11-2021", "12:30"),
            HistoryModel("Cereal", "3", "Lily", "12-04-2018", "08:55"),
            HistoryModel("Coffee", "2", "Alexander", "25-07-2017", "15:40"),
            HistoryModel("Tea", "3", "Charlotte", "30-10-2023", "07:25"),
            HistoryModel("Juice", "5", "Gabriel", "05-01-2022", "10:00"),
            HistoryModel("Soda", "4", "Madison", "14-03-2019", "13:35"),
            HistoryModel("Water", "1", "Henry", "20-06-2016", "16:20"),
            HistoryModel("Beer", "6", "Zoe", "28-09-2020", "19:05"),
            HistoryModel("Wine", "7", "Jackson", "01-12-2018", "22:30"),
        )
    )

    val personList = mutableLiveData(
        arrayListOf(
            PersonData("Alice", 803),
            PersonData("John", 695),
            PersonData("Mike", 610),
            PersonData("Emily", 750),
            PersonData("David", 820),
            PersonData("Sarah", 600),
            PersonData("Chris", 720),
            PersonData("Jessica", 680),
            PersonData("Matt", 740),
            PersonData("Emma", 690),
            PersonData("Daniel", 710),
            PersonData("Olivia", 780),
            PersonData("Michael", 680),
            PersonData("Sophia", 720),
            PersonData("James", 730),
            PersonData("Lily", 710),
            PersonData("Benjamin", 800),
            PersonData("Ava", 690),
            PersonData("William", 770),
            PersonData("Mia", 640),
            PersonData("Alexander", 790),
            PersonData("Charlotte", 720),
            PersonData("Ethan", 740),
            PersonData("Amelia", 710),
            PersonData("Ryan", 750),
            PersonData("Harper", 670),
            PersonData("Matthew", 780),
            PersonData("Evelyn", 710),
            PersonData("Lucas", 760)
        )
    )
}
