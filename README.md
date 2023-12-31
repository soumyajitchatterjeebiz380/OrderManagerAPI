# OrderManagerAPI

## Table of Contents
1. [Introduction](#introduction)
2. [About](#about)
3. [Features](#features)
4. [Contributions](#contributions)
5. [Credits](#credits)
6. [Blog](#blog)
7. [Technologies](#technologies)

## Introduction
The OrderManagementAPI is a tool designed to manage orders within your application. It achieves this by facilitating interactions with another external API, seamlessly integrating order-related operations into your software ecosystem.

## About
This project is a simulation of some industry-standard technologies that provide optimal application performance and scalability. By implementing asynchronous code, I ensure swift and responsive handling of API requests, enhancing the user experience while efficiently utilizing system resources. I have also integrated service discovery via Eureka, allowing seamless communication between services and dynamic automated registration. Furthermore, I created a simple API gateway that centralizes and manages external service communication, which is integrated with the Eureka service to help provide future security management and seamless API redirection.
## Features
List the key features of your project here. You can use bullet points or a numbered list for clarity.

- **Asynchronous Code**: My project efficiently handles API requests with asynchronous code execution, ensuring swift responses and optimal resource utilization.

- **Service Discovery with Eureka**: I've integrated Netflix Eureka for automated service registration, load balancing, and fault tolerance, enabling seamless service communication.

- **API Gateway**: My system centralizes and manages external service communication through an API gateway, offering routing,  and in the future, load balancing, security enforcement, and analytics for enhanced reliability and performance.


## MySQL CODE(This code should be inserted into your MySQL Database)
```

use testdb;

CREATE TABLE items(
	item_id  VARCHAR(10) PRIMARY KEY ,
    quantity INT,
    review INT,
	num_review int
);

CREATE TABLE orders(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
    userid INT,
    item_id  VARCHAR(10),
	FOREIGN KEY(item_id) REFERENCES items(item_id),
    quantity INT
);


INSERT INTO items(item_id, quantity,review,num_review) VALUES
	("Burger",100,5,1),
    ( "Fries",100,3,1),
    ("peas",100,3,1),
    ("Tacos",100,4,1);
    
    
INSERT INTO orders(order_id,userid, item_id, quantity ) VALUES
	(1,1,"Burger",2),
    (3,2,"Burger",2),
    (2,2,"Tacos",2);
    
SELECT * FROM items;

Select * FROM orders;

```


## Contributions
This project implements some industry standard tools used in our everyday world. I am always eager to learn about new technologies, so if you have any suggestion, please feel free to submit a pull request.

## Credits
Owner: Soumyajit Chatterjee

linkedin: linkedin.com/in/soumyajit-chatterjee-b46758181


## Blog
I have created a blog to explain this project in detail. Please feel free to read this project.

https://medium.com/@soumyajitchatterjee380/microservice-fundamentals-asynchronous-calls-service-discovery-and-api-gateways-491f62b82511


## Technologies
Technologies used in this project are :

- SpringBoot 3.0
- MySQL (Please Make Sure You Have Data In The Table Beforehand)
- Eureka

Thanks for visiting this repository!!!
