package edu.problems.db;

public class QueryMaxOrderWithin10Years {
    /**

     select top 1 c.name, o.price from customer c
     join orders o on c.order_id = o.id
     where o.order_date <= dateadd(year, 10, (select min(order_date) from orders))
     order by o.price desc;
     */
}
