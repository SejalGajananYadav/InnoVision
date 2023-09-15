![image](https://github.com/SejalGajananYadav/InnoVision/assets/108066950/3548971e-bd44-4355-aaaf-ce29c0762b26)

# **Team InnoVision**
-----------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------
## Application
### *Order Processing System*
------------------------------------------------------------------------------------------------------------
## Contributing Members 
#### *Sejal, Abhinav, Ajay, Aakash, Shruti, Shweta, Tanvi and Diksha*
-------------------------------------------------------------------------------------------------------------
## Table of Contents
- Application Description
- Installing and Running Requirements
- UML Diagrams
- Sample UI Snapshots
- Instructions to Execute Frontend
- Instructions to Execute Backend

--------------------------------------------------------------------------------------------------------------
### Application Description

We have taken our product as 'Wedding Clothes' as not only that provides a variety and fits well with the statement, it also provides us a chance to make a good front-end.
Distributor runs a wedding clothes shop and is the customer/client of the company. Orders processing happens between a distributor and a company.

Step1 - Create Quote page for employee - A quote is a list of prices that are proposed by company to distributor. So employee will create a quote for distributor to approve.

Step 2 - Order Management page for distributor - He can approve this quote created by the employee here.

Step 3 - Import Products - Based on what Quotes have been approved by the distributor, the employee will import products that were there in the list. This is in json/xml format.
Order Management page for employee is also there but it will just have his/her last login time and links to Create Quote and Import products page.

--------------------------------------------------------------------------------------------------------------
### Installing and Running Requirements

##### Installation 
No installations as such are required to run the front end code except for a browser, spring suite 4 or any other java ide can be used to run the backend code.

#### Running
Remember to run a live server on port of your choice through the browser for locally running the application frontend. Backend can be run inside the IDE itself.

--------------------------------------------------------------------------------------------------------------
### UML Diagrams

![image](https://github.com/SejalGajananYadav/InnoVision/assets/108066950/260c5882-9d4c-47d4-9f99-2333d95fe284)

![image](https://github.com/SejalGajananYadav/InnoVision/assets/108066950/a004279a-9c7c-498e-9429-09c64b227263)

![image](https://github.com/SejalGajananYadav/InnoVision/assets/108066950/af1b7603-c351-4a7e-999f-bd0545d49af7)

--------------------------------------------------------------------------------------------------------------
### Sample UI Snapshots

![image](https://github.com/SejalGajananYadav/InnoVision/assets/108066950/08f32c5e-4965-4e4f-8f48-8671585f4e44)

![image](https://github.com/SejalGajananYadav/InnoVision/assets/108066950/182d0622-acf6-4f83-9f6e-e231ad1d29d8)


--------------------------------------------------------------------------------------------------------------
### Instructions to Execute Frontend
Instructions to execute frontend working:
1) Go to the Home page, apart from the login various links like Contact Us and Our collection are also present.
2) From here on scroll down, here you can select login as customer or employee
3) then pass the userId and password if you are customer
4) Alternatively if you are an employee pass the Id and password for the same.
5) Employee functions : employee can create the quotes with order status pending and he can also import products
6) The list of the pending orders will be displayed to employee and then employee will select the orders to create quote
7) Customer after login also sees his side of Order Management Screen.
8) Customer is able to review the pending orders and can place the new order
9) While reviewing the pending orders customer can approve that orders and generate the invoice that changes will reflect to database
10) While placing the new order the customer is able to select various products of any quantity and according to that the shipping cost total order value is calculated
11) After selecting the product customer is asked to approve the order if yes then order status will be approved or else it will be pending.

--------------------------------------------------------------------------------------------------------------
### Instructions to Execute Backend
Instructions for the backend are also very similar to the frontend, but with slight differences of functionality and the difference of GUI.

Instructions to execute backend working:
1) Select login option employee login or customer login
2) Then pass the userId and password if you are employee
3) Employee functions : employee can create the quotes with order status pending
4) The list of the pending orders will be displayed to employee and then employee will select the orders to create quote
5) Then that quote will be saved to database
6) Customer functions: he can login by Id or username and password
7) Customer is able to review the pending orders and can place the new order
8) While reviewing the pending orders customer can approve that orders and generate the invoice that changes will reflect to database
9) While placing the new order the customer is able to select various products of any quantity and according to that the shipping cost total order value is calculated
10) After selecting the product customer is asked to approve the order if yes then order status will be approved or else it will be pending.


--------------------------------------------------------------------------------------------------------------
<h1 align="center">THANK YOU</h1>
