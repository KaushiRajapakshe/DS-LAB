
Registration number - IT16178700

Q10) It is Singleton.


The Server object's instantiation method is Singleton because there is one server object to serve multiple clients.

We can also create multiple server objects to serve each client. This is called "per client" implementation. It can increment feature about Server object's. Here we can use a pattern called Remote Session where it can store "per client" information as it creates an instance per client.
In this case, we can have two remote interfaces; one for the main server object(RemoteServer) and other for the specific server object(RemoteSpecificServer)(which is to be used by a specific client/call). Initially the client lookup for the RemoteServer object. That RemoteServer object should contain a method to return the reference to the RemoteSpecificServer object. From there onwards client can connect with the RemoteSpecificServer object. 