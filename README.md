# qp-assessment
Here’s a detailed README.md file for your Grocery Booking API project:
The Grocery Booking API is a Spring Boot application that allows Admin and User roles to manage and book grocery items efficiently. The API is built with RESTful principles, uses an H2 in-memory database, and supports basic CRUD operations for grocery management and order placement.

### Features
* Admin Features
* Add new grocery items.
* View the list of grocery items.
* Update grocery item details (name, price, quantity).
* Remove grocery items from the system.

### User Features
* View the list of available grocery items.
* Place an order for multiple grocery items.
* View all orders for a specific user.

### Tech Stack
* Backend Framework: Java Spring Boot
* Database: H2 (in-memory database)
* API Testing: Postman, Hoppscotch, or Terminal
* Dependencies:
  1. Spring Web
  2. Spring Data JPA
  3. H2 Database
  4. Lombok (optional)

### Database Configuration
The application uses an H2 in-memory database. The database schema and data are automatically created using the schema.sql and data.sql files.
Access the H2 Console
* URL: http://localhost:8080/h2-console
* JDBC URL: jdbc:h2:mem:testdb
* Username: sa
* Password: (leave empty)

### Admin Endpoints
    HTTP Method	    Endpoint	            Description
    POST	        /admin/items	        Add a new grocery item.
    GET	            /admin/items	        View all grocery items.
    PUT	            /admin/items/{id}	    Update a grocery item.
    DELETE	        /admin/items/{id}	    Delete a grocery item.

### User Endpoints
    HTTP Method	    Endpoint	            Description
    GET	            /items	                View all available grocery items.
    POST	        /orders	                Place an order.
    GET	            /users/{userId}/orders	View all orders for a specific user.

### Folder Structure
src/
├── main/
│   ├── java/
│   │   ├── com.groceries.grocerybooking/
│   │   │   ├── controller/    # REST Controllers
│   │   │   ├── entity/        # Entity Classes (GroceryItem, Order, OrderItem)
│   │   │   ├── repository/    # JPA Repositories
│   │   │   ├── service/       # Service Layer
│   ├── resources/
│       ├── application.properties # Application configuration
│       ├── schema.sql            # SQL script for schema
│       ├── data.sql              # SQL script for sample data