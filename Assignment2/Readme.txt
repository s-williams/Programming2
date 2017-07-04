##############################
# LightWeight Auction System #
##############################

Scott Williams
Saw1g15
COMP1206 Programming 2 Coursework 2

# Sections attempted

Core:
* Users
* Items
* Communication
* Client, Client GUIs
* Server, Server GUI, Logging

Extensions:
* Sockets

# How it works

The main methods are located in Server.java and Client.java, representing both the server application and the java application.

The files which consist the server are: Server, Comms, ServerComms, ServerGUI, User, Item, Message, ObjectMessage, Log, DataPersistence, Category, Bid
The files which consist the client are: Client, Comms, ClientComms, AuctionGUI, LogInGUI, User, Item, Message, ObjectMessage, Category, Bid

## Logging in and Registering

The system uses the revolutionary new system of both the first name and last name of each user to act as their identifier. This dos away with the need for separate usernames and allows the users to not have to remember their uniquely generated user IDs.

# License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.