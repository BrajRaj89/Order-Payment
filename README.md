# Order-Payment Microservice (Phase 1)

This is the **first phase** of an Order-Payment backend project. It is designed as a **Spring Boot REST API** to manage users, orders, order items, and payments. The next phases will focus on **microservice architecture, Spring Security, and extended features**.

---

## **Features Implemented (Phase 1)**

1. **User Registration**
   - Endpoint: `POST /auth/register`
   - Registers a user with username, password, and role.
   - Example Request Body:
     ```json
     {
       "username": "brajraj",
       "password": "password123",
       "role": "USER"
     }
     ```
   - Response:
     ```json
     {
       "success": true,
       "message": "User registered successfully"
     }
     ```

2. **Create Order**
   - Endpoint: `POST /orders`
   - Create an order with items and total amount for a user.
   - Example Request Body:
     ```json
     {
       "username": "brajraj",
       "amount": 1500,
       "items": [
         {"name": "Product1", "price": 500, "quantity": 1},
         {"name": "Product2", "price": 1000, "quantity": 1}
       ]
     }
     ```
   - Response:
     ```json
     {
       "id": 1,
       "status": "CREATED",
       "totalAmount": 1500,
       "items": [
         {"id":1,"name":"Product1","price":500,"quantity":1},
         {"id":2,"name":"Product2","price":1000,"quantity":1}
       ],
       "user": {"id":1,"username":"brajraj"}
     }
     ```

3. **Get Order by ID**
   - Endpoint: `GET /orders/{id}`
   - Fetch order details including user and items.

4. **Make Payment**
   - Endpoint: `POST /payments`
   - Make payment for an order.
   - Validates duplicate payments.
   - Example Request Body:
     ```json
     {
       "orderId": 1,
       "amount": 1500
     }
     ```
   - Response:
     ```json
     {
       "id": 1,
       "order": {"id":1},
       "amount": 1500,
       "status": "SUCCESS"
     }
     ```

5. **Validation for Duplicate Payment**
   - Returns error if payment already exists for an order:
     ```json
     {
       "error": "Payment already exists for this order"
     }
     ```

---

## **Technology Stack**

- Java 17, Spring Boot 3.x
- Spring Data JPA, Hibernate
- H2 / MySQL database
- Maven
- RESTful APIs

---

## **Next Phase**

- Refactor into **microservice architecture**
- Implement **Spring Boot Security** for authentication and authorization
- Add advanced features like order history, payment history, and analytics

---

## **Postman Collection**

You can test the APIs using Postman by creating the following requests:

- `POST /auth/register`
- `POST /orders`
- `GET /orders/{id}`
- `POST /payments`

---

## **Author**

Brajraj Devda  
Email: brajrajdevda152@gmail.com
GitHub: [https://github.com/BrajRaj89/OrderPaymentAPI](https://github.com/BrajRaj89/OrderPaymentAPI)
