###Creating Java Stub class for testing

Looking at this commit, we can understand:

- TodoBusinessImpl is the main business class.
- TodoService is the service class which contacts external world.

Now to test the TodoBusinessImpl, need TodoService as a dependency
which contacts to external world and hence a real test is not possible.

So, to test such classes with such dependencies, there is java way of
testing:

- Create the stub class TodoService Stub implementing dependency class so that it has 
all the methods in the dependency class.
- Use the stub class in test as used in TodoBusinessImplStubTest.java

The problem is:
- maintaining the stub class, every update in main class should also be
 done in stub class.
- Dynamic behavior: the stub class is static, to get values based on
 scenarios, all the scenario logic should be added in stub class which makes 
 it complex.

