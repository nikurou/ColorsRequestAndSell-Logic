# ColorsRequestAndSell-Logic

A rough prototype program to work out the logic behind how to create a system in which sellers/buyers can place orders and sellers can list items (dyes in this case). Dyes for sale and dyes ordered are listed in seperate "databases" which are simulated as an arrayList. When users make an order or sellers place an item for sale, the item is put into it's respective DB.

------------------------
Features
------------------------

As a Buyer
1) Place an order in HEX or RGB with a given acceptable range of error in color.
2) Be notified if your order (with range of error in consideration) already exists in the marketplace's database.
3) Be notified if a seller posts a dye that matches your order.

As a Seller 
1) Place your dye on marketplace with the appropriate HEX and RGB values.
2) Pending?: Notify seller if there are rq orders for their item?  (Mash said not a good idea because they may be flooded with orders)
  
--------------------------

Since it's a rough prototype for some basic planning, there is no checking that input is correct and some other important features like actually buying, removing item, etc etc.

---------------------------------------
Possible Optimizations for Final Project
----------------------------------------

USE HASHMAP FOR STORAGE
Rather than read the database iteratively everytime, read the database once and anytime it's updated and add it to a dictionary (hashmap) with the sum of the RGB as the key (where you add 1,2,3 to each position so it's truly unique), and the seller/buyer objects as the key.  

This makes searching for matching orders faster because given an RGB, you can immediately find a list of who wants it in constant time rather than searching through the entire list iteratively.

