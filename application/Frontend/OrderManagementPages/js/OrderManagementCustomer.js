        // Imaginary dataset
        const orders = [
            { id: 1, date: "2023-09-15", shippingCost: 100.0, totalValue: 10000.0, status: "quote" },
            { id: 2, date: "2023-09-12", shippingCost: 120.0, totalValue: 8090.0, status: "quote" },
            { id: 3, date: "2023-09-10", shippingCost: 215.0, totalValue: 7120.0, status: "approved" },
            { id: 4, date: "2023-09-08", shippingCost: 180.0, totalValue: 9080.0, status: "approved" },
        ];

        // Function to display orders based on status
        function displayOrders(status) {
            const ordersContainer = status === "quote" ? document.getElementById("pending-quotes") : document.getElementById("approved-orders");

            // Clear the container first
            ordersContainer.innerHTML = "";

            // Filter orders by status
            const filteredOrders = orders.filter(order => order.status === status);

            // Populate the container with order items
            filteredOrders.forEach(order => {
                const orderItem = document.createElement("div");
                orderItem.classList.add("order-item");
                orderItem.innerHTML = `
                    <p>Order ID: ${order.id}</p>
                    <p>Date: ${order.date}</p>
                    <p>Shipping Cost: Rs. ${order.shippingCost.toFixed(2)}</p>
                    <p>Total Order Value: Rs. ${order.totalValue.toFixed(2)}</p>
                   <button class="invoice-btn" onclick="${status === "quote" ? `approveQuote(${order.id})` : `showInvoice(${order.id}, '${status}')`}">${status === "quote" ? "Approve" : "Show Invoice"}</button>
                   
                `;
                ordersContainer.appendChild(orderItem);
            });
        }

        // Function to approve a quote
        function approveQuote(orderId) {
            const orderToApprove = orders.find(order => order.id === orderId && order.status === "quote");
            if (orderToApprove) {
                orderToApprove.status = "approved";
                displayOrders("quote");
                displayOrders("approved");
            }
        }

        // Function to show invoice
        function showInvoice(orderId, status) {
            const orderToShow = orders.find(order => order.id === orderId && order.status === status);
            if (orderToShow) {
                // Open invoice.html in a new tab/window
                window.open(`invoice.html?order=${orderId}&status=${status}`, '_blank');
            }
        }


        // Initial display of orders
        displayOrders("quote");
        displayOrders("approved");