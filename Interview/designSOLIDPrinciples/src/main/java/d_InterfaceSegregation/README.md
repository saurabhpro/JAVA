# I is for Interface Segregation Principle

- The Interface Segregation Principle (ISP) says that you should favor many, smaller, 
client-specific interfaces over one larger, more monolithic interface. 
In short, you don't want to force clients to depend on things they don't actually need. 
Imagine your code consuming some big, fat interface and having to re-compile/deploy with 
annoying frequency because some method you don't even care about got a new signature.

- To picture this in the real world, think of going down to your local corner restaurant 
and checking out the menu. You'll see all of the normal menu mainstays, and then something 
that's just called "soup of the day." Why do they do this? Because the soup changes a lot 
and there's no sense reprinting the menus every day. Clients that don't care about the soup 
needn't even be concerned, and clients that do use a different interface -- asking the server.