# Task

Create a solution for filling out the home enquiry form on Policy Expert's website: https://insurance.policyexpert.co.uk/home
## Test Framework
Tests have been automated using Serenity+Cucumber framework. Preferred Serenity for this task to focus on the test 
automation without worrying about setting the webdriver instances/sessions and generating reports.
### Code Structure
All the test related code is under erc/test folder. The test folder contains 2 main folders. 


#### src/test/resources
1. features - Contains feature files. All the test scenarios have been written using gherkin syntax. 

2. data -  Includes files to store field selector information and field input values.
    Since the enquiry form has too many fields, maintaining them in a page object class will make it tedious to maintain.
    So I used the following logic. All the fields share a similar class name eg.,"question-row-first-name". 
    So I have created a csv file for each section to store the element selector information. 
    
    eg.,```src/test/resources/data/about-me-field-selectors.csv```
    
    Following fields are present in this file
    
    ```fieldName,fieldSelector,fieldType```
    
    with values
    
    ```firstName,first-name,input```
    
    FetchFieldSelector(src/test/java/enquiryForm/utils/FetchFieldSelectors.java) - uses this file and creates an element selector like below
    
    ```[class*="first-name"]  input```
    
    The values that needs to be entered/selected in these fields will be fetched from json files.
    eg.,```data/happy-path-field-values.json```

3. driver - Store all the webdriver executables under this folder. 
 For now, I have stored only the chrome webdriver for Mac.
 
#### src/test/java
1. actions - Logic to perform actions on a page

2. navigation - To include the navigation urls for each page. 
   Can be extended to include the navigation for other tabs in the Enquiry Form 

3. stepDefinitions - Includes step implementations of test scenarios

4. utils - Includes util classes to create field selectors from csv file 
   and to fetch values to be entered
   
#### CucumberTestSuite - Test runner   

#### Command to run all the operations
**To run from IDE**

The `CucumberTestSuite` test runner can be run from the IDE to run all the scenarios present under the feature files

**To run from the terminal**

```mvn clean verify```

#### Improvements that can be done
1. The details page is not friendly enough to perform test automation. So I would definitely talk to the developers and
 make sure they provide an easy way to fill this form. Some options that I can think of are as follows.
    - to break the single page form into multiple page form
    - the components in general don't follow industry's best practices

2. This automation code might not be performant enough. Need to investigate on how to make them faster    

                       