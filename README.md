# OrderManagementSystem
Api to add cutomer (POST) - localhost:8080/api/customers/
Request Body example - {
    "firstName":"Krishna",
    "lastName":"Chamoli"
}

Api to get customers (GET) - localhost:8080/api/customers/

Api to get customer by id (GET) - localhost:8080/api/customers/customer?customerId=1

Api to update customer (PUT) - localhost:8080/api/customers/
Request Body example - {
    "customerId":1,
    "firstName":"Rohan",
    "lastName":"Singh"
}

Api to delete customer (DELETE) - localhost:8080/api/customers/?customerId=1

Api to create order (POST) - localhost:8080/api/customers/createorder
Request Body example - {
    "orderName":"order19",
    "orderQuantity":"20",
    "customerId":"1",
    "orderPrice":100
}
