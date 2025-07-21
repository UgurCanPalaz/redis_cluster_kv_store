# sahibinden.com

### Key Value Store Implementation

Write an application which uses a key-value store implementation. You can use any existing key-value store implementation. 
For example: Memcache, Redis vs.. 

### Prerequisites:
* All your development must be in feature/key-value-store-code-case branch. You must open a pull request to main branch

### Requirements:
* Key-value store has to scale horizontally 
* We can add and remove new nodes to key-value store
* When we add a new node to key-value store, we must not change anything on client side. Clients, who are using key-value store, will not be changed!

### Expectations
* The application has to start without any configuration changes by our side.
* You must use docker to install memcache or any relative key-value implementation.
* Documentation
* You must write a test to add and get data from key-value store
* Use your test to perform a load test.

### Exclusions
* Cache values can be invalidated.

### Suggestions
* Use Object Oriented Principles
* Give necessary care to commit history


