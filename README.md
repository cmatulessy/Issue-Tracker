# Issue-Tracker
Author: [Carlo Matulessy](http://www.carlomatulessy.com/)
Date: 14-9-2017
Version: 1.0

[Download the app through the playstore](https://play.google.com/store/apps/details?id=com.carlomatulessy.issuetracker)

## The App
The purpose of this app is to showcase how to load data from an CSV file. As you can see, I also added the following functionality:
* If you start the app you first see a splashscreen, this will disappear if the data is loaded from the CSV file. (AsyncTask)
* The MainActivity screen loads the data from the CSV file into the Listview and plot the data in several CardViews.
* I added an About page with some background info about this app. Click on the menu button in the right upper corner and tap on about to access this page
* On this page there are two buttons, one will navigate outside the app to the github project of this app and the other one to my personal website.
* If you tap on one of the three cards you see a dialog with two buttons (Cancel and New Issue)
* If you click on the new issue button, you will navigate to the screen with Create New issue. In here you can add a new issue.
* We validate if there is any text typed, if not you get a notification (snackbar) with the question if you have any issues. If you click on the snackbar actionbutton yes, it will autofill the EditText.
* If you click on the button Submit button you navigate back to the MainActivity screen, you will see that the counter of issues will raise with +1 (e.g. 5 issues -> 6 issues)

## But wait there is more...
I also  took the liberty to add an example of an unittest, you can find it in the test director. Besides this unittest I also implemented an End-2-End testcase with the help of the frameworks Cucumber-jvm, Espresso and the Spoon library (gradle-plugin version)
* [Cucumber-jvm](https://cucumber.io/) is used to translate a feature file, which is written in Gherkin language, to the desired method to kick off a certain action (e.g. tap on a button)
* [Espresso](https://developer.android.com/training/testing/espresso/index.html) is the UI test automation framework of Google. I used this framework to "steer" the application
* [Spoon](http://square.github.io/spoon/) is an opensource library which create awesome test reports which you can store in your jenkins jobs. It contains also screenshots and it can create a gif of the whole test.
*  It has two nice reporting modes:
     1) [Normal report](http://carlomatulessy.com/issue-tracker/)
     2) [TV Dashboard report](http://carlomatulessy.com/issue-tracker/tv.html)

If you have any questions, please contact me through github :)

Cheers,

Carlo Matulessy