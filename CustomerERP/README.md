# Customer ERP Project

This project is a Customer ERP (Enterprise Resource Planning) system that allows managing customers, orders, products, and taxes. It is developed using Java and Spring Boot, with a PostgreSQL database for data storage.

## Overview

The project consists of several service classes, each responsible for managing different entities. Here's an overview of each service class:

### CustomerService

The `CustomerService` class is responsible for managing customers. It provides methods for creating, updating, deleting, and retrieving customer information from the database.

- `createCustomer(String name, String email)`: Creates a new customer with the provided name and email.
- `getAll()`: Retrieves a list of all customers from the database.
- `getAllByNameIContains(String name)`: Retrieves a list of customers whose names contain the specified search string (case-insensitive).
- `updateCustomer(UUID uuid, CustomerEntity customerEntity)`: Updates the information of an existing customer identified by the provided UUID.
- `deleteCustomer(UUID uuid)`: Deletes the customer with the specified UUID.

### KdvService

The `KdvService` class is responsible for managing taxes (KDV - Katma Değer Vergisi). It provides methods for creating, deleting, and retrieving tax information from the database.

- `createKdv(String type, BigDecimal percent)`: Creates a new tax (KDV) with the provided type and percentage.
- `getAll()`: Retrieves a list of all taxes (KDV) from the database.
- `getAllByTypeIContains(String type)`: Retrieves a list of taxes (KDV) whose types contain the specified search string (case-insensitive).
- `deleteKdv(UUID uuid)`: Deletes the tax (KDV) with the specified UUID.
- `updateKdv(UUID uuid, KdvEntity kdv)`: Updates the information of an existing tax (KDV) identified by the provided UUID.

### ProductService

The `ProductService` class is responsible for managing products. It provides methods for creating, updating, deleting, and retrieving product information from the database. It also includes a method to calculate the true price of a product after applying or removing KDV.

- `createProduct(String name, Boolean isKdvApplied, BigDecimal price, Integer stock, KdvEntity kdv)`: Creates a new product with the provided information, including KDV information.
- `getAll()`: Retrieves a list of all products from the database.
- `deleteProduct(UUID uuid)`: Deletes the product with the specified UUID.
- `getByUuid(UUID uuid)`: Retrieves a product by its UUID.
- `getAllByNameIContains(String name)`: Retrieves a list of products whose names contain the specified search string (case-insensitive).
- `updateProduct(UUID uuid, ProductEntity productEntity)`: Updates the information of an existing product identified by the provided UUID.
- `kdvTruePrice(ProductEntity product)`: Calculates the true price of a product after applying or removing KDV.

### OrderService

The `OrderService` class is responsible for managing orders. It provides methods for creating, updating, deleting, and retrieving order information from the database. It also includes methods for adding products to an order, calculating the total price of an order, and controlling the order status based on product stock availability.

- `createOrder(CustomerEntity customer, List<ProductEntity> productEntityList)`: Creates a new order for a customer with a list of products.
- `getAll()`: Retrieves a list of all orders from the database.
- `getByStatus(EOrderStatus status)`: Retrieves a list of orders by their status (e.g., WAITING, APPROVED, REJECTED).
- `getByUuid(UUID uuid)`: Retrieves an order by its UUID.
- `deleteOrderEntity(UUID uuid)`: Deletes the order with the specified UUID.
- `updateOrderEntity(UUID uuid, OrderEntity order)`: Updates the information of an existing order identified by the provided UUID.
- `addProduct(UUID productUuid, UUID orderUuid)`: Adds a product to an existing order.
- `calculateTotalPrice(UUID uuid)`: Calculates the total price of an order based on the products and their order counts.
- `controlOrderStatus(UUID uuid)`: Controls the order status and updates it based on product stock availability.

## Getting Started

To run the Customer ERP project, follow these steps:

1. Clone the repository to your local machine.
2. Make sure you have Java and Spring Boot installed.
3. Set up a PostgreSQL database and configure the database connection in the application properties.
4. Build and run the application using your preferred IDE or by running `mvn spring-boot:run` in the project directory.
5. Access the application through the provided endpoints.

## Conclusion

The Customer ERP project is designed to efficiently manage customers, orders, products, and taxes in an enterprise environment. Each service class provides the necessary functionalities to interact with the database and perform operations on the entities. The system ensures data integrity and consistency while offering convenient methods for managing various aspects of the business.